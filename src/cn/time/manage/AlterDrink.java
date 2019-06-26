package cn.time.manage;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.apache.ibatis.session.SqlSession;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import com.time.Tool;

import cn.time.entity.Employe;
import cn.time.entity.TbDrink;
import cn.time.mapper.EmployeMapper;
import cn.time.mapper.TbDrinkMapper;
import cn.time.test.MyBatisUtil;

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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

public class AlterDrink extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField_2;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	JRadioButton radioButton;
	JRadioButton radioButton_1;
	JComboBox<String> comboBox;
	int d_id=0;
	Map<String ,Integer> drinkId=new HashMap<>();

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
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public AlterDrink(List<String> c_nameArr,String name,int c_index) throws ClassNotFoundException, SQLException {
		setResizable(false);
		setTitle("修改饮品："+name);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 377, 340);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("更改类别:");
		lblNewLabel.setBounds(27, 26, 54, 28);
		contentPane.add(lblNewLabel);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		JButton button = new JButton("确定");
	
				
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String status = "";
					int c_id = 0;

					if (radioButton.isSelected())
						status = "在售";
					else
						status = "停售";
					
					if(textField_1.getText().equals("")||Integer.parseInt(textField_2.getText())<=0) {
						JOptionPane.showMessageDialog(null,"请输入饮品名称并且价格要大于0！");
						return;						
					}
					
					
					
					Connection connection = Tool.getConnection();
					
					String sql;
					Statement st1=connection.createStatement();
					sql="select * from tb_drink where status!='移除'";
					ResultSet	rs=	st1.executeQuery(sql);	
				
					while (rs.next()) {
						String s1=rs.getString(2);	
						
						if(textField_1.getText().equals(s1)){
						
							JOptionPane.showMessageDialog(null,"已经存在该饮品！");
						return;
						}						
					}
					
					
					sql = "select * from tb_category ";
					st1 = connection.createStatement();
					rs = st1.executeQuery(sql);

					while (rs.next()) {
						drinkId.put( rs.getString(2),rs.getInt(1));
						
					}
					
			
					c_id=drinkId.get(comboBox.getSelectedItem()).intValue();
					sql = "update tb_drink set d_name=?,c_id=?,price=?,status=? where d_id=?"	;		
					PreparedStatement st = connection.prepareStatement(sql);
					st.setString(1, textField_1.getText());
					st.setInt(2, c_id);
					st.setInt(3, Integer.parseInt(textField_2.getText()));
					st.setString(4, status);					
					st.setInt(5, d_id);					
					st.executeUpdate();
					
					JOptionPane.showMessageDialog(null, "修改成功!");
					DrinkPanel.drinkList.setModel(DrinkPanel.queryCategory(2));
					DrinkPanel.drinkList.updateUI();
					dispose();
				} catch (ClassNotFoundException | SQLException e1) {
					JOptionPane.showMessageDialog(null,"饮品名已经存在！！");
					e1.printStackTrace();
				}

			}
		});
		button.setBounds(223, 218, 66, 23);
		contentPane.add(button);

		JLabel label = new JLabel("更改名称:");
		label.setBounds(27, 83, 54, 28);
		contentPane.add(label);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(126, 82, 84, 31);
		contentPane.add(textField_1);

		JLabel label_1 = new JLabel("更改价格:");
		label_1.setBounds(27, 135, 54, 28);
		contentPane.add(label_1);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(126, 134, 84, 31);
		contentPane.add(textField_2);

		JLabel label_2 = new JLabel("更改状态:");
		label_2.setBounds(27, 187, 54, 28);
		contentPane.add(label_2);

		radioButton = new JRadioButton("在售");
		buttonGroup.add(radioButton);
		radioButton.setBounds(116, 190, 69, 23);
		contentPane.add(radioButton);
		radioButton.setSelected(true);

		radioButton_1 = new JRadioButton("停售");
		buttonGroup.add(radioButton_1);
		radioButton_1.setBounds(187, 190, 67, 23);
		contentPane.add(radioButton_1);

		comboBox = new JComboBox<>();
		comboBox.setBounds(124, 30, 130, 28);
		contentPane.add(comboBox);

		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>();

		for (String c_name : c_nameArr) {
			model.addElement(c_name);
		}
		comboBox.setModel(model);
		comboBox.setSelectedIndex(c_index);
		comboBox.updateUI();

		
		SqlSession session =MyBatisUtil.getSession();	
		TbDrinkMapper drinkMapper = session.getMapper(TbDrinkMapper.class);

		List<TbDrink> dList = drinkMapper.findAll();
			for (TbDrink tbDrink : dList) {
				
				if(tbDrink.getD_Name().equals(name)) {
					textField_1.setText(name);
					textField_2.setText(String.valueOf(tbDrink.getPrice()));
					if(tbDrink.getStatus().equals("在售"))radioButton.setSelected(true);
					else radioButton_1.setSelected(true);
					d_id=tbDrink.getd_Id();
					
				}
			}
		
	}
}
