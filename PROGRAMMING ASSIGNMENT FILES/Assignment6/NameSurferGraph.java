/*
 * File: NameSurferGraph.java
 * ---------------------------
 * This class represents the canvas on which the graph of
 * names is drawn. This class is responsible for updating
 * (redrawing) the graphs whenever the list of entries changes or the window is resized.
 */

import acm.graphics.*;

import java.awt.event.*;
import java.util.*;
import java.awt.*;

public class NameSurferGraph extends GCanvas
	implements NameSurferConstants, ComponentListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9084754009601797106L;
	/**
	* Creates a new NameSurferGraph object that displays the data.
	*/
	public NameSurferGraph() {
		displayName=new ArrayList<NameSurferEntry>();	
		addComponentListener(this);
		//	 You fill in the rest //
	}
	
	/**
	* Clears the list of name surfer entries stored inside this class.
	*/
	public void clear() {
		removeAll();
		//	 You fill this in //
	}
	
	/* Method: addEntry(entry) */
	/**
	* Adds a new NameSurferEntry to the list of entries on the display.
	* Note that this method does not actually draw the graph, but
	* simply stores the entry; the graph is drawn by calling update.
	*/
	public void addEntry(NameSurferEntry entry) {
		 displayName.add(entry);
	}
	
	
	
	/**
	* Updates the display image by deleting all the graphical objects
	* from the canvas and then reassembling the display according to
	* the list of entries. Your application must call update after
	* calling either clear or addEntry; update is also called whenever
	* the size of the canvas changes.
	*/
	public void update() {
		removeAll();
		initialGraph();
		drawGraph(displayName);
//	 You fill this in //
	}
	
	
	
	
	public void drawGraph(ArrayList<NameSurferEntry> displayName2) {
		for (int j=0; j<displayName.size(); j++){
NameSurferEntry entry=displayName.get(j);
color = selectColor(j);
			try{
				int startPointY;
				int endPointY;
				int startPointX;
				int endPointX;
				
				for (int i=1; i<NDECADES; i++){
					
					if (entry.getRank(i-1)==0){startPointY=getHeight()-GRAPH_MARGIN_SIZE;}
					
					else{startPointY=GRAPH_MARGIN_SIZE+((getHeight()-GRAPH_MARGIN_SIZE*2)*entry.getRank(i-1)/MAX_RANK);}
				 
					if (entry.getRank(i)==0){endPointY=getHeight()-GRAPH_MARGIN_SIZE;}
					else{endPointY=GRAPH_MARGIN_SIZE+((getHeight()-GRAPH_MARGIN_SIZE*2)*entry.getRank(i)/MAX_RANK);}
				 
					
					 startPointX=(i-1)*getWidth()/NDECADES; 
					 endPointX=(i)*getWidth()/NDECADES;
					
					
					if (entry.getRank(i-1)==0){
						GLabel label=new GLabel(entry.getName()+"*",startPointX,getHeight()-GRAPH_MARGIN_SIZE);
						label.setColor(color);
						add(label);	
					} else{
					GLabel label=new GLabel(entry.getName()+entry.getRank(i-1),startPointX,startPointY);
					label.setColor(color);
					add(label);}
					
			
					GLine line=new GLine(startPointX,startPointY,endPointX,endPointY);
					line.setColor(color);
					add(line);
				}
				
				 startPointY=GRAPH_MARGIN_SIZE+((getHeight()-GRAPH_MARGIN_SIZE*2)*entry.getRank(10)/MAX_RANK);
				startPointX=(10)*getWidth()/NDECADES;
				if(entry.getRank(10)==0){
					
					GLabel label=new GLabel (entry.getName()+"*",startPointX,getHeight()-GRAPH_MARGIN_SIZE);
					label.setColor(color);
					add(label);
				}
				
				else{
				GLabel label=new GLabel (entry.getName()+entry.getRank(10),startPointX,startPointY);
				label.setColor(color);
				add(label);
				}}
				 catch (NullPointerException ex) {
					displayName.get(j).toString();
				 }// You fill thi
		}// TODO Auto-generated method stub
		
	}

	private Color selectColor(int j) {
	if(j>=4) j=j%4;
	
	switch (j){
	case 0: return Color.BLACK;
	case 1: return Color.RED;
	case 2: return Color.BLUE;
	case 3: return Color.MAGENTA;
	default:return null;
	}// TODO Auto-generated method stub
		
	}

	private void initialGraph() {
		int decade=1900;
		for (int i=0; i<NDECADES;i++){
			int jump=i*getWidth()/NDECADES;
			add(new GLine(jump,0,jump,getHeight()));
			
			String decadeString= String.valueOf(decade);
			add(new GLabel(decadeString),jump,getHeight()-GRAPH_MARGIN_SIZE/4);
			decade+=10;
		}
		add(new GLine(0,GRAPH_MARGIN_SIZE,getWidth(),GRAPH_MARGIN_SIZE));
		add(new GLine(0,getHeight()-GRAPH_MARGIN_SIZE,getWidth(),getHeight()-GRAPH_MARGIN_SIZE));	// TODO Auto-generated method stub
		
	}

	/* Implementation of the ComponentListener interface */
	public void componentHidden(ComponentEvent e) { }
	public void componentMoved(ComponentEvent e) { }
	public void componentResized(ComponentEvent e) { update(); }
	public void componentShown(ComponentEvent e) { }
	
	private Color color;
	private ArrayList<NameSurferEntry> displayName;
}
