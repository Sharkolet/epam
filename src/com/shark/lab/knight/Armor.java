package com.shark.lab.knight;

public class Armor extends Ammunition {
	private String bodyPart;
	
	Armor(String name, double weight, int price, String material, String bodyPart) {
		this.name = name;
		this.weight = weight;
		this.price = price;
		this.material = material;
		this.bodyPart = bodyPart;
	}
	
	public boolean equals(Object obj) {
		Armor arm = (Armor) obj;
		return(this.name.equals(arm.name));
	}
	
	public String getBodyPart() {
		return bodyPart;
	}
	
	@Override
	public String toString() {
		return "" + name + ": " + material + " | " + weight + " kg | " + price 
				+ " gold | for " + bodyPart;
	}
	
}
