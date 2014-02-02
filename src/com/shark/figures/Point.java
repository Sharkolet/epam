package com.shark.figures;

public class Point extends Figure {
	protected double x;
	protected double y;
	
	Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	Point() {
		this.x = 0;
		this.y = 0;
	}
	
	Point(Point a) {
		this.x = a.x;
		this.y = a.y;
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	public void move(double x, double y) {
		this.x += x;
		this.y += y;
	}
	
	public void resize(double proc) { }
}
