package com.time;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JLabel;

import java.awt.Dimension;
import java.awt.Font;
import java.util.List;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;


public class CheckFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public CheckFrame(String num,int e_id,String date,String total,String yingshou,List<Drink> list,String sis) {
		setResizable(false);
		setTitle("小票预览");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 307, 617);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 255, 478);
		contentPane.add(scrollPane);
		
		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		panel.setBounds(10, 206, 213, 600);
		panel.setLayout(null);
		//scrollPane.add(panel);
		
		JLabel label = new JLabel("慢时光茶饮");
		label.setFont(new Font("宋体", Font.PLAIN, 20));
		label.setBounds(62, 10, 111, 31);
		panel.add(label);
		
		JLabel label_1 = new JLabel("结账单");
		label_1.setBounds(156, 45, 54, 15);
		panel.add(label_1);
		
		JLabel label_p0 = new JLabel(num);
		label_p0.setFont(new Font("宋体", Font.PLAIN, 24));
		label_p0.setBounds(29, 60, 116, 29);
		panel.add(label_p0);
		
		JLabel label_3 = new JLabel("服务员:");
		label_3.setBounds(10, 99, 47, 15);
		panel.add(label_3);
		
		JLabel label_p1 = new JLabel(String.valueOf(e_id));
		label_p1.setBounds(62, 99, 54, 15);
		panel.add(label_p1);
		
		JLabel label_5 = new JLabel("结账时间:");
		label_5.setBounds(10, 124, 64, 15);
		panel.add(label_5);
		
		JLabel label_p2 = new JLabel(date);
		label_p2.setBounds(78, 124, 138, 15);
		panel.add(label_p2);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 149, 213, 2);
		panel.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 194, 213, 2);
		panel.add(separator_1);
		
		JLabel label_7 = new JLabel("饮品名称");
		label_7.setBounds(10, 161, 54, 15);
		panel.add(label_7);
		
		JLabel label_8 = new JLabel("金额");
		label_8.setHorizontalAlignment(SwingConstants.CENTER);
		label_8.setBounds(184, 161, 39, 15);
		panel.add(label_8);
		
		JLabel label_9 = new JLabel("数量");
		label_9.setHorizontalAlignment(SwingConstants.CENTER);
		label_9.setBounds(135, 161, 39, 15);
		panel.add(label_9);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 206, 213, 153);
		panel.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 379, 213, 87);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel label_10 = new JLabel("总价:");
		label_10.setBounds(10, 10, 37, 15);
		panel_2.add(label_10);
		
		JLabel label_11 = new JLabel("应收:");
		label_11.setBounds(10, 35, 37, 15);
		panel_2.add(label_11);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(0, 60, 213, 2);
		panel_2.add(separator_2);
		
		JLabel label_12 = new JLabel("谢谢惠顾,欢迎下次光临!");
		label_12.setHorizontalAlignment(SwingConstants.CENTER);
		label_12.setBounds(30, 68, 172, 15);
		panel_2.add(label_12);
		
		JLabel label_p3 = new JLabel(total);
		label_p3.setBounds(48, 10, 54, 15);
		panel_2.add(label_p3);
		
		JLabel label_p4 = new JLabel(yingshou);
		label_p4.setBounds(48, 35, 54, 15);
		panel_2.add(label_p4);
		
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		//scrollPane.add(panel);
		panel.setPreferredSize(new Dimension(213, 0));
		panel_1.setPreferredSize(new Dimension(213, 0));
		
		
		int comnum;
		for (Drink drink : list) {
			
		MetaDrink md=	new MetaDrink(drink.getName(), drink.getNum(), drink.getAfprice(),drink.getIce().toString()+","+drink.getSuger().toString()+","+drink.getSize().toString());
		md.setPreferredSize(new Dimension(200, 60));
		panel_1.add(md);
		
		comnum=	panel_1.getComponentCount();
		
		if (comnum>=3) {	
			
			panel.setPreferredSize(new Dimension(panel.getWidth(), panel.getHeight()+60));
			panel.setSize(new Dimension(panel.getWidth(), panel.getHeight()+60));
			panel_1.setSize(new Dimension(panel_1.getWidth(), panel_1.getHeight()+60));
			panel_1.setPreferredSize(new Dimension(panel_1.getWidth(), panel_1.getHeight()+60));
			panel_2.setBounds(panel_2.getX(), panel_2.getY()+60, panel_2.getWidth(), panel_2.getHeight());
			
		}
		}
		
		
		
	}
}
