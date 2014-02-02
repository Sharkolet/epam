package com.shark.texteditor;

public class Symbol implements SentPart {
	private char data;
	
	Symbol(char s) {
		data = s;
	}
	
	@Override
	public String toString() {
		return ("" + data);
	}
}
