package edu.miracosta.cs113;
import java.awt.List;
import java.util.*;



public class DoubleLinkedList<E> extends AbstractSequentialList<E>
{  // Data fields
    	private Node<E> head = null;   // points to the head of the list
    	private Node<E> tail = null;   //points to the tail of the list
    	private int size = 0;    // the number of items in the list
   
  public void add(int index, E obj)
  { // Fill Here 
	  listIterator(index).add(obj);
  }
  public void addFirst(E obj) { // Fill Here 
//	  Node<E> node = new Node(obj); 
//	  
//	  this.head.prev = node;
//	  node.next = this.head;   ///make add mthod first 
//	  node.prev = null;
//	  this.head = node;
//	  ++size;
	  listIterator(0).add(obj);
	  
	  
  }
  public void addLast(E obj) { // Fill Here
//	  Node<E> node = new Node<E>(obj);    //list iteratr (index . add object)
//	  
//	  node.prev = this.tail;
////	  node.next = null;
//	  this.tail = node;
//	  ++size;
	  listIterator(size).add(obj);
	  
  }

  public E get(int index) 
  { 	ListIterator<E> iter = listIterator(index); 
      	return iter.next();
  }  
  public E getFirst() { return head.data;  }
  public E getLast() { return tail.data;  }

  public int size() {  
	  return this.size;
  } // Fill Here

  public E remove(int index)
  {     E returnValue = null;
        ListIterator<E> iter = listIterator(index);
        if (iter.hasNext())
        {   returnValue = iter.next();
            iter.remove();
        }
        else {   throw new IndexOutOfBoundsException();  }
        return returnValue;
  }

  public Iterator iterator() { return new ListIter(0);  }
  public ListIterator listIterator() { return new ListIter(0);  }
  public ListIterator listIterator(int index){return new ListIter(index);}
  public ListIterator listIterator(ListIterator iter)
  {     return new ListIter( (ListIter) iter);  }

  // Inner Classes
  private static class Node<E>
  {     private E data;
        private Node<E> next = null;
        private Node<E> prev = null;

        private Node(E dataItem)  //constructor
        {   data = dataItem;   }   
        
  }  // end class Node

  public class ListIter implements ListIterator<E> 
  {
        private Node<E> nextItem;      // the current node
        private Node<E> lastItemReturned;   // the previous node
        private int index = 0;   // 

    public ListIter(int i){  
    	
	    if (i < 0 || i > size){ 
	    	throw new IndexOutOfBoundsException("Invalid index " + i); 
	    }
	    lastItemReturned = null;
	 
	    if (i == size){ 
	    	index = size;     
	    	nextItem = null;
	    	
	    }else{   
	    	nextItem = head;// this is where it happens, once it has the first node it then will have access to the rest of the nodes 
	    	for (index = 0; index < i; index++)  nextItem = nextItem.next;   
	    }
  
    }  
    
    

    public ListIter(ListIter other){   
    	nextItem = other.nextItem;
        index = other.index;    
    }

	public boolean hasNext() {   
		return nextItem != null;
	} // Fill Here

    
    public boolean hasPrevious()
    {
    	return (nextItem == null && size != 0) || nextItem.prev != null;
    	
    } // Fill Here
    
    public int previousIndex() {
    	
    	return index - 1;
    	
    } // Fill Here
    
    
    public int nextIndex() {
    	if(index == size) {
    		return size;
    	}else {
    		return index;
    	}
    } // Fill here
    
    
    public void set(E o)  { 
    	if(nextItem.next == null) {
    		nextItem.data = o;
    	}
    
    }  // not implemented
    
    
    public void remove(){
    	if(nextItem.next == null) {
    		lastItemReturned.next = null;
    	}
    	
    }      // not implemented
    
    

    public E next(){
    	 if(!(this.hasNext())) {
    		 throw new NoSuchElementException();
    	 }
    	 
    	 lastItemReturned = nextItem;
    	 nextItem = nextItem.next;
    	 index++;
    	 return nextItem.data;
    }

    public E previous() 
    {  
    	if(!(this.hasPrevious())) {
    		throw new NoSuchElementException();
    	}
    	
    	if(nextItem == null) {
    		nextItem = tail;
    	}else {
    		nextItem = nextItem.prev;
    	}
    	
    	lastItemReturned = nextItem;						//fix t
    	index--;
    	return lastItemReturned.data;
    }

    public void add(E obj) {
    	//adding if list is empty
    	if(head == null) {
    		head = new Node<E>(obj);
    		tail = head;
    		
    	}else if(nextItem == head) {//insert at head
    		//create a new Node
    		Node<E> newNode = new Node<E>(obj);
    		//link the new node to the nextItem
    		newNode.next = nextItem;
    		//link nexItem to the new Node
    		nextItem.prev =  newNode;              //size increment // last item return null
    		//the new node is now the head
    		head = newNode;
    	}else if(nextItem == null) {//insert at tail
    		//create new node
    		Node<E> newNode = new Node<E>(obj);
    		//link the tail to the new node
    		tail.next = newNode;
    		//link the new node to the tail
    		newNode.prev = tail;
    		//the new node is the new tail
    		tail = newNode;
    	}else {
    		//create new node
    		Node<E> newNode = new Node<E>(obj);
    		//link it to the nextitem.prev
    		newNode.prev = nextItem.prev;
    		nextItem.prev.next = newNode;
    		//link it to the nextItem
    		newNode.next = nextItem;
    		nextItem.prev = newNode;
    		
    	}
    	
    	size++;
		index++;
		lastItemReturned = null;
    		
    }
    
  }// end of inner class ListIter
  
  public String toString() {
  	ListIterator<E> tempIter = listIterator();  //note: this ListIterator is not the default iterator since it is reassigned at line 62 - 66 so it does hold the data within
  	String finalList = "["; 
  	
  	while(tempIter.hasNext()) {
  		
  		if (tempIter.next() == null) {
  			System.out.println("it works HERE");
  			finalList += tempIter.next().toString();
  			finalList += "]";
  			
  		}else{
  			finalList += tempIter.next().toString() + ",";
  			System.out.println(finalList);
  		}
  		
  	}
  	
  	
  			
  	return finalList;
  
  
  }
  
  
  
}// end of class DoubleLinkedList
