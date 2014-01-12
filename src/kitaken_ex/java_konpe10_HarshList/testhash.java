package kitaken_ex.java_konpe10_HarshList;

import java.util.HashMap;

public class testhash {
	public static void main(String[] args) {
		HashMap<String,String> m = new HashMap<String,String>();
		m.put("kanpe", "kitaken");
		m.put("jineq", "new kitaken");
		System.out.println(m.get("kanpe"));
		System.out.println(m.get("jineq"));
	}
}
