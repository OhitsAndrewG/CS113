package edu.miracosta.cs113;
import java.util.Scanner;


public class MainDriver {

	public static void main(String[] args) {
		Scanner newScanner = new Scanner(System.in);
		
		Polynomial newPoly1 = new Polynomial();
		Polynomial newPoly2 = new Polynomial();
		String userAnswer;
		
		
		System.out.println("----------------------------");
		System.out.println("WELCOME TO DS-POLYNOMIAL");
		System.out.println("----------------------------");
		System.out.println("What does DS-POLYNOMIAL do ?");
		System.out.println("----------------------------");
		System.out.println("Its a program that allows you to add polynomials together,");
		System.out.println("NO MATTER THE SIZE");
		System.out.println("-------------------------------");
		System.out.println("-------------------------------");
		do {
			do {
				
				System.out.println("Go ahead and add your Terms once at a time for your FIRST Polynomial below (EX:5x^3):");
				
				userAnswer = newScanner.nextLine();
				Term firstTerm = new Term(userAnswer);
				newPoly1.addTerm(firstTerm);
				System.out.println("-------------------------------");
				System.out.println("Your Polynomial: " + newPoly1.toString());
				System.out.println("-------------------------------");
				System.out.println("if you like to add another Term please enter (y), if you'd like to continue please enter (c)");
				System.out.println("if youd like to clear the Terms you currently have enter (clear)");
				userAnswer = newScanner.nextLine();
				if(userAnswer.equals("clear")) {
					newPoly1.clear();
					System.out.println("-------------------------------");
					System.out.println("your polynomial has been cleared!");
					System.out.println("-------------------------------");
				}
				
				
			}while(userAnswer.equals("y") || userAnswer.equals("clear"));
			
			do {
				System.out.println("Go ahead and add your Terms once at a time for your SECOND Polynomial below (EX:5x^3):");
				
				userAnswer = newScanner.nextLine();
				Term secondTerm = new Term(userAnswer);
				newPoly2.addTerm(secondTerm);
				System.out.println("-------------------------------");
				System.out.println("Your Polynomial: " + newPoly2.toString());
				System.out.println("-------------------------------");
				System.out.println("if you like to add another Term please enter (y), if you'd like to continue please enter (c)");
				System.out.println("if youd like to clear the Terms you currently have enter (clear)");
				userAnswer = newScanner.nextLine();
				if(userAnswer.equals("clear")) {
					newPoly2.clear();
					System.out.println("-------------------------------");
					System.out.println("your polynomial has been cleared!");
					System.out.println("-------------------------------");
				}
				
				
			}while(userAnswer.equals("y") || userAnswer.equals("clear"));
			
			System.out.println();
			System.out.println(); 
			System.out.println("--------------------------------------------------------------------------------------");
			System.out.println("Here are your Two polynomials: " + newPoly1.toString() + " and " + newPoly2.toString());
			System.out.println("--------------------------------------------------------------------------------------");
			
			Polynomial finalPoly = new Polynomial();
			Polynomial newPoly3 = new Polynomial(newPoly1);
			
			
			System.out.println("if you would like add your polynomials please enter (y), if you would like to exit your program please enter (exit)");
			userAnswer = newScanner.nextLine();
			
			if(userAnswer.equals("y")) {
				
				finalPoly = newPoly3.add(newPoly2);
				
				
			}else if(userAnswer.equals("exit")) {
				System.exit(0);
			}
			System.out.println("--------------------------------------------------------------------------------------");
			System.out.println("Here are your Two polynomials: " + newPoly1.toString() + " and " + newPoly2.toString());
			System.out.println("--------------------------------------------------------------------------------------");
			System.out.println("your final Polynomial is: " + finalPoly.toString());
			System.out.println("--------------------------------------------------------------------------------------");
			
			System.out.println("would you like to add another Polynomial to your result, please enter (y), if not and youd like to exit the program please enter (exit)");
			userAnswer = newScanner.nextLine();
			
			if(userAnswer.equals("exit")) {
				System.exit(0);
			}
			
			newPoly1 = finalPoly;
			
			
		}while(userAnswer.equals("y"));
		
		
		
		
		
		
		
		
		



	}

}
