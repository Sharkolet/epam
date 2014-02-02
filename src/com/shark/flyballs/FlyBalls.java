package com.shark.flyballs;

import java.awt.*;
import javax.swing.*;


public class FlyBalls extends JFrame {

	FlyBalls() {
		super("Testing threads!");
		Painting panel = new Painting();
		
		// Set Window and panel size, add panel to Window
		setSize(800, 600);
		panel.setPreferredSize(new Dimension(800, 600));
		
		add(panel);
		
		this.getContentPane().setBackground(Color.WHITE);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		pack();
		setVisible(true);
		setResizable(false);
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new FlyBalls();
				//frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
			}
		});
	}
}