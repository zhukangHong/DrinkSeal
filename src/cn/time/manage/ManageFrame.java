package cn.time.manage;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.jar.Attributes.Name;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTree;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class ManageFrame extends JFrame {

	private JPanel contentPane;
	static	JPanel panel_1 = new JPanel();
	public  static boolean lock=false ;
	
	
	
	
	

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
					 UIManager.put("RootPane.setupButtonVisible", false);
				
					ManageFrame frame = new ManageFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	
	
	
	
	
	/**
	 * Create the frame.
	 * @throws ClassNotFoundException 
	 */
	public ManageFrame() throws ClassNotFoundException, SQLException {
		setResizable(false);
		
		lock=false;
		setTitle("慢时光茶饮系统管理页");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 943, 696);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 233, 597);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btMemb = new JButton("会员管理");	
		btMemb.setBounds(56, 28, 136, 77);
		panel.add(btMemb);
		
		JButton btDeal = new JButton("订单管理");
		btDeal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!lock) {return;}
				panel_1.removeAll();
				panel_1.add(new DealPanel());
				panel_1.updateUI();
			}
		});
		btDeal.setBounds(56, 146, 136, 77);
		panel.add(btDeal);
		
		JButton btDrink = new JButton("饮品管理");
		btDrink.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!lock) {return;}
				panel_1.removeAll();
				try {
					panel_1.add(new DrinkPanel());
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				panel_1.updateUI();
			}
		});
		btDrink.setBounds(56, 251, 136, 77);
		panel.add(btDrink);
		
		JButton btSeal = new JButton("销售统计");
		
		btSeal.setBounds(56, 367, 136, 77);
		panel.add(btSeal);
		
		JButton btEmp = new JButton("员工管理");
		btEmp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!lock) {return;}
				panel_1.removeAll();
				panel_1.add(new EmployePanel());
				panel_1.updateUI();
			}
		});
		btEmp.setBounds(56, 478, 136, 77);
		panel.add(btEmp);
		
		
		
		panel_1.setBounds(232, 0, 665, 597);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		
		panel_1.removeAll();
		panel_1.add(new PasswdPanel());
		panel_1.updateUI();
		
	
		/*
		 * 全部按钮
		 * 
		 * */
		
		
		//会员管理
		btMemb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!lock) {return;}
				panel_1.removeAll();
				panel_1.add(new MembPanel());
				panel_1.updateUI();
				
			}
		});
		
		//销量统计
		btSeal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				if(!lock) {return;}
				panel_1.removeAll();
				try {
					panel_1.add(new SealPanel());
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				panel_1.updateUI();
				
			}
		});
		
		
		
		
		
		
		
	}
	//刷新界面
	public static void reflash() {
		panel_1.removeAll();
		try {
			panel_1.add(new DrinkPanel());
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		panel_1.updateUI();
		
	}
}
