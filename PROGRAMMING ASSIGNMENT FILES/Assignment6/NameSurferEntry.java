/*
 * File: NameSurferEntry.java
 * --------------------------
 * This class represents a single entry in the database.  Each
 * NameSurferEntry contains a name and a list giving the popularity
 * of that name for each decade stretching back to 1900.
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class NameSurferEntry implements NameSurferConstants {

/* Constructor: NameSurferEntry(line) */
/**
 * Creates a new NameSurferEntry from a data line as it appears
 * in the data file.  Each line begins with the name, which is
 * followed by integers giving the rank of that name for each
 * decade.
 */
	public NameSurferEntry(String line) {
		
		try {
	
			BufferedReader rd = new BufferedReader(new FileReader("names-data.txt"));	
			
			while (true){
				name=rd.readLine();
				if(name==null) break;
				
				 String[] ss=name.split(" ");
		 
				if(ss[0].equalsIgnoreCase(line)) break;
			} 
			rd.close();
			} catch (IOException ex) {
				
				// TODO Auto-generated catch block
			}
			
	}// You fill this in //
	

/* Method: getName() */
/**
 * Returns the name associated with this entry.
 */
	public String getName() {
		
		
		// You need to turn this stub into a real implementation //
		try {
			String[] ss=name.split(" ");
			return ss[0];
			} 
			 catch (NullPointerException ex) {
				return null;
				// TODO Auto-generated catch block
			}}
			
	

/* Method: getRank(decade) */
/**
 * Returns the rank associated with an entry for a particular
 * decade.  The decade value is an integer indicating how many
 * decades have passed since the first year in the database,
 * which is given by the constant START_DECADE.  If a name does
 * not appear in a decade, the rank value is 0.
 */
	public int getRank(int decade) {
		
		int firstStop= name.indexOf(" ");
		String numbers=name.substring(firstStop+1);
		String[] ss=numbers.split(" ");
	    nam=new ArrayList<Integer>();
	
	
	for (String a : ss){
		int decadenumber=Integer.parseInt(a);
		nam.add(decadenumber);
	}
		try {
	// You need to turn this stub into a real implementation //
	return nam.get(decade);
			
			} 
			 catch (NullPointerException ex) {
				return 0;
				// TODO Auto-generated catch block
			}}
	

/* Method: toString() */
/**
 * Returns a string that makes it easy to see the value of a
 * NameSurferEntry.
 */
	public String toString() {
	
		try {
			int firstStop= name.indexOf(" ");
			String numbers=name.substring(firstStop+1);
			String[] sss=numbers.split(" ");
		    nam=new ArrayList<Integer>();
		
		
		for (String a : sss){
			int decadenumber=Integer.parseInt(a);
			nam.add(decadenumber);}
		
			String[] ss=name.split(" ");// You need to turn this stub into a real implementation //
			return ss[0]+" "+nam;
			} 
			 catch (NullPointerException ex) {
				return null;
				// TODO Auto-generated catch block
			}}
			
	
	private String name;
	private ArrayList<Integer> nam;
}

