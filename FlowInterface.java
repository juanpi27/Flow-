
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;


public class FlowInterface {

	private static JTextArea text= new JTextArea(); 
	private static JButton compile=new JButton(); 
	private static JButton run=new JButton();
	private static String userCode=new String();
	private static FlowDrawer flowchart;
	
	public static void main(String[] args) {
		//Main frame
		JFrame frame= new JFrame("Flow++");
		//Main Panel
		JPanel mainPanel= new JPanel();
		//Panel for text area
		JPanel textPanel= new JPanel();
		//Panel for buttons
		JPanel buttonPanel= new JPanel();
		//Layout that will be used
		BorderLayout layout = new BorderLayout();
		
		//Program exits when window is closed
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Size of window
		frame.setSize(1000, 1000);
		//Horizontal and vertical gap between components
		layout.setHgap(10);
		layout.setVgap(20);
		
		
		text.setEditable(true);
		text.setPreferredSize(new Dimension(900, 800));
		
		compile.setPreferredSize(new Dimension(100, 50));
		compile.setText("Compile");
		
		run.setPreferredSize(new Dimension(100, 50));
		run.setText("Run");
	
		//Will indicate if buttons were pressed
		ActionListener listener=new FlowListener();
		compile.addActionListener(listener);
		run.addActionListener(listener);
		
		
		textPanel.add(text);
		
				
		buttonPanel.add(compile, BorderLayout.EAST);
		buttonPanel.add(run, BorderLayout.WEST);
		
		mainPanel.add(textPanel, BorderLayout.NORTH);
		mainPanel.add(buttonPanel, BorderLayout.SOUTH);
		
		frame.add(mainPanel);
	
		frame.setVisible(true);
		
		
	}

	
	/**
	 * 
	 * @return code written by user
	 */
	public static String getText() {
		return text.getText();
	}


	/**
	 * @param userCode the userCode to set
	 */
	public static void setUserCode(String userCode) {
		FlowInterface.userCode = userCode;
	}


	

