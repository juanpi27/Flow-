package gui;


import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import lexical.LexicalAnalyzer;






public class FlowInterface {

	private JTextArea text= new JTextArea(); 
	private static JTextArea outputText= new JTextArea(); 
	private static JTextField inputFile=new JTextField();
	private JTextField openFile=new JTextField();
	private JButton compile; 
	private JButton run;
	private JButton open;
	private JButton browse; 
	private JButton save;
	private File codeFile=new File("inputFile.fpp");
	private FlowDrawer flowchart;
	private LinkedList<FlowChart>flowcharts;
	private boolean saved=false;
	
	public static void main(String[] args) {
		new FlowInterface().launchGUI();
	}
	private void launchGUI()
	{
		//Main frame
		JFrame frame= new JFrame("Flow++");
		//Main Panel
		JPanel mainPanel= new JPanel();
		//Panel for text area
		JPanel textPanel= new JPanel();
		//Panel for buttons
		JPanel buttonPanel= new JPanel();
		JPanel sidePanel=new JPanel();
		//
		JPanel codingPanel=new JPanel();
		
		JLabel conLabel=new JLabel("Console");

		JLabel message1=new JLabel("Give file name. (Without .fpp)");
		JLabel message2=new JLabel("File to open:");
		
		compile=new JButton();
		run=new JButton();
		open=new JButton();
		browse=new JButton();
		save=new JButton();
		
		//Program exits when window is closed
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Size of window
		frame.setSize(1000, 1010);
	
		codingPanel.setLayout(new BoxLayout(codingPanel,BoxLayout.Y_AXIS));
		sidePanel.setLayout(new BoxLayout(sidePanel,BoxLayout.Y_AXIS));
		buttonPanel.setLayout(new BoxLayout(buttonPanel,BoxLayout.X_AXIS));
		mainPanel.setLayout(new BoxLayout(mainPanel,BoxLayout.X_AXIS));
		
		conLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		text.setEditable(true);
		
		outputText.setEditable(false);
		outputText.setAlignmentX(Component.CENTER_ALIGNMENT);
		outputText.setLineWrap(true);
		outputText.setWrapStyleWord(true);
		
		
		compile.setPreferredSize(new Dimension(100, 50));
		compile.setText("Compile");
		compile.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		run.setPreferredSize(new Dimension(100, 50));
		run.setText("Run");
		run.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		browse.setPreferredSize(new Dimension(100, 50));
		browse.setText("Browse");
		browse.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		save.setPreferredSize(new Dimension(100, 50));
		save.setText("Save");
		save.setAlignmentX(Component.CENTER_ALIGNMENT);
	
		open.setPreferredSize(new Dimension(100, 50));
		open.setText("Open");
		open.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		//Will indicate if buttons were pressed
		ActionListener listener=new FlowListener();
		compile.addActionListener(listener);
		run.addActionListener(listener);
		browse.addActionListener(listener);
		save.addActionListener(listener);
		open.addActionListener(listener);
		
		message1.setAlignmentX(Component.CENTER_ALIGNMENT);
		message2.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		inputFile.setEditable(true);
		inputFile.setPreferredSize(new Dimension(190,30));
		inputFile.setAlignmentX(Component.CENTER_ALIGNMENT);
		inputFile.setText("inputfile");
		
		openFile.setEnabled(true);
		openFile.setPreferredSize(new Dimension(190,30));
		openFile.setAlignmentX(Component.CENTER_ALIGNMENT);
		openFile.setText("");
		
				
			
		
		//Assigns the scrollbar to the panel
		 JScrollPane scrollbar = new JScrollPane(text);
		//No horizontal scrollbar
		scrollbar.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		//Places panel with scrollbar to the frame.
		
		//Assigns the scrollbar to the panel
		 JScrollPane scrollbar1 = new JScrollPane(outputText);
		//No horizontal scrollbar
		scrollbar.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollbar.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		//Places panel with scrollbar to the frame.
		
		scrollbar.setPreferredSize(new Dimension(750, 850));
		
		scrollbar1.setPreferredSize(new Dimension(190, 500));
		
		textPanel.add(scrollbar);
		
		buttonPanel.add(save);
		buttonPanel.add(Box.createHorizontalStrut(15));
		buttonPanel.add(browse);
		buttonPanel.add(Box.createHorizontalStrut(15));
		buttonPanel.add(compile);
		buttonPanel.add(Box.createHorizontalStrut(15));
		buttonPanel.add(run);
		
		textPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
		sidePanel.setAlignmentX(Component.RIGHT_ALIGNMENT);
		
		sidePanel.add(conLabel);
		sidePanel.add(Box.createVerticalStrut(2));
		sidePanel.add(scrollbar1);
		sidePanel.add(Box.createVerticalStrut(100));
		sidePanel.add(message1);
		sidePanel.add(Box.createVerticalStrut(2));
		sidePanel.add(inputFile);
		sidePanel.add(Box.createVerticalStrut(5));
		sidePanel.add(message2);
		sidePanel.add(Box.createVerticalStrut(2));
		sidePanel.add(openFile);
		sidePanel.add(Box.createVerticalStrut(5));
		sidePanel.add(open);
		sidePanel.add(Box.createVerticalStrut(300));
		
		
		codingPanel.add(textPanel);
		codingPanel.add(Box.createVerticalStrut(2));
		codingPanel.add(buttonPanel);
		
		codingPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		mainPanel.add(codingPanel);
		mainPanel.add(sidePanel);
		mainPanel.add(Box.createHorizontalStrut(5));
		
		
		frame.add(mainPanel);
	
		frame.setVisible(true);
		
				
	}
	
