/*
 * File: Yahtzee.java
 * ------------------
 * This program will eventually play the Yahtzee game.
 */

import java.util.ArrayList;
import java.util.Arrays;

import acm.io.*;
import acm.program.*;
import acm.util.*;

public class Yahtzee extends GraphicsProgram implements YahtzeeConstants {
	
public static void main(String[] args) {
		new Yahtzee().start(args);
	}
	
public void run() {
		IODialog dialog = getDialog();
		nPlayers = dialog.readInt("Enter number of players");
		playerNames = new String[nPlayers];
		for (int i = 1; i <= nPlayers; i++) {
			playerNames[i - 1] = dialog.readLine("Enter name for player " + i);
		}
		display = new YahtzeeDisplay(getGCanvas(), playerNames);
		playGame();
	}

private void playGame() {
		int rolls=13;
		
		while(rolls!=0){
			for (int i=1; i<=nPlayers; i++){
		rollDie(i);
		updateCategory(i);
		}
		
		rolls-=1;
		}
		
		for (int i=1; i<=nPlayers; i++){
	updateFinalScore(i);
		}
		
	announceWinner();
		/* You fill this in */
	}

private void announceWinner() {
	int person=0;
	int max=0;
	for (int i=1; i<=nPlayers;i++){
		if (totalScore(i)>max){
					person=i;
					max=totalScore(i);
		}
				}
	
	display.printMessage("The winner is " + playerNames[person-1]+ " with a total of " + max + " points!!!. CONGRATULATIONS!!");
}

//method to update the final score 
private void updateFinalScore(int i) {
	// TODO Auto-generated method stub
	display.updateScorecard(7, i, upperScore(i));
	
	if (upperScore(i)>=63){
		display.updateScorecard(8, i, 35);
}else {
	display.updateScorecard(8, i, 0);
}
	display.updateScorecard(16, i, lowerScore(i));
	
	display.updateScorecard(17, i, totalScore(i));
	
	}

//method tocalculate the final score for upper and lower score
private int totalScore(int i) {
int bonus=upperScore(i);
if (bonus>=63) bonus+=35;
// TODO Auto-generated method stub
	return bonus + lowerScore(i);
}

//methods to calculae the lower score
private int lowerScore(int i) {
	int total=0;
	lowerCount(i);
	for (int j=0; j<lowerCount(i).size(); j++){
		total+= lowerCount(i).get(j);
	}
	// TODO Auto-generated method stub
	return total;
}
private ArrayList<Integer> lowerCount(int i) {
	if (i==1) {
		return array5;
	}
	else if(i==2){
		return array6;
	}
	else if (i==3){
		return array7;
	}
	
	else if (i==4){
		return array8;
	}else return null;
	// TODO Auto-generated me;
	// TODO Auto-generated method stub
	
}
private void addScoreLower(int i, int j) {
	if (i==1){
		array5.add(j);
	}
	
	else if(i==2){
	array6.add(j);	
	}
	
	else if(i==3){
		array7.add(j);
	}
	
	else if (i==4){
		array8.add(j);
	}// TODO Auto-generated method stub
	
}


//methods to calculate the upper score
private int upperScore(int i) {
	int total=0;
	upperCount(i);
	for (int j=0; j<upperCount(i).size(); j++){
		total+= upperCount(i).get(j);
	}
	// TODO Auto-generated method stub
	return total;
}
private ArrayList<Integer> upperCount(int i) {
	if (i==1) {
		return array1;
	}
	else if(i==2){
		return array2;
	}
	else if (i==3){
		return array3;
	}
	
	else if (i==4){
		return array4;
	}else return null;
	// TODO Auto-generated me;
	
}
private void addScoreUpper(int i, int j) {

	if (i==1){
		array1.add(j);
	}
	
	else if(i==2){
	array2.add(j);	
	}
	
	else if(i==3){
		array3.add(j);
	}
	
	else if (i==4){
		array4.add(j);
	}
}


//method to roll the die
private int[] rollDie(int index) {
	// TODO Auto-generated method stub
	display.printMessage( playerNames[index-1]+"'s turn to click roll ");
	display.waitForPlayerToClickRoll(index);
	
	dice=new int[N_DICE];

	for (int i=0; i<N_DICE;i++){
		dice[i]=rgen.nextInt(1,6);
		
	}
	display.displayDice(dice);
	
	int n=2;
	
	while(n!=0){
		display.printMessage(" You have "+n + " more roll" + (n==1?"":"s"));
	display.waitForPlayerToSelectDice();
	for (int i=0; i<N_DICE; i++){
		if (display.isDieSelected(i)){
			dice[i]=rgen.nextInt(1,6);
		}
		
	}
	display.displayDice(dice);
	n-=1;
	}
	return dice; 
	}


//method to update the category when selected
private void updateCategory(int i) {
		display.printMessage("Select a category ");
		int category=display.waitForPlayerToSelectCategory();
		
		while (categoryChecker(i).contains(category)){
			display.printMessage("ERROR! ENTER NEW CATEGORY");
			category=display.waitForPlayerToSelectCategory();
			
		}
		
		boolean p = checkifValid(dice, category);
		if (p==true){
			
			display.updateScorecard(category, i, count(category,dice));
			display.printMessage("Your score is "+count(category,dice));
			if (category<=6){
				addScoreUpper(i, count(category,dice));
			}else if(category>8 && category <=15){
				addScoreLower(i, count(category,dice));
			}
		}else {
			display.updateScorecard(category, i, 0);
			display.printMessage("Your score is 0");
			if (category<=6){
				addScoreUpper(i, 0);
			}else if(category>8 && category <=15) {
				addScoreLower(i, 0);
			}
		}
	categoryPut(i, category);	// TODO Auto-generated method stub
		
	}


private ArrayList<Integer> categoryChecker(int i) {
	if (i==1){
		return arrayCat1;
		}
		else if(i==2){
			return arrayCat2;
		}
		else if (i==3){
		return	arrayCat3;
		}
		else if(i==4){
		return	arrayCat4;
		}	else return null;
}

private void categoryPut(int i, int category) {
	if (i==1){
	arrayCat1.add(category);
	}
	else if(i==2){
		arrayCat2.add(category);
	}
	else if (i==3){
		arrayCat3.add(category);
	}
	else if(i==4){
		arrayCat4.add(category);
	}// TODO Auto-generated method stub
	
}

//counts the dice if valid
private int count(int num, int[] die){
		switch(num){
		case 1: case 2: case 3: case 4: case 5: case 6: 
		int fig=0;
		for (int i=0; i<die.length; i++){
			if(die[i]==num) fig+=1;
		}
		return fig*num;
		
		case 9:
			return totalOnDice(die);
			
		case 10: 
			return totalOnDice(die);
			
		case 11: return 25;
		
		case 12: return 30;
		
		case 13: return 40;
			
		case 14: return 50;
		
		case 15: return totalOnDice(die);
		
		default: return 0;
		}
		}
	

//method to count the dice for a specific case in count method
private int totalOnDice(int[] die) {
	int total =0;
	for (int i=0; i<die.length;i++){
		total+=die[i];
	}
	return total;
	}


//used to check if the dice meets a certian condition
private boolean checkifValid(int[] die, int category) {
	switch (category){
	case 1: return ones(die);
	case 2: return twos(die);
	case 3: return threes(die);
	case 4: return fours(die);
	case 5: return fives(die);
	case 6: return sixs(die);
	case 9: return threeOfAKind(die);
	case 10: return fourOfAKind(die);
	case 11: return fullHouse(die);
	case 12: return smallStraight(die);
	case 13: return largeStraight(die);
	case 14: return yahtzee(die);
	case 15: return chance(die);
	default: return false;
	}
		// TODO Auto-generated method stub
		
	}


private boolean chance(int[] die) {
	// TODO Auto-generated method stub
	return true;
}
private boolean yahtzee(int[] die) {
	double n=0;
	for (int i=0; i<die.length;i++){
		for (int j=0; j<die.length;j++){
			if (i!=j){
				if (die[i]==die[j]){
					n+=1;
				}
			}
		}
	}
	n=n/4;
	if (n==5) {return true;}
	
	else{
	return false;
	}
}
private boolean largeStraight(int[] die) {
	if (arrangeArrayLarge(die)==4) return true;// TODO Auto-generated method stub
	return false;
}
private boolean smallStraight(int[] die) {
	if (arrangeArraySmall(die)>=3) return true;// TODO Auto-generated method stub
	return false;
}
private boolean fullHouse(int[] die) {
	double n=0;
	for (int i=0; i<die.length;i++){
		for (int j=0; j<die.length;j++){
			if (i!=j){
				if (die[i]==die[j]){
					n+=1;
				}
			}
		}
	}
	n=n/2;
	if (n==4) {return true;}
	
	else{
	return false;
	}
}
private boolean fourOfAKind(int[] die) {
	double n=0;
	for (int i=0; i<die.length;i++){
		for (int j=0; j<die.length;j++){
			if (i!=j){
				if (die[i]==die[j]){
					n+=1;
				}
			}
		}
	}
	n=n/3;
	if (n>=4) {return true;}
	
	else{
	return false;
	}
}
private boolean threeOfAKind(int[] die) {
	double n=0;
	for (int i=0; i<die.length;i++){
		for (int j=0; j<die.length;j++){
			if (i!=j){
				if (die[i]==die[j]){
					n+=1;
				}
			}
		}
	}

	n=n/2;
	
	if (n>=3){ 
		return true;
		}
	
	else{
	return false;
	}
}
private boolean sixs(int[] die) {
	for (int i=0; i<die.length; i++){
		if(die[i]==6) {
			return true;
		}
	}
	return false;
}
private boolean fives(int[] die) {
	for (int i=0; i<die.length; i++){
		if(die[i]==5) {
			return true;
		}
	}
	return false;
}
private boolean fours(int[] die) {
	for (int i=0; i<die.length; i++){
		if(die[i]==4) {
			return true;
		}
	}
	return false;
}
private boolean threes(int[] die) {
	for (int i=0; i<die.length; i++){
		if(die[i]==3) {
			return true;
		}
	}
	return false;
}
private boolean twos(int[] die) {
	for (int i=0; i<die.length; i++){
		if(die[i]==2) {
			return true;
		}
	}
	return false;
}
private boolean ones(int[] die) {
	
	for (int i=0; i<die.length; i++){
		if(die[i]==1) {
			return true;
		}
	}
	return false;
}

//sorts the array for small straight and large straight
private int arrangeArrayLarge(int[] die) {
	Arrays.sort(die);
	int total=0;
	for( int i=1; i<die.length; i++){
		if (die[i]-die[i-1]==1) total+=1;
	}
	return total;
	}
private int arrangeArraySmall(int[] die) {
	Arrays.sort(die);
	int total=0;
	for( int i=1; i<die.length; i++){
		if (die[i]-die[i-1]==1) total+=1;
	}
	for( int i=1; i<die.length; i++){
		if (die[i]-die[i-1]>1) total-=1;
	}
	return total;
	}

/* Private instance variables */
	private int nPlayers;
	private String[] playerNames;
	private YahtzeeDisplay display;
	private RandomGenerator rgen = new RandomGenerator();
	private int[] dice;
	
	private ArrayList<Integer> arrayCat1=new ArrayList<Integer>() ;
	private ArrayList<Integer> arrayCat2=new ArrayList<Integer>() ;
	private ArrayList<Integer> arrayCat3=new ArrayList<Integer>() ;
	private ArrayList<Integer> arrayCat4=new ArrayList<Integer>() ;
	private ArrayList<Integer> array1=new ArrayList<Integer>() ;
	private ArrayList<Integer> array2=new ArrayList<Integer>();
	private ArrayList<Integer> array3=new ArrayList<Integer>();
	private ArrayList<Integer> array4=new ArrayList<Integer>();
	private ArrayList<Integer> array5=new ArrayList<Integer>();
	private ArrayList<Integer> array6=new ArrayList<Integer>();
	private ArrayList<Integer> array7=new ArrayList<Integer>();
	private ArrayList<Integer> array8=new ArrayList<Integer>();
}
