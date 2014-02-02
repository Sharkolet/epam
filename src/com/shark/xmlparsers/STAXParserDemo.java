package com.shark.xmlparsers;

import java.util.*;



public class STAXParserDemo {
	public static void main(String[] args) {
		System.out.println("SAXParser Demo...");
		System.out.println("--------------------------");
		STAXPars parser = new STAXPars("Candy.xml");
		parser.parse();
		List<Candy> res = parser.getCandies();
		for(Candy temp: res) {
			System.out.println(temp);
			System.out.println("--------------------------");
		}
	}
}
