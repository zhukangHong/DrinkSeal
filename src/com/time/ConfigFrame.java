package com.time;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.time.Tool;
import com.time.front.FrontFrame;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;

public class ConfigFrame extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JButton button_1;
	private JButton button_2;
	private JButton button_3;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// AddDrink frame = new AddDrink();
					// frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ConfigFrame() {
		setResizable(false);
		setTitle("设置图片");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 367, 290);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("TOP1:");
		lblNewLabel.setBounds(27, 26, 54, 28);
		contentPane.add(lblNewLabel);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		JButton button = new JButton("确定");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				dispose();	
				FrontFrame.setIcon();
				
			}
		});
		button.setBounds(235, 228, 66, 23);
		contentPane.add(button);

		JLabel lblTop = new JLabel("TOP2:");
		lblTop.setBounds(27, 83, 54, 28);
		contentPane.add(lblTop);

		JLabel lblTop_1 = new JLabel("TOP3:");
		lblTop_1.setBounds(27, 135, 54, 28);
		contentPane.add(lblTop_1);
		
		button_1 = new JButton("上传");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				textField.setText(uploadPic(button_1, 1));
				FrontFrame.lblNewLabel.updateUI();
			}
		});
		button_1.setBounds(235, 29, 66, 23);
		contentPane.add(button_1);
		
		button_2 = new JButton("上传");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_1.setText(	uploadPic(button_2, 2));
				FrontFrame.lblNewLabel_1.updateUI();
				
			}
		});
		button_2.setBounds(235, 86, 66, 23);
		contentPane.add(button_2);
		
		button_3 = new JButton("上传");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_2.setText(	uploadPic(button_3, 3));
				FrontFrame.label_1.updateUI();
				
			}
		});
		button_3.setBounds(235, 138, 66, 23);
		contentPane.add(button_3);
		
		textField = new JTextField();
		textField.setBounds(87, 30, 136, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(87, 87, 136, 21);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(87, 139, 136, 21);
		contentPane.add(textField_2);

	

		

	}
	
	
	public  String uploadPic(JButton btnNewButton,int which) {
		
		File[] arrfiles=null ;
		JFileChooser chooser = new JFileChooser("C:/Users/hasee/Desktop");
		FileNameExtensionFilter filter = new FileNameExtensionFilter("图像文件(*.jpg,*png)", "png", "jpg");
		chooser.setFileFilter(filter);
		
		chooser.setMultiSelectionEnabled(true);				
		 int returnVal = chooser.showOpenDialog(btnNewButton);
		  if (returnVal == JFileChooser.APPROVE_OPTION) {
			/** 得到选择的文件* */		 
			arrfiles = chooser.getSelectedFiles();
			System.out.println(arrfiles.length);
			if (arrfiles == null || arrfiles.length == 0) {			
				return null;
			}
		
			
			
			FileInputStream input = null;
			FileOutputStream out = null;
			String path = "img/";
			String filename="";
			try {
				for (File f : arrfiles) {
					File dir = new File(path);
					/** 目标文件夹 * */
					File[] fs = dir.listFiles();
					HashSet<String> set = new HashSet<String>();
					for (File file : fs) {
						set.add(file.getName());
					}
					
					input = new FileInputStream(f);
					byte[] buffer = new byte[1024];
			
					switch (which) {
					case 1:
						filename="timg.jpg";
						break;
					case 2:
						filename="timg1.jpg";
						break;
					case 3:
						filename="timg2.jpg";
						break;
					default:
						break;
					}
					
					
					File des = new File(path, filename);
				
					out = new FileOutputStream(des);
					int len = 0;
					while (-1 != (len = input.read(buffer))) {
						out.write(buffer, 0, len);
					}
					
					out.close();
					input.close();
				}
				 JOptionPane.showMessageDialog(null, "上传成功！重启系统后生效！", "提示",
					      JOptionPane.INFORMATION_MESSAGE);
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		  System.out.println(arrfiles[0].getAbsolutePath());
		return arrfiles[0].getAbsolutePath();


		
	}
	
	
	
}
