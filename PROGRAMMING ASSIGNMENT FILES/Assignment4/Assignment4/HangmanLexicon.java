/*
 * File: HangmanLexicon.java
 * -------------------------
 * This file contains a stub implementation of the HangmanLexicon
 * class that you will reimplement for Part III of the assignment.
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import acm.util.*;


public class HangmanLexicon {
public HangmanLexicon() {
	try {
		words = new ArrayList<String>();
		BufferedReader rd = new BufferedReader(new FileReader("HangmanLexicon.txt"));	
		while (true){
			
			String line=rd.readLine();
			if(line==null) break;
			
			words.add(line);
		} 
		rd.close();
		} catch (IOException ex) {
			// TODO Auto-generated catch block
		}
}
	
/** Returns the number of words in the lexicon. */
	public int getWordCount(String x) {
		
		return x.length();
	}

/** Returns the word at the specified index. */
	public String getWord() {
		
		return words.get(rgen.nextInt(words.size()));
	}
	private RandomGenerator rgen= new RandomGenerator();
	private ArrayList<String> words;
}
