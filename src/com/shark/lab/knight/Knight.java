package com.shark.lab.knight;
import java.util.*;

public class Knight {
	private String name;
	private ArrayList<Ammunition> ammunition = new ArrayList<Ammunition>();
	
	
	Knight(String name) {
		this.name = name;
	}
	
	public int getAmmunitionPrice() {
		int total = 0;
		for(Ammunition ammu : ammunition) {
			total += ammu.getPrice();
		}
		return total;
	}
	
	public ArrayList<Ammunition> getAmmuInRange(int min, int max) {
		ArrayList<Ammunition> temp = new ArrayList<Ammunition>();
		for(Ammunition ammu : ammunition) {
			if ((ammu.getPrice() >= min) && (ammu.getPrice() <= max)) {
				temp.add(ammu);
			}
		}
		return temp;
	}
	
	public void sortAmmunition() {
		Collections.sort(ammunition, new Comparator<Ammunition>() {
			public int compare(Ammunition a, Ammunition b) {
				if((a.getWeight() - b.getWeight()) > Double.MIN_VALUE) {
					return 1;
				} else if ((a.getWeight() - b.getWeight()) < Double.MIN_VALUE) {
					return -1;
				} else {
					return 0;
				}
			}
		});
	}
	
	public void showAmmunition() {
		System.out.println(" ----- Ammunition: -----");
		for (Ammunition ammu : ammunition) {
			System.out.println(ammu);
		}
	}
	
	public void addAmmunition(Ammunition am) {
		ammunition.add(am);
	}
	
	public String getName() {
		return name;
	}
	
	public static void main(String[] args) {
		Knight knight1 = new Knight("Arthur");
		knight1.addAmmunition(new Weapon("Hammer", 5.6, 300, "Metal", 2, "Crushing"));
		knight1.addAmmunition(new Weapon("Bow", 1.3, 50, "Wood", 2, "Piercing"));
		knight1.addAmmunition(new Weapon("Arbalet", 1.36, 50, "Wood", 2, "Piercing"));
		knight1.addAmmunition(new Weapon("Bow2", 1.3, 50, "Wood", 2, "Piercing"));
		knight1.addAmmunition(new Armor("Helm", 2.2, 100, "Metal", "Head"));
		knight1.showAmmunition();
		//knight1.sortAmmunition();
		//knight1.showAmmunition();
		System.out.println("-------------------------");
		ArrayList<Ammunition> am = new ArrayList<Ammunition>();
		am = knight1.getAmmuInRange(50, 100);
		for(Ammunition amu : am) {
			System.out.println(amu);
		}
		am.get(0).price = 30000;
		knight1.showAmmunition();
	}

}
