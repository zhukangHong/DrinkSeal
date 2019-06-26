package com.time;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import com.time.MainFrame;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.IOException;
import java.nio.channels.SelectableChannel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.awt.event.ActionEvent;

public class LoginFrame extends JFrame {

	private JPanel contentPane;
	private JTextField userText;
	private JPasswordField passText;
	static Map<String, String> login= new HashMap<>();
	static Connection connection;
	static Map<String, Integer> e_id=new HashMap<>();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
					// BeautyEyeLNFHelper.translucencyAtFrameInactive = false;
					 UIManager.put("RootPane.setupButtonVisible", false);
					connection=Tool.getConnection();
					Statement statement=connection.createStatement();
					ResultSet rs=statement.executeQuery("select * from tb_employe");
					while (rs.next()) {
						login.put(rs.getString(4), rs.getString(5)) ;	
						e_id.put(rs.getString(4), rs.getInt(1));
					}
					LoginFrame frame = new LoginFrame();
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
	public LoginFrame() {
		setResizable(false);		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel() {
			  @Override
              protected void paintComponent(Graphics g) {
           	    super.paintComponent(g);
           	    ImageIcon img = new ImageIcon(LoginFrame.class.getResource("login.jpg"));  
                 /**
                  * bg.PNG这个地方换成自己的图片
                  * 此处使用的相对路径，bg.png跟该测试类在同一路径下
                  * 不过建议使用相对路径避免使用绝对路径
                  */
    	            img.paintIcon(this, g, 0, 0);
              }

		};
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("慢时光茶饮销售系统登录");
		JLabel lblNewLabel = new JLabel("账号");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 16));
		lblNewLabel.setBounds(50, 74, 54, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("密码");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(312, 74, 54, 15);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("登录");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				if (login.containsKey(userText.getText())) {    
					
		    		if (String.valueOf(passText.getPassword()).equals(login.get(userText.getText()))) {
		    			JOptionPane.showMessageDialog(null,"登录成功！");
						setVisible(false);						
						//MainFrame.main(null);
						try {
							new MainFrame(e_id.get(userText.getText()));
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					
						
					}else JOptionPane.showMessageDialog(null,"密码错误！");						
				}else	JOptionPane.showMessageDialog(null,"账号错误！");
				
		    	
				
			}
		});
		btnNewButton.setBounds(23, 185, 93, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("退出");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(DO_NOTHING_ON_CLOSE);
				
			}
		});
		btnNewButton_1.setBounds(293, 185, 93, 23);
		contentPane.add(btnNewButton_1);
		
		userText = new JTextField();
		userText.setText("kb");
		userText.setBounds(35, 119, 66, 21);
		contentPane.add(userText);
		userText.setColumns(10);
		this.setLocationRelativeTo(null);
		passText = new JPasswordField();
		passText.setBounds(302, 119, 66, 21);
		contentPane.add(passText);
	}
}
