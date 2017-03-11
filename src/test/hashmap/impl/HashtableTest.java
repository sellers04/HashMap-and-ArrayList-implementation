package hashmap.impl;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;

import org.junit.Test;

public class HashtableTest {
	private HashtableImpl hashtable = new HashtableImpl();
	
	
	@Test
	public void testGetHashMap() {
		
		HashMap<Integer, String> map = hashtable.getHashMap();
		assertNotNull(map);
		
		//fail("Not yet implemented");
	}

	@Test
	public void testGetArrList() {
		List<String> arrList = hashtable.getArrList();
		assertNotNull(arrList);
		//fail("Not yet implemented");
	}

}
