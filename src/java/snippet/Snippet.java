package snippet;

import java.util.HashMap;

import hashmap.HashtableMap;
import hashmap.impl.HashtableImpl;

public class Snippet {
	
	public Snippet () {
		HashtableMap htm =  new HashtableImpl();
		HashMap<Integer, String> map = htm.getHashMap();
		
	}
}

