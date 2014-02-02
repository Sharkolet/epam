package com.shark.figures;

public class HorisontalLine extends Figure{
	protected Point a;
	protected Point b;
	
	HorisontalLine(double x1, double x2, double y) {
		a = new Point(x1, y);
		b = new Point(x2, y);
	}
	
	/// VOPROS!!! PRESECH NE HORISONTAL!!
	HorisontalLine(Point a1, Point b1) {
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
		a.x *= proc / 100;
		b.x *= proc / 100;
	}
	
}