	/**
	 * 
	 * @return code written by user
	 */
	private String getText() {
		return text.getText();
	}
	private void setText(String code) {
		text.setText(code);
	}


	public static String getInputFile() {
		return inputFile.getText();
	}
	private String getOpenFile() {
		return openFile.getText();
	}
	public static void writeToUser(String write, boolean error)
	{
		if(error)
		{
			outputText.setForeground(Color.RED);
		}
		else
		{
			outputText.setForeground(Color.BLACK);
		}
		outputText.setText(outputText.getText()+write+"\n");
	}

	

	/**
	 * Sets the positions in the frame of each state in the flowchart
	 * @param LinkedList of FlowShapes
	 */
	private void setFlowchartPositions(LinkedList<FlowShape>list) {
		//First element in list is Start state
		FlowShape current=list.get(0);
		current.setPositionX(500);
		current.setPositionY(10);
		statePositioner(current);

		list.getFirst().setShape("circle");
		list.getLast().setShape("circle");
		flowchart=new FlowDrawer(list);
	}
	private void statePositioner(FlowShape first)
	{
		FlowShape current=first;
		FlowShape next=current.getNext();
		//While the next node of the current FLowShape isn't empty
		while(next!=null&&(next.getPositionX()==0||next.equals(new FlowShape("End"))))
		{
			
			FlowShape next2=current.getNext2();
			//If the shape of the state is a diamond then the positions of the next states is lower than usual.
			if(current.getShape().equals("diam")||current.getShape().equals("diam-arrow-yes")||current.getShape().equals("diam-arrow-no")||current.getShape().equals("diam-arrow-yes-no"))
			{
				
				//Position in x doesn't change and position in y take into account size of the shape and the arrow
				next.setPositionX(current.getPositionX());
				next.setPositionY(current.getPositionY()+300);
				//Since this is an if statement the no state has to be positioned as well
				if(next2.getPositionX()==0)
				{
					next2.setPositionX(current.getPositionX()+260);
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
	}

	private void codeDecoder(String filename) throws IOException
	{
		//Empty flowchart
		FlowChart fc=null;
		//Index of variables
		int ind=0;
		//Index of commands
		int indc=0;
		//If there is a variables
		boolean var=false;
		//If there is a command
		boolean com=false;
		//If it is genesis
		boolean gen=false;
		
		//Read file with all the possible commands
		FileReader fr=new FileReader("src/resources/CommandList.txt");
		BufferedReader read=new BufferedReader(fr);
		String temp=read.readLine();
		LinkedList<String> allCommands=new LinkedList<String>();
		while(temp!=null)
		{
			allCommands.add(temp);
			temp=read.readLine();
		}
		//Read file with lexical analysis
		fr=new FileReader(filename);
		read=new BufferedReader(fr);
		temp=read.readLine();
		//Read every line in lexical analysis
		while(temp!=null)
		{
			//If variable save as a variable of the flowchart
			if(temp.contains("-Var")&&!com)
			{
				fc.addVariable(temp.substring(temp.indexOf(" "),temp.indexOf("-")).trim());
				ind++;
				var=true;
			}
			//If string that save in the flowchart with the appropriate variable
			else if(var&&temp.contains("-String"))
			{
				fc.getVariables().set(ind-1, fc.getVariables().get(ind-1)+"="+(temp.substring(temp.indexOf(" "),temp.indexOf("-")-1).trim()));
				var=false;
			}
			//If command save as command in flowchart
			else if(allCommands.contains(temp.substring(temp.indexOf("-")+1, temp.length())))
			{
				//If genesis start new flowchart
				if(temp.substring(temp.indexOf("-")+1, temp.length()).trim().equals("Genesis"))
				{
					if(fc==null){
						fc=new FlowChart();
					}
					//If not the first flowchart then save previous and start a new one
					else
					{
						//Save positions of states
						fc.setStates(flowSorter(fc.getVariables(), fc.getCommands()));
						//Save flowchart
						flowcharts.add(fc);
						//New flowchart
						fc=new FlowChart();
						ind=0;
						indc=0;
					}
					gen=true;
				}
				fc.addCommand(temp.substring(temp.indexOf("-")+1, temp.length()).trim());
				indc++;
				com=true;
			}
			//If command was found get its parameters
			else if(com)
			{
				if(temp.contains("LeftParen"))
				{
					fc.getCommands().set(indc-1, fc.getCommands().get(indc-1)+"(");
				}
				else if(temp.contains("Var"))
				{
					if(gen)
					{
						fc.setName(varMatch(temp.substring(temp.indexOf(" "),temp.indexOf("-")).trim(), fc.getVariables()));
						gen=false;
					}
					fc.getCommands().set(indc-1, fc.getCommands().get(indc-1)+varMatch(temp.substring(temp.indexOf(" "),temp.indexOf("-")).trim(), fc.getVariables()));
				}
				else if(temp.contains("RightParen"))
				{
					fc.getCommands().set(indc-1, fc.getCommands().get(indc-1)+")");
					com=false;
				}
				else
				{
					fc.getCommands().set(indc-1, fc.getCommands().get(indc-1)+",");
				}
			}
			temp=read.readLine();
		}
		//Set the order of the states
		fc.setStates(flowSorter(fc.getVariables(), fc.getCommands()));
		//Save flowchart
		flowcharts.add(fc);
		
	}
	/**
	 * Accepts a variable and returns it's value
	 * @param String containing the variable
	 * @param Array of variables with their values
	 * @return String with the value of the given variable
	 */
	private String varMatch(String var, LinkedList<String> vars)
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
	private LinkedList<FlowShape> flowSorter(LinkedList<String> var,LinkedList<String>com)
	{
		
		LinkedList<FlowShape>varList=new LinkedList<FlowShape>();
		//Add the variables as FlowShapes
		for(String g:var)
		{
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
			//Obtain the parameters of the command
			String[] param=g.substring(g.indexOf("(")+1, g.lastIndexOf(")")).split(",");
			
			if(g.contains("InsertIf"))
			{
				prev=varList.get(varList.indexOf(new FlowShape(param[1].trim())));
				current=varList.get(varList.indexOf(new FlowShape(param[0].trim())));
				next=varList.get(varList.indexOf(new FlowShape(param[2].trim())));
				next2=varList.get(varList.indexOf(new FlowShape(param[3].trim())));
			
				
				if(prev.getShape().equals("diam"))
				{
					
					current.setNext(next);
					current.setNext2(next2);
					if(next.getPrev()!=null)
					{
						current.setShape("diam-arrow-yes");
						if(next2.getPrev()!=null)
						{
							current.setShape("diam-arrow-yes-no");
						}
						else
						{
							next2.setPrev(current);
							current.setShape("diam");
						}
					}
					else if(next2.getPrev()!=null)
					{
						next.setPrev(current);
						current.setShape("diam-arrow-no");
					}
					else
					{
						next.setPrev(current);
						next2.setPrev(current);
						current.setShape("diam");
					}
				}
				else
				{
					prev.setNext(current);
					current.setNext(next);
					
					current.setNext2(next2);
					if(next.getPrev()!=null)
					{
						current.setShape("diam-arrow-yes");
						if(next2.getPrev()!=null)
						{
							current.setShape("diam-arrow-yes-no");
						}
						else
						{
							next2.setPrev(current);
							current.setShape("diam");
						}
					}
					else if(next2.getPrev()!=null)
					{
						next.setPrev(current);
						current.setShape("diam-arrow-no");
					}
					else
					{
						next.setPrev(current);
						next2.setPrev(current);
						current.setShape("diam");
					}
				}
				
			}
			
			else if(g.contains("Insert"))
			{

				prev=varList.get(varList.indexOf(new FlowShape(param[1].trim())));
				current=varList.get(varList.indexOf(new FlowShape(param[0].trim())));
				next=varList.get(varList.indexOf(new FlowShape(param[2].trim())));
				
				if(prev.getShape().equals("diam"))
				{
					current.setNext(next);
					
					if(next.getPrev()!=null)
					{
						current.setShape("rect-arrow");
					}
					else
					{
						next.setPrev(current);
						current.setShape("rect");
					}
					
				}
				else
				{
					prev.setNext(current);
					current.setNext(next);
					if(next.getPrev()!=null)
					{
						current.setShape("rect-arrow");
					}
					else
					{
						next.setPrev(current);
						current.setShape("rect");
					}
				}
				
			}
			else if(g.contains("GetOverHere"))
			{
			
				current=varList.get(varList.indexOf(new FlowShape(param[0].trim())));
				next=varList.get(varList.indexOf(new FlowShape(param[1].trim())));
			
				current.setNext(next);
				next.setPrev(current);
				if(next.getShape()==null)
				{
					next.setShape("rect");
				}
			}
			else if(g.contains("Smash"))
			{
				current=varList.get(varList.indexOf(new FlowShape(param[0].trim())));
				next=current.getNext();
				prev=current.getPrev();
				prev.setNext(next);
				next.setPrev(prev);
				
				varList.remove(current);
			}
			else
			{
				continue;
			}
		}
		
		
		
		
		
		return varList;
	}
	private void saveFileWarn()
	{
		JFrame frame=new JFrame();
		JPanel mainPanel=new JPanel();
		JTextArea warning =new JTextArea("\n     Remember to change your the file name from the default ones!");
		frame.setSize(650, 150);
		frame.setLocation(300, 400);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setTitle("Warning!");
		mainPanel.setLayout(new BoxLayout(mainPanel,BoxLayout.Y_AXIS));
		warning.setEditable(false);
		warning.setWrapStyleWord(true);
		warning.setLineWrap(true);
		warning.setFont(new Font("Sans Serif", Font.PLAIN, 20));
		warning.setBackground(new Color(239,239,239));
		warning.setSize(300, 195);
		mainPanel.add(warning);
		frame.add(mainPanel);
		
		frame.setVisible(true);
		
	}
	private void openFileWarn()
	{
		JFrame frame=new JFrame();
		JPanel mainPanel=new JPanel();
		JTextArea warning =new JTextArea("\n\t\tError: File not found.\n     Check if name is correct and remember that files end with .fpp");
		frame.setSize(650, 150);
		frame.setLocation(300, 400);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setTitle("Warning!");
		mainPanel.setLayout(new BoxLayout(mainPanel,BoxLayout.Y_AXIS));
		warning.setEditable(false);
		warning.setWrapStyleWord(true);
		warning.setLineWrap(true);
		warning.setFont(new Font("Sans Serif", Font.PLAIN, 20));
		warning.setBackground(new Color(239,239,239));
		warning.setSize(300, 195);
		mainPanel.add(warning);
		frame.add(mainPanel);
		
		frame.setVisible(true);
		
	}
	private String openFile(String filename) throws IOException
	{
		FileReader fr=new FileReader(filename);
		BufferedReader read=new BufferedReader(fr);
		String temp=read.readLine();
		String code="";
		while(temp!=null)
		{
			code=code+temp+"\n";
			temp=read.readLine();
		}
		return code;
	}
	/**
	 * Class the listens for input in the GUI. More specifically from the buttons.
	 * @author Gretchen
	 *
	 */
	private class FlowListener implements ActionListener{

		
		public void actionPerformed(ActionEvent e) {
			
			LexicalAnalyzer lex=new LexicalAnalyzer();
			JButton theButton = (JButton) e.getSource();
			//If button pressed is compile then obtain what the user wrote and check for errors
			if(theButton==compile)
			{
				
			}
			//If button pressed is run, compile code and execute it.
			else if(theButton==run)
			{
				flowcharts=new LinkedList<FlowChart>();
				if(saved)
				{
					try {
						FileWriter w=new FileWriter(codeFile);
						w.write(getText());
						w.flush();
						w.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						writeToUser("Error: IO Exception", true);
					}
					
					lex.start();
					
					//Gives data to FlowDrawer so flowchart can be drawn
					try {
						codeDecoder(inputFile.getText()+"_lexAnalisys.txt");
						for(int i=0;i<flowcharts.size();i++)
						{
							if(flowcharts.get(i).getCommands().contains("ShowItToMe()"))
							{
								setFlowchartPositions(flowcharts.get(i).getStates());
								flowchart.showItToMe(1000, 0);
							}
							if(flowcharts.get(i).getCommands().contains("Fatality()"))
							{
								flowcharts.remove(i);
								i--;
							}
						}
						
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						writeToUser("Error: File not found", true);
					}
					
				}
				else
				{
					saveFileWarn();
					
				}
			}
			else if(theButton==save)
			{
				if(inputFile.getText().equals("")||inputFile.getText().equals(" "))
				{
					writeToUser("Error: No name for save file", true);
				}
				codeFile=new File(inputFile.getText()+".fpp");
				saved=true;
			}
			
			else if(theButton==browse)
			{
				lex.start2();
			}
			else if(theButton==open)
			{
				try {
					setText(openFile(getOpenFile()));
					inputFile.setText(getOpenFile().replace(".fpp", ""));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					writeToUser("Error: Could not open file", true);
					openFileWarn();
					
				}
			}
			
			
		}
	}
	
}