	/**
	 * Sets the positions in the frame of each state in the flowchart
	 * @param LinkedList of FlowShapes
	 */
	public static void setFlowchart(LinkedList<FlowShape>list) {
		//First element in list is Start state
		FlowShape current=list.get(0);
		current.setPositionX(500);
		current.setPositionY(10);
		FlowShape next=list.get(0).getNext();
		//While the next node of the current FLowShape isn't empty
		while(next!=null)
		{
			//If the shape of the state is a diamond then the positions of the next states is lower than usual.
			if(current.getShape().equals("diam"))
			{
				//Position in x doesn't change and position in y take into account size of the shape and the arrow
				next.setPositionX(current.getPositionX());
				next.setPositionY(current.getPositionY()+300);
				//Since this is an if statement the no state has to be positioned as well
				list.get(list.indexOf(current.getNext2())).setPositionX(current.getPositionX()+210);
				list.get(list.indexOf(current.getNext2())).setPositionY(current.getPositionY()+300);
				current=next;
				
				next=list.get(list.indexOf(next)).getNext();
								
				
			}
			else
			{
				next.setPositionX(current.getPositionX());
				next.setPositionY(current.getPositionY()+200);
				current=next;
				if(next.getNext()==null&&!next.equals(list.getLast()))
				{
					next.setNext(list.getLast());
				}
				else
				{
					next=list.get(list.indexOf(next)).getNext();
				}
			}
			
			
		}
		list.get(0).setShape("circle");
		list.get(list.size()-1).setShape("circle");
		flowchart=new FlowDrawer(list);
	}
	public static LinkedList<FlowShape>codeDecoder(String code)
	{
		
		String[] allCode=code.split("\\n");
		//Stores all commands
		String[] commands=new String[allCode.length];
		//Stores all variables
		String[] variables=new String[allCode.length];
		//Places commands and variables in their respective arrays.
		for(int t=0,n=0,p=0;t<allCode.length-1;t++){
			if(allCode[t].contains("="))
			{
				variables[n++]=allCode[t];
			}
			else
			{
				commands[p++]=allCode[t];
			}
		}
		//Changes the variables in the parameters of the commands for their respective meaning.
		for(int t=0;t<commands.length;t++)
		{
			if(commands[t]==null)
			{
				break;
			}
			int n=0;
			String[] param=commands[t].substring(commands[t].indexOf("(")+1, commands[t].indexOf(")")).split(",");	
			String param1="";
			while(n<param.length)
			{
				param[n]=varMatch(param[n].trim(), variables);
				if(n==0)
				{
					param1=param[n];
				}
				else
				{
					param1=param1+","+param[n];
				}
				n++;
			}
			if(param1.equals(""))
			{
				for(int p=t;p<commands.length-1;p++)
				{
					commands[p]=commands[p+1];
				}
				t--;
			}
			else{
				commands[t]=commands[t].substring(0, commands[t].indexOf("(")+1)+param1+")";
			}
			
		}
		
		return flowSorter(variables, commands);
	}
	/**
	 * Accepts a variable and returns it's value
	 * @param String containing the variable
	 * @param Array of variables with their values
	 * @return String with the value of the given variable
	 */
	private static String varMatch(String var, String[] vars)
	{
		//If the variable received are Start and End then they a special constants.
		if(var.contains("Start"))
		{
			return "Start";
		}
		if(var.contains("End"))
		{
			return "End";
		}
		for(String g:vars)
		{
			if(g==null)
			{
				break;
			}
			
			if(g.contains(var+"=")||g.contains(var+" ="))
			{
				return g.substring(g.indexOf("=")+1, g.length());
			}
		}
		//If variable does not exist then return ""
		return "";
	}
	/**
	 * Orders all the states into a Linked List
	 * @param ArrayList with the variables
	 * @param ArrayList of the commands
	 * @return LinkedList of FlowShapes that have all the next and previous states organized.
	 */
	private static LinkedList<FlowShape> flowSorter(String[] var,String[]com)
	{
		
		LinkedList<FlowShape>varList=new LinkedList<FlowShape>();
		//Add the variables as FlowShapes
		for(String g:var)
		{
			if(g==null)
			{
				break;
				
			}
			varList.add(new FlowShape((g.substring(g.indexOf("=")+1, g.length()).trim())));
		}
		//First FLowShape should be start
		varList.addFirst(new FlowShape("Start"));
		//Last FlowShape should be End
		varList.addLast(new FlowShape("End"));
		
		FlowShape prev=null;
		FlowShape current=null;
		FlowShape next=null;
		FlowShape next2=null;
		for(String g:com)
		{
			if(g==null)
			{
				break;
			}
			//Obtain the parameters of the command
			String[] param=g.substring(g.indexOf("(")+1, g.lastIndexOf(")")).split(",");
			
			if(g.contains("InsertIf"))
			{
				prev=new FlowShape(param[1].trim());
				current=new FlowShape(param[0].trim());
				next=new FlowShape(param[2].trim());
				next2=new FlowShape(param[3].trim());
			
				varList.get(varList.indexOf(prev)).setNext(varList.get(varList.indexOf(current)));
				varList.get(varList.indexOf(current)).setNext(varList.get(varList.indexOf(next)));
				varList.get(varList.indexOf(next)).setPrev(varList.get(varList.indexOf(current)));
				varList.get(varList.indexOf(current)).setNext2(varList.get(varList.indexOf(next2)));
				varList.get(varList.indexOf(next2)).setPrev(varList.get(varList.indexOf(current)));
				varList.get(varList.indexOf(current)).setShape("diam");
			}
			
			else if(g.contains("Insert"))
			{
				prev=new FlowShape(param[1].trim());
				current=new FlowShape(param[0].trim());
				next=new FlowShape(param[2].trim());
			
				if(varList.get(varList.indexOf(prev)).getShape().equals("diam"))
				{
					varList.get(varList.indexOf(current)).setNext(varList.get(varList.indexOf(next)));
					varList.get(varList.indexOf(next)).setPrev(varList.get(varList.indexOf(current)));
					varList.get(varList.indexOf(current)).setShape("rect");
				}
				else
				{
					varList.get(varList.indexOf(prev)).setNext(varList.get(varList.indexOf(current)));
					varList.get(varList.indexOf(current)).setNext(varList.get(varList.indexOf(next)));
					varList.get(varList.indexOf(next)).setPrev(varList.get(varList.indexOf(current)));
					varList.get(varList.indexOf(current)).setShape("rect");
				}
				
			}
			else if(g.contains("GetOverHere"))
			{
			
				current=new FlowShape(param[0].trim());
				next=new FlowShape(param[1].trim());
			
				varList.get(varList.indexOf(current)).setNext(varList.get(varList.indexOf(next)));
				varList.get(varList.indexOf(next)).setPrev(varList.get(varList.indexOf(current)));
				if(varList.get(varList.indexOf(next)).getShape()==null)
				{
					varList.get(varList.indexOf(next)).setShape("rect");
				}
			}
			else if(g.contains("Smash"))
			{
				current=new FlowShape(param[0].trim());
				next=varList.get(varList.indexOf(current)).getNext();
				prev=varList.get(varList.indexOf(current)).getPrev();
				varList.get(varList.indexOf(prev)).setNext(varList.get(varList.indexOf(next)));
				varList.get(varList.indexOf(next)).setPrev(varList.get(varList.indexOf(prev)));
				
				varList.remove(current);
			}
			else
			{
				continue;
			}
		}
		
		
		
		
		
		return varList;
	}
	/**
	 * Class the listens for input in the GUI. More specifically from the buttons.
	 * @author Gretchen
	 *
	 */
	private static class FlowListener implements ActionListener{

		
		public void actionPerformed(ActionEvent e) {
			
			JButton theButton = (JButton) e.getSource();
			//If button pressed is compile then obtain what the user wrote and check for errors
			if(theButton==compile)
			{
				setUserCode(getText());
			}
			//If button pressed is run, compile code and execute it.
			else if(theButton==run)
			{
				setUserCode(getText());
				if(userCode.contains("ShowItToMe"))
				{
					//Gives data to FlowDrawer so flowchart can be drawn
					setFlowchart(codeDecoder(userCode));
					//Shows flowchart to user
					flowchart.showItToMe(1000, 0);
				}
			}
			
			
		}
	}
	
}
