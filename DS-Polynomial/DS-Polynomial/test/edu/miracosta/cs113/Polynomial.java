package edu.miracosta.cs113;

import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Iterator; 

public class Polynomial {
	//You should build a Polynomial class with a LinkedList<Term> instance variable, which specifically contains polynomial-related 
	//methods (like creating a polynomial, adding two polynomials, etc.). You need not
	//build your own linked list (homework for next week), use the built in java.util.LinkedList
	private LinkedList<Term> newPoly = new LinkedList();
	
	/*
	 * Default Constructor
	 */
	public Polynomial(){
		this.newPoly = new LinkedList();
	} 
	  
	/*
	 * copy constructor
	 * method will create a copy of the original polynomial
	 * @param original Polynomial
	 * 
	 */
	public Polynomial(Polynomial original){
		
		if(original == null){
			System.exit(0);
		}else {
			for(int i = 0; i < original.getNumTerms(); i++) {
				newPoly.add(new Term (original.getTerm(i)));
			}
		}
	}
	
	/*
	 * addTerm method allows you to add a new Term to your LinkedList(Polynomial), adding like Terms together
	 * @param Term newTerm
	 * @return void
	 */
	public void addTerm(Term newTerm) {
	  int polySize = newPoly.size();


	  if(newPoly.isEmpty()) {
	    newPoly.add(newTerm);

	  }else {

	    for(int i = 0; i < polySize; ++i) {

	      if(newTerm.getExponent() == newPoly.get(i).getExponent()){ 
	        int newCoefficient;
	        newCoefficient = newTerm.getCoefficient() + newPoly.get(i).getCoefficient();		//run through a for loop, then
	        Term newTermUpdate = new Term(newCoefficient, newPoly.get(i).getExponent());		//checked whether the Terms exponents were the same
	        newPoly.remove(i);																		//added the coefficients
	        newPoly.add(i, newTermUpdate);															//removed the old coefficient
	        break;																					//then added the newTerm to the polynomial that adding it too, then breaks

	      }else if(newTerm.getExponent() > newPoly.get(i).getExponent()) {						//checks if the Terms exponent is larger
	        newPoly.add(i, newTerm);																//if it is then it adds the term in that current position in the polynomial
	        break;																					//breaks
	      }
	    }

	    if(newTerm.getExponent() < newPoly.get(polySize - 1).getExponent()){					//if none of those cases pass and if the Terms exponent is less than the last Term in the Polynomial it wil
	    	newPoly.addLast(newTerm);																//add it to the end of the Polynomial
	    }
	    
	  }
	}
	
	/*
	 * add method will add two Polynomial(LinkedList) together
	 * @param Polynomial otherPoly
	 * @return Polynomial finalPoly 
	 */
	public Polynomial add(Polynomial otherPoly){
		  int otherPolySize = otherPoly.getNumTerms();
		  Polynomial finalPoly = new Polynomial();

		  for(int i = 0; i < otherPolySize; ++i){
		    this.addTerm(otherPoly.getTerm(i));
		  }

		  int polySize = newPoly.size();
		  for(int i = 0; i < polySize; ++i){
		    finalPoly.addTerm(newPoly.get(i));
		  }
		  
		  newPoly.clear();

		  return finalPoly;
		}
	
	
	
	/*
	 * getNumTerms will get the total number of Terms within the Polynomial
	 * @return int size
	 */
	public int getNumTerms() {
		return newPoly.size();
	}
	
	/*
	 * getTerm will any specified Term in the Polynomial
	 * @param int index
	 * @return Term
	 */
	public Term getTerm(int index) {
		return newPoly.get(index);
	}
	
	/*
	 * clear method will clear all 
	 */
	public void clear() {
		newPoly.clear();
	}
	
	//come back to this, test failed
	public String toString() {
		String finalPoly = "";
		if(newPoly.isEmpty() == true) {
			return "0";
		}
		
		 for(int i = 0; i < newPoly.size(); ++i){
		   String termStr = newPoly.get(i).toString();
		   finalPoly += termStr;
		 }
		 
		 if(finalPoly.indexOf("+") == 0){
		   String finalPoly2 = finalPoly.substring(1, finalPoly.length());
		   return finalPoly2;
		 }else{
		   return finalPoly;
		 }
		
		

	}
	
}
		
		
		
		
		
	
	
	
	
	
	
	
	



