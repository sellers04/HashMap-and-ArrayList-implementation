package snippet.impl;

import hashmap.impl.HashtableImpl;

public class HashtableString extends HashtableImpl {
	
	private String str;

	public HashtableString() {
		str = "Initialized String";
	}
	
	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

}
