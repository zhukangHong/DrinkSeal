package com.time;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class test {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					test window = new test();
					window.frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public test() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 549, 451);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(155, 100, 220, 102);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("\u996E\u54C1\u540D\u79F0");
		label.setBounds(20, 10, 54, 15);
		panel.add(label);
		
		JLabel label_1 = new JLabel("\u591A\u51B0\u3001\u5E38\u6E29\u3001\u5C11\u7CD6");
		label_1.setBounds(30, 35, 114, 15);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("\u6570\u91CF\uFF1A");
		label_2.setBounds(10, 77, 54, 15);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("2");
		label_3.setBounds(43, 77, 54, 15);
		panel.add(label_3);
		
		JLabel label_4 = new JLabel("\u5355\u4EF7\uFF1A\uFFE5");
		label_4.setBounds(74, 77, 54, 15);
		panel.add(label_4);
		
		JLabel label_5 = new JLabel("12");
		label_5.setBounds(124, 77, 54, 15);
		panel.add(label_5);
		
		JButton btnNewButton = new JButton("\u79FB\u9664");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(149, 73, 61, 23);
		panel.add(btnNewButton);
		
		
		
	}
}
