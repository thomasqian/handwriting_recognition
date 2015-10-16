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
	private static boolean drawn = false;

	public UIMain() {
		setPreferredSize(new Dimension(width, height));
		setLayout(new GridBagLayout());
		c = new GridBagConstraints();
		
		pixels = new Pixel[height/RES][width/RES];
		
		for(int i = 0; i < height/RES; i++) {
			for(int j = 0; j < width/RES; j++) {
				pixels[i][j] = new Pixel(RES);
				c.gridx = i;
				c.gridy = j;
				add(pixels[i][j], c);
			}
		}

		addMouseMotionListener(this);
	}
	
	public void clear() {
		for(int i = 0; i < height/RES; i++) {
			for(int j = 0; j < width/RES; j++) {
				pixels[i][j].clear();
			}
		}
		repaint();
		drawn = false;
	}

	public int[][] createArray() {
		int[][] arr = new int[height/RES][width/RES + 1];
		boolean hasContent = false;
		
		for(int i = 0; i < height/RES; i++) {
			for(int j = 0; j < width/RES + 1; j++) {
				if(j == width/RES) {
					if(hasContent) arr[i][j] = 9;
					else arr[i][j] = 1;
					hasContent = false;
				} else if(pixels[j][i].isFilled()) {
					arr[i][j] = 0;
					hasContent = true;
				} else arr[i][j] = 1;
			}
		}
		
		int lower, upper;
		for(lower = -1; arr[lower + 1][arr[0].length - 1] == 1 && 
				lower < height/RES; ++lower);
		lower++;
		for(upper = arr.length; arr[upper - 1][arr[0].length - 1] == 1 && 
				upper > 0; --upper);
		
		int[][] vertTrim = new int[upper - lower][width/RES];
		for(int i = 0; i < upper - lower; i++) {
			for(int j = 0; j < width/RES; j++) {
				vertTrim[i][j] = arr[i + lower][j];
			}
		}
		
		//trim horizontal
		hasContent = false;
		outloop:
		for(int i = 0; i < vertTrim[0].length; i++) {
			for(int j = 0; j < vertTrim.length; j++) {
				if(vertTrim[j][i] == 0) {
					lower = i;
					break outloop;
				}
			}
		}
		
		outloop2:
		for(int i = vertTrim[0].length - 1; i > 0; i--) {
			for(int j = 0; j < vertTrim.length; j++) {
				if(vertTrim[j][i] == 0) {
					upper = i + 1;
					break outloop2;
				}
			}
		}
		
		int[][] finalArr = new int[vertTrim.length][upper - lower];
		for(int i = 0; i < vertTrim.length; i++) {
			for(int j = 0; j < upper - lower; j++) {
				finalArr[i][j] = vertTrim[i][j + lower];
			}
		}
		
		return finalArr;
	}
	
	@Override
	public void mouseDragged(MouseEvent m) {
		if(DEBUG) System.out.println("Painting: " + m.getX()/RES + " " + m.getY()/RES);
		if(m.getX() < width - 3 && m.getX() > 3 && m.getY() < height - 3 && m.getY() > 3) {
			pixels[m.getX()/RES][m.getY()/RES].fill();
			
			//fill around
			pixels[m.getX()/RES - 1][m.getY()/RES - 1].fill();
			pixels[m.getX()/RES - 1][m.getY()/RES].fill();
			pixels[m.getX()/RES][m.getY()/RES - 1].fill();
			pixels[m.getX()/RES + 1][m.getY()/RES + 1].fill();
			pixels[m.getX()/RES + 1][m.getY()/RES].fill();
			pixels[m.getX()/RES][m.getY()/RES + 1].fill();
			pixels[m.getX()/RES + 1][m.getY()/RES - 1].fill();
			pixels[m.getX()/RES - 1][m.getY()/RES + 1].fill();
		}
		
		drawn = true;
	}
	
	public boolean hasDrawing() {return drawn;}

	@Override
	public void mouseMoved(MouseEvent arg0) {}
	
}
