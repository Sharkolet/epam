package com.shark.flyballs;

import java.awt.*;
import javax.swing.*;

public class Painting extends JPanel implements Runnable {
	
	Circle c1 = new Circle();
	Circle c2 = new Circle();
	Circle c3 = new Circle();
	
	public Painting() {
    	super();
    	setOpaque(false);
		new Thread(this).start();
    }
	
	private void showCircles(Graphics g2d) {
		g2d.setColor(Color.GREEN);
        g2d.fillOval((int)c1.getX(), (int)c1.getY(), c1.getSize(), c1.getSize());
        g2d.setColor(Color.RED);
        g2d.fillOval((int)c2.getX(), (int)c2.getY(), c2.getSize(), c2.getSize());
        g2d.setColor(Color.BLUE);
        g2d.fillOval((int)c3.getX(), (int)c3.getY(), c3.getSize(), c3.getSize());
	}

    @Override
    protected void paintComponent(Graphics g) {
    	super.paintComponent(g);
    	Graphics2D g2d = (Graphics2D)g;
    	
    	g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    	showCircles(g2d);
    }
    
    @Override
    public void run() {
    	new Thread(c1).start();
    	new Thread(c2).start();
    	new Thread(c3).start();
		while (true) {
			repaint();
			/*try {
				Thread.sleep(10 / speed);
			} catch (InterruptedException ex) {}*/
		}
	}
}
