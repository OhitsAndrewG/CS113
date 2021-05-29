package edu.miracosta.cs113;

import java.util.*;

import javax.swing.text.TabExpander;

import sun.awt.image.ImageWatched.Link;

//array of linked lists that take in value/entry that gets a key from hashing method, then determines which indexed linked list it goes in, if it the same value going it, it will go under the same array index and change the cound of the node to 2

/**
 * HashTable implementation using chaining to tack a pair of key and value
 * pairs.
 * 
 * @param <K> Generic Key
 * @param <V> Generic Value
 */
public class HashTableChain<K, V> implements Map<K, V> { // IMPLEMENTS MAP: means that its showing the required methods
															// needed for a map (interface)

	private LinkedList<Entry<K, V>>[] table;
	private int numKeys;
	private static final int CAPACITY = 101;
	private static final double LOAD_THRESHOLD = 1.5;
	
	/**
	 * Default constructor, sets the table to initial capacity size
	 */
	public HashTableChain() {
		this.table = new LinkedList[CAPACITY];
	}

	// returns number of keys
	@Override
	public int size() {
		// FILL HERE
		return this.numKeys;

	}

	// returns boolean if table has no keys
	@Override
	public boolean isEmpty() {

		return this.numKeys == 0;
	}

	// returns boolean if table has the searched for key
	@Override
	public boolean containsKey(Object key) {
		// Fill Here
		SetIterator iter = new SetIterator();

		while (iter.hasNext()) {
			if (iter.next().getKey().equals(key)) {
				return true;
			}
		}

		return false;

	}

	// returns boolean if table has the searched for value
	@Override
	public boolean containsValue(Object value) {
		// FILL HERE
		
		SetIterator iter = new SetIterator();
		
		
		while (iter.hasNext()) {
			if (iter.next().getValue().equals(value)) {
				
				
				return true;
			}
		}

		return false;
	}

	// returns Value if table has the searched for key
	@Override
	public V get(Object key) {
		int index = key.hashCode() % table.length;
		if (index < 0) {
			index += table.length;
		}
		if (table[index] == null) {
			return null; // key is not in the table
		}

		// search the list at the table[index] to find the key
		for (Entry<K, V> nextItem : table[index]) {
			if (nextItem.key.equals(key)) {
				return nextItem.value;
			}
		}

		// assert: key is not in the table
		return null;
	}

	// adds the key and value pair to the table using hashing
	@Override
	public V put(K key, V value) {
		int index = key.hashCode() % table.length;
		if (index < 0) {
			index += table.length;
		}

		if (table[index] == null) {
			// create a new linked list at table[index]
			table[index] = new LinkedList<Entry<K, V>>();
		}

		// search the list at the table[index] to find the key
		for (Entry<K, V> nextItem : table[index]) {
			// if the search is successful, replace the old value
			if (nextItem.key.equals(key)) {
				// replace old value for this key
				V oldVal = nextItem.value;
				nextItem.setValue(value);
				return oldVal;
			}
		}

		// assert: key is not in the table, add new item
		table[index].addFirst(new Entry<K, V>(key, value));
		numKeys++;
		if (numKeys > (LOAD_THRESHOLD * table.length)) {
			this.rehash();
		}

		return null;

	}

	/**
	 * Resizes the table to be 2X +1 bigger than previous NOTE:RESIZING THE TABLE
	 */
	private void rehash() {
		// save a reference to oldTable
		LinkedList<Entry<K, V>>[] refTable = this.table;
		//allocate a new hash table that is at least double the size and has and odd length
		this.table = new LinkedList[refTable.length * 2 + 1];
		this.numKeys = 0; //reset the number of keys and number deletions to 0
		
		//reinsert each table entry that has not been deleted in the new hashtable
		
		for(LinkedList<Entry<K, V>> individualList : refTable) {			//for each linked list in the the table refTable
			
			if(individualList != null) {									//if the individual list in the array is not null 
				
				for(Entry<K, V> individualEntry : individualList) {				//for each entry in the in the individual linked list
					
					if(individualEntry != null) {							//if the single individual entry is not null 
						
						this.put((K)individualEntry.getKey(), (V)individualEntry.getValue());	//put each individual Entry into the table, which rehashes the the individual entries and places them where they need to go
					}
					
				}
				
				
				
			}
		}
	}

	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder("[");
		
