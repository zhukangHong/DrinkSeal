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
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import org.apache.ibatis.session.SqlSession;

import com.time.Tool;

import cn.time.entity.Member;
import cn.time.entity.TbDeal;
import cn.time.entity.TbDetail;
import cn.time.mapper.MemberMapper;
import cn.time.mapper.TbDealMapper;
import cn.time.mapper.TbDetailMapper;
import cn.time.test.MyBatisUtil;
import javax.swing.JSeparator;

public class DealPanel extends JPanel {
	
	 JTextField textField;
	public static JTextField textField_1;
	public static JTextField textField_2;
	public static JTextField textField_4;
	 List<TbDeal> mlist;
	 List<TbDetail> detaillist;
	 JScrollPane scrollPane_1;
	 JTable table;
	 DefaultTableModel model;
	 DefaultTableModel detailModel;
	 Object[] columnTitle = {"订单号" , "日期" , "总价", "员工", "会员号", "获得积分", "数量"};
	 Object[] detailcolumnTitle = {"饮品" , "数量" , "价格"};
	 public static String om_id;
	 private final ButtonGroup buttonGroup = new ButtonGroup();
	 JTable table_1;
	public static String dd_id ;
	 
	 
	/**
	 * Create the panel.
	 * 
	 * sql=select * from tb_member
	 *	where m_id like "%4%" or name like "%吴%" 
	 * 
	 * 
	 */
	public DealPanel() {
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
		
		JLabel label_1 = new JLabel("总价:");
		label_1.setBounds(451, 387, 54, 15);
		add(label_1);
		
		JLabel label_3 = new JLabel("获得积分:");
		label_3.setBounds(451, 430, 54, 15);
		add(label_3);
		
		JLabel label_4 = new JLabel("会员号");
		label_4.setBounds(451, 345, 54, 15);
		add(label_4);
		
		textField_1 = new JTextField();
		textField_1.setEnabled(false);
		textField_1.setEditable(false);
		textField_1.setBounds(515, 380, 123, 29);
		add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setEnabled(false);
		textField_2.setEditable(false);
		textField_2.setBounds(515, 338, 123, 29);
		add(textField_2);
		textField_2.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setEnabled(false);
		textField_4.setBounds(515, 423, 66, 29);
		add(textField_4);
		textField_4.setColumns(10);
		
		JButton button = new JButton("修改订单");
		button.setVisible(false);
		button.setBounds(488, 471, 93, 23);
		add(button);
		
		JButton button_1 = new JButton("删除订单");
	
		button_1.setBounds(488, 502, 93, 23);
		add(button_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(42, 137, 596, 175);
		add(scrollPane);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(42, 338, 359, 249);
		add(scrollPane_1);
		
		table_1 = new JTable((TableModel) null);
		scrollPane_1.setViewportView(table_1);
		
		
		 Object[][] dealData =findAll();
		
		// Object[][] detailData =findAll();	
		 
			  //定义一维数据作为列标题
			 
		 model=new DefaultTableModel(dealData, columnTitle){public boolean isCellEditable(int row, int column){return false;}};			
		 
		 
		 table = new JTable(model);	
		 setTableStyle(table);	
		scrollPane.setViewportView(table);
		
		 detailModel=new DefaultTableModel(null, detailcolumnTitle){public boolean isCellEditable(int row, int column){return false;}};			
		 table_1=new JTable(detailModel);	
		 scrollPane_1.setViewportView(table_1);
		
		
		
		
		JButton button_3 = new JButton("退出");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		button_3.setBounds(488, 549, 93, 23);
		add(button_3);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(424, 471, 198, 2);
		add(separator);
		
		
		
						

       
		//点击显示详细列表
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(java.awt.event.MouseEvent e) {
				   int r= table.getSelectedRow();	
				   String m_id="";
				dd_id =  table.getValueAt(r, 0).toString();	
				SqlSession session=	 MyBatisUtil.getSession();
				TbDetailMapper tbDetailMapper = session.getMapper(TbDetailMapper.class);
				detaillist=tbDetailMapper.selectById(dd_id)	;
				
				if(table.getValueAt(r, 4)!=null) {
					m_id=table.getValueAt(r, 4).toString();
				}
				textField_2.setText(m_id);
				textField_1.setText(table.getValueAt(r, 2).toString());
				textField_4.setText(table.getValueAt(r, 5).toString());
				
				detailModel=new DefaultTableModel(convertDetail(detaillist), detailcolumnTitle){public boolean isCellEditable(int row, int column){return false;}};	
				table_1.setModel(detailModel);
				
				table_1.updateUI();
				MyBatisUtil.closeSession();
							 
			}
		});
		
		
		
