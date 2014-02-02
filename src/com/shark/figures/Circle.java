package com.shark.figures;

public class Circle extends Figure {
	protected Point center;
	protected double radius;
	
	
	Circle(Point a, double rad) {
		this.center = a;
		this.radius = rad;
	}
	
	Circle() {
		this.center = new Point(0, 0);
		this.radius = 1;
	}
	
	public void show() {
		center.show();
		this.isVisible = true;
	}
	
	public void hide() {
		center.hide();
		this.isVisible = false;
	}
	
	@Override
	public void move(double x, double y) {
		center.move(x, y);
	}

	@Override
	public void resize(double proc) {
		radius *= proc / 100;
	}

}
