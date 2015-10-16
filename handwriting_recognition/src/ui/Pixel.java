package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Pixel extends JPanel {
	private boolean filled;
	
	public Pixel(int RES) {
		filled = false;
		setPreferredSize(new Dimension(RES, RES));
	}
	
	public void paintComponent(Graphics g) {
		if(filled) g.setColor(Color.BLACK);
		else g.setColor(Color.WHITE);
		g.fillRect(0, 0, getWidth(), getHeight());
	}
	
	public void fill() {
		if(!filled) {
			filled = true;
			repaint();
		}
	}
	
	public boolean isFilled() {return filled;}
	
	public void clear() {
		filled = false;
	}
}
