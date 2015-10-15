package ui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

public class UIMain extends JPanel {
	
	private Pixel[][] pixels;
	private GridBagConstraints c;

	public void UIMain() {
		setLayout(new GridBagLayout());
		c = new GridBagConstraints();
		
		pixels = new Pixel[getWidth()][getHeight()];
		
		for(int i = 0; i < getWidth(); i++) {
			for(int j = 0; j < getHeight(); j++) {
				pixels[i][j] = new Pixel();
				c.gridx = i;
				c.gridy = j;
				add(pixels[i][j], c);
			}
		}
	}
	
}
