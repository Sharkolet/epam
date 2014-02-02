package com.shark.pc;

import java.util.Random;

public abstract class Complect {
	private boolean isOn = false;
	
	public void powerOn() {
		isOn = true;
	}
	
	public void powerOff() {
		isOn = false;
	}
	
	public boolean getStatus() {
		return isOn;
	}
	
	public boolean checkViruses() {
		Random rand = new Random();
		int k = rand.nextInt(2);
		if (k == 0) {
			return false;
		} else {
			//System.out.println("You got viruses on your " + getType());
			return true;
		}
	}
	
	public abstract String getType();
}
