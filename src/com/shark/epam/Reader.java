package com.shark.epam;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Reader {
	public ArrayList<String> lines = new ArrayList<String>();
	public BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	Reader()  throws IOException {
		System.out.println("Enter Strings.");
		System.out.println("Use '/end' to exit.");
		String tempLine;
		tempLine = bf.readLine();
		
		while ( !tempLine.equals("/end") ) {
			lines.add(tempLine);
			tempLine = bf.readLine();
		}
		if(lines.isEmpty()) {
			System.exit(0);
		}
	}
}