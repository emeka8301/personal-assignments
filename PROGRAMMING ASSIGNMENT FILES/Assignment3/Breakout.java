/*
 * File: Breakout.java
 * -------------------
 * Name:
 * Section Leader:
 * 
 * This file will eventually implement the game of Breakout.
 */

import acm.graphics.*;
import acm.program.*;
import acm.util.*;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class Breakout extends GraphicsProgram {

	public static void main(String[] args){
		new Breakout().start(args);
	}
/** Width and height of application window in pixels */
	public static final int APPLICATION_WIDTH = 400;
	public static final int APPLICATION_HEIGHT = 600;

/** Dimensions of game board (usually the same) */
	private static final int WIDTH = APPLICATION_WIDTH;
	private static final int HEIGHT = APPLICATION_HEIGHT;

/** Dimensions of the paddle */
	private static final int PADDLE_WIDTH = 60;
	private static final int PADDLE_HEIGHT = 10;

/** Offset of the paddle up from the bottom */
	private static final int PADDLE_Y_OFFSET = 30;

/** Number of bricks per row */
	private static final int NBRICKS_PER_ROW = 10;

/** Number of rows of bricks */
	private static final int NBRICK_ROWS = 10;

/** Separation between bricks */
	private static final int BRICK_SEP = 4;

/** Width of a brick */
	private static final int BRICK_WIDTH =
	  (WIDTH - (NBRICKS_PER_ROW - 1) * BRICK_SEP) / NBRICKS_PER_ROW;

/** Height of a brick */
	private static final int BRICK_HEIGHT = 8;

/** Radius of the ball in pixels */
	private static final int BALL_RADIUS = 10;

/** Offset of the top brick row from the top */
	private static final int BRICK_Y_OFFSET = 70;

/** Number of turns */
	private static final int NTURNS = 3;

/* Method: run() */
/** Runs the Breakout program. */
	public void run() {
		
		gameSetUp(); 
	//sets up the game
		gamePlay();
		// plays te game
		/* You fill this in, along with any subsidiary methods */
	}


//set up game
private void gameSetUp() {
	GRect gameBox=new GRect(WIDTH,HEIGHT);
add(gameBox);
//number of rows
for (int i=0; i<NBRICK_ROWS;i++){
	//number of columns
	for (int j=0; j<NBRICKS_PER_ROW; j++){
		
		int x=(j*(BRICK_WIDTH+BRICK_SEP));
		int y=((i)*(BRICK_HEIGHT+BRICK_SEP));
		
		
	    brickSize=new GRect(x+BRICK_SEP/2,y+BRICK_Y_OFFSET,BRICK_WIDTH,BRICK_HEIGHT);
		((GRect) brickSize).setFilled(true);
		brickSize.setColor(brickColor(i));
		add(brickSize);	
	
		
	}
	
}

//create the paddle
paddle=new GRect (0,(getHeight()-((getHeight()-HEIGHT)))-(PADDLE_Y_OFFSET+PADDLE_HEIGHT),PADDLE_WIDTH,PADDLE_HEIGHT);
paddle.setFilled(true);
add(paddle);

addMouseListeners();
// TODO Auto-generated method stub
}

public void mouseMoved(MouseEvent e){
	if (e.getX()<(WIDTH-PADDLE_WIDTH)){
	paddle.move(e.getX()-lastX,0);
	lastX = e.getX();
	}
} 



private Color brickColor(int i){
	switch (i){
	case 0: case 1:
		return Color.RED;	
	case 2: case 3:
		return Color.ORANGE;
	case 4: case 5:
		return Color.YELLOW;	
	case 6: case 7:
		return Color.GREEN;	
	case 8: case 9:
		return Color.CYAN;	
		default:
			return null;
	}
}
private void gamePlay() {
	
	
	ball=new GOval((getWidth()-(getWidth()-WIDTH))/2-BALL_RADIUS,(getHeight()-(getHeight()-HEIGHT))/2-BALL_RADIUS,2*BALL_RADIUS,2*BALL_RADIUS);
	ball.setFilled(true);
	add(ball);
	
	vy=3.0;
	vx=rgen.nextDouble(1.0, 3.0);
	if (rgen.nextBoolean(0.5)) vx=-vx;
	


	while(!gameOver()){
	moveBall();
	
	 pause(paused);
	
	
	

}

	// TODO Auto-generated method stub	
}


private GObject getCollidingObject(){
	if(getElementAt(ball.getX(),ball.getY())!=null){
return getElementAt(ball.getX(),ball.getY());
	} 
	else if(getElementAt((ball.getX()+2*BALL_RADIUS),ball.getY())!=null){
		return getElementAt((ball.getX()+2*BALL_RADIUS),ball.getY());
	}
	else if(getElementAt(ball.getX(),(ball.getY()+2*BALL_RADIUS))!=null){
		return getElementAt(ball.getX(),(ball.getY()+2*BALL_RADIUS));
	}
	else if (getElementAt((ball.getX()+ 2*BALL_RADIUS),(ball.getY()+2*BALL_RADIUS))!=null){
		return getElementAt((ball.getX()+ 2*BALL_RADIUS),(ball.getY()+2*BALL_RADIUS));
	}
	else {return null;
	}
}

private void moveBall() {
	
	// TODO Auto-generated method stub
	ball.move(vx,-vy);
	
	if(ball.getY()>=(HEIGHT-2*BALL_RADIUS) || ball.getY()<0){
	vy=-vy;
		
	}
	
	if(ball.getX()>=(WIDTH-2*BALL_RADIUS) || ball.getX()<0){
		vx=-vx;
			
		}
	GObject collider = getCollidingObject();
	 if (collider==paddle){
		 vy=-vy;
		 AudioClip bounceClip= MediaTools.loadAudioClip("bounce.au");
		 bounceClip.play();
	 }
	 else if (collider!=null){
		 
		 remove(collider);
		 count-=1;
		 vy=-vy;
		

		 }
	if(ball.getY()>HEIGHT-PADDLE_Y_OFFSET){
		remove(ball);
		n-=1;
		add(ball,WIDTH/2,HEIGHT/2);
		
		
		
	}	
}

private boolean gameOver(){
	
	if (count==0){
		removeAll();
		add(new GLabel("YOU WIN" ,WIDTH/2,HEIGHT/2));
		return true;
	}
	else if(n==0) {
		removeAll();
		add(new GLabel("YOU LOSE" ,WIDTH/2,HEIGHT/2));
	return true;	
	}
	else return false;
	
}

private GOval ball;
public GRect brickSize; //ADDS BRICKS TO THE BOARD
private GRect paddle; //CREATES THE PADDLE
private double lastX; //STORES LAST POSITION FOR X
private double vx,vy; //velocity of the ball
private RandomGenerator rgen=new RandomGenerator();
private int count=NBRICKS_PER_ROW*NBRICK_ROWS;
private int n=NTURNS;
private int paused= 15;
}
