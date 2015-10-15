package hr;

import ui.*;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.JFrame;

public class HRMain extends JFrame {

	public HRMain() {
		//setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));
		setLayout(new BorderLayout());
		setSize(400, 400);
		setTitle("Handwriting Recognition");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setBackground(Color.WHITE);

		UIMain ui = new UIMain();
		add(ui, BorderLayout.CENTER);
		
		Menu menu = new Menu(ui);
		add(menu, BorderLayout.EAST);

		pack();
		validate();
		setVisible(true);
		
		//System.out.println("loaded");
		
		ui.requestFocusInWindow();
	}
	
	public static void main(String[] args) {
		HRMain main = new HRMain();
	}

}
