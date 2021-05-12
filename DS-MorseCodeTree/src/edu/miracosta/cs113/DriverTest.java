package edu.miracosta.cs113;

import java.io.IOException;

public class DriverTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MorseCodeTree<Character> newTree = new MorseCodeTree<Character>();
		
		try {
			newTree.fileInput();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		System.out.println(newTree.toString());
		
		
		String result = newTree.translateFromMorseCode("*--*");
		
		System.out.println(result);

	}

}
