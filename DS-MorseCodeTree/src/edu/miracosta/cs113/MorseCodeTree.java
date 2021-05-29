package edu.miracosta.cs113;
import java.io.FileInputStream; 
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.BufferedReader;


import edu.miracosta.cs113.BinaryTree.Node; 



/**
 * MorseCodeTree : A BinaryTree, with Nodes of type Character to represent each letter of the English alphabet,
 * and a means of traversal to be used to decipher Morse code.
 *
 * @version 1.0
 */
public class MorseCodeTree<Chatacter> extends BinaryTree<String>{ //NOTE: it would be a binary tree because you don't need to organize the nodes, you just need to find them based off the mores code given
	
	public static final String[] MORSE_LETTERS = {"*-", "-***", "-*-*","-**", "*", "**-*", "--*", "****", 
			"**","*---", "-*-", "*-**", "--", "-*", "---", 
			"*--*", "--*-", "*-*","***", "-", "**-",
			"***-", "*--", "-**-","-*--", "--**"};

	public static final char LEFT_SYMBOL = '*';
	public static final char RIGHT_SYMBOL = '-';
	
	//Constructor
	public MorseCodeTree() {
		try {
			this.fileInput();
		} catch (IOException e) { 
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void fileInput() throws IOException {
		try {
			String dataSet;
			BufferedReader newBuffer = new BufferedReader(new FileReader("/Users/andrewgonzales/Cs113Homework/DS-MorseCodeTree/src/BinaryTreeCharacters.txt"));
			
			while((dataSet = (String)newBuffer.readLine()) != null) {
				this.add(dataSet);
				
			}
			newBuffer.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		System.out.println("RUNNING FILEINPUT METHOD");
//		System.out.println("--------------------------");
	} 
	
	
	public void add(String data) {
		Node<String> currentNode = this.root;
//		System.out.println("TESTING: This is the root inside of the add method: " + this.root);
		int dataSize = data.length();
		
		
		
		String morseCode = data.substring(0, dataSize -1);
		String letter = data.substring(dataSize - 1, dataSize);
		
//		System.out.println("Data: " + data);
//		System.out.println("Data Size: " + dataSize);
//		System.out.println("Letter: " + letter);
//		System.out.println("Morse Code: " + morseCode);
//		System.out.println("--------------------------");
		
		if(currentNode == null) {
			Node<String> newNode = new Node<String>(data);
			this.root = newNode;
		}
		
		if(currentNode != null) {
			
			for(int i = 0; i < morseCode.length(); i ++) {
				
				if(LEFT_SYMBOL == morseCode.charAt(i) && currentNode.left != null) {
					currentNode = currentNode.left;
				}else if(RIGHT_SYMBOL == morseCode.charAt(i) && currentNode.right != null) {
					currentNode = currentNode.right;
				}else if(currentNode.left == null) {
					currentNode.left = new Node<String>(data);
				}else if(currentNode.right == null) {
					currentNode.right = new Node<String>(data); 
				}
			}
			currentNode = new Node<String>(data);
			
		}
		
		
		
	}
	
	
	
	private String translateMorseCodeWithMorse(String morseCode) {
		
    	Node<String> tempNode = this.root; // Temporary node at the root of the tree
    	String sentence = "";
    	
    	String[] morseLetter = morseCode.split(" "); //splitting the morse code into individual letters in morse code
    	
    	for(int i = 0; i < morseLetter.length; i ++) { //for every letter in morsecode
    		
    		String singleLetter = morseLetter[i]; //one letter in morsecode
    		
    		for(int j = 0; j < singleLetter.length(); j ++) { //for every character in the the morse code letter
    			char singleCharacter = singleLetter.charAt(j);
    			
    			if(singleCharacter == LEFT_SYMBOL) { //ISSUE IS HAPPENING HERE
    																				
    				tempNode = tempNode.left;	//for sure an issue with tempNode.left that isn't making it run
    				
    			}else if(singleCharacter == RIGHT_SYMBOL) {
    				
    				tempNode = tempNode.right;
    			}else {
    				throw new IllegalArgumentException();
    			}
    			
    			
    			
    			
    		}
    		
        		sentence += tempNode.data;
            	tempNode = this.root;
    		
    	}
    	
		return sentence;
		
	}
	
	public String dislayTree() {
		String letterAndMorse = " ";
		String finalSet = "";
		for(int i = 0; i < 26; i++) {
			letterAndMorse = this.translateMorseCodeWithMorse(MORSE_LETTERS[i]);
			finalSet += "[" + letterAndMorse + "] ";
		}
		
		return finalSet;
	}
	
	
	
	
	
	
    // TODO:
    // Build this class, which includes the parent BinaryTree implementation in addition to
    // the `translateFromMorseCode` and `readMorseCodeTree` methods. Documentation has been suggested for the former,
    // where said exceptional cases are to be handled according to the corresponding unit tests.
    /**
     * Non-recursive method for translating a String comprised of morse code values through traversals
     * in the MorseCodeTree. 
     *
     * The given input is expected to contain morse code values, with '*' for dots and '-' for dashes, representing
     * only letters in the English alphabet.
     *
     * This method will also handle exceptional cases, namely if a given token's length exceeds that of the tree's
     * number of possible traversals, or if the given token contains a character that is neither '*' nor '-'.
     *
     * @param morseCode The given input representing letters in Morse code
     * @return a String representing the decoded values from morseCode
     */
    public String translateFromMorseCode(String morseCode) throws IllegalArgumentException{
    	
    	
 
    	Node<String> tempNode = this.root; // Temporary node at the root of the tree
    	String sentence = "";
    	
    	String[] morseLetter = morseCode.split(" "); //splitting the morse code into individual letters in morse code
    	
    	for(int i = 0; i < morseLetter.length; i ++) { //for every letter in morsecode
    		
    		String singleLetter = morseLetter[i]; //one letter in morsecode
    		
    		for(int j = 0; j < singleLetter.length(); j ++) { //for every character in the the morse code letter
    			char singleCharacter = singleLetter.charAt(j);
    			
    			if(singleCharacter == LEFT_SYMBOL) { //ISSUE IS HAPPENING HERE
    																				
    				tempNode = tempNode.left;	//for sure an issue with tempNode.left that isn't making it run
    				
    			}else if(singleCharacter == RIGHT_SYMBOL) {
    				
    				tempNode = tempNode.right;
    			}else {
    				throw new IllegalArgumentException();
    			}
    			
    			
    			
    			
    		}
    		
        		sentence += tempNode.data;
            	tempNode = this.root;
    		
    	}
    	
    	
    	sentence = sentence.replaceAll("\\*", "");
    	sentence = sentence.replaceAll("-", ""); 
    	
    	
    	
    	
		return sentence;
    	
    		
    	
    }

} // End of class MorseCodeTree