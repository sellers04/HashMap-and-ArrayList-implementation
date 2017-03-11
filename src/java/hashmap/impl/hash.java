package hashmap.impl;

import java.util.ArrayList;
import java.util.Arrays;


class MyArrayList<E> {
	private int size = 0;
	private static final int DEFAULT_CAPACITY = 10;
	private Object elements[];
	
	//Methods add, get, set
	
	//Constructor
	public MyArrayList() {
		elements = new Object[DEFAULT_CAPACITY];
	}
	
	public void add(E e) {
		if(size == elements.length){
			ensureCapacity();
		}
		elements[size++] = e;
	}
	
	private void ensureCapacity() {
		int newSize = elements.length * 2;
		elements = Arrays.copyOf(elements, newSize);
	}
	
	public E get(int i){
		if(i < 0 || i >= size){
			throw new IndexOutOfBoundsException("Index: " + i + ". Not valid with Size: " + size);
		}
		return (E) elements[i];
	}
	
	
	public void set(int position, E element){
		if(position < 0 || position >= size)
			throw new IndexOutOfBoundsException("Index: " + position + " is not valid.");
		elements[position] = element;
	}
}



class HashNode<K, V>{
	K key;
	V value;
	
	//Reference to next node in chain.
	HashNode<K, V> next;
	
	//Constructor
	public HashNode(K key, V value){
		this.key = key;
		this.value = value;
	}
	
}

class CustomHashMap<K, V>{
	//Array of chains
	private ArrayList<HashNode<K,V>> bucketArray;
	private int numBuckets;
	private int size;
	
	//Load threshold
	public static final double LOAD_THRESHOLD = 0.7;
	
	//Constructor
	public CustomHashMap(){
		bucketArray = new ArrayList<>();
		numBuckets = 10;
		size = 0;
		
		//Initialize array
		for(int i = 0; i < numBuckets; i++){
			bucketArray.add(null);
		}
	}
	
	public int size(){ return size; }
	public boolean isEmpty(){ return size() == 0; }
	
	//Hash and compress for index;
	private int getBucketIndex(K key){
		return key.hashCode() % numBuckets;
	}
	
	public V remove(K key){
		int bucketIndex = getBucketIndex(key);
		HashNode<K, V> head = bucketArray.get(bucketIndex);
		
		//Search for key
		HashNode<K, V> prev = null;
		while(head != null){
			if(head.key.equals(key))
				break;
			
			prev = head;
			head = head.next;
		}
		
		//If key was not found
		if(head == null)
			return null;
		
		//Reduce size
		size--;
		
		//Remove key
		if(prev != null)
			prev.next = head.next;
		else
			bucketArray.set(bucketIndex, head.next);
		
		return head.value;
	}
	
	public V get(K key){
		int bucketIndex = getBucketIndex(key);
		HashNode<K, V> head = bucketArray.get(bucketIndex);
		
		//Search chain for key
		while(head != null){
			if(head.key == key)
				//Found key
				return head.value;
			head = head.next;
		}
		
		//Key not found.
		return null;
	}
	
	public void add(K key, V value){
		//Get head of chain for key
		int bucketIndex = getBucketIndex(key);
		HashNode<K, V> head = bucketArray.get(bucketIndex);
		
		//Find key, if already present.
		while(head != null){
			if(head.key.equals(key)){
				//Found key, set new value.
				head.value = value;
				return;
			}
			head = head.next;
		}
		
		//Insert key at front of assigned bucket
		size++;
		head = bucketArray.get(bucketIndex);
		HashNode<K, V> newNode = new HashNode<K, V>(key, value);
		newNode.next = head;
		bucketArray.set(bucketIndex, newNode);
		
		//Ensure load factor is within threshold. If not, double numBuckets.
		if((1.0*size)/numBuckets >= LOAD_THRESHOLD){
			ArrayList<HashNode<K, V>> temp = bucketArray;
			bucketArray = new ArrayList<>();
			numBuckets = 2 * numBuckets;
			size = 0;
			for(int i = 0; i < numBuckets; i++){
				bucketArray.add(null);
			}
			for(HashNode<K, V> headNode : temp){
				while(headNode != null){
					add(headNode.key, headNode.value);
					headNode = headNode.next;
				}
			}
		}	
	}
	

}


class Main{
	// Driver method to test Map class
    public static void main(String[] args)
    {
        CustomHashMap<String, Integer> map = new CustomHashMap<>();
        map.add("this",1 );
        map.add("coder",2 );
        map.add("this",4 );
        map.add("hi",5 );
        System.out.println(map.size());
        System.out.println(map.remove("this"));
        System.out.println(map.remove("this"));
        System.out.println(map.size());
        System.out.println(map.isEmpty());
    }
}




















