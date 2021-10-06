package HashTable;

import java.util.ArrayList;


public class MyHashMap <K, V> {

	    MyMapNode<K, V> head;
	    MyMapNode<K, V> tail;
	    private final int numOfBuckets;
	    ArrayList<MyMapNode<K, V>> myBucketArray;

	    public MyHashMap() {
	        this.numOfBuckets = 10;
	        this.myBucketArray = new ArrayList<MyMapNode<K, V>>(numOfBuckets);
	        // Create empty LinkedLists
	        for (int i = 0; i < numOfBuckets; i++)
	            this.myBucketArray.add(null);
	    }

	    

	    public V get(K key) {
	        int index = this.getBucketIndex(key);
	        if (this.myBucketArray.get(index) == null)
	            return null;
	        MyMapNode<K, V> myNode = search(key);
	        return (myNode == null) ? null : myNode.getValue();
	    }


	    public MyMapNode<K, V> search(K key) {
	        MyMapNode<K, V> currentNode = head;
	        while (currentNode != null) {
	            if (currentNode.getKey().equals(key)) {
	                return currentNode;
	            }
	            currentNode = currentNode.getNext();
	        }

	        return currentNode;
	    }

	    
	    public void add(K key, V value) {
	        int index = this.getBucketIndex(key);
	        MyMapNode<K, V> myNode = this.myBucketArray.get(index);
	        if (myNode == null) {
	            myNode = new MyMapNode<K, V>(key, value);
	            this.myBucketArray.set(index, myNode);
	        }
	        myNode = search(key);
	        if (myNode == null) {
	            myNode = new MyMapNode<K, V>(key, value);
	            this.append(myNode);
	        } else
	            myNode.setValue(value);
	    }

	    // This implements hash function to find index for a key
	    public int getBucketIndex(K key) {
	        int hashCode = Math.abs(key.hashCode());
	        int index = hashCode % numOfBuckets;
	        return index;
	    } 
	    private void append(MyMapNode<K, V> myNode) {
	        if (this.head == null)
	            this.head = myNode;
	        if (this.tail == null)
	            this.tail = myNode;
	        else {
	            this.tail.setNext(myNode);
	            this.tail = myNode;
	        }
	    }
	    public String toString() {
	        return "MyHashMapNodes{" + head + '}';
	    }
	}