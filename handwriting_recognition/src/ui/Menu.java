package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Menu extends JPanel implements ActionListener {
	
	private UIMain ui;
	JButton clearButton;
	
	public Menu(UIMain ui) {
		setPreferredSize(new Dimension(200, 400));
		setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		setBackground(Color.GRAY);
		
		this.ui = ui;
		
		clearButton = new JButton("Clear");
		add(clearButton, BorderLayout.CENTER);
		clearButton.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == clearButton) {
			ui.clear();
		}
		
	}

}
