package edu.miracosta.cs113;

public class MainDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashTableChain<String, Integer> newChain = new HashTableChain<String, Integer>();
		
		newChain.put("one", 1);
		newChain.put("two", 2);
		newChain.put("three", 3);
		newChain.put("four", 4);
		
		
		System.out.println("BEFORE: " + newChain.entrySet());
		
		newChain.remove("two");
		
		
		
		System.out.println("AFTER" + newChain.entrySet());
	}

}
