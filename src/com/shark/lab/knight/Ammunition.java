package com.shark.lab.knight;

public abstract class Ammunition {
	protected String name;
	protected double weight;
	protected int price;
	protected String material;
	
	
	public String getName() {
		return name;
	}
	
	public double getWeight() {
		return weight;
	}
	
	public int getPrice() {
		return price;
	}
	
	public String getMaterial() {
		return material;
	}
	
}