package com.time;


import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class C_label extends JLabel {
	
	Connection conn;

	public C_label(final String text,final JPanel panellist) {
		super();
		this.setText(text);
		
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			try {
				panellist.removeAll();
				panellist.repaint();
				MainFrame.panel_4.setSize(new Dimension(135,400));
				MainFrame.panel_4.setPreferredSize(new Dimension(135,400));
					conn=Tool.getConnection();
					
					Tool.printDrink(conn, panellist,text);
				
					
					
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			
				
			}
				
				
				
				
				
		});	
		this.setPreferredSize(new Dimension(94, 50));
		this.setOpaque(true);
		
	}
	
	
	
}
