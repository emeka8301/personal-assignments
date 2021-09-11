/* 
 * File: FacePamphlet.java
 * -----------------------
 * When it is finished, this program will implement a basic social network
 * management system.
 */

import acm.program.*;
import acm.graphics.*;
import acm.util.*;
import java.awt.event.*;
import javax.swing.*;

public class FacePamphlet extends Program 
					implements FacePamphletConstants {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1493044478911780658L;
	public static void main(String[] args) {
		new FacePamphlet().start(args);
	}
	/**
	 * This method has the responsibility for initializing the 
	 * interactors in the application, and taking care of any other 
	 * initialization that needs to be performed.
	 */
	public void init() {
		canvas = new FacePamphletCanvas();
		add(canvas);
		//WEST BUTTONS
		status= new JTextField(TEXT_FIELD_SIZE);
		status.setActionCommand("Change Status");
		status.addActionListener(this);
		
		profilePicture= new JTextField(TEXT_FIELD_SIZE);
		profilePicture.setActionCommand("Change Photo");
		profilePicture.addActionListener(this);
		
		addFriend= new JTextField(TEXT_FIELD_SIZE);
		addFriend.setActionCommand("Add Friend");
		addFriend.addActionListener(this);
		
		add(status, WEST);
		add(new JButton("Change Status"),WEST);
		add(new JLabel(EMPTY_LABEL_TEXT), WEST);
		add(profilePicture, WEST);
		add(new JButton("Change Photo"),WEST);
		add(new JLabel(EMPTY_LABEL_TEXT), WEST);
		add(addFriend, WEST);
		add(new JButton("Add Friend"),WEST);
		
		
		//NORTH 
		addProfile=new JTextField(TEXT_FIELD_SIZE);
		
		add(new JLabel("Name: "),NORTH);
		add(addProfile, NORTH);
		add(new JButton("ADD"),NORTH);
		add(new JButton("DELETE"),NORTH);
		add(new JButton("LOOKUP"),NORTH);
		
		addActionListeners();
		// You fill this in
    }
    
  
    /**
     * This class is responsible for detecting when the buttons are
     * clicked or interactors are used, so you will have to add code
     * to respond to these actions.
     */
    public void actionPerformed(ActionEvent e) {
		String com=e.getActionCommand();
		if(com.equals("Change Status")&& !status.getText().equals("")){
		if(current!=null){
			String updatestatus= status.getText();
			current.setStatus(updatestatus);
			 canvas.displayProfile(current);
			 canvas.showMessage(current.getName() + "'s status changed to " + updatestatus );
			 
		}
		else{
			canvas.remove();
			canvas.showMessage("select a profile to update status");
		}
		}
		
		else if(com.equals("Change Photo")&& !profilePicture.getText().equals("")){
			if(current!=null){
				String filename=profilePicture.getText();
				GImage image = null;
				 try {
				 image = new GImage(filename);
				 } catch (ErrorException ex) {
					 canvas.displayProfile(current);
					 canvas.showMessage(" Invalid Photo");// Code that is executed if the filename cannot be opened.
				 }
				 if(image!=null){
					 current.setImage(image);
					 canvas.displayProfile(current);
					 canvas.showMessage("image changed");
					 }

			}
			else{
				canvas.remove();
				canvas.showMessage("select a profile to update photo");
			}
		}
		
		
		else if(com.equals("Add Friend")&& !addFriend.getText().equals("")){
			if (current!=null){
				String friend=addFriend.getText();
				if(data.containsProfile(friend) && !current.getName().equals(friend)){
					if(current.addFriend(friend)){
					current.addFriend(friend);
					data.getProfile(friend).addFriend(current.getName());
					 canvas.displayProfile(current);
					 canvas.showMessage(friend + " is now your friend");
					 }
					else{
					 canvas.displayProfile(current);
					 canvas.showMessage(friend + " is already in your friendslist");
					}
				}
				else{
					 canvas.displayProfile(current);
					 canvas.showMessage(friend + "'s profile does not exist");
					}
				}
			else{
				canvas.remove();
				 canvas.showMessage("select a profile to update friendslist");
			}
		}
		
		else if(com.equals("ADD")&& !addProfile.getText().equals("")){
			String add=addProfile.getText();
			FacePamphletProfile newprofile;
			if(!data.containsProfile(add)){
				newprofile=new FacePamphletProfile(add);
				data.addProfile(newprofile);
				
			  current=data.getProfile(add);
			  canvas.displayProfile(current);
			  canvas.showMessage("New profile added");
			}else{
			current=data.getProfile(add);
			canvas.displayProfile(current);
			canvas.showMessage(current.getName()+" profile already exists");
			}
			
		}
		
		else if(com.equals("DELETE")&& !addProfile.getText().equals("")){
			String delete=addProfile.getText();
			if(data.containsProfile(delete)){
				data.deleteProfile(delete);
				current=null;
				canvas.remove();
				canvas.showMessage(delete+" profile has been deleted");
			}
			else{
				current=null;
				canvas.remove();
				canvas.showMessage(delete+" profile does not exist");
			}
		}
		
		else if(com.equals("LOOKUP") && !addProfile.getText().equals("")){
			String lookup=addProfile.getText();
			if(data.containsProfile(lookup)){
				current=data.getProfile(lookup);
				canvas.displayProfile(current);
				canvas.showMessage("Displaying "+current.getName());
			}
			else{
				canvas.remove();
				current=null;
				canvas.showMessage(lookup+" profile does not exist");
			}
		}
		
	// You fill this in as well as add any additional methods
	}
private JTextField status;
private JTextField profilePicture;
private JTextField addFriend;
private FacePamphletDatabase data=new FacePamphletDatabase();
private FacePamphletProfile current;
private JTextField addProfile;
private FacePamphletCanvas canvas;

}
