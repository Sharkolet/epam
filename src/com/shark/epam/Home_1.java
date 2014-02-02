package com.shark.epam;
import java.util.*;
import java.io.*;
public class Home_1 {
	
	public static void Execute(ArrayList<String> str) {
		// 1. MinMax lines and length
		int minIndex = 0, maxIndex = 0;
		for(int i = 0; i < str.size(); ++i) {
			if(str.get(i).length() >= str.get(maxIndex).length()) {
				maxIndex = i;
			}
			if(str.get(i).length() <= str.get(minIndex).length()) {
				minIndex = i;
			}
		}
		System.out.println("1.");
		System.out.println("Min (" + str.get(minIndex).length() + ") String: " + str.get(minIndex));
		System.out.println("Max (" + str.get(maxIndex).length() + ") String: " + str.get(maxIndex));
		System.out.println("----------------------------");
		
		
		//2. Length-sorted strings
		Collections.sort(str, new Comparator<String>() { 
			public int compare(String a, String b) {
				return (a.length() - b.length()); 
			}
		});
		System.out.println("2.");
		System.out.println(str);
		System.out.println("----------------------------");
		
		
		// 3. String with length >= avarage
		int avarageIndex = str.size()/2;
		System.out.println("3.");
		System.out.println("Avarage length = " + str.get(avarageIndex).length());
		for(int i = avarageIndex; i < str.size(); ++i) {
			System.out.println(str.get(i));
		}
		System.out.println("----------------------------");
		
		
		////////// Separeted words
		ArrayList<String> words = new ArrayList<String>();
		for(int i = 0; i < str.size(); ++i) {
			String[] temp = str.get(i).split(" ");
			for(int j = 0; j < temp.length; ++j) {
				words.add(temp[j]);
			}
		}
		System.out.println("Separated words");
		System.out.println(words);
		System.out.println("----------------------------");
		
		
		// 4. Words with less different symbols
		int minCount = Integer.MAX_VALUE;
		minIndex = 0;
		Set<Character> tempSet = new HashSet<Character>();
		
		for (int i = 0; i < words.size(); ++i) {
			char[] tempWord = words.get(i).toCharArray();
			for (int j = 0; j < tempWord.length; ++j) {
				tempSet.add(tempWord[j]);
			}
			//System.out.println(words.get(i) + " " + tempSet.size());
			if (tempSet.size() < minCount) {
				minIndex = i;
				minCount = tempSet.size();
			}
			tempSet.clear();
		}
		System.out.println("4.");
		System.out.println("Less unic letters (" + minCount + ") in: " + words.get(minIndex));
		System.out.println("----------------------------");
		
		
		// 5. (Words with only letters).count and (equal 'glas-soglas').count
		int lettersCounter = words.size();
		for(int i = 0; i < words.size(); ++i) {
			for(int j = 0; j < words.get(i).length(); ++j) {
				if(!Character.isLetter(words.get(i).charAt(j))) {
					lettersCounter--;
					break;
				}
			}
		}
		System.out.println("5. ");
		System.out.println(lettersCounter + " words got only letters.");
		System.out.println("----------------------------");
		
		
		// 6. Symbol-codes are getting higher
		boolean gotIt = true;
		System.out.println("6. ");
		for(int i = 0; i < words.size(); ++i) {
			String temp = new String(words.get(i));
			for(int j = 1; j < temp.length(); ++j) {
				if(temp.charAt(j) <= temp.charAt(j-1)) {
					gotIt = false;
					break;
				}
			}
			if(gotIt) {
				System.out.println(words.get(i));
			}
			gotIt = true;
		}
		System.out.println("----------------------------");
		
		
		// 7. Print first with all uniq
		System.out.println("7. ");
		out:
		for(int i = 0; i < words.size(); ++i) {
			String temp = new String(words.get(i));
			for(int j = 0; j < temp.length()-1; ++j) {
				if(temp.substring(j+1).contains(String.valueOf(temp.charAt(j)))) {
					break;
				}
				if( (!(temp.substring(j+1).contains(String.valueOf(temp.charAt(j))))) && (j==temp.length()-2 )) {
					System.out.println(words.get(i));
					break out;
				}
			}
		}
		System.out.println("----------------------------");
	}
	
	public static void main(String[] args) throws IOException {
		Reader rd = new Reader();
		Execute(rd.lines);
		//System.out.println(rd.lines);
		
	}
}