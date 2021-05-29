package edu.miracosta.cs113;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class DriverTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		MorseCodeTree<Character> newTree = new MorseCodeTree<Character>();
		Scanner newScanner = new Scanner(System.in);
		String userAnswer = " ";
		String translatedFile = "";
		
		
		translatedFile = DriverTest.fileInput();
		System.out.println("///////////////////////////////////////");
		System.out.println(translatedFile);
		System.out.println("///////////////////////////////////////");
		System.out.println();
		
		
		System.out.println("MorseCode Options:");
		System.out.println("===================================================================================================================================================================="
				+ "=====================");
		
		System.out.println(newTree.dislayTree());
		
		System.out.println("===================================================================================================================================================================="
				+ "=====================");
		
		do {
			System.out.println("-------------------------------------");
			System.out.print("Enter your Morse Code to Translate: " );
			userAnswer = newScanner.nextLine();
			System.out.println();
			System.out.println("MORSE CODE: " + userAnswer);
			System.out.println("TRANSLATION: " + newTree.translateFromMorseCode(userAnswer));
			System.out.println();
			System.out.print("Would you like to try again ? yes/no: ");
			userAnswer = newScanner.nextLine();
			
		}while(userAnswer.equals("yes"));
		
		newScanner.close();
		System.out.println("-------------------------------------");
		System.out.println("PROGRAM CLOSED...");
		System.exit(0);
		
		
		
		
		
		
		
		

	}
	
	
	public static String fileInput() throws IOException {
		String finalTranslation = " ";
		MorseCodeTree<String> newTree = new MorseCodeTree<String>();
		
		try {
			String dataSet;
			String word = " ";
			BufferedReader newBuffer = new BufferedReader(new FileReader("/Users/andrewgonzales/Cs113Homework/DS-MorseCodeTree/src/edu/miracosta/cs113/randomWords.txt"));
			
			while((dataSet = (String)newBuffer.readLine()) != null) {
				word = newTree.translateFromMorseCode(dataSet);
				finalTranslation += word + " ";
			}
			newBuffer.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return finalTranslation;
	} 

}
