package com.time;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Drink_label extends JPanel {
		
	JLabel label;
	int num=0;
	JLabel lblNewLabel ;
	boolean isSelect=false;
	JLabel lblNewLabel_1;
	
	public Drink_label(final String text,String price) {
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//清除其他选择;				
				Tool.clearSelect(MainFrame.labelList);
				isSelect=true;
				for (Drink_label label : MainFrame.labelList) {								
					label.setBackground(Color.white);
					label.updateUI();
					if (label.isSelect) {
						label.setBackground(new Color(255, 204, 51));
						label.updateUI();
					}
					
				}
				
				
				
			}
		});
		
		
		
		this.setPreferredSize(new Dimension(120, 75));
		this.setLayout(null);
		
		 lblNewLabel = new JLabel(text);
		
		lblNewLabel.setBounds(1, 0, 89, 43);
		this.add(lblNewLabel);
					
				
		
		JLabel label_1 = new JLabel("\uFFE5");

		label_1.setBounds(72, 10, 23, 23);
		this.add(label_1);
		
		lblNewLabel_1 = new JLabel(price);
		
		lblNewLabel_1.setBounds(90, 6, 23, 31);		
		
		this.add(lblNewLabel_1);
	}
	
}
