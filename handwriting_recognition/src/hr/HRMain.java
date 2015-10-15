package hr;

import ui.*;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

public class HRMain extends JFrame {

	public void HRMain() {
		setPreferredSize(new Dimension(400, 400));

		add(new UIMain(), BorderLayout.EAST);
		
		setTitle("Handwriting Recognition");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		validate();
		setVisible(true);
	}
	
	public static void main(String[] args) {
		HRMain main = new HRMain();
	}

}
