package gui;

import java.util.LinkedList;

public class FlowChart {
	
	private LinkedList<String>commands;
	private LinkedList<String>variables;
	private LinkedList<FlowShape>states;
	private FlowDrawer flowchart;
	private String name;
	
	public FlowChart(){
		this.commands=new LinkedList<String>();
		this.variables=new LinkedList<String>();
		this.name="";
		this.states=new LinkedList<FlowShape>();
		this.flowchart=null;
	}
	public LinkedList<String> getCommands() {
		return commands;
	}

	public void addCommand(String command) {
		this.commands.add(command);
	}
	public LinkedList<String> getVariables() {
		return variables;
	}

	public void addVariable(String variable) {
		this.variables.add(variable);
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Orders all the states into a Linked List
	 * @param ArrayList with the variables
	 * @param ArrayList of the commands
	 * @return LinkedList of FlowShapes that have all the next and previous states organized.
	 */
	private void flowSorter()
	{
		
		LinkedList<FlowShape>varList=new LinkedList<FlowShape>();
		//Add the variables as FlowShapes
		for(String g:this.variables)
		{
			varList.add(new FlowShape((g.substring(g.indexOf("=")+1, g.length()).trim())));
		}
		//First FlowShape should be start
		varList.addFirst(new FlowShape("Start"));
		//Last FlowShape should be End
		varList.addLast(new FlowShape("End"));
		
		FlowShape prev=null;
		FlowShape current=null;
		FlowShape next=null;
		FlowShape next2=null;
		for(String g:this.commands)
		{
			//Obtain the parameters of the command
			String[] param=g.substring(g.indexOf("(")+1, g.lastIndexOf(")")).split(",");
			
			if(g.contains("InsertIf"))
			{
				try{
					prev=varList.get(varList.indexOf(new FlowShape(param[1].trim())));
					current=varList.get(varList.indexOf(new FlowShape(param[0].trim())));
					next=varList.get(varList.indexOf(new FlowShape(param[2].trim())));
					next2=varList.get(varList.indexOf(new FlowShape(param[3].trim())));
				}catch(IndexOutOfBoundsException e1)
				{
					FlowInterface.writeToUser("In InsertIf("+param[0]+","+param[1]+","+param[2]+","+param[3]+") a parameter is null", true);
				}
				
				if(!prev.getShape().equals("diam"))
				{
					prev.setNext(current);
					
				}
				current.setNext(next);
				current.setNext2(next2);
				if(next.getPrev()==null)
				{
					next.setPrev(current);
					if(next2.getPrev()==null)
					{
						next2.setPrev(current);
						
					}
					
				}
				else if(next2.getPrev()==null)
				{
					next2.setPrev(current);
				}
				else
				{
					next.setPrev(current);
					next2.setPrev(current);
				}
				current.setShape("diam");
				
			}
			
			else if(g.contains("Insert"))
			{
				try{
					prev=varList.get(varList.indexOf(new FlowShape(param[1].trim())));
					current=varList.get(varList.indexOf(new FlowShape(param[0].trim())));
					next=varList.get(varList.indexOf(new FlowShape(param[2].trim())));
				}catch(IndexOutOfBoundsException e1)
				{
					FlowInterface.writeToUser("In Insert("+param[0]+","+param[1]+","+param[2]+") a parameter is null", true);
				}
				
				if(prev.getShape().contains("diam"))
				{
					current.setNext(next);	
				}
				else
				{
					prev.setNext(current);
					current.setNext(next);
					
				}
				if(next.getPrev()==null)
				{
					next.setPrev(current);
				}
				current.setShape("rect");
				
				
			}
			else if(g.contains("GetOverHere"))
			{
				try{
					current=varList.get(varList.indexOf(new FlowShape(param[0].trim())));
					next=varList.get(varList.indexOf(new FlowShape(param[1].trim())));
				}catch(IndexOutOfBoundsException e1)
				{
					FlowInterface.writeToUser("In GetOverHere("+param[0]+","+param[1]+") a parameter is null", true);
				}
			
				current.setNext(next);
				if(next.getShape()==null)
				{
					next.setShape("rect");
				}
			}
			else if(g.contains("Smash"))
			{
				try{
					current=varList.get(varList.indexOf(new FlowShape(param[0].trim())));
					next=current.getNext();
					prev=current.getPrev();
				}catch(IndexOutOfBoundsException e1)
				{
					FlowInterface.writeToUser("In Smash("+param[0]+") a parameter is null", true);
				}
				
				for(FlowShape th:varList)
				{
					
					if(th.getNext()!=null&&th.getNext().equals(current))
					{
						th.setNext(next);
					}
					if(th.getPrev()!=null&&th.getPrev().equals(current))
					{
						th.setPrev(prev);
					}
					if(th.getNext2()!=null&&th.getNext2().equals(current))
					{
						th.setNext2(next);
					}
				}
				
				varList.remove(current);
			}
			
		}
		this.states=varList;
	}
	private void setFlowchartPositions() {
		//First element in list is Start state
		FlowShape current=this.states.get(0);
		current.setPositionX(500);
		current.setPositionY(10);
		statePositioner(current);

		this.states.getFirst().setShape("circle");
		this.states.getLast().setShape("circle");
		flowchart= new FlowDrawer(this.states);
	}
	private void statePositioner(FlowShape first)
	{
		FlowShape current=first;
		FlowShape next=current.getNext();
		//While the next node of the current FlowShape isn't empty
		while(next!=null&&(next.getPositionX()==0||next.equals(new FlowShape("End"))))
		{			
			FlowShape next2=current.getNext2();
			//If the shape of the state is a diamond then the positions of the next states is lower than usual.
			if(current.getShape().equals("diam"))
			{
				//Position in x doesn't change and position in y take into account size of the shape and the arrow
				next.setPositionX(current.getPositionX());
				next.setPositionY(current.getPositionY()+300);
				//Since this is an if statement the no state has to be positioned as well
				if(next2.getPositionX()==0)
				{
					next2.setPositionX(current.getPositionX()+260*current.getIfNum());
					next2.setPositionY(current.getPositionY()+300);
				}
				statePositioner(next2);
			}
			else
			{
				next.setPositionX(current.getPositionX());
				next.setPositionY(current.getPositionY()+200);
			}
			current=next;
			next=next.getNext();
		}
		states.getLast().setPositionX(states.getFirst().getPositionX());
	}
	private void ifAjuster()
	{
		int ifCount=1;
		for(FlowShape sh: states)
		{
			if(sh.getShape().equals("diam"))
			{
				FlowShape next=sh.getNext();
				while(next!=null&&!next.equals(sh))
				{
					FlowShape prev=next.getPrev();
					while(prev!=null)
					{
						if(prev.equals(next))
						{
							break;
						}
						prev=prev.getPrev();
					}
					if(next.getShape().equals("diam"))
					{
						sh.setIfNum(++ifCount);
					}
					next=next.getNext();
					if(ifCount>100)
					{
						FlowInterface.writeToUser("Error: Too many loops", true);
						break;
						
					}
				}
				ifCount=1;
			}
			
		}
	}
	public FlowDrawer createFlowchart()
	{
		this.flowSorter();
		this.ifAjuster();
		this.setFlowchartPositions();
		return flowchart;
	}
	


}
