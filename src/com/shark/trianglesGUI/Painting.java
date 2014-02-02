package com.shark.trianglesGUI;

import java.awt.*;
import java.awt.geom.Path2D;
import javax.swing.*;
import java.util.Timer;
import java.util.TimerTask;

public class Painting extends JPanel implements Runnable {
	
	static final Object monitor = new Object();
	Triangle t1 = new Triangle();
	Triangle t2 = new Triangle();
	Triangle t3 = new Triangle();
	Thread r1 = new Thread(t1);
	Thread r2 = new Thread(t2);
	Thread r3 = new Thread(t3);
	public static double angle = 1;
	
	public class Task extends TimerTask {
		@Override
		public void run() {
			synchronized(Painting.monitor) {
				t1.setDef();
				t2.setDef();
				t3.setDef();
			}
		}
	}
	
	public Painting() {
    	super();
    	setOpaque(false);
    	r1.setPriority(10);
    	r2.setPriority(5);
    	r3.setPriority(1);
		new Thread(this).start();
    }
	
	private void showTriangles(Graphics2D g2d) {
        
		g2d.setColor(Color.GREEN);
        Path2D path = new Path2D.Double();
        path.moveTo(t1.getX()[0], t1.getY()[0]);
        for(int i = 1; i < 3; ++i) {
           path.lineTo(t1.getX()[i], t1.getY()[i]);
        }
        path.closePath();
        g2d.fill(path);
        
        g2d.setColor(Color.BLUE);
        path = new Path2D.Double();
        path.moveTo(t2.getX()[0], t2.getY()[0]);
        for(int i = 1; i < 3; ++i) {
           path.lineTo(t2.getX()[i], t2.getY()[i]);
        }
        path.closePath();
        g2d.fill(path);
        
        g2d.setColor(Color.RED);
        path = new Path2D.Double();
        path.moveTo(t3.getX()[0], t3.getY()[0]);
        for(int i = 1; i < 3; ++i) {
           path.lineTo(t3.getX()[i], t3.getY()[i]);
        }
        path.closePath();
        g2d.fill(path);
	}

    @Override
    protected void paintComponent(Graphics g) {
    	super.paintComponent(g);
    	Graphics2D g2d = (Graphics2D) g;
    	g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    	showTriangles(g2d);
    	g2d.dispose();
    }
    
    @Override
    public void run() {
    	r1.start();
    	r2.start();
    	r3.start();
    	Timer time = new Timer();
    	Task task = new Task();
    	time.scheduleAtFixedRate(task, 5000, 5000);
		while (true) {
			synchronized(monitor) {
				repaint();
			}
		}
	}
}
