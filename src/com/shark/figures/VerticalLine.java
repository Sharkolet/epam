package com.shark.figures;

public class VerticalLine extends Figure {
	protected Point a;
	protected Point b;
	
	VerticalLine(double x, double y1, double y2) {
		a = new Point(x, y1);
		b = new Point(x, y2);
	}
	
	/// VOPROS!!! PRESECH NE VERTICAL!!
	VerticalLine(Point a1, Point b1) {
		a = new Point(a1);
		b = new Point(b1);
	}
	
	public void show() {
		a.show();
		b.show();
		this.isVisible = true;
	}
	
	public void hide() {
		a.hide();
		b.hide();
		this.isVisible = false;
	}
	
	@Override
	public void move(double x, double y) {
		a.move(x, y);
		b.move(x, y);
	}
	
	@Override
	public void resize(double proc) {
		a.y *= proc / 100;
		b.y *= proc / 100;
	}
}
