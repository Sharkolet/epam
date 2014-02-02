package com.shark.figures;

public abstract class Figure {
	protected boolean isVisible;
	public void show() {
		isVisible = true;
	}
	public abstract void move(double x, double y);
	public abstract void resize(double proc);
	public void hide() {
		isVisible = false;
	}
}
