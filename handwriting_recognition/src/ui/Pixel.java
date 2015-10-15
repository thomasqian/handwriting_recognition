package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Pixel extends JPanel {
	private boolean filled;
	
	public void Pixel() {
		filled = false;
		
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(1, 1));
	}
	
	public void paintComponent(Graphics g) {
		if(filled) setBackground(Color.BLACK);
		else setBackground(Color.WHITE);
	}
}
