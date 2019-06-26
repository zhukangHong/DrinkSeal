package cn.time.manage;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import com.time.Tool;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class AddCategory extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddCategory frame = new AddCategory();					
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
	public AddCategory() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 283, 213);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		JLabel lblNewLabel = new JLabel("类别名称:");
		lblNewLabel.setBounds(27, 44, 54, 28);
		contentPane.add(lblNewLabel);
		setTitle("增加类别");
		textField = new JTextField();
		textField.setBounds(127, 41, 66, 31);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton button = new JButton("确定");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection connection=Tool.getConnection();					
					
					String sql;
					Statement st=connection.createStatement();
					sql="select * from tb_category where status!='移除'";
					ResultSet	rs=	st.executeQuery(sql);	
				
					while (rs.next()) {
						String s1=rs.getString(2);	
						
						if(textField.getText().equals(s1)){
						
							JOptionPane.showMessageDialog(null,"已经存在该类别！");
						return;
						}						
					}
					
					sql="insert into tb_category(c_name) value('"+textField.getText()+"')";										
					st.execute(sql);
					JOptionPane.showMessageDialog(null,"添加成功!");
					DrinkPanel.cateList.setModel(DrinkPanel.queryCategory(1)); 
					DrinkPanel.cateList.updateUI();
					ManageFrame.reflash();
					dispose();
				} catch (MySQLIntegrityConstraintViolationException e2) {
					e2.printStackTrace();
					JOptionPane.showMessageDialog(null,"已经有这个类别！！");
				}
				catch (ClassNotFoundException | SQLException e1) {
					
					e1.printStackTrace();
				}
				
				
			}
		});
		button.setBounds(127, 105, 66, 23);
		contentPane.add(button);
	}
}