		for (int i = 0; i < table.length; i++) {
			if (table[i] != null) {
				for (Entry<K, V> individualItem : table[i]) {
					sb.append(individualItem.toString() + ", ");
				}
				
			}
		}
		
		sb.delete(sb.length() - 2, sb.length());
		
		return sb.toString() + "]";
		


	}

	// remove an entry at the key location
	// return removed value
	@Override
	public V remove(Object key) {
		
		SetIterator newIter = new SetIterator();
	
		while(newIter.hasNext()) {
			
			if(newIter.next().getKey().equals(key)) {
				
				Entry<K, V> tempEntry = new Entry<K, V>(newIter.lastItemReturned.getKey(), newIter.lastItemReturned.getValue());
				
				newIter.remove();//issue here
				
				System.out.println("The removed Entry is here: " + tempEntry.getValue());
				return tempEntry.getValue();
			}
		}
		
		return null;

	}

	// throws UnsupportedOperationException
	@Override
	public void putAll(Map<? extends K, ? extends V> m) {
		throw new UnsupportedOperationException();
	}

	// empties the table
	@Override
	public void clear() {//ISSUE HERE
		this.numKeys = 0;
	}

	// returns a view of the keys in set view
	//sets do not allow duplicate values, a hashset uses a hash table for storage.
	@Override
	public Set<K> keySet() {
		// FILL HERE
		 Set<K> keySet = new HashSet<K>(numKeys); //creating a set called keySet that puts the initial capacity of the set which is the numKeys(total number of nodes in every array)
		 
		 for(LinkedList<Entry<K, V>> individualLinkedList : this.table) { //for every individual linked list in the array in the this.table
			 if(individualLinkedList != null) {							  //if the individual linkedList is not null
				 for(Entry<K, V> singleEntry : individualLinkedList) {	  //for every entry in the individual linked list 
					 keySet.add(singleEntry.key);						  //add individual entries key to the keySet
					 													  //NOTE: a set doesn't allow duplicate values, which means you aren't going to have two of the same key
				 }
			 }
		 }
		 
		 return keySet;
		
		
	}

	// throws UnsupportedOperationException
	@Override
	public Collection<V> values() {
		throw new UnsupportedOperationException();
	}

	// returns a set view of the hash table
	@Override
	public Set<Map.Entry<K, V>> entrySet() {
		// FILL HERE
		EntrySet newSetOfEntries = new EntrySet();
		
		return newSetOfEntries;

	}

	@Override
	public boolean equals(Object o) {
		
		if(o instanceof Map) {
			
			Map tempMap = (Map)o;
			
			if(tempMap.size() != this.size()) { 
				return false;
			}
			
			for(LinkedList<Entry<K, V>> linkedListInArray : table) {
				if(linkedListInArray != null) {
					for(Entry<K, V> entry : linkedListInArray) {
						if(!(tempMap.containsValue(entry.getValue()))){
							return false;
						}
					} 
				}
			}
			
			return true;
		}
		
		return false;
		
	}

	
	/*
	 * meant to transform the key value to an integer value(its hash code) that will then be transformed into a table index
	 */
	
	@Override
	public int hashCode() {
		// FILL HERE
		Set<K> allKeysInHash = this.keySet(); //creating a Set of keys from the keySet method
		int locationInArray = 1;  //start at one because if it was 0, it would be too small			  
		
		for(K key : allKeysInHash) {
//			System.out.println("This is the HashValue before: " + locationInArray);
			locationInArray += key.hashCode();
//			System.out.println("This is the HasCode value: " + locationInArray);
		}
		
		return locationInArray;
		

	}



	
	////////////// EntrySet Class //////////////////////////////////

	/**
	 * Inner class to implement set view
	 */
	private class EntrySet extends AbstractSet<Map.Entry<K, V>> { // WHAT IS AND ENTRY SET ?//
																	// it is a set of entries that are put into the data
		
		@Override
		public Iterator<Map.Entry<K, V>> iterator() {
			return new SetIterator();
		}
		
		@Override
		public int size() {
			return numKeys;
		}// structure
		
		

	}

	////////////// end EntrySet Class //////////////////////////////

	////////////// SetIterator Class ////////////////////////////

	/**
	 * Class that iterates over the table. Index is table location and
	 * lastItemReturned is entry
	 */
	private class SetIterator implements Iterator<Map.Entry<K, V>> { // IMPLEMENTS ITERATOR<MAP.ENTRY<K, V>>: This gives
																		// us the proper methods to use and implement to
																		// create this class

		private int index = 0;
		private Entry<K, V> lastItemReturned = null;
		private Iterator<Entry<K, V>> iter = null;
		
		@Override
		public boolean hasNext() {
			
			//THIS WAS THE ISSUE:always check null before hasNext
			
			if (iter != null && iter.hasNext()) { // if the array of linked list is not empty, and its current linked
												  // list spot in the array exists
				return true; // return true
			}

			do { // WHAT HAPPENS ? : do to hashing, giving you the index of the array, there can
					// be spots that are null, so you want to keep looping through each index to
					// determine
				index++; // if there is a hasNext or not
				
				if (index >= table.length) { // If the iterator is empty, we start from index 0 to the length of the
												// actual array size, if the its gets greater than the length of the
												// array it returns false
												// you then check that specified index in the array to see if its null,
												// if it is, then you increment the index again to check the next index
												// until you get on that isn't
					return false;

				}

			} while (table[index] == null); //also where you access the data, you just use iterator to go through it
			// when you do hit an index that isn't null, you then reinstatnitate the iter
			// iterator which will start at that specified index then go through the process
			// again when you return it
			
			iter = table[index].iterator();

			return iter.hasNext();
		}

		@Override
		public Map.Entry<K, V> next() { // you are checking if there is any index of the array that is populated until
										// you find one, then return true, if it is then it will return the first node
										// in the LList
			// FILL HERE
			if (iter.hasNext()) {
				lastItemReturned = iter.next(); //this is important because when calling next you want to make sure your returning the item
				return lastItemReturned;

			} else {
				throw new NoSuchElementException(); // else throw no such element 
			}
		}

		@Override
		public void remove() {
			// FILL HERE
			if(lastItemReturned == null) {
				throw new IllegalArgumentException();
			}else {
				iter.remove();
				lastItemReturned = null;
			}
		}
	}

	////////////// end SetIterator Class ////////////////////////////

	
	
	
	///////////// ENTRY CLASS ///////////////////////////////////////
	
	/**
	 * Contains key-value pairs for HashTable
	 * 
	 * @param <K> the key
	 * @param <V> the value
	 */
	private static class Entry<K, V> implements Map.Entry<K, V> { // IMPLEMENTS MAP.ENTRY: means that its giving you the
																	// required methods to implement (interface)
		private K key;
		private V value;

		/**
		 * Creates a new key-value pair
		 * 
		 * @param key   the key
		 * @param value the value
		 */
		public Entry(K key, V value) {
			this.key = key;
			this.value = value;
		}

		/**
		 * Returns the key
		 * 
		 * @return the key
		 */
		public K getKey() {
			return this.key;
		}

		/**
		 * Returns the value
		 * 
		 * @return the value
		 */
		public V getValue() {
			return this.value;
		}

		/**
		 * Sets the value
		 * 
		 * @param val the new value
		 * @return the old value
		 */
		public V setValue(V val) {
			V oldVal = this.value;
			this.value = val;
			return oldVal;
		}

		@Override
		public String toString() {
			return this.key + "=" + this.value;
		}

	}

	////////////// end Entry Class /////////////////////////////////

}
