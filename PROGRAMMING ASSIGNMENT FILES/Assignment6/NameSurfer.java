/*
 * File: NameSurfer.java
 * ---------------------
 * When it is finished, this program will implements the viewer for
 * the baby-name database described in the assignment handout.
 */

import acm.program.*;
import acmx.export.javax.swing.JTextField;

import java.awt.event.*;
import javax.swing.*;

public class NameSurfer extends Program implements NameSurferConstants {
	public static void main(String[] args) {
		new NameSurfer().start(args);
	}
	
/**
	 * 
	 */
	private static final long serialVersionUID = -1750292467491516827L;
/* Method: init() */
/**
 * This method has the responsibility for reading in the data base
 * and initializing the interactors at the bottom of the window.
 */
	public void init() {
		graph=new NameSurferGraph();
		graph.update();
		add(graph);
		
		enterName= new JTextField(20);
		enterName.setActionCommand("Graph");
		enterName.addActionListener(this);
		
		add(new JLabel("NAME"), SOUTH);
		add(enterName, SOUTH);
		add(new JButton("Graph"), SOUTH);
		add(new JButton("Clear"), SOUTH);
		addActionListeners();
		
		
	    // You fill this in, along with any helper methods //
	}


/* Method: actionPerformed(e) */
/**
 * This class is responsible for detecting when the buttons are
 * clicked, so you will have to define a method to respond to
 * button actions.
 */
	public void actionPerformed(ActionEvent e) {
		String cmd= e.getActionCommand();
		if (cmd.equals("Graph")){
		NameSurferEntry entry=new NameSurferEntry(enterName.getText());
		graph.addEntry(entry);
		graph.update();
		}
		
		else if (cmd.equals("Clear")){
			graph.clear();
			
			}// You fill this in //
	}
	
	private NameSurferGraph graph;
	private JTextField enterName;
}
