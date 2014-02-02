package com.shark.hashMapProblem;

import java.util.*;

public class hashMapProblem {
	
	public static void main(String[] args) {
		Entity entity1 = new Entity("value1");
		Entity entity2 = new Entity("value2");
		Map<Entity, String> h = new HashMap<Entity, String>();
		h.put(entity1, "Hello World!");
		h.put(entity2, "Hello World!2");
		entity1.setValue("incorrect");
		h.remove(entity2);
		if(h.get(entity1) == null)
			System.out.println("ERROR!\nCongrats! You failed: hashcode must always return same value!");
	}
	
}
