package com.time;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPanel;

import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import com.time.front.FrontFrame;

public class DetailLabel extends JPanel {
	
	
	public String name;
	public  JPanel panel;
	public  String other;
	
	JLabel label; //名字
	JLabel label_1;	//SIS
	JLabel label_5; //price	
	public static	JButton btnNewButton;
	public  boolean isRemove=false;
	
	
	public DetailLabel(final String name,String num,String SIS,final String price,final JPanel panel,final String other) {

		this.other=other;
		this.panel = panel;
		this.setPreferredSize(new Dimension(240, 100));	
		this.setLayout(null);
		
		
		
		 label = new JLabel(name);
		this.name=name;
		label.setBounds(20, 10, 203, 15);
		this.add(label);
		
		 label_1 = new JLabel(SIS);
		label_1.setBounds(30, 27, 193, 18);
		this.add(label_1);
		
		JLabel label_2 = new JLabel("\u6570\u91CF\uFF1A");
		label_2.setBounds(10, 77, 54, 15);
		this.add(label_2);
		
		JLabel label_3 = new JLabel(num);
		label_3.setBounds(43, 77, 54, 15);
		this.add(label_3);
		
		JLabel label_4 = new JLabel("\u5355\u4EF7\uFF1A\uFFE5");
		label_4.setBounds(74, 77, 54, 15);
		this.add(label_4);
		
		label_5 = new JLabel(price);
		label_5.setBounds(124, 77, 54, 15);
		this.add(label_5);
		
		btnNewButton = new JButton("\u79FB\u9664");
		btnNewButton.setBounds(157, 73, 80, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				isRemove=true;
			if(	MainFrame.detailLabelList.size()!=0) {
			int r=	Tool.cancel(MainFrame.detailLabelList, name,MainFrame.detaillist,other);
				Tool.printDetail(MainFrame.detailLabelList, panel);
				Tool.cancel(MainFrame.fdetailLabelList, name,null,other,r);
				Tool.printDetail(MainFrame.fdetailLabelList, FrontFrame.panel);
				
				float	tmpprice=0f;
				int zk=0;
				for (Drink drink2 : MainFrame.detaillist) {				
					tmpprice+=drink2.afprice*drink2.num;
				}					
				MainFrame.label_14.setText(String.valueOf(tmpprice));
				FrontFrame.label_3.setText(String.valueOf(tmpprice));
				tmpprice-=zk;
				MainFrame.label_11.setText(String.valueOf(tmpprice));
				FrontFrame.label_4.setText(String.valueOf(tmpprice));
			
			if(	MainFrame.detailLabelList.size()==0) {
				MainFrame.label_14.setText("0");
				MainFrame.label_11.setText("0");
				MainFrame.detaillist.clear();
				MainFrame.detailLabelList.clear();
				FrontFrame.panel.removeAll();
				FrontFrame.panel.updateUI();
			}
			MainFrame.panel_5.setPreferredSize(new Dimension(237,MainFrame.panel_5.getHeight()-105));
			FrontFrame.panel.setPreferredSize(new Dimension(237,MainFrame.panel_5.getHeight()-105));		
			MainFrame.panel_5.updateUI();
			FrontFrame.panel.updateUI();
			
			if(MainFrame.panel_5.getComponentCount()==0) {
				MainFrame.label_11.setText("0");
				MainFrame.label_14.setText("0");
				MainFrame.label_13.setText("0");
				MainFrame.textField_2.setText("0");
				
			}
			
			
			
			
			}
			
			}	
		});
		
		this.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel(other);
		lblNewLabel.setBounds(33, 53, 190, 15);
		add(lblNewLabel);

		
	}
}
