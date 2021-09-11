/*
 * File: FacePamphletCanvas.java
 * -----------------------------
 * This class represents the canvas on which the profiles in the social
 * network are displayed.  NOTE: This class does NOT need to update the
 * display when the window is resized.
 */


import acm.graphics.*;
import java.awt.*;

public class FacePamphletCanvas extends GCanvas 
					implements FacePamphletConstants {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5557704207950965108L;

	/** 
	 * Constructor
	 * This method takes care of any initialization needed for 
	 * the display
	 */
	public FacePamphletCanvas() {
		// You fill this in
	}

	
	/** 
	 * This method displays a message string near the bottom of the 
	 * canvas.  Every time this method is called, the previously 
	 * displayed message (if any) is replaced by the new message text 
	 * passed in.
	 */
	public void showMessage(String msg) {
		GLabel label=new GLabel(msg);
		label.setFont(MESSAGE_FONT);
		double x=(getWidth()-label.getWidth())/2;
		double y=getHeight()-BOTTOM_MESSAGE_MARGIN;
		add(label,x,y);// You fill this in
	}
	
	
	/** 
	 * This method displays the given profile on the canvas.  The 
	 * canvas is first cleared of all existing items (including 
	 * messages displayed near the bottom of the screen) and then the 
	 * given profile is displayed.  The profile display includes the 
	 * name of the user from the profile, the corresponding image 
	 * (or an indication that an image does not exist), the status of
	 * the user, and a list of the user's friends in the social network.
	 */
	public void displayProfile(FacePamphletProfile profile) {
	removeAll();
	//name
	GLabel name= new GLabel(profile.getName());
	name.setColor(Color.BLUE);
	name.setFont( PROFILE_NAME_FONT);
	double y=TOP_MARGIN+name.getAscent();
	add(name, LEFT_MARGIN, y);
	
	//image
	GRect imageRect= new GRect(IMAGE_WIDTH,IMAGE_HEIGHT);
	double xImage=LEFT_MARGIN;
	double yImage=y+IMAGE_MARGIN;
	
	if (profile.getImage()==null){
		add(imageRect,xImage,yImage);
		GLabel noImage= new GLabel("No Image");
		noImage.setFont(PROFILE_IMAGE_FONT);
		add(noImage,((xImage+IMAGE_WIDTH)-noImage.getWidth())/2,yImage+IMAGE_HEIGHT/2+noImage.getAscent()/2);
	}else{
		GImage image=profile.getImage();
image.setBounds(xImage,yImage,IMAGE_WIDTH,IMAGE_HEIGHT);
		add(image);
	}
	
	//status
	if(profile.getStatus().equals("")){
		GLabel status= new GLabel("No Current Status");
		double yStatus= yImage + IMAGE_HEIGHT +  STATUS_MARGIN+status.getAscent();
		status.setFont(PROFILE_STATUS_FONT);
		add(status,xImage,yStatus);
	}
	else{
		GLabel status= new GLabel(profile.getName()+" is "+profile.getStatus());
		double yStatus= yImage + IMAGE_HEIGHT +  STATUS_MARGIN+status.getAscent();
		status.setFont(PROFILE_STATUS_FONT);
		add(status,xImage,yStatus);
	}
	
	GLabel friends=new GLabel("Friends: ");
	friends.setFont(PROFILE_FRIEND_LABEL_FONT);
	double xF=(getWidth()-friends.getWidth())/2;
	double yF=yImage+friends.getDescent();
	add(friends,xF,yF);
	
	for (int i=0; i<profile.getFriends().size();i++){
		GLabel fL= new GLabel(profile.getFriends().get(i));
		yF+=15;
		fL.setFont(PROFILE_FRIEND_FONT);
		add(fL,xF,yF);
		
	}
	
	
	//friends
	
	
// You fill this in
	}
	
public void remove(){
	removeAll();
}

	
}
