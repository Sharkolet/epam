package com.shark.figures;

public class Rocket extends Figure {
	protected Circle window;
	protected Rectangle body;
	protected Triangle nose;
	protected Triangle wing1;
	protected Triangle wing2;
	
	
 	public Rocket(Circle window, Rectangle body, Triangle nose, Triangle wing1,
			Triangle wing2) {
		this.window = window;
		this.body = body;
		this.nose = nose;
		this.wing1 = wing1;
		this.wing2 = wing2;
	}
 	
 	Rocket() { }
 	
	public void show() {
		window.show();
		body.show();
		nose.show();
		wing1.show();
		wing2.show();
		this.isVisible = true;
	}
	
	public void hide() {
		window.hide();
		body.hide();
		nose.hide();
		wing1.hide();
		wing2.hide();
		this.isVisible = false;
	}
	
	@Override
	public void move(double x, double y) {
		window.move(x, y);
		body.move(x, y);
		nose.move(x, y);
		wing1.move(x, y);
		wing2.move(x, y);
	}

	@Override
	public void resize(double proc) {
		window.resize(proc);
		body.resize(proc);
		nose.resize(proc);
		wing1.resize(proc);
		wing2.resize(proc);
	}
	
}
