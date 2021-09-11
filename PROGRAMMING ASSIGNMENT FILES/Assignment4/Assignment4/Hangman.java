/*
 * File: Hangman.java
 * ------------------
 * This program will eventually play the Hangman game from
 * Assignment #4.
 */

import acm.graphics.*;
import acm.program.*;
import java.util.Arrays;

public class Hangman extends ConsoleProgram {
	public static void main(String[] args) {
		new Hangman().start(args);
	}
	public void init(){
		canvas=new HangmanCanvas();
		add(canvas);
		canvas.reset();		
	}
    public void run() {
    	lexicon=new HangmanLexicon();
    	
    	
    	String play=readLine(" Enter \"0\" to play");
    	println("WELCOME TO HANGMAN");
    	while (play.equals("0")){
    	
    	String randomWord= (String) lexicon.getWord();//generates a random word from the class
    	int wordcount=lexicon.getWordCount(randomWord);//gets the word count for the selected random word
    	char[] characterforRandomWord= randomWord.toCharArray(); //changes the string into array of characters
    	char[] blanks=new char[wordcount];// creates the blank lines on the screen
    	char [] check= new char[wordcount];// used to check if the user has entered a valid letter 
    	int tries=8;//number of tries per word
    	
    	
    	
    	print("The word now looks like this:	");
    	
    	
    	//prints blanks on the screen 
    	for (int i=0; i<characterforRandomWord.length;i++){
    		blanks[i]='_';
    		print(blanks[i] + " ");
    		canvas.add(new GLabel(blanks[i] + " "),100+i*10,400);
    		}
    	println("");
    	println("You have "+ tries + " tries left");
    	
 
    	//makes check equal to blanks as its initial stage
    	for (int i=0; i<characterforRandomWord.length;i++){
    		check[i]='_';
    		}
    	int d=0;
    	int k=0;
    	//plays the game
    	while (tries!=0){
    		
    		println(" ");
    		char ch=inputLetter();
    		// gets an input letter from the user
    		canvas.add(new GLabel(ch + " "),100+k*10,450);
    		k+=1;
    		
    		//checks if the input letter is present in the string converted to char[] array
    		//if it is present, it replaces the '_' with the character ch 
    		for (int i=0; i<characterforRandomWord.length;i++){
    			if (ch==characterforRandomWord[i]){
    			blanks[i]=ch;
    			}}
    		
    		//this part subtracts 1 if the user inputs a wrong ch
    		/*the problem initially was that if you input the same ch, it 
    		 * will always be equal to check but with the contains function, if 
    		 * ch is already present, it skips the step
    		 */
    		if(!(contains(blanks,ch))){
    			if (Arrays.equals(blanks,check)){
    			tries-=1;
    			
    			d+=1;
    			canvas.noteIncorrectGuess(d);
    		} }
    		
    		print("The word now looks like this:	");
    		//prints blanks array after searching for ch
    		for (int i=0; i<characterforRandomWord.length;i++){
    		print(blanks[i]+ " ");
    		canvas.add(new GLabel(blanks[i] + " "),100+i*10,400);
    		}
        	
    		println("");
        	println("You have "+ tries + " tries left");
        	
        	
    		//makes check equal to blanks so that it is able to decide if the next input is the same or not present
    		for (int i=0; i<characterforRandomWord.length; i++){
    		check[i]=blanks[i];
    		}
        
        	
        	//breaks from the loop if blanks is complete and still have valid tries left
        	if (Arrays.equals(blanks, characterforRandomWord))break;
        		
    		}
    	
    	if (tries==0){
    		println("YOU LOSE! the word is "+ randomWord );
    	}else {
    		println("YOU WIN" );
    	}
    	play=readLine(" Enter \"0\" to play again");
    	canvas.reset();
    	}
    }
    
    
    // inputs your guess into the game
    private char inputLetter(){
    	String str=readLine("Enter a character: ");
    
    	while (str.length()>1||str.length()<1){
    		str=readLine("Enter ONE character: ");
    	}
    	char strChar=str.charAt(0);
    	
    	while (!(Character.isLetter(strChar))){
    		str=readLine("Enter a character that is a Letter: ");
    		strChar=str.charAt(0);
    		
    		while (str.length()>1){
        		str=readLine("Enter ONE character that is a letter: ");
        	}
    		
    		strChar=str.charAt(0);
    		if (Character.isLetter(strChar)) break;
    	}
    	
    	strChar =Character.toUpperCase(strChar);
    	return strChar;
    	}
    	
    	//contains method cheks if ch is present in the array word
    private boolean contains(char[] word, char ch){
    	for (int i=0; i<word.length;i++){
    		if (ch==word[i]){
    			return true;
    			}
    		}
    	return false;
    }
	private HangmanCanvas canvas;
    private HangmanLexicon lexicon;
}
