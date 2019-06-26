package cn.time.manage;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

import cn.time.entity.Employe;
import cn.time.entity.Member;
import cn.time.mapper.EmployeMapper;
import cn.time.mapper.MemberMapper;
import cn.time.test.MyBatisUtil;
import javax.swing.JComboBox;

public class EmployePanel extends JPanel {

	/**
	 * Create the panel.
	 */
	
	
	
	 JTextField textField;
		public static JTextField textField_1;
		public static JTextField textField_2;
		public static JTextField textField_4;
		public static JRadioButton radioButton ;
		public static JRadioButton radioButton_1 ;
		 List<Employe> elist;
		 JTable table;
		 DefaultTableModel model;
		 Object[] columnTitle = {"员工号" , "姓名" , "性别", "用户名","密码"};
		 public static String oe_id;
		 private final ButtonGroup buttonGroup = new ButtonGroup();
	
	
	
	public EmployePanel() {
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
		
		JLabel label_1 = new JLabel("用户名:");
		label_1.setBounds(427, 181, 54, 15);
		add(label_1);
		
		JLabel label_2 = new JLabel("性别:");
		label_2.setBounds(427, 353, 54, 15);
		add(label_2);
		
		JLabel label_3 = new JLabel("姓名:");
		label_3.setBounds(427, 296, 54, 15);
		add(label_3);
		
		JLabel label_4 = new JLabel("密码:");
		label_4.setBounds(427, 244, 54, 15);
		add(label_4);
		
		textField_1 = new JTextField();
		textField_1.setBounds(485, 174, 123, 29);
		add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(485, 237, 123, 29);
		add(textField_2);
		textField_2.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(485, 293, 66, 29);
		add(textField_4);
		textField_4.setColumns(10);
		
		JButton button = new JButton("修改");
		
		button.setBounds(545, 443, 93, 23);
		add(button);
		
		JButton button_1 = new JButton("删除");
	
		button_1.setBounds(424, 511, 93, 23);
		add(button_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 153, 378, 381);
		add(scrollPane);
		
		
		 Object[][] tableData =findAll();			
			  //定义一维数据作为列标题
			 
		 model=new DefaultTableModel(tableData, columnTitle){public boolean isCellEditable(int row, int column){return false;}};	
		
		table = new JTable(model);
	
		table.getColumnModel().getColumn(0).setPreferredWidth(100);
		table .getTableHeader().setReorderingAllowed(false);
		scrollPane.setViewportView(table);		
		
		JButton button_2 = new JButton("增加");
		
		button_2.setBounds(424, 443, 93, 23);
		add(button_2);
		
		JButton button_3 = new JButton("退出");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		button_3.setBounds(545, 511, 93, 23);
		add(button_3);
		
		 radioButton = new JRadioButton("男");
		 buttonGroup.add(radioButton);
		radioButton.setBounds(487, 349, 64, 23);
		add(radioButton);
		
		 radioButton_1 = new JRadioButton("女");
		 buttonGroup.add(radioButton_1);
		radioButton_1.setBounds(561, 349, 54, 23);
		add(radioButton_1);
		//display();
				
		
		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>();
		model.addElement("正常");
		model.addElement("离职");
		model.addElement("暂离");
		
		//搜索回车确认
		KeyAdapter keyAdapter=	new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {				
				if (e.getKeyCode()==KeyEvent.VK_ENTER) 	query();
			}
		};
		
		textField.addKeyListener(keyAdapter);
		
