package com.time.front;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import java.awt.Image;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.time.DetailLabel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class FrontFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrontFrame frame = new FrontFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */

	public static List<DetailLabel> list2= new  ArrayList<>();
	public static	JPanel panel = new JPanel();
	public static JLabel label_3;
	public static JLabel label_4;
	public static	JScrollPane scrollPane ;
	public static JLabel lblNewLabel_1;
	private static JLabel label;
	public static JLabel label_1;
	private JLabel label_2;
	public static JLabel lblNewLabel;
	private static	String[] path;
	private JLabel label_5;
	static ImageIcon img;
	
	public FrontFrame() throws IOException {
		setResizable(false);
		
		//读取配置文件
		FileReader reader = new FileReader("config/my.conf");
        BufferedReader br = new BufferedReader(reader);     
        path=new String[5];
        int i=1;
        while ((path[0] = br.readLine()) != null) {     
        	path[i]=path[0];
        	i++;          
        }
		br.close();
		
		setTitle("客户窗口");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 537, 530);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 184, 433);
		scrollPane.setSize(184, 433);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		contentPane.add(scrollPane);
		
		
		scrollPane.add(panel);
		scrollPane.setViewportView(panel);
		panel.setPreferredSize(new Dimension(237, 0));
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));					
		
		img = new ImageIcon(path[1]);			
		lblNewLabel = new JLabel("");			
		img.setImage(img.getImage().getScaledInstance(270,250,Image.SCALE_DEFAULT)); 
		lblNewLabel.setIcon(img);
		lblNewLabel.setBounds(204, 52, 267, 194);
		lblNewLabel.setOpaque(false);
		contentPane.add(lblNewLabel);
		
		
		img = new ImageIcon(path[2]);
		img.setImage(img.getImage().getScaledInstance(128,128,Image.SCALE_DEFAULT)); 		
		lblNewLabel_1 = new JLabel("图片2");
		lblNewLabel_1.setIcon(img);
		lblNewLabel_1.setBounds(204, 256, 128, 129);
		lblNewLabel_1.setOpaque(true);
		contentPane.add(lblNewLabel_1);
		
		label = new JLabel("图片3");
		img = new ImageIcon(path[3]);
		img.setImage(img.getImage().getScaledInstance(128,128,Image.SCALE_DEFAULT)); 		
		label.setIcon(img);
		label.setBounds(345, 256, 128, 129);
		label.setOpaque(true);
		contentPane.add(label);
		
		label_1 = new JLabel("总价:");
		label_1.setBounds(387, 397, 42, 15);
		contentPane.add(label_1);
		
		label_2 = new JLabel("应收:");
		label_2.setBounds(387, 422, 42, 15);
		contentPane.add(label_2);
		
		label_3 = new JLabel("0");
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setBounds(429, 397, 42, 15);
		contentPane.add(label_3);
		
		label_4 = new JLabel("0");
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		label_4.setBounds(429, 422, 42, 15);
		contentPane.add(label_4);
		
		label_5 = new JLabel("人气饮品");
		label_5.setFont(new Font("宋体", Font.PLAIN, 18));
		label_5.setBounds(302, 14, 72, 28);
		contentPane.add(label_5);

	
		
	
		
		//this.setUndecorated(true);//隐藏标题栏
		
		
		
	}
	
	public static void setIcon() {
		img = new ImageIcon(path[3]);
		img.setImage(img.getImage().getScaledInstance(128,128,Image.SCALE_DEFAULT)); 		
		label.setIcon(img);
		label.updateUI();
		
		img = new ImageIcon(path[2]);
		img.setImage(img.getImage().getScaledInstance(128,128,Image.SCALE_DEFAULT)); 	
		lblNewLabel_1.setIcon(img);
		lblNewLabel_1.updateUI();
		
		img = new ImageIcon(path[1]);		
		img.setImage(img.getImage().getScaledInstance(270,250,Image.SCALE_DEFAULT)); 
		lblNewLabel.setIcon(img);
		lblNewLabel.updateUI();
	}
	
}
