package com.shark.trianglesGUI;

public class Triangle implements Runnable {
	private static int mult = 0;
	private final int count;
	private int speed = 5;
	private double x[] = new double[3];
    private double y[] = new double[3];
    private double xcenter;
    private double ycenter;
    private double angle = Math.toRadians(1);
    
	
	Triangle() {
		count = mult;
		mult++;
		x[0] = 100 + 200 * count;
		x[1] = x[0] + 100;
		x[2] = x[0] + 50;
		y[0] = 350;
		y[1] = y[0];
		y[2] = y[0] - Math.sqrt(10000 - 2500);
		xcenter = x[2];
		ycenter = y[2] + (Math.sqrt(3) / 3) * 100;
	}
	
	
	public void rotatePoints() {
	    //this.angle = ((this.angle/180)*Math.PI);
	    double cosAngle = Math.cos(angle);
	    double sinAngle = Math.sin(angle);
	    
	    
	    for(int i = 0; i < 3; ++i) {
	    	double dx = (x[i] - xcenter);
		    double dy = (y[i] - ycenter);
		    x[i] = xcenter +  (dx*cosAngle - dy*sinAngle);
		    y[i] = ycenter +  (dx*sinAngle + dy*cosAngle);
	    }
	}
	
	@Override
	public void run() {
		while (true) {
			rotatePoints();
			try {
				Thread.sleep(100 / (count + 1));
			} catch (InterruptedException ex) {}			
		}
	}
	
	public void setX(double s[]) { 
		for(int i = 0; i < 3; i++) {
			x[i] = s[i];
		}
	}
	
	public void setY(double s[]) { 
		for(int i = 0; i < 3; i++) {
			y[i] = s[i];
		}
	}
	
	public void setDef() {
		x[0] = 100 + 200 * count;
		x[1] = x[0] + 100;
		x[2] = x[0] + 50;
		y[0] = 350;
		y[1] = y[0];
		y[2] = y[0] - Math.sqrt(10000 - 2500);
		xcenter = x[2];
		ycenter = y[2] + (Math.sqrt(3) / 3) * 100;
	}
	
	public double[] getX() { return x; }
	public double[] getY() { return y; }	
}
