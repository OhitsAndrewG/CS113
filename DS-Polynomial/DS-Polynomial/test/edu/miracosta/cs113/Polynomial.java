package edu.miracosta.cs113;

import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Iterator; 

public class Polynomial {
	//You should build a Polynomial class with a LinkedList<Term> instance variable, which specifically contains polynomial-related 
	//methods (like creating a polynomial, adding two polynomials, etc.). You need not
	//build your own linked list (homework for next week), use the built in java.util.LinkedList
	private LinkedList<Term> newPoly = new LinkedList();
	
	//default constructor
	public Polynomial(){
		this.newPoly = new LinkedList();
	} 
	  
	//copy constructor
	public Polynomial(Polynomial original){
		
		if(original == null){
			System.exit(0);
		}else {
			for(int i = 0; i < original.getNumTerms(); i++) {
				newPoly.add(new Term (original.getTerm(i)));
			}
		}
	}
	
	public void addTerm(Term newTerm) {
	  int polySize = newPoly.size();


	  if(newPoly.isEmpty()) {
	    newPoly.add(newTerm);

	  }else {

	    for(int i = 0; i < polySize; ++i) {

	      if(newTerm.getExponent() == newPoly.get(i).getExponent()){
	        int newCoefficient;
	        newCoefficient = newTerm.getCoefficient() + newPoly.get(i).getCoefficient();
	        Term newTermUpdate = new Term(newCoefficient, newPoly.get(i).getExponent());
	        newPoly.remove(i);
	        newPoly.add(i, newTermUpdate);
	        break;

	      }else if(newTerm.getExponent() > newPoly.get(i).getExponent()) {
	        newPoly.add(i, newTerm);
	        break;
	      }
	    }

	    if(newTerm.getExponent() < newPoly.get(polySize - 1).getExponent()){
	    newPoly.addLast(newTerm);
	    }
	    
	  }
	}
	
	
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
	
	
	
	
	public int getNumTerms() {
		return newPoly.size();
	}
	
	public Term getTerm(int index) {
		return newPoly.get(index);
	}
	
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
		
		
		
		
		
	
	
	
	
	
	
	
	



