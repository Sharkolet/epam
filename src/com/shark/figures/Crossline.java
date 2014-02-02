package com.shark.figures;

public class Crossline extends Figure {
	protected HorisontalLine hor;
	protected VerticalLine ver;
	
	
	Crossline(HorisontalLine hor, VerticalLine ver) {
		this.hor = hor;
		this.ver = ver;
	}
	
	Crossline(Point center, double size) {
		hor = new HorisontalLine(center.x + size / 2, center.x - size / 2, center.y);
		ver = new VerticalLine(center.y + size / 2, center.y - size / 2, center.y);
	}
	
	public void show() {
		hor.isVisible = true;
		ver.isVisible = true;
	}
	
	public void hide() {
		hor.isVisible = false;
		ver.isVisible = false;
	}
	
	@Override
	public void move(double x, double y) {
		hor.move(x, y);
		ver.move(x, y);
	}

	@Override
	public void resize(double proc) {
		hor.resize(proc);
		ver.resize(proc);
	}

}
