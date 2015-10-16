package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import freeman.Freeman;

public class Menu extends JPanel implements ActionListener {
	
	private UIMain ui;
	JButton clearButton;
	JButton freemanButton;
	JButton exitButton;
	
	public Menu(UIMain ui) {
		setPreferredSize(new Dimension(200, 400));
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		setBackground(Color.GRAY);
		
		this.ui = ui;
		
		clearButton = new JButton("Clear");
		add(clearButton);
		clearButton.addActionListener(this);
		
		//spacing between buttons
		add(Box.createRigidArea(new Dimension (50, 50)));
		
		freemanButton = new JButton("Freeman Code");
		add(freemanButton);
		freemanButton.addActionListener(this);
		
		//spacing between buttons
		add(Box.createRigidArea(new Dimension (50, 50)));
		
		exitButton = new JButton("Exit");
		add(exitButton);
		exitButton.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == clearButton) {
			ui.clear();
		}
		
		if(ae.getSource() == freemanButton) {
			if(ui.hasDrawing()) {
				Freeman f = new Freeman(ui.createArray());
				f.print();
			}
		}
		
		if(ae.getSource() == exitButton) {
			System.exit(0);
		}
	}

}
