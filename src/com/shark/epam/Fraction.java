package com.shark.epam;
public class Fraction {
	private int chisel;
	private int znamen;
	
	Fraction(int a, int b) {
		chisel = a;
		if(b == 0) {
			System.out.println("Can't make znamen == 0. Znamen set to 1.");
			znamen = 1;
		} else {
			znamen = b;
		}
		cutFraction();
	}
	
	Fraction(Fraction copy) {
		this(copy.chisel, copy.znamen);
	}
	
	Fraction(int a) {
		this(a, 1);
	}
	
	private int gcd() {
		int a = chisel;
		int b = znamen;
		
		if (a == 0)
	        return b;

	    while (b != 0) {
	        if (a > b)
	            a = a - b;
	        else
	            b = b - a;
	    }

	    return a;
	}
	
	private void cutFraction() {
		if((chisel < 0) && (znamen < 0)) {
			chisel = chisel * (-1);
			znamen = znamen * (-1);
		} else if(znamen < 0) {
			chisel *= (-1);
			znamen *= (-1);
		}
		
		boolean isPositive = true;
		if(chisel < 0) {
			isPositive = false;
			chisel = chisel * (-1);
		}
		int k = gcd();
		chisel /= k;
		znamen /= k;
		if(!isPositive) {
			chisel *= (-1);
		}
	}
	
	public static Fraction multFractions(Fraction x, Fraction y) {
		Fraction res = new Fraction(x.chisel * y.chisel, x.znamen * y.znamen);
		res.cutFraction();
		return res;
	}
	
	public static Fraction divFractions(Fraction x, Fraction y) {
		Fraction res = new Fraction(x.chisel * y.znamen, x.znamen * y.chisel);
		res.cutFraction();
		return res;
	}
	
	public static Fraction addFractions(Fraction x, Fraction y) {
		Fraction res = new Fraction(x.chisel * y.znamen + y.chisel * x.znamen, x.znamen * y.znamen);
		res.cutFraction();
		return res;
	}
	
	public static Fraction subFractions(Fraction x, Fraction y) {
		Fraction res = new Fraction(x.chisel * y.znamen - y.chisel * x.znamen, x.znamen * y.znamen);
		res.cutFraction();
		return res;
	}
	
	public void show() {
		System.out.println(chisel + "/" + znamen);
	}
	
	public static void changePaired(Fraction[] ar) {
		int k = 0;
		for(int i = 0; i < ar.length / 2; ++i) {
			ar[k] = addFractions(ar[k], ar[k+1]);
			k += 2;
		}
	}
	
	public static void main(String[] args) {
		Fraction f1 = new Fraction(2, 5);
		Fraction f2 = new Fraction(-3, 10);
		
		// Actions
		Fraction f3 = multFractions(f1, f2);
		f3.show();
		Fraction f4 = divFractions(f1, f2);
		f4.show();
		Fraction f5 = addFractions(f1, f2);
		f5.show();
		Fraction f6 = subFractions(f1, f2);
		f6.show();
		System.out.println("----------------------");
		
		// Show array of Fractions
		Fraction[] frArray = new Fraction[] {
			new Fraction(-5, 6), new Fraction(10, 2), new Fraction(7), new Fraction(f1), new Fraction(2, 7)
		};
		for(int i = 0; i < frArray.length; ++i) {
			frArray[i].show();
		}
		System.out.println("----------------------");
		
		// Array, summed paired
		changePaired(frArray);
		for(int i = 0; i < frArray.length; ++i) {
			frArray[i].show();
		}
	}
}