package com.shark.pc;

public class ROM extends Complect {
	private int size;
	//private boolean gotCD;
	
	ROM(int size) {
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
		return "ROM";
	}
	
	public int getSize() {
		return size;
	}
	
	public String toString() {
		return ("ROM with " + size + " Mb capacity");
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
		ROM other = (ROM) obj;
		if (size != other.size)
			return false;
		return true;
	}
	
	/*public boolean ifGotCD() {
		return gotCD;
	}*/
	
	/*public void insertCD() {
		if (gotCD) {
			System.out.println("There is already CD int this ROM!");
		} else {
			gotCD = true;
		}
	}*/

}
