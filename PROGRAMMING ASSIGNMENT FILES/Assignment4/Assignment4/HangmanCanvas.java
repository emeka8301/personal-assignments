/*
 * File: HangmanCanvas.java
 * ------------------------
 * This file keeps track of the Hangman display.
 */

import acm.graphics.*;

public class HangmanCanvas extends GCanvas {

	
/** Resets the display so that only the scaffold appears */
	public void reset() {
		removeAll();
//		scaffold
		add(new GLine(150+HEAD_RADIUS-BEAM_LENGTH,50-ROPE_LENGTH,150+HEAD_RADIUS-BEAM_LENGTH,50-ROPE_LENGTH+SCAFFOLD_HEIGHT));
//		beam
		add(new GLine(150+HEAD_RADIUS,50-ROPE_LENGTH,150+HEAD_RADIUS-BEAM_LENGTH,50-ROPE_LENGTH));
	}

/**
 * Updates the word on the screen to correspond to the current
 * state of the game.  The argument string shows what letters have
 * been guessed so far; unguessed letters are indicated by hyphens.
 */
	public void displayWord(String word) {
		/* You fill this in */
	}
	
	/**
	 * Updates the display to correspond to an incorrect guess by the
	 * user.  Calling this method causes the next body part to appear
	 * on the scaffold and adds the letter to the list of incorrect
	 * guesses that appears at the bottom of the window.
	 */
		public void noteIncorrectGuess(int n) {
			add(bodyParts(n));/* You fill this in */
		}

	public GObject bodyParts(int n){

		switch(n){
		
		case 1: return new GLine(150+HEAD_RADIUS,50,150+HEAD_RADIUS,50-ROPE_LENGTH);// rope
		case 2: return new GOval(150,50,HEAD_RADIUS*2,HEAD_RADIUS*2);//head
		case 3: return new GLine(150+HEAD_RADIUS,50+HEAD_RADIUS*2,150+HEAD_RADIUS,50+BODY_LENGTH+HEAD_RADIUS*2);//body
		case 4: return arms();//right and left arms
		case 5: return fingers();// returns fingers
		case 6: return hips();// hips
		case 7: return legs();//legs 
		case 8: return feet();//feet
		default: return null;
		
		}
		
	}
	private GObject feet() {
		// TODO Auto-generated method stub
		add(new GLine(150+HEAD_RADIUS+HIP_WIDTH,50+BODY_LENGTH+HEAD_RADIUS*2+LEG_LENGTH,150+HEAD_RADIUS+HIP_WIDTH+FOOT_LENGTH,50+BODY_LENGTH+HEAD_RADIUS*2+LEG_LENGTH)); 
		return new GLine(150-HEAD_RADIUS+HIP_WIDTH,50+BODY_LENGTH+HEAD_RADIUS*2+LEG_LENGTH,150-HEAD_RADIUS+HIP_WIDTH-FOOT_LENGTH,50+BODY_LENGTH+HEAD_RADIUS*2+LEG_LENGTH); 
	}

	private GObject hips() {
		// TODO Auto-generated method stub
		add(new GLine(150+HEAD_RADIUS,50+BODY_LENGTH+HEAD_RADIUS*2,150+HEAD_RADIUS+HIP_WIDTH,50+BODY_LENGTH+HEAD_RADIUS*2));
		return new GLine(150+HEAD_RADIUS,50+BODY_LENGTH+HEAD_RADIUS*2,150+HEAD_RADIUS-HIP_WIDTH,50+BODY_LENGTH+HEAD_RADIUS*2);
	}

	private GObject fingers() {
		// TODO Auto-generated method stub
		add(new GLine(150+HEAD_RADIUS-UPPER_ARM_LENGTH,50+HEAD_RADIUS*2+ARM_OFFSET_FROM_HEAD,150+HEAD_RADIUS-UPPER_ARM_LENGTH,50+HEAD_RADIUS*2+ARM_OFFSET_FROM_HEAD+LOWER_ARM_LENGTH));
		return new GLine(150+HEAD_RADIUS+UPPER_ARM_LENGTH,50+HEAD_RADIUS*2+ARM_OFFSET_FROM_HEAD,150+HEAD_RADIUS+UPPER_ARM_LENGTH,50+HEAD_RADIUS*2+ARM_OFFSET_FROM_HEAD+LOWER_ARM_LENGTH);
	}

	private GObject arms() {
		// TODO Auto-generated method stub
	add(new GLine(150+HEAD_RADIUS,50+HEAD_RADIUS*2+ARM_OFFSET_FROM_HEAD,150+HEAD_RADIUS-UPPER_ARM_LENGTH,50+HEAD_RADIUS*2+ARM_OFFSET_FROM_HEAD));
	return new GLine(150+HEAD_RADIUS,50+HEAD_RADIUS*2+ARM_OFFSET_FROM_HEAD,150+HEAD_RADIUS+UPPER_ARM_LENGTH,50+HEAD_RADIUS*2+ARM_OFFSET_FROM_HEAD);/* You fill this in */
	}

	private GObject legs(){
		add(new GLine(150+HEAD_RADIUS+HIP_WIDTH,50+BODY_LENGTH+HEAD_RADIUS*2,150+HEAD_RADIUS+HIP_WIDTH,50+BODY_LENGTH+HEAD_RADIUS*2+LEG_LENGTH));
		return new GLine(150-HEAD_RADIUS+HIP_WIDTH,50+BODY_LENGTH+HEAD_RADIUS*2,150-HEAD_RADIUS+HIP_WIDTH,50+BODY_LENGTH+HEAD_RADIUS*2+LEG_LENGTH);
	}


/* Constants for the simple version of the picture (in pixels) */
	private static final int SCAFFOLD_HEIGHT = 360;
	private static final int BEAM_LENGTH = 144;
	private static final int ROPE_LENGTH = 18;
	private static final int HEAD_RADIUS = 36;
	private static final int BODY_LENGTH = 144;
	private static final int ARM_OFFSET_FROM_HEAD = 28;
	private static final int UPPER_ARM_LENGTH = 72;
	private static final int LOWER_ARM_LENGTH = 44;
	private static final int HIP_WIDTH = 36;
	private static final int LEG_LENGTH = 108;
	private static final int FOOT_LENGTH = 28;

}