		//回车搜索
		KeyAdapter keyAdapter=	new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {				
				if (e.getKeyCode()==KeyEvent.VK_ENTER) 	query();
			}
		};
		
		textField.addKeyListener(keyAdapter);
		
		//按钮搜索
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				query();
			}
		});
		
		//修改按钮
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TbDeal tbDeal=new TbDeal();
				tbDeal.setm_Id(textField_2.getText());
				tbDeal.setTotal(Float.valueOf(textField_1.getText()));
				tbDeal.setPoint(Integer.parseInt(textField_4.getText()));
				tbDeal.setDd_Id(dd_id);
	
				int err=0;
				String msg="";
				try {
					err= isRegex(tbDeal);					
					if(err!=0) {msg=getErrorMsg(err);throw new Exception(); }
					else {
					SqlSession session=	 MyBatisUtil.getSession();
					TbDealMapper tbDealMapper = session.getMapper(TbDealMapper.class);
					tbDealMapper.upDate(tbDeal);
					session.commit();
					MyBatisUtil.closeSession();
					JOptionPane.showMessageDialog(null,"修改成功");
					upDate(table);
					}					
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
			
				try {
					SqlSession session=	 MyBatisUtil.getSession();
					TbDealMapper tbDealMapper = session.getMapper(TbDealMapper.class);
					tbDealMapper.deleteDeal(dd_id);	
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
	
	}
	
	
	
	public Object[][] findAll() {	
		
	SqlSession session=	 MyBatisUtil.getSession();
	TbDealMapper tbDealMapper = session.getMapper(TbDealMapper.class);
	mlist=tbDealMapper.findAll();	
 	Object data[][]= new Object[mlist.size()][7];
 	
 	for (int i = 0; i < mlist.size(); i++) { 					
 		//	System.out.println(mlist.get(i).getM_id());
 	 		data[i][0]=mlist.get(i).getDd_Id();
 	 		data[i][1]=mlist.get(i).getDd_Date();
 	 		data[i][2]=String.valueOf(mlist.get(i).getTotal());	 		
 	 		data[i][3]=mlist.get(i).gete_Id();
 	 		data[i][4]=mlist.get(i).getm_Id();
 	 		data[i][5]=String.valueOf(mlist.get(i).getPoint());
 	 		data[i][6]=String.valueOf(mlist.get(i).getNum());		
 	 		
 	
		}
	
 	MyBatisUtil.closeSession();
 	return data;
 	
	}



	public Object[][] convert(List<TbDeal> mlist){
		
		
		Object data[][]= new Object[mlist.size()][7];
	 	
	 	for (int i = 0; i < mlist.size(); i++) { 					
	 		
	 		data[i][0]=mlist.get(i).getDd_Id();
 	 		data[i][1]=mlist.get(i).getDd_Date();
 	 		data[i][2]=String.valueOf(mlist.get(i).getTotal());	 		
 	 		data[i][3]=mlist.get(i).gete_Id();
 	 		data[i][4]=mlist.get(i).getm_Id();
 	 		data[i][5]=String.valueOf(mlist.get(i).getPoint());
 	 		data[i][6]=String.valueOf(mlist.get(i).getNum());		
	 	 	
			}
	
		return data;
	}

	public Object[][] convertDetail(List<TbDetail> mlist){
		
		
		Object data[][]= new Object[mlist.size()][3];
	 	
	 	for (int i = 0; i < mlist.size(); i++) { 					
	 		
	 		data[i][0]=mlist.get(i).getd_Name();
 	 		data[i][1]=String.valueOf(mlist.get(i).getNum());		
 	 		data[i][2]=String.valueOf(mlist.get(i).getPrice());	
	 	 	
			}
	
		return data;
	}

	
	public void query() {
		SqlSession session =MyBatisUtil.getSession();	
		TbDealMapper tbDealMapper = session.getMapper(TbDealMapper.class);
	
		List<TbDeal> mlist = tbDealMapper.queryLike(textField.getText(),textField.getText());
		
		 model=new DefaultTableModel(convert(mlist), columnTitle){public boolean isCellEditable(int row, int column){return false;}};	
		
		table.setModel(model);
		 setTableStyle(table);
		table.updateUI();
		MyBatisUtil.closeSession();
	}


	public void upDate(JTable table) {
		
		
		 Object[][]	tableData=findAll();
		 model=new DefaultTableModel(tableData, columnTitle){public boolean isCellEditable(int row, int column){return false;}};				 
		 	table.setModel(model);
		 	 setTableStyle(table);	
			table.updateUI();
	}

	//#start  int isRegex(Member member)
	public int isRegex(TbDeal tbDeal) throws ClassNotFoundException, SQLException {
		
		
		//匹配是否为会员
		String str=tbDeal.getm_Id();
		boolean isMember=false;
		Connection connection=Tool.getConnection();
		Statement st=connection.createStatement();
		ResultSet rs =  st.executeQuery("select m_id from tb_member");
		while (rs.next()) {
			if(rs.getString(1).equals(str)) {
				isMember=true;
			}
		}
		
		String regex="^[\\u4e00-\\u9fa5]{1,2}$";
		boolean m;	
		Pattern pattern=Pattern.compile(regex);
		Matcher matcher=pattern.matcher(str);	
		if(!isMember) {return 1;}
		
		//匹配手机号格式
		str=tbDeal.getm_Id();
		regex="^1[3|4|5|8]\\d{9}$";
		pattern=Pattern.compile(regex);
		matcher=pattern.matcher(str);
		 m=	matcher.matches();
		if(!m) { return 2;}
		

		
		//匹配积分
		if(tbDeal.getPoint()<0) {
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
			msg="无此会员";
			break;
		case 2:
			msg="手机格式有误";
			break;
		case 4:
			msg="积分输入有误";
			break;		
		}
		
		
		return msg;
		
	}
	
	//#end
	
	//设置表格样式
	//#start public static void setTableStyle(JTable table)
	public static void setTableStyle(JTable table) {
		table.getColumnModel().getColumn(0).setPreferredWidth(120);
		table.getColumnModel().getColumn(1).setPreferredWidth(170);
		table.getColumnModel().getColumn(3).setPreferredWidth(50);
		table.getColumnModel().getColumn(4).setPreferredWidth(100);		
		table .getTableHeader().setReorderingAllowed(false);
	}
	//#end




}
