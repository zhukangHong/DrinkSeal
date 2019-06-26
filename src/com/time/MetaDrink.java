package com.time;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class MetaDrink extends JPanel {

	/**
	 * Create the panel.
	 */
	public MetaDrink(String name,int num,float price,String SIS) {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setLayout(null);
		
		JLabel label_p1 = new JLabel(name);
		label_p1.setBounds(10, 22, 83, 15);
		add(label_p1);
		
		JLabel label_p2 = new JLabel(String.valueOf(num));
		label_p2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_p2.setBounds(103, 22, 35, 15);
		add(label_p2);
		
		JLabel label_p3 = new JLabel(String.valueOf(price));
		label_p3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_p3.setBounds(148, 22, 42, 15);
		add(label_p3);
		
		JLabel lblNewLabel_p4 = new JLabel(SIS);
		lblNewLabel_p4.setBounds(10, 40, 180, 15);
		add(lblNewLabel_p4);

	}

}
