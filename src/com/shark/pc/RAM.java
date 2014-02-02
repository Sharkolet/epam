package com.shark.pc;

public class RAM extends Complect {
	private int size;
	
	RAM(int size) {
		this.size = size;
	}
	
	public void setSize(int size) {
		try {
			if(size > 8 || size < 0) throw new IllegalArgumentException();
			this.size = size;
		} catch(IllegalArgumentException e) {
			System.out.println("Insert correct value!");
		}
	}
	
	public String getType() {
		return "RAM";
	}
	
	public boolean checkViruses() {
		return false;
	}
	
	public int getSize() {
		return size;
	}
	
	public String toString() {
		return ("RAM with " + size + " Gb memory size!");
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + size;
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
		RAM other = (RAM) obj;
		if (size != other.size)
			return false;
		return true;
	}
}
