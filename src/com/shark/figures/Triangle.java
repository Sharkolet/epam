package com.shark.figures;

public class Triangle extends Figure {
	protected Point a;
	protected Point b;
	protected Point c;
	
	
	Triangle(Point a1, Point b1, Point c1) {
		this.a = a1;
		this.b = b1;
		this.c = c1;
	}
	
	public void show() {
		a.show();
		b.show();
		c.show();
		this.isVisible = true;
	}
	
	public void hide() {
		a.hide();
		b.hide();
		c.hide();
		this.isVisible = false;
	}
	
	@Override
	public void move(double x, double y) {
		a.move(x, y);
		b.move(x, y);
		c.move(x, y);
	}
	
	@Override
	public void resize(double proc) { }
	
}
