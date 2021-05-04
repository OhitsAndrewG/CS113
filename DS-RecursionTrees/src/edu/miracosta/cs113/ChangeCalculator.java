package edu.miracosta.cs113;
import java.io.File;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.TreeSet;



public class ChangeCalculator {
	
	  private static final int coin[] = {25, 10, 5, 1};
	  private static TreeSet<String> combos = new TreeSet<>();

    /**
     * Wrapper method for determining all possible unique combinations of quarters, dimes, nickels, and pennies that
     * equal the given monetary value in cents.
     *
     * In addition to returning the number of unique combinations, this method will print out each combination to the
     * console. The format of naming each combination is up to the user, as long as they adhere to the expectation
     * that the coins are listed in descending order of their value (quarters, dimes, nickels, then pennies). Examples
     * include "1Q 2D 3N 4P", and "[1, 2, 3, 4]".
     *
     * @param cents a monetary value in cents
     * @return the total number of unique combinations of coins of which the given value is comprised
     */
    public static int calculateChange(int change) {
        combos.clear();
        //its almost like and upside down recursion tree
        ChangeCalculator.makeChange(change, 0, 0, 0, change); //starts at 0Q, 0D, 0N, and change = # of pennies//
        return combos.size();
    }
    
    
	public static int makeChange(int totalChange, int numQuar, int numDime, int numNick, int numPenn){
		/*
		Assigning the values of the coins to variables
		*/
		final int QUARTER = coin[0];		//the method makeChange starts with 25 pennies//
		final int DIME = coin[1];
		final int NICKEL = coin[2];
		final int PENNY = coin[3];
		
		//int addedChange = numQuar * QUARTER + numDime * DIME + numNick * NICKEL + numPenn * PENNY;
		
		//I first check whether the number of change adds up the the totalChange, therefore reaches the end of the tree
		if(numPenn < 0){
		  return 0;
		}
		
		//creating a string of the coin combo to add to the treeSet
		String coinCombo = "[" + numQuar + ", " + numDime + ", " + numNick + ", " + numPenn + "]";
		
		//contains method return true if this set contains the specified element, seeing if the tree set already contains the coin combo
		boolean result = combos.contains(coinCombo);
		
		if(result == false){
		  //add method will add the string data into the treeSet
		  combos.add(coinCombo);
		
		  //after the combo has been added you need to look for other combinations
		  return (makeChange(totalChange, numQuar + 1, numDime, numNick, numPenn - 25) + makeChange(totalChange, numQuar, numDime + 1, numNick, numPenn - 10) + 
		  makeChange(totalChange, numQuar, numDime, numNick + 1, numPenn - 5)) + 1;
		  
		}else {
			
			return (makeChange(totalChange, numQuar + 1, numDime, numNick, numPenn - 25) + makeChange(totalChange, numQuar, numDime + 1, numNick, numPenn - 10) + 
					  makeChange(totalChange, numQuar, numDime, numNick + 1, numPenn - 5));
		}
		
		
		// if(change == 0){
		  
		//   return 1;
		// }
		// if(change < 0){
		//   return 0;
		// }
		// return recursiveChange(change - coin[0]) + recursiveChange(change - coin[1]) + recursiveChange(change - coin[2] + 
		//   recursiveChange(change - coin[3]));
	  }
	
	

    /**
     * Calls upon calculateChange(int) to calculate and print all possible unique combinations of quarters, dimes,
     * nickels, and pennies that equal the given value in cents.
     *
     * Similar to calculateChange's function in printing each combination to the console, this method will also
     * produce a text file named "CoinCombinations.txt", writing each combination to separate lines.
     *
     * @param cents a monetary value in cents
     * @throws IOException 
     */
    public static void printCombinationsToFile(int change) {
    	
    	ChangeCalculator.calculateChange(change);
    	
    	//using file class
    	//using file writer class
    	//printwriter class
    	try {
    		
            
            File file = new File("/Users/andrewgonzales/Cs113Homework/DS-RecursionTrees/test/edu/miracosta/cs113/CoinCombinations.txt");
            FileWriter fW = new FileWriter(file);  //throw IO exception
            PrintWriter printer = new PrintWriter(fW);
            
            //enhanced forloop statment
            for(String totalCombinations : combos) {
            	printer.println(totalCombinations);
            }
            
            printer.close();
            
    	}catch(IOException e){
    		e.printStackTrace();
    	}
        
        
        //counter controlled for loop statment
//        for(int i = 0; i < combos.size(); i ++) {
//        	printer.println();
//        }
        
        
        
    }
    
    
    

    
    
    
}
