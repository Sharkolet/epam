package com.shark.pc;
import java.util.*;

public class PC {
	private String name;
	private boolean isOn = false;
	private ArrayList<Complect> inside = new ArrayList<Complect>();
	
	
	public String getName() {
		return name;
	}
	
	public boolean getStatus() {
		System.out.println(name + " is On!");
		return isOn;
	}
	
	public void powerOn() {
		if (isOn) {
			System.out.println("The PC is already powered on!");
			return;
		} else {
			for(Complect comp:inside) {
				comp.powerOn();
			}
			isOn = true;
		}
	}
	
	public void powerOff() {
		for(Complect comp:inside) {
			comp.powerOff();
		}
		isOn = false;
	}
	
	public boolean checkViruses() {
		boolean gotViruses = false;
		for(Complect obj:inside) {
			if(obj.checkViruses()) {
				gotViruses = true;
				System.out.println("You got viruses in your " + obj.getType() + " in " + inside.indexOf(obj) + " socket");
			}
		}
		return gotViruses;
	}
	
	public void showHDDCapacity() {
		int i = 1;
		for(Complect comp:inside) {
			if (comp.getType().equals("HDD")) {
				HDD a = (HDD) comp;
				System.out.println(i + ". " + a.getCapacity());
				++i;
			}
		}
	}
	
	public void addComplect(Complect comp) {
		inside.add(comp);
	}
	
	@Override
	public String toString() {
		if (isOn) {
			return ("PC " + name + " is ON!");
		} else {
			return ("PC " + name + " is OFF!");
		}
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((inside == null) ? 0 : inside.hashCode());
		result = prime * result + (isOn ? 1231 : 1237);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		PC other = (PC) obj;
		if (inside == null) {
			if (other.inside != null)
				return false;
		} else if (!inside.equals(other.inside))
			return false;
		if (isOn != other.isOn)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	public static void main(String args[]) {
		try {
			PC pc = new PC();
			HDD hd = new HDD(500, 7200);
			pc.addComplect(hd);
			pc.addComplect(new ROM(700));
			pc.addComplect(new HDD(750, 4800));
			pc.addComplect(new RAM(4));
			pc.checkViruses();
			pc.showHDDCapacity();
			System.out.println("" + pc);
			HDD raw = new HDD(40, 7200);
			raw.setCapacity(-3);
			System.out.println(raw);
		} catch(OutOfMemoryError err) {
			System.out.println("You are out of memory!");
		}
	}

}
