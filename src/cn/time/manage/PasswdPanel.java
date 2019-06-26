package cn.time.manage;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import org.apache.commons.codec.binary.Base32;
import org.apache.ibatis.session.SqlSession;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import com.time.LoginFrame;
import com.time.Tool;

import cn.time.entity.Employe;
import cn.time.entity.Member;
import cn.time.entity.TbCategory;
import cn.time.entity.TbDrink;
import cn.time.mapper.EmployeMapper;
import cn.time.mapper.MemberMapper;
import cn.time.mapper.TbCategoryMapper;
import cn.time.mapper.TbDrinkMapper;
import cn.time.test.MyBatisUtil;
import javax.swing.JList;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import javax.swing.JPasswordField;

public class PasswdPanel extends JPanel {
	String basePass;
	String realPass;
	private JPasswordField textField;
	
	
	  @Override
      protected void paintComponent(Graphics g) {
   	    super.paintComponent(g);
   	    ImageIcon img = new ImageIcon(PasswdPanel.class.getResource("passwd1.jpg"));  
         /**
          * bg.PNG这个地方换成自己的图片
          * 此处使用的相对路径，bg.png跟该测试类在同一路径下
          * 不过建议使用相对路径避免使用绝对路径
          */
            img.paintIcon(this, g, 0, 0);
      }
	
	

	public PasswdPanel() throws ClassNotFoundException {
		
		
		
		
		setLayout(null);
		setSize(new Dimension(665, 597));
		
		JButton btnNewButton = new JButton("验证");

		btnNewButton.setBounds(404, 276, 93, 23);
		add(btnNewButton);

		JLabel label = new JLabel("验证身份：");
		label.setBounds(78, 280, 73, 15);
		add(label);

		JButton button_3 = new JButton("退出");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		button_3.setBounds(523, 523, 93, 23);
		add(button_3);
		
		JLabel lblNewLabel = new JLabel("<html><u><i>修改口令</i></u></html>");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				new AlterPass().setVisible(true);
			}
		});
		lblNewLabel.setFont(lblNewLabel.getFont().deriveFont(lblNewLabel.getFont().getStyle() | Font.ITALIC));
		lblNewLabel.setBounds(424, 309, 54, 30);
		add(lblNewLabel);
		
		textField = new JPasswordField();
		textField.setBounds(161, 277, 118, 21);
		add(textField);
		
		//验证按钮
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FileReader fr;
				try {
					fr = new FileReader("config/my.conf");
					BufferedReader reader =new BufferedReader(fr);
					while(reader.readLine()!=null)
					basePass=reader.readLine();
					
					realPass=new String(textField.getPassword() );
					
					if(	base32IsSame(basePass, realPass)) {
						JOptionPane.showMessageDialog(null,"验证成功！");
						ManageFrame.panel_1.removeAll();
						ManageFrame.panel_1.add(new MembPanel());
						ManageFrame.panel_1.updateUI();
						ManageFrame.lock=true;
					}
					else JOptionPane.showMessageDialog(null,"验证失败！");
					
				
					
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
	
	
		
		
	}
	
	public static boolean base32IsSame(String basePass,String realPass) throws UnsupportedEncodingException {
		
		boolean ret;
		Base32 pass =new Base32();
		realPass=	pass.encodeToString(realPass.getBytes("UTF-8"));
		
		ret=basePass.equals(realPass)?true:false;
		
		return ret;
		
	}
	
	
	
	
	}
