package edu.miracosta.cs113;
import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Queue;

//NOTE A QUEUE IS FIFO

public class CircularArrayQueue<E> extends AbstractQueue<E> implements Queue<E> {
	
	private int front;
	private int rear;
	private int size;
	private int capacity;
	private E[] theData;
	
	public CircularArrayQueue(int capacity){
		this.theData = (E[]) new Object[capacity];
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
	
	
	
	
	
	private void reallocate() {
		int newCapacity = 2 * this.capacity;
		E[] newData = (E[]) new Object[newCapacity];
		
		int j= this.front;
		for(int i = 0; i < this.size; i++) {
			newData[i] = theData[j];
			j = (j + 1) % this.capacity;
		}
		this.front = 0;
		this.rear = this.size - 1;
		this.theData = newData;
		
	}

	@Override
	public E poll() {
		if(this.size == 0) {
			return null;
		}
		E result = theData[this.front];
		this.front = (this.front + 1) % this.capacity;
		this.size--;
		return result;
		
	}

	@Override
	public E peek() {
		if(this.size == 0) {
			return null;
		}else {
			return this.theData[this.front];
		}
	}

	

	@Override
	public int size() {
		
		return 0;
	}
	
	private class QueueIterator implements Iterator<E>{
		private int index;
		private int count = 0;
		
		public QueueIterator() {
			this.index = front;
		}
		
		
		@Override
		public boolean hasNext() {
			return this.count < size;
		}
		
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
