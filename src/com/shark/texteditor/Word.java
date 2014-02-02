package com.shark.texteditor;

import java.util.*;

public class Word implements SentPart {
	private ArrayList<Character> data = new ArrayList<Character>();
	
	Word() {}
	
	Word(Word copy) {
		for(char s : copy.data) {
			data.add(s);
		}
	}
	
	Word(char[] copy) {
		for(char s : copy) {
			data.add(s);
		}
	}
	
	Word(String copy) {
		for(char s : copy.toCharArray()) {
			data.add(s);
		}
	}
	
	public char getChar(int i) {
		return new Character(data.get(i));
	}
	
	public int getLength() {
		return data.size();
	}
	
	@Override
	public String toString() {
		String c = new String();
		for(int i = 0; i < data.size(); ++i) {
			c = c + "" + data.get(i);
		}
		return c;
	}
	
	@Override
	public boolean equals(Object obj) {
		Word temp = (Word)obj;
		if(this.toString().toLowerCase().equals(temp.toString().toLowerCase())) {
			return true;
		}
		return false;
	}
	
}
