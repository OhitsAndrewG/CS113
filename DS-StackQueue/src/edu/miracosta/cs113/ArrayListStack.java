package edu.miracosta.cs113;


import java.util.ArrayList;
import java.util.EmptyStackException;


public class ArrayListStack<E> implements StackInterface<E> {
	
	private ArrayList<E> stack;
	private int topOfStack;
	
	public ArrayListStack() {
		stack = new ArrayList<E>();
		topOfStack = -1;
	}
	 
	
	
	
    /**
     * Returns true if the stack is empty; otherwise, returns false
     *
     * @return true if empty, false otherwise
     */
    public boolean empty() {
    	return stack.isEmpty();
    }

    /**
     * Returns the object at the top of the stack without removing it
     *
     * @return reference (shallow copy) of object at top of stack
     */
    public E peek() {
    	if(stack.isEmpty()) {
    		throw new EmptyStackException();
    	}else {
    		return stack.get(topOfStack);
    	}
    }

    /**
     * Returns the object at the top of the stack and removes it
     *
     * @return reference of removed object from top of stack
     */
    public E pop() {
    	if(stack.isEmpty()) {
    		throw new EmptyStackException();
    	}else {
    		E topItem = stack.remove(topOfStack); //remove returns the element then removes the item from the stack
    		topOfStack--;
    		
    		return topItem;
    	}
    	
    }

    /**
     * Pushes an item onto the top of the stack and returns the item pushed.
     *
     * @param obj object to push onto top of stack 
     * @return item that was pushed
     */
    public E push(E obj) {
    	
    	stack.add(obj);    	
    	topOfStack++;
    	return stack.get(topOfStack);
    }
    
    
    
    
    
    

}
