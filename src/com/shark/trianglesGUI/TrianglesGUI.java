package com.shark.trianglesGUI;

import java.awt.*;
import java.util.TimerTask;

import javax.swing.*;


public class TrianglesGUI extends JFrame {
	
	TrianglesGUI() {
		super("Triangles!");
		Painting panel = new Painting();
		
		// Set Window and panel size, add panel to Window
		setSize(800, 600);
		panel.setPreferredSize(new Dimension(700, 600));
		
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
				new TrianglesGUI();
				//frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
			}
		});
	}
}
