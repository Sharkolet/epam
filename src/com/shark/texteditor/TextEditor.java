package com.shark.texteditor;

public class TextEditor {
	
	TextEditor(Text t) {
		outer:
		for(int i = 0; i < t.getSentences().get(0).getParts().size(); ++i) {
			if(t.getSentences().get(0).getPart(i) instanceof Word) {
				for(int j = 1; j < t.getSentences().size(); ++j) {
					if(t.getSentences().get(j).contains((Word)t.getSentences().get(0).getPart(i))) {
						continue outer;
					}
				}
				System.out.println((Word)t.getSentences().get(0).getPart(i));
			}
		}
	}
	
	public static void main(String[] args) {
		Text temp = new Text("test.txt");
		System.out.println(temp);
		System.out.println("-------------");
		new TextEditor(temp);
	}
}
