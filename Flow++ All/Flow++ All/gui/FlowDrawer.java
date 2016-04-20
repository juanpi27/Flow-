package gui;


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
	
	private boolean mes=false;

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
		panel.setPreferredSize(new Dimension(2000,10000));
		
		//Assigns the scrollbar to the panel
		 JScrollPane scrollbar = new JScrollPane(panel);
		//We want a vertical scrollbar
		scrollbar.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		//No horizontal scrollbar
		scrollbar.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		//Places panel with scrollbar to the frame. 
		flowFrame.add(scrollbar);
	
	}
		/**
		 * Displays flowchart in window
		 * @param xLocation- x position for top right corner of window
		 * @param yLocation- y position for top right corner of window
		 */
	public void showItToMe(int xLocation, int yLocation)
	{
		
		flowFrame.setLocation(xLocation, yLocation);
		flowFrame.setVisible(true);
		
	}
	private class FlowPanel extends JPanel
	{
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			//Draw the corresponding shape for each FlowShape
			for(FlowShape thing:listOfCommands)
			{
				if(thing.getPositionX()!=0)
				{
			
			
					if(thing.getShape().equalsIgnoreCase("diam"))
					{
						flowDiamond(g,thing.getName(),thing.getPositionX(),thing.getPositionY(),thing.getNext(),thing.getNext2());
					}
					else if(thing.getShape().equalsIgnoreCase("rect"))
					{
						flowRectangle(g,thing.getName(),thing.getPositionX(),thing.getPositionY(), thing.getNext());
					}
					else if(thing.getShape().equalsIgnoreCase("circle"))
					{
						circle(g,thing.getName(),thing.getPositionX(),thing.getPositionY(), thing.getNext());
					}
				}
				else if(!mes)
				{
					FlowInterface.writeToUser("Error: Some components were not well positioned. "
							+ "Make sure everything has a next and a previous. One that of the components was "
							+ thing.getName(), true);
					
					mes=true;
				}
			}
		}
		
		//Creates a circle
		private void circle(Graphics g, String name, int x, int y, FlowShape next)
		{
			g.setColor(new Color(164, 221, 237));
			g.fillOval(x-50,y, 100, 100);
			g.setFont(new Font("Arial", Font.PLAIN, 25));
			g.setColor(Color.black);
			g.drawString(name, x-30,y+50);
			if(!name.equalsIgnoreCase("end"))
			{
				arrow(g,x,y+100, next);
			}
		}
		//Creates rectangle 
		private void flowRectangle(Graphics g, String name, int x, int y, FlowShape next)
		{
			g.setColor(new Color(164, 221, 237));
			g.fillRect(x-100, y, 200, 100);
			g.setFont(new Font("Arial", Font.PLAIN, 25));
			g.setColor(Color.black);
			g.drawString(name, x-20,y+50);
			arrow(g,x,y+100, next);
		}
		//Creates diamond for if
		private void flowDiamond(Graphics g, String name, int x, int y, FlowShape next, FlowShape next2)
		{
			int x1[]= {x,x+100,x,x-100};
			int y1[] = {y,y+100,y+200,y+100};
			g.setColor(new Color(164, 221, 237));
			g.fillPolygon(x1, y1, 4);
			g.setFont(new Font("Arial", Font.PLAIN, 25));
			g.setColor(Color.black);
			g.drawString(name, x-20,y+100);
			ifArrow(g,x,y+200, next, next2);
		}
		
		private void arrow(Graphics g, int x, int y,FlowShape next )
		{
			g.drawLine(x, y, x, y+50);
			if(x==next.getPositionX())
			{
				
				if(y<next.getPositionY())
				{
					g.drawLine(x, y+50, x, next.getPositionY());
					g.drawLine(x, next.getPositionY(), x-10, next.getPositionY()-10);
					g.drawLine(x, next.getPositionY(), x+10, next.getPositionY()-10);
					next.setPointed(true);
				}
				else
				{
					finishArrow(g,x,y,next,false,next.isPointed());
				}
			}
			else if(next.getPositionX()<x)
			{
				
				finishArrow(g,x,y,next,true,next.isPointed());
			}
			else
			{
				finishArrow(g,x,y,next,false,next.isPointed());
			}
		}
		private void arrowIf(Graphics g, int x, int y,FlowShape next )
		{
			g.drawLine(x, y, x, y+25);
			if(x==next.getPositionX())
			{
				
				if(y<next.getPositionY())
				{
					g.drawLine(x, y+25, x, next.getPositionY());
					g.drawLine(x, next.getPositionY(), x-10, next.getPositionY()-10);
					g.drawLine(x, next.getPositionY(), x+10, next.getPositionY()-10);
					next.setPointed(true);
				}
				else
				{
					finishArrow2(g,x,y,next, false,next.isPointed());
				}
			}
			else if(next.getPositionX()<x)
			{
				
				finishArrow2(g,x,y,next, true, next.isPointed());
			}
			else
			{
				finishArrow2(g,x,y,next,false, next.isPointed());
			}
		}
		private void ifArrow(Graphics g, int x, int y, FlowShape next, FlowShape next2)
		{
			arrowIf(g,x,y, next);
			g.setFont(new Font("Arial", Font.PLAIN, 20));
			g.drawString("yes", x-30,y+50);
						
			if(next2.getPositionX()<=x)
			{
				g.drawLine(x+100,y-100, x+150,y-100);
				g.drawLine(x+150,y-100, x+150,next2.getPositionY()-25);
				g.drawLine(x+150,next2.getPositionY()-25, next2.getPositionX(),next2.getPositionY()-25);
				g.drawLine(next2.getPositionX(),next2.getPositionY()-25, next2.getPositionX()+10,next2.getPositionY()-15);
				g.drawLine(next2.getPositionX(),next2.getPositionY()-25, next2.getPositionX()+10,next2.getPositionY()-35);
			}
			else
			{
				g.drawLine(x+100,y-100, next2.getPositionX(),y-100);
				g.drawLine(next2.getPositionX(),y-100, next2.getPositionX(),next2.getPositionY());
				g.drawLine(next2.getPositionX(),next2.getPositionY(), next2.getPositionX()-10,next2.getPositionY()-10);
				g.drawLine(next2.getPositionX(),next2.getPositionY(), next2.getPositionX()+10,next2.getPositionY()-10);		
				next2.setPointed(true);
			}
			g.drawString("no", x+160,y-85);

		}
		private void finishArrow(Graphics g, int x, int y, FlowShape next, boolean small, boolean pointed)
		{
			int dis=-110;
			int dis2=-10;
			int dis3=-60;
			int dis4=-40;
			if(small)
			{
				dis=110;
				dis2=10;
				dis3=60;
				dis4=40;
			}
			g.drawLine(x, y+50, next.getPositionX()+dis, y+50);
			g.drawLine(next.getPositionX()+dis, y+50, next.getPositionX()+dis, next.getPositionY()-50);
			g.drawLine(next.getPositionX()+dis, next.getPositionY()-50, next.getPositionX(), next.getPositionY()-50);
			if(!pointed)
			{
				g.drawLine(next.getPositionX(), next.getPositionY()-50, next.getPositionX(), next.getPositionY());
				g.drawLine(next.getPositionX(), next.getPositionY(), next.getPositionX()+10, next.getPositionY()-10);
				g.drawLine(next.getPositionX(), next.getPositionY(), next.getPositionX()-10, next.getPositionY()-10);
				next.setPointed(true);
			}
			else
			{
				g.drawLine(next.getPositionX(), next.getPositionY()-50, next.getPositionX()+dis2, next.getPositionY()-dis4);
				g.drawLine(next.getPositionX(), next.getPositionY()-50, next.getPositionX()+dis2, next.getPositionY()-dis3);
			}
			
			
			
			
		}
		private void finishArrow2(Graphics g, int x, int y, FlowShape next, boolean small, boolean pointed)
		{
			int dis=-110;
			int dis2=-10;
			if(small)
			{
				dis=110;
				dis2=10;
			}
			g.drawLine(x, y+25, next.getPositionX()+dis, y+25);
			g.drawLine(next.getPositionX()+dis, y+25, next.getPositionX()+dis, next.getPositionY()-25);
			g.drawLine(next.getPositionX()+dis, next.getPositionY()-25, next.getPositionX(), next.getPositionY()-25);
			if(!pointed)
			{
				g.drawLine(next.getPositionX(), next.getPositionY()-25, next.getPositionX(), next.getPositionY());
				g.drawLine(next.getPositionX(), next.getPositionY()-25, next.getPositionX()+10, next.getPositionY()-35);
				g.drawLine(next.getPositionX(), next.getPositionY()-25, next.getPositionX()-10, next.getPositionY()-35);
				next.setPointed(true);
			}
			else
			{
				g.drawLine(next.getPositionX(), next.getPositionY()-25, next.getPositionX()+dis2, next.getPositionY()-35);
				g.drawLine(next.getPositionX(), next.getPositionY()-25, next.getPositionX()+dis2, next.getPositionY()-15);
			}
			
		}
		
	}

}
