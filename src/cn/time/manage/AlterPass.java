package cn.time.manage;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.apache.commons.codec.binary.Base32;

import com.time.Tool;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class AlterPass extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JPasswordField passwordField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlterPass frame = new AlterPass();					
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
	public AlterPass() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 262, 353);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		JLabel lblNewLabel = new JLabel("原密码：");
		lblNewLabel.setBounds(10, 46, 54, 28);
		contentPane.add(lblNewLabel);
		setTitle("修改密码");
		
		JButton button = new JButton("确定");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<String> line=new ArrayList<>();
				String realPass;
				String base32Pass;
				String textPass;
				String textBase;
				String str;
					try {
						FileReader fr=new FileReader("config/my.conf");
						BufferedReader br=new BufferedReader(fr);
					while((str=br.readLine())!=null)	{
					line.add(str)	;
						}
					br.close();
					Base32 base32=new Base32();
					realPass = new String(base32.decode(line.get(line.size()-1)));	
			
					textPass=new String(passwordField.getPassword());
					
					if(!textPass.equals(realPass)) 
						{JOptionPane.showMessageDialog(null,"原密码错误！");
						return;
						}
					if(passwordField_1.getPassword().length<=0) {
						JOptionPane.showMessageDialog(null,"请输入密码！");
						return;
					}
					if(!new String(passwordField_1.getPassword()).equals(new String(passwordField_2.getPassword()))) {
						JOptionPane.showMessageDialog(null,"请确认新密码相同！");
						return;
					}	
						
					textBase=new String(passwordField_1.getPassword());
					base32Pass=	base32.encodeToString(textBase.getBytes("UTF-8"));

					
					line.add(line.size()-1, base32Pass);
					
					FileWriter fw=new FileWriter("config/my.conf");
					BufferedWriter bw=new BufferedWriter(fw);

					for (int i = 0; i < line.size()-1; i++) {
						if(i==line.size()-2) {bw.write(line.get(i));}
						else
						bw.write(line.get(i)+"\n");
					}
					
					bw.close();
					JOptionPane.showMessageDialog(null,"密码修改成功！");
					dispose();
					
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					dispose();
				
				
				
			}
		});
		button.setBounds(91, 228, 66, 23);
		contentPane.add(button);
		
		JLabel label = new JLabel("新密码：");
		label.setBounds(10, 101, 54, 28);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("确认密码：");
		label_1.setBounds(10, 152, 66, 28);
		contentPane.add(label_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(91, 44, 102, 34);
		contentPane.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(91, 99, 102, 34);
		contentPane.add(passwordField_1);
		
		passwordField_2 = new JPasswordField();
		passwordField_2.setBounds(91, 150, 102, 34);
		contentPane.add(passwordField_2);
	}
}
