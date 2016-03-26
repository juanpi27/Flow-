

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;



public class FlowDrawer {
	
	private JFrame flowFrame;

	private LinkedList<FlowShape> listOfCommands;

	
	
	public FlowDrawer(LinkedList<FlowShape>a1)
	{
		
		this.listOfCommands=a1;
		//Creates Frame
		flowFrame = new JFrame("Your Flowchart");
		//Closes disposes of frame when closed
		flowFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//Size of frame
		flowFrame.setSize(925, 1000);

		//Creates FlowPanel. This is where the flowchart is drawn.
		FlowPanel panel=new FlowPanel();
		//Preferred size of panel. This is what determines how much we can scroll in the panel.
		panel.setPreferredSize(new Dimension(925,10000));
		
		//Assigns the scrollbar to the panel
		 JScrollPane scrollbar = new JScrollPane(panel);
		//We want a vertical scrollbar
		scrollbar.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		//No horizontal scrollbar
		scrollbar.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		//Places panel with scrollbar to the frame. 
		flowFrame.add(scrollbar);
	
	}
		
	
		/**
		 * Displays flowchart in window
		 * @param xLocation- x position for top right corner of window
		 * @param yLocation- y position for top right corner of window
		 */
	public void showItToMe(int xLocation, int yLocation){
		
		flowFrame.setLocation(xLocation, yLocation);
		flowFrame.setVisible(true);
		
	}

	
	class FlowPanel extends JPanel
	{
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			//Draw the corresponding shape for each FlowShape
			for(FlowShape thing:listOfCommands)
			{
				if(thing.getShape().equalsIgnoreCase("diam")){
					flowDiamond(g,thing.getName(),thing.getPositionX(),thing.getPositionY());
				}
				else if(thing.getShape().equalsIgnoreCase("rect")){
					flowRectangle(g,thing.getName(),thing.getPositionX(),thing.getPositionY());
				}
				else if(thing.getShape().equalsIgnoreCase("circle"))
				{
					circle(g,thing.getName(),thing.getPositionX(),thing.getPositionY());
				}
			}
			
		}
		//Creates an arrow
		private void arrow(Graphics g, int x, int y)
		{
			
			g.drawLine(x,y, x,y+100);
			g.drawLine(x,y+100, x-10,y+90);
			g.drawLine(x,y+100, x+10,y+90);
			

		}
		//Creates arrow for case of an if
		private void ifArrow(Graphics g, int x, int y)
		{
			
			arrow(g,x,y);
			g.setFont(new Font("Arial", Font.PLAIN, 20));
			g.drawString("yes", x-30,y+50);
			g.drawLine(x+100,y-100, x+210,y-100);
			g.drawLine(x+210,y-100, x+210,y+100);
			g.drawLine(x+210,y+100, x+200,y+90);
			g.drawLine(x+210,y+100, x+220,y+90);
			g.drawString("no", x+190,y+50);

		}
		//Creates a circle
		private void circle(Graphics g, String name, int x, int y)
		{
			g.setColor(new Color(164, 221, 237));
			g.fillOval(x-50,y, 100, 100);
			g.setFont(new Font("Arial", Font.PLAIN, 25));
			g.setColor(Color.black);
			g.drawString(name, x-30,y+50);
			if(!name.equalsIgnoreCase("end"))
			{
				arrow(g,x,y+100);
			}
	
		
		}
		//Creates rectangle 
		private void flowRectangle(Graphics g, String name, int x, int y)
		{
			g.setColor(new Color(164, 221, 237));
			g.fillRect(x-100, y, 200, 100);
			g.setFont(new Font("Arial", Font.PLAIN, 25));
			g.setColor(Color.black);
			g.drawString(name, x-20,y+50);
			arrow(g,x,y+100);
		}
		//Creates diamond for if
		private void flowDiamond(Graphics g, String name, int x, int y)
		{
			int x1[]= {x,x+100,x,x-100};
			int y1[] = {y,y+100,y+200,y+100};
			g.setColor(new Color(164, 221, 237));
			g.fillPolygon(x1, y1, 4);

			g.setFont(new Font("Arial", Font.PLAIN, 25));
			g.setColor(Color.black);
			g.drawString(name, x-20,y+100);
			
			ifArrow(g,x,y+200);
		}
			

		
	}

}