		//按钮确认
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				query();
			}
		});
		
		
		//显示在控件
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(java.awt.event.MouseEvent e) {
				   int r= table.getSelectedRow();
				   int c= table.getSelectedColumn();
				   EmployePanel.textField_1.setText(table.getValueAt(r, 3).toString());
				   EmployePanel.textField_2.setText(table.getValueAt(r, 4).toString());
				   if(table.getValueAt(r, 2).toString().equals("男")) {radioButton.setSelected(true);}
				   else radioButton_1.setSelected(true);								   
				   EmployePanel.textField_4.setText(table.getValueAt(r, 1).toString());
				   oe_id=table.getValueAt(r, 0).toString();
           
			}
		});
       
		//修改按钮
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Employe employe=new Employe();
				employe.setUser(textField_1.getText());
				employe.setPasswd(textField_2.getText());
				if(radioButton.isSelected())employe.setSex("男");
				else employe.setSex("女");			
				employe.setName(textField_4.getText());
				int err=0;
				String msg="";
				try {
					 err= isRegex(employe);					
					if(err!=0) {msg=getErrorMsg(err);throw new Exception(); }
					else {
					SqlSession session=	 MyBatisUtil.getSession();
					EmployeMapper employeMapper = session.getMapper(EmployeMapper.class);
					employeMapper.upDateEmploye(employe, oe_id);;
					session.commit();
					MyBatisUtil.closeSession();
					JOptionPane.showMessageDialog(null,"修改成功");
					upDate(table);
					}					
				} catch (PersistenceException e1) {
					JOptionPane.showMessageDialog(null,"用户名已存在！");
				}
				catch (Exception e2) {
					e2.printStackTrace();
					//JOptionPane.showMessageDialog(null,msg);
				
				}
			
				
				
				
			}
		});
		
		//删除按钮
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SqlSession session=	 MyBatisUtil.getSession();
				EmployeMapper employeMapper = session.getMapper(EmployeMapper.class);
				try {
					employeMapper.delEmploye(oe_id);
					session.commit();
					MyBatisUtil.closeSession();
					JOptionPane.showMessageDialog(null,"已删除");									
					upDate(table);
						
						
				} catch (Exception e2) {
					e2.printStackTrace();
					JOptionPane.showMessageDialog(null,"删除失败");
					
				}
				
				
			}
		});
	
		
		//增加按钮
				button_2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Employe employe = new Employe();
						employe.setUser(textField_1.getText());
						employe.setPasswd(textField_2.getText());
						if(radioButton.isSelected())employe.setSex("男");
						else employe.setSex("女");						
						employe.setName(textField_4.getText());
						int err= isRegex(employe);
						String msg="";
						try {
						if(err!=0) {msg=getErrorMsg(err);/*throw new Exception();*/ }
						else 
						{
						SqlSession session=	 MyBatisUtil.getSession();
						EmployeMapper employeMapper = session.getMapper(EmployeMapper.class);
						
							employeMapper.addEmploye(employe);
							session.commit();
							MyBatisUtil.closeSession();
							JOptionPane.showMessageDialog(null,"增加成功");
							upDate(table);}
						} 
						catch(org.apache.ibatis.exceptions.PersistenceException e1){
							e1.printStackTrace();
							JOptionPane.showMessageDialog(null,"用户名存在!");
						}catch (Exception e2) {
							e2.printStackTrace();
							JOptionPane.showMessageDialog(null,msg);
						
						}
					
						
					}
				});
			
	}
	
	
	
	
	public Object[][] findAll() {
		
	SqlSession session=	 MyBatisUtil.getSession();
	EmployeMapper employeMapper = session.getMapper(EmployeMapper.class);
	elist=employeMapper.findAll();	
 	Object data[][]= new Object[elist.size()][5];
 	
 	for (int i = 0; i < elist.size(); i++) { 					
 		//	System.out.println(mlist.get(i).getM_id());	 		
 	 		data[i][0]=elist.get(i).gete_Id();	//e_id
 	 		data[i][1]=elist.get(i).getName();	//	name
 	 		data[i][2]=elist.get(i).getSex();	//sex
 	 		data[i][3]=elist.get(i).getUser();	//user
 	 		data[i][4]=elist.get(i).getPasswd();	//pass
 	 	
		}
	
 	MyBatisUtil.closeSession();
 	return data;
 	
	}



	public Object[][] convert(List<Employe> elist){
		
		
		Object data[][]= new Object[elist.size()][5];
	 	
	 	for (int i = 0; i < elist.size(); i++) { 					
	 		
	 		data[i][0]=elist.get(i).gete_Id();	//e_id
 	 		data[i][1]=elist.get(i).getName();	//	name
 	 		data[i][2]=elist.get(i).getSex();	//sex
 	 		data[i][3]=elist.get(i).getUser();	//user
 	 		data[i][4]=elist.get(i).getPasswd();	//pass
			}
	
		return data;
	}

	
	
	public void query() {
		SqlSession session =MyBatisUtil.getSession();	
		EmployeMapper employeMapper=session.getMapper(EmployeMapper.class);
		List<Employe> elist = employeMapper.queryLike(textField.getText(),textField.getText(),textField.getText());
		
		 model=new DefaultTableModel(convert(elist), columnTitle){public boolean isCellEditable(int row, int column){return false;}};	
		table.setModel(model);
		table.updateUI();
		MyBatisUtil.closeSession();
	}


	public void upDate(JTable table) {
		
		
		 Object[][]	tableData=findAll();
		 model=new DefaultTableModel(tableData, columnTitle){public boolean isCellEditable(int row, int column){return false;}};	
		 table.getColumnModel().getColumn(0).setPreferredWidth(100);
			table .getTableHeader().setReorderingAllowed(false);
		 	table.setModel(model);
			table.updateUI();
	}

	//#start  int isRegex(Member member)
	public int isRegex(Employe employe) {
		
		
		//匹配姓氏
		String str=employe.getName();
		String regex="^[\\u4e00-\\u9fa5]{1,2}$";
		boolean m;
		
		Pattern pattern=Pattern.compile(regex);
		Matcher matcher=pattern.matcher(str);
		 m=	matcher.matches();
		if(!m) {return 1;}
		
		//匹配用户名
		str=employe.getUser();
		regex="^[a-z]{1,10}$";
		pattern=Pattern.compile(regex);
		matcher=pattern.matcher(str);
		 m=	matcher.matches();
		if(!m) { return 2;}
		

		
		//匹配密码
		str=employe.getPasswd();
		regex="^[a-z|0-9]{6,10}$";
		pattern=Pattern.compile(regex);
		matcher=pattern.matcher(str);
		 m=	matcher.matches();
		if(!m) { return 4;}
		

		return 0;
	
	}
//#end	
	
	//#start  String getErrorMsg(int m)
	public String getErrorMsg(int m) {
		
		String msg="";
		
		switch (m) {
		case 1:
			msg="姓氏输入有误";
			break;
		case 2:
			msg="用户名输入有误,请输入10位以下小写英文!";
			break;
		case 3:
			msg="性别输入有误";
			break;
		case 4:
			msg="密码输入有误,请输入6位以上10位以下小写英文或数字!";
			break;		
		}
		
		
		return msg;
		
	}
}
