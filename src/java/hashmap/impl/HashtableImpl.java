package hashmap.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import hashmap.HashtableList;
import hashmap.HashtableMap;

public class HashtableImpl implements HashtableMap, HashtableList {
	private HashMap<Integer, String> map;
	private List<String> arrList;
	
	
	
	
	public HashtableImpl() {
		map = new HashMap<Integer, String>();
		map.put(1, "this");
        map.put(2, "coder");
        map.put(3, "this");
        map.put(4, "hi");
        
        arrList = new ArrayList<String>();
        arrList.add("this");
        arrList.add("coder");
        arrList.add("this");
        arrList.add("hi");
        
	}
	
	public HashMap<Integer, String> getHashMap(){
		return map;
	}
	
	public List<String> getArrList(){
		return arrList;
	}

	
	
}
