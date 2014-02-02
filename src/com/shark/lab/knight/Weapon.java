package com.shark.lab.knight;

public class Weapon extends Ammunition {
	private int hands;
	private String damageType;
	
	Weapon(String name, double weight, int price, String material, int hands, String damageType) {
		this.name = name;
		this.weight = weight;
		this.price = price;
		this.material = material;
		this.hands = hands;
		this.damageType = damageType;
	}
	
	public boolean equals(Object obj) {
		Weapon weap = (Weapon) obj;
		return(this.name.equals(weap.name));
	}
	
	public int getHands() {
		return hands;
	}
	
	public String getDamageType() {
		return damageType;
	}

	@Override
	public String toString() {
		return "" + name + ": " + material + " | " + weight + " kg | " + price 
				+ " gold | " + hands + " hands | " + damageType + " damage type";
	}
	
	
}