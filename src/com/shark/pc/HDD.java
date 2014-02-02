package com.shark.pc;

public class HDD extends Complect {
	private int capacity;
	private int speed;
	
	HDD(int capacity, int speed) {
		this.capacity = capacity;
		this.speed = speed;
	}
	
	public void setCapacity(int capacity) {
		try {
			if(capacity > 1000 || capacity < 0) throw new IllegalArgumentException();
			this.capacity = capacity;
		} catch(IllegalArgumentException e) {
			System.out.println("Insert correct value!");
		}
	}
	
	public void setSpeed(int speed) {
		try {
			if(speed > 7200 || speed < 0) throw new IllegalArgumentException();
			this.speed = speed;
		} catch(IllegalArgumentException e) {
			System.out.println("Insert correct value!");
		}
	}
	
	public String getType() {
		return "HDD";
	}
	
	public int getCapacity() {
		return capacity;
	}
	
	public int getSpeed() {
		return speed;
	}
	
	public String toString() {
		return ("HDD with " + capacity + " Gb and " + speed + " speed");
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + capacity;
		result = prime * result + speed;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HDD other = (HDD) obj;
		if (capacity != other.capacity)
			return false;
		if (speed != other.speed)
			return false;
		return true;
	}
}
