package com.shark.texteditor;

import java.util.*;
import java.io.*;

public class Text {
	
	private ArrayList<Sentence> data = new ArrayList<Sentence>();
	
	Text() { }
	
	Text(String name) {
		String all = readFromFile(name);
		
		ArrayList<Character> temp = new ArrayList<Character>();
		for(int i = 0; i < all.length(); ++i) {
			if ((all.charAt(i) != '.') && (all.charAt(i) != '!') && (all.charAt(i) != '?')) {
				temp.add(all.charAt(i));
				continue;
			}
			temp.add(all.charAt(i));
			String c = new String();
			//char[] c = new char[temp.size()];
			for(int j = 0; j < temp.size(); ++j) {
				c += temp.get(j);
			}
			addSentence(new Sentence(c));
			temp = new ArrayList<Character>();
		}
	}
	
	public ArrayList<Sentence> getSentences() {
		return data;
	}
	
	public void addSentence(Sentence s) {
		data.add(s);
	}
	
	private String readFromFile(String filename)
	{
	   String content = null;
	   File file = new File(filename);
	   try {
	       FileReader reader = new FileReader(file);
	       char[] chars = new char[(int) file.length()];
	       reader.read(chars);
	       content = new String(chars);
	       reader.close();
	   } catch (IOException e) {
	       e.printStackTrace();
	   }
	   return content;
	}
	
	@Override
	public String toString() {
		String temp = new String();
		for(int i = 0; i < data.size(); ++i) {
			temp += data.get(i).toString();
		}
		return temp;
	}
}
