package com.shark.xmlparsers;

import java.io.*;
import java.util.*;
import javax.xml.parsers.*;
import org.xml.sax.SAXException;



public class SAXParserDemo {
	public static void main(String[] args) {
		try {
			System.out.println("\tSAX Demo...");
			System.out.println("--------------------------");
			SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
			SAXPars sx = new SAXPars();
			List<Candy> res = new ArrayList<Candy>();
			if(sx != null) parser.parse("Candy.xml", sx);
			res = sx.getCandies();
			for(int i = 0; i < res.size(); i++) {
				System.out.println(res.get(i).toString());
				System.out.println("---------------------------");
			}
		} catch (SAXException e) { System.out.println("SAXException!");}
		catch (ParserConfigurationException e) { System.out.println("Parser Configuration Exception!");}
		catch (IOException e) { System.out.println("Can't find such a file!");}
	}
}
