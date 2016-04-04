package gui;

import java.util.LinkedList;

public class FlowChart {
	
	private LinkedList<String>commands;
	private LinkedList<String>variables;
	private LinkedList<FlowShape>states;
	private String name;
	
	public FlowChart(){
		this.commands=new LinkedList<String>();
		this.variables=new LinkedList<String>();
		this.name="";
		this.states=new LinkedList<FlowShape>();
	}
	public LinkedList<String> getCommands() {
		return commands;
	}

	public void addCommand(String command) {
		this.commands.add(command);
	}
	public String getCommand(String command) {
		return this.commands.get(this.commands.indexOf(command));
	}
	public void setCommands(LinkedList<String> commands) {
		this.commands = commands;
	}
	public void setVariables(LinkedList<String> variables) {
		this.variables = variables;
	}
	public LinkedList<String> getVariables() {
		return variables;
	}

	public void addVariable(String variable) {
		this.variables.add(variable);
	}
	public String getVariable(String command) {
		return this.variables.get(this.variables.indexOf(command));
	}

	public LinkedList<FlowShape> getStates() {
		return states;
	}

	public void setStates(LinkedList<FlowShape> states) {
		this.states = states;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
