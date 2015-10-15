package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class UIMain extends JPanel implements MouseMotionListener {
	
	private static final boolean DEBUG = false;
	private Pixel[][] pixels;
	private GridBagConstraints c;
	private static final int RES = 4;
	private static int width = 400;
	private static int height = 400;

	public UIMain() {
		setPreferredSize(new Dimension(width, height));
		setLayout(new GridBagLayout());
		c = new GridBagConstraints();
		
		pixels = new Pixel[width/RES][height/RES];
		
		for(int i = 0; i < width/RES; i++) {
			for(int j = 0; j < height/RES; j++) {
				pixels[i][j] = new Pixel(RES);
				c.gridx = i;
				c.gridy = j;
				add(pixels[i][j], c);
			}
		}

		addMouseMotionListener(this);
	}
	
	public void clear() {
		for(int i = 0; i < width/RES; i++) {
			for(int j = 0; j < height/RES; j++) {
				pixels[i][j].clear();
			}
		}
		repaint();
	}

	@Override
	public void mouseDragged(MouseEvent m) {
		if(DEBUG) System.out.println("Painting: " + m.getX()/RES + " " + m.getY()/RES);
		if(m.getX() < 400 && m.getX() > 0 && m.getY() < 400 && m.getY() > 0) {
			pixels[m.getX()/RES][m.getY()/RES].fill();
		}
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {}
	
}
