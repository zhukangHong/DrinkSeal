package cn.time.manage;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;
import org.eclipse.swt.events.MouseEvent;
import org.omg.CORBA.MARSHAL;

import cn.time.entity.Member;
import cn.time.mapper.MemberMapper;
import cn.time.test.MyBatisUtil;

import java.awt.Dimension;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.nio.channels.SeekableByteChannel;
import java.sql.SQLException;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class MembPanel extends JPanel {
	
	 JTextField textField;
	public static JTextField textField_1;
	public static JTextField textField_2;
	public static JTextField textField_4;
	public static JRadioButton radioButton ;
	public static JRadioButton radioButton_1 ;
	 List<Member> mlist;
	 JTable table;
	 DefaultTableModel model;
	 Object[] columnTitle = {"手机号" , "姓名" , "性别", "积分"};
	 public static String om_id;
	 private final ButtonGroup buttonGroup = new ButtonGroup();
	 public String m_id="";
	 
	 
	 
	/**
	 * Create the panel.
	 * 
	 * sql=select * from tb_member
	 *	where m_id like "%4%" or name like "%吴%" 
	 * 
	 * 
	 */
	public MembPanel() {
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
		
		JLabel label_1 = new JLabel("手机号:");
		label_1.setBounds(427, 181, 54, 15);
		add(label_1);
		
		JLabel label_2 = new JLabel("性别:");
		label_2.setBounds(427, 313, 54, 15);
		add(label_2);
		
		JLabel label_3 = new JLabel("积分:");
		label_3.setBounds(427, 377, 54, 15);
		add(label_3);
		
		JLabel label_4 = new JLabel("姓氏:");
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
		textField_4.setText("0");
		textField_4.setBounds(485, 374, 66, 29);
		add(textField_4);
		textField_4.setColumns(10);
		
		JButton button = new JButton("修改");
		
		button.setBounds(545, 443, 93, 23);
		add(button);
		
		JButton button_1 = new JButton("删除");
	
		button_1.setBounds(424, 511, 93, 23);
		add(button_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(42, 153, 348, 381);
		add(scrollPane);
		
		
		 Object[][] tableData =findAll();			
			  //定义一维数据作为列标题
			 
		 model=new DefaultTableModel(tableData, columnTitle){public boolean isCellEditable(int row, int column){return false;}};	
		
		table = new JTable(model);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.getColumnModel().getColumn(0).setPreferredWidth(100);
		table .getTableHeader().setReorderingAllowed(false);
		scrollPane.setViewportView(table);		
		
		JButton button_2 = new JButton("增加");
		
		button_2.setBounds(424, 443, 93, 23);
		add(button_2);
		
		JButton button_3 = new JButton("积分记录");
		
		button_3.setBounds(545, 511, 93, 23);
		add(button_3);
		
		 radioButton = new JRadioButton("先生");
		 buttonGroup.add(radioButton);
		radioButton.setBounds(487, 309, 64, 23);
		add(radioButton);
		
		 radioButton_1 = new JRadioButton("小姐");
		 buttonGroup.add(radioButton_1);
		radioButton_1.setBounds(561, 309, 66, 23);
		add(radioButton_1);
		//display();
						
		
		//显示在控件
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(java.awt.event.MouseEvent e) {
				   int r= table.getSelectedRow();
				   int c= table.getSelectedColumn();
				   MembPanel.textField_1.setText(table.getValueAt(r, 0).toString());
				   MembPanel.textField_2.setText(table.getValueAt(r, 1).toString());
				   if(table.getValueAt(r, 2).toString().equals("男")) {radioButton.setSelected(true);}
				   else radioButton_1.setSelected(true);								   
				   MembPanel.textField_4.setText(table.getValueAt(r, 3).toString());
				   om_id=textField_1.getText();
           
			}
		});
       
		
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
		
		//修改按钮
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Member member=new Member();
				member.setM_id(textField_1.getText());
				member.setName(textField_2.getText());
				if(radioButton.isSelected())member.setSex("男");
				else member.setSex("女");			
				member.setPoint(Integer.parseInt(textField_4.getText()));
				int err=0;
				String msg="";
				try {
					 err= isRegex(member);					
					if(err!=0) {msg=getErrorMsg(err);throw new Exception(); }
					else {
					SqlSession session=	 MyBatisUtil.getSession();
					MemberMapper memberMapper = session.getMapper(MemberMapper.class);
					memberMapper.upDateMember(member, om_id);
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
					JOptionPane.showMessageDialog(null,msg);
				
				}
			
				
				
				
			}
		});
		
	
		//删除按钮
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SqlSession session=	 MyBatisUtil.getSession();
				MemberMapper memberMapper = session.getMapper(MemberMapper.class);
				try {
					memberMapper.delMember(textField_1.getText());
					session.commit();
					MyBatisUtil.closeSession();
					JOptionPane.showMessageDialog(null,"已删除");
					
				/*	 Object[][]	tableData=findAll();
					 model=new DefaultTableModel(tableData, columnTitle){public boolean isCellEditable(int row, int column){return false;}};	
						table.setModel(model);
						table.updateUI();
						*/
					upDate(table);
						
						
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null,"删除失败");
					// TODO: handle exception
				}
				
				
			}
		});
	
		//增加按钮
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Member member = new Member();
				member.setM_id(textField_1.getText());
				member.setName(textField_2.getText());
				if(radioButton.isSelected())member.setSex("男");
				else member.setSex("女");						
				member.setPoint(Integer.parseInt(textField_4.getText()));
				int err= isRegex(member);
				String msg="";
				try {
				if(err!=0) {msg=getErrorMsg(err);throw new Exception(); }
				else 
				{
				SqlSession session=	 MyBatisUtil.getSession();
				MemberMapper memberMapper = session.getMapper(MemberMapper.class);
				
					memberMapper.addMember(member);
					session.commit();
					MyBatisUtil.closeSession();
					JOptionPane.showMessageDialog(null,"增加成功");
					upDate(table);}
				} 
				catch(org.apache.ibatis.exceptions.PersistenceException e1){
					JOptionPane.showMessageDialog(null,"已是会员");
				}catch (Exception e2) {
					e2.printStackTrace();
					JOptionPane.showMessageDialog(null,msg);
					// TODO: handle exception
				}
			
				
			}
		});
		
		//查询积分按钮
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(textField_1.getText().equals("")) {JOptionPane.showMessageDialog(null,"请选择会员！");return;}
					new PointRecordFrame(textField_1.getText()).setVisible(true);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	
	}
	
	
	
	public Object[][] findAll() {
		
	SqlSession session=	 MyBatisUtil.getSession();
	MemberMapper memberMapper = session.getMapper(MemberMapper.class);
	mlist=memberMapper.findAll();	
 	Object data[][]= new Object[mlist.size()][4];
 	
 	for (int i = 0; i < mlist.size(); i++) { 					
 		//	System.out.println(mlist.get(i).getM_id());
 	 		data[i][0]=mlist.get(i).getM_id();
 	 		data[i][1]=mlist.get(i).getName();
 	 		data[i][2]=mlist.get(i).getSex();
 	 		data[i][3]=String.valueOf(mlist.get(i).getPoint());
 		
 	 	
		}
	
 	MyBatisUtil.closeSession();
 	return data;
 	
	}



	public Object[][] convert(List<Member> mlist){
		
		
		Object data[][]= new Object[mlist.size()][4];
	 	
	 	for (int i = 0; i < mlist.size(); i++) { 					
	 		
	 	 		data[i][0]=mlist.get(i).getM_id();
	 	 		data[i][1]=mlist.get(i).getName();
	 	 		data[i][2]=mlist.get(i).getSex();
	 	 		data[i][3]=String.valueOf(mlist.get(i).getPoint()); 		
	 	 	
			}
	
		return data;
	}

	
	
	public void query() {
		SqlSession session =MyBatisUtil.getSession();	
		MemberMapper memberMapper = session.getMapper(MemberMapper.class);
		List<Member> mlist = memberMapper.queryLike(textField.getText(),textField.getText());
		
		 model=new DefaultTableModel(convert(mlist), columnTitle){public boolean isCellEditable(int row, int column){return false;}};	
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
	public int isRegex(Member member) {
		
		
		//匹配姓氏
		String str=member.getName();
		String regex="^[\\u4e00-\\u9fa5]{1,2}$";
		boolean m;
		
		Pattern pattern=Pattern.compile(regex);
		Matcher matcher=pattern.matcher(str);
		 m=	matcher.matches();
		if(!m) {return 1;}
		
		//匹配手机号
		str=member.getM_id();
		regex="^1[3|4|5|8]\\d{9}$";
		pattern=Pattern.compile(regex);
		matcher=pattern.matcher(str);
		 m=	matcher.matches();
		if(!m) { return 2;}
		

		
		//匹配积分
		if(member.getPoint()<0) {
			return 4;
		}

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
			msg="手机输入有误";
			break;
		case 3:
			msg="性别输入有误";
			break;
		case 4:
			msg="积分输入有误";
			break;		
		}
		
		
		return msg;
		
	}
	//#end
}
