package cn.time.manage;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
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

import org.apache.ibatis.session.SqlSession;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
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

public class DrinkPanel extends JPanel {

	/**
	 * Create the panel.
	 */

	JTextField textField;
	DefaultTableModel model;
	private static Connection connection;
	static JList<String> cateList;
	static JList<String> drinkList;
	DefaultListModel<String> cateModel;
	List<String> c_nameArr;

	public DrinkPanel() throws ClassNotFoundException, SQLException {
		setLayout(null);
		setSize(new Dimension(665, 597));

		JButton btnNewButton = new JButton("查找");

		btnNewButton.setBounds(400, 84, 93, 23);
		add(btnNewButton);

		textField = new JTextField();

		textField.setBounds(144, 78, 180, 35);
		add(textField);
		textField.setColumns(10);

		JLabel label = new JLabel("搜索:");
		label.setBounds(65, 81, 39, 15);
		add(label);

		JButton button_3 = new JButton("退出");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		button_3.setBounds(533, 525, 93, 23);
		add(button_3);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(44, 141, 99, 372);
		add(scrollPane);

		cateList = new JList<String>();
		scrollPane.add(cateList);
		scrollPane.setViewportView(cateList);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(180, 141, 93, 372);
		add(scrollPane_1);
		
		drinkList = new JList<String>();
		scrollPane_1.setViewportView(drinkList);
		drinkList.setModel(queryCategory(2)); 
		

		cateList.setModel(queryCategory(1)); 
		
		JButton button = new JButton("添加饮品类别");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AddCategory().setVisible(true);
				
			}
		});
		button.setBounds(332, 172, 129, 23);
		add(button);
		
		JButton button_1 = new JButton("添加饮品");
		
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new AddDrink(c_nameArr,cateList.getSelectedIndex()).setVisible(true);
			}
		});
		button_1.setBounds(512, 172, 114, 23);
		add(button_1);
		
		JButton button_4 = new JButton("更改饮品属性");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(drinkList.isSelectionEmpty()) {
					JOptionPane.showMessageDialog(null,"请选择要修改的饮品!");
					return;
				}
				if (cateList.isSelectionEmpty()) {
					JOptionPane.showMessageDialog(null,"请选择饮品类型!");
					return;
				}
				try {
					new AlterDrink(c_nameArr,drinkList.getSelectedValue(),cateList.getSelectedIndex()).setVisible(true);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		button_4.setBounds(512, 219, 114, 23);
		add(button_4);
		
		JButton button_5 = new JButton("更改选中类别属性");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cateList.isSelectionEmpty()) {
					JOptionPane.showMessageDialog(null,"请选择要修改的类别!");
					return;
				}
				new AlterCategory(cateList.getSelectedValue()).setVisible(true);
				 
				 
			}
		});
		button_5.setBounds(332, 219, 129, 23);
		add(button_5);
		
		JButton button_6 = new JButton("删除选择类别");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cateList.isSelectionEmpty()) {	
					JOptionPane.showMessageDialog(null,"请选择要删除的类别!");
					return;
				}
				
				if(drinkList.getModel().getSize()!=0) {
					JOptionPane.showMessageDialog(null,"请先移除该类下的所有饮品!");							
					return;
				}else {
				int k =	JOptionPane.showConfirmDialog(null, "确定要删除吗?", "",JOptionPane.YES_NO_OPTION);
				if(k==0) {			
				SqlSession session=	MyBatisUtil.getSession();
				TbCategoryMapper tbCategory = session.getMapper(TbCategoryMapper.class);
				tbCategory.delCate(cateList.getSelectedValue());
				session.commit();
				JOptionPane.showMessageDialog(null,"删除成功!");	
				ManageFrame.reflash();
				try {
					DrinkPanel.cateList.setModel(DrinkPanel.queryCategory(1));
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
				DrinkPanel.cateList.updateUI();
				}

				}
				
			}
		});
		button_6.setBounds(332, 264, 129, 23);
		add(button_6);
		
		JButton button_2 = new JButton("删除饮品");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection connection;
				if (drinkList.isSelectionEmpty()) {
					JOptionPane.showMessageDialog(null,"请选择要删除的饮品！");
					return;
				}
			if(JOptionPane.showConfirmDialog(null, "确定要删除吗")!=0) {return;}	;
				try {
					connection = Tool.getConnection();
					String sql="update  tb_drink set status='移除' where d_name='"+drinkList.getSelectedValue()+"'";
					Statement st=connection.createStatement();					
					st.executeUpdate(sql);
					JOptionPane.showMessageDialog(null,"删除成功！");
					ManageFrame.reflash();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}					
				
				
			}
		});
		button_2.setBounds(512, 264, 114, 23);
		add(button_2);

		//选择列表事件
		cateList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				 if(!e.getValueIsAdjusting()){
					 try {
							drinkList.setModel(queryDrink(cateList.getSelectedValue()));
							drinkList.updateUI();
					} catch (ClassNotFoundException | SQLException e1) {						
						e1.printStackTrace();
					}
					 
				 }
			}
		});
		
		//查找按钮
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				queryLike(cateList,drinkList);
			}
		});
	
		c_nameArr=new ArrayList<>();
		for (int i = 0; i < cateList.getModel().getSize(); i++) {		
			c_nameArr.add(cateList.getModel().getElementAt(i));
		}
		
		
		
	}
	
	
	
	
	
	
	public static DefaultListModel<String> queryCategory(int mode) throws ClassNotFoundException, SQLException {
	
		DefaultListModel<String> model=new DefaultListModel<>();
		connection=Tool.getConnection();
		String sql;
		Statement statement =connection.createStatement();
		
		if(mode==1){sql="select * from tb_category where status=\"正常\" ";
		ResultSet rs=	statement.executeQuery(sql);
		
		while (rs.next()) {				
			model.addElement(rs.getString(2));				
		}
	
		}
		else {sql="select * from tb_drink where status!='移除'";
		ResultSet rs=	statement.executeQuery(sql);
		while (rs.next()) {				
			model.addElement(rs.getString(2));				
		}
		}
	
		return model;

		
	}
	
	public DefaultListModel<String> queryDrink(String c_name) throws ClassNotFoundException, SQLException{
		
		DefaultListModel<String> model=new DefaultListModel<>();
		connection=Tool.getConnection();
		String sql;
		Statement statement =connection.createStatement();
		sql="select * from tb_drink as x,tb_category as y where x.c_id=y.c_id and c_name='"+c_name+"' and x.status!='移除' and y.status!='移除'";
		
		ResultSet rs=	statement.executeQuery(sql);
		while (rs.next()) {				
			model.addElement(rs.getString(2));				
		}
		return model;
	}
			
	public void queryLike(JList<String> list1,JList<String> list2 ) {
		DefaultListModel<String> model1=new DefaultListModel<>();
		DefaultListModel<String> model2=new DefaultListModel<>();
		SqlSession session =MyBatisUtil.getSession();	
		TbCategoryMapper categoryMapper = session.getMapper(TbCategoryMapper.class);
		List<TbCategory> clist = categoryMapper.queryLike(textField.getText());
		for (TbCategory tbCategory : clist) {
			model1.addElement(tbCategory.getC_Name()); 
	}
		TbDrinkMapper drinkMapper = session.getMapper(TbDrinkMapper.class);
		List<TbDrink> dlist = drinkMapper.queryLike(textField.getText());
		
		for (TbDrink tbDrink : dlist) {
			model2.addElement(tbDrink.getD_Name()); 
	}
		
		list1.setModel(model1);
		list1.updateUI();
		list2.setModel(model2);
		list2.updateUI();
		
		MyBatisUtil.closeSession();
		


	 }
}
