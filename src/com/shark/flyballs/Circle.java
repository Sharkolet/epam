package com.shark.flyballs;

import java.util.Random;
public class Circle implements Runnable {
	private double x;
	private double y;
	private int size = 100;
	private double xStep = 1;
	private double yStep = 1;
	private int speed = 5;
	
	Circle(int x, int y, int size) {
		this.x = x;
		this.y = y;
		this.size = size;
	}
	
	Circle() {
		Random rand = new Random();
		x = rand.nextInt(800 - size);
		y = rand.nextInt(600 - size);
	}
	
	@Override
	public void run() {
		while (true) {
			if ((x + xStep <= 0) || (x + size + xStep >= 800)) {
	    		xStep = -xStep;
	    	}
			if ((y + yStep <= 0) || (y + size + yStep >= 600)) {
	    		yStep = -yStep;
	    	}
	    	x += xStep;
	    	y += yStep;
	    	try {
				Thread.sleep(10 / speed);
			} catch (InterruptedException ex) {}
		}
	}
	
	public double getX() { return x; }
	public double getY() { return y; }
	public void setX(double x) { this.x = x; }
	public void setY(double y) { this.y = y; }
	public int getSize() { return size; }
	
}
