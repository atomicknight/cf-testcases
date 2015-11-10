package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class EntrySet {
	public static void main(String[] args) {
		Map<String, String> m = new HashMap<>();
		Set<Map.Entry<String, String>> es = m.entrySet();
	}
}
