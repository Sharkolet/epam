package com.shark.texteditor;

import java.util.*;

public class Sentence {
	private ArrayList<SentPart> data = new ArrayList<SentPart>();
	
	Sentence() { }
	
	Sentence(Sentence copy) {
		for(SentPart s : copy.data) {
			data.add(s);
		}
	}
	
	Sentence(String t) {
		t = t.replaceAll("\\t+", " ");
		t = t.replaceAll(" +", " ");
		//t = t.trim();
		ArrayList<Character> temp = new ArrayList<Character>();
		
		for(int i = 0; i < t.length(); ++i) {
			if (Character.isLetterOrDigit(t.charAt(i))) {
				temp.add(t.charAt(i));
				continue;
			}
			if (!temp.isEmpty()) {
				String c = new String();
				for(int j = 0; j < temp.size(); ++j) {
					c += temp.get(j);
				}
				addPart(new Word(c));
				temp = new ArrayList<Character>();
			}
			addPart(new Symbol(t.charAt(i)));
		}
	}
	
	public void addPart(SentPart w) {
		data.add(w);
	}
	
	public SentPart getPart(int i) {
		return data.get(i);
	}
	
	public ArrayList<SentPart> getParts() {
		return data;
	}
	
	@Override
	public String toString() {
		String temp = new String();
		for(int i = 0; i < data.size(); ++i) {
			temp += data.get(i).toString();
		}
		return temp;
	}
	
	public boolean contains(Word w) {
		for(int i = 0; i < data.size(); ++i) {
			if(data.get(i) instanceof Word) {
				if(data.get(i).equals(w)) {
					return true;
				}
			}
		}
		return false;
	}
	
}
