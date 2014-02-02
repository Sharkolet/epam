package com.shark.xmlparsers;

import java.util.*;



public class DOMDemo {
	public static void main(String argv[]) {
		System.out.println("\tDOM Demo...");
		System.out.println("--------------------------");
		DOMPars parser = new DOMPars("Candy.xml");
		parser.parse();
		List<Candy> res = parser.getCandies();
		for(Candy temp:res) {
			System.out.println(temp);
			System.out.println("--------------------------");
		}
	}
}
