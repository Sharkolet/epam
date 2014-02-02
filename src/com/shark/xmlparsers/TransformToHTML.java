package com.shark.xmlparsers;

import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class TransformToHTML {
	public static void main(String[] args) {
		try {
			TransformerFactory tFact = TransformerFactory.newInstance();
			Transformer transformer = tFact.newTransformer(new StreamSource("Candy.xsl"));
			transformer.transform(new StreamSource("Candy.xml"), new StreamResult("Candy.html"));
		} catch(Exception e) {
			System.out.println("Error in transforming!");
		}
	}
}
