package edu.miracosta.cs113;
import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Queue;

//NOTE A QUEUE IS FIFO

public class CircularArrayQueue<E> extends AbstractQueue<E> implements Queue<E> {
	//index of the front of the queue
	private int front;
	//index of rear of the queue
	private int rear;
	//current size of the queue, helps keep track of the actual amount of items in queue, helps if size = 0 or size is at capacity
	private int size;
	//current capacity of the queue
	private int capacity;
	//Default capacity of the queue
	private static final int DEFAULT_CAPACITY = 10;
	//array to hold the data
	private E[] theData;
	
	/**
	 * constructs a queue with the default initial capacity
	 */
	public CircularArrayQueue() {
		this(DEFAULT_CAPACITY);
	}
	
	/*
	 * constructs a queue with a specified initial capacity
	 */
	public CircularArrayQueue(int initCapacity){
		this.capacity = initCapacity;
		this.theData = (E[]) new Object[this.capacity];
		this.front = 0;
		this.rear = this.capacity - 1; 
		this.size = 0;
		
	}
	
	public boolean offer(E item) {
		if(this.size == this.capacity) {
			this.reallocate();
		}
		size++;
		this.rear = (this.rear + 1) % this.capacity; 
		this.theData[this.rear] = item;
		return true;
	}
	
	
    public boolean add(E item) { 
    	this.offer(item);
    	return true;
//        if (this.size == this.capacity) {
//            this.reallocate();
//        }
//        
//        this.theData[this.front] = item;
//        this.size++; 
//        return true;
    }
	
	
	
	
	
	private void reallocate() {
		int newCapacity = 2 * this.capacity;
		
		E[] newData = (E[]) new Object[newCapacity];
		
		int j = this.front;
		for(int i = 0; i < this.size; i++) {
			newData[i] = this.theData[j];
			j = (j + 1) % this.capacity;
		}
		this.front = 0;
		this.rear = this.size - 1;
		this.capacity = newCapacity;
		this.theData = newData;
		
	}
	
	@Override
	public E peek() {
		if(this.size == 0) {
			return null;
		}else { 
			System.out.println("The font of the array is:      " + this.theData[this.front]);
			return this.theData[this.front];
		}
	}

	@Override
	public E poll() {
		if(this.size == 0) {
			return null;
		}
		E result = this.theData[this.front];
		this.front = (this.front + 1) % this.capacity;
		this.size--;
		return result;

		
	}



	@Override
	public int size() {
		
		return 0;
	}
	
	private class QueueIterator implements Iterator<E>{
		//index of next element
		private int index;
		//count of elements accessed so far
		private int count = 0;
		
		public QueueIterator() {
			this.index = front;
		}
		
		/*
		 * return true if there are more elements in the queue to access
		 */
		@Override
		public boolean hasNext() {
			return this.count < size;
		}
		
		/*
		 * return the next element in the queue
		 */
		@Override
		public E next() {
			if(!this.hasNext()) {
				throw new NoSuchElementException();
			}
			
			E returnValue = theData[this.index];
			this.index = (this.index + 1) % capacity;
			this.count++;
			return returnValue;
		}
		
		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
		
		
		
		
		
		
		
	}
	
	
	
}
