package com.time;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollBar;
import javax.swing.ButtonGroup;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

import org.eclipse.ui.internal.handlers.WizardHandler.New;

import com.time.front.FrontFrame;

import java.awt.Color;
import javax.swing.border.EtchedBorder;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.AbstractButton;
import javax.swing.Box;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.awt.FlowLayout;
import java.awt.Point;

import javax.swing.ScrollPaneConstants;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentListener;
import javax.swing.event.UndoableEditListener;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.Element;
import javax.swing.text.Position;
import javax.swing.text.Segment;
import javax.swing.event.ChangeEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.CaretEvent;

public class MainFrame /*extends JFrame*/{

	
	
	/*
	 * 
	 * 
	 * 
	 * */
	

	
	
	private JFrame frame;
	private final JScrollPane scrollPane = new JScrollPane();
	private JScrollPane scrollPane_1;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JScrollPane scrollPane_2;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private JRadioButton T1;
	private JRadioButton T2;
	private JRadioButton T3;
	private JRadioButton S1;
	private JRadioButton S2;
	private JRadioButton S3;
	private final ButtonGroup buttonGroup_2 = new ButtonGroup();
	private JButton btnNewButton;
	private JLabel label;
	private JTextField textField;
	private JTextField textField_1;
	private final ButtonGroup buttonGroup_3 = new ButtonGroup();
	private final ButtonGroup buttonGroup_4 = new ButtonGroup();
	public static JTextField textField_2;
	private static  Connection conn;
	public static List<Drink> drinklist=new ArrayList<>();
	public static List<Drink> drinkPrint=new ArrayList<>();
	public static List<Drink> detaillist=new ArrayList<>();
	public static List<Drink_label> labelList=new ArrayList<>();
	public static List<DetailLabel> detailLabelList=new ArrayList<>();
	public static List<DetailLabel> fdetailLabelList=new ArrayList<>();
	JRadioButton B1 = new JRadioButton("\u6B63\u5E38");
	JRadioButton B2 = new JRadioButton("\u5C11\u51B0");
	JRadioButton B3 = new JRadioButton("\u53BB\u51B0");
	JRadioButton B4 = new JRadioButton("\u5E38\u6E29");
	JRadioButton B5 = new JRadioButton("\u52A0\u70ED");
	public static JPanel panel_5 = new JPanel();
	public static JPanel panel_4 = new JPanel();
	Statement st;

	public static JLabel label_14 = new JLabel("0");
	public static JLabel label_10 = new JLabel("100%");
	public static JLabel label_11 = new JLabel("0");
	public static JLabel label_13 = new JLabel("0");
	public static JSpinner spinner_1;
	public static String sis;
	JCheckBox chckbxNewCheckBox = new JCheckBox("珍珠");
	JCheckBox checkBox = new JCheckBox("椰果");
	JCheckBox checkBox_1 = new JCheckBox("泷珠");
	JCheckBox chckbxNewCheckBox_1 = new JCheckBox("布丁");
	JCheckBox chckbxNewCheckBox_2 = new JCheckBox("爆珠");
	JCheckBox chckbxNewCheckBox_3 = new JCheckBox("红豆");

	JRadioButton radioButtonMenuItem_3 = new JRadioButton("\u5148\u751F");
	JSpinner spinner = new JSpinner();
	JRadioButton radioButtonMenuItem_4 = new JRadioButton("\u5C0F\u59D0");
	JButton button = new JButton("\u786E\u8BA4\u5F00\u901A");
	JLabel lblN = new JLabel("");
	JLabel label_15 = new JLabel("积分");
	JButton button_2 = new JButton("积分兑换");
	JRadioButton radioButtonMenuItem_5 ;
	JRadioButton radioButtonMenuItem_6 ;
	public int e_id=1;
	static float zk = 1.0f;
	static float membzk = 0.85f;
	static float allzk = 1.0f;
	private final JButton button_3 = new JButton("设置");
	public static boolean pointEnough=true;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					  String lookAndFeel = "javax.swing.plaf.nimbus.NimbusLookAndFeel";
					  UIManager.setLookAndFeel(lookAndFeel);
					

					MainFrame window = new MainFrame(1);

					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws IOException 
	 */
	public MainFrame(int e_id) throws IOException {
		try {
			this.e_id=e_id;
			//System.out.println(e_id);
			initialize();

			// setVisible(true);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws IOException 
	 */
	private void initialize() throws ClassNotFoundException, SQLException, IOException {
		
		
		/*//美化
		
		try {
			org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
			 UIManager.put("RootPane.setupButtonVisible", false);
		} catch (Exception e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
	*/
		
		
		frame = new JFrame();	
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setTitle("慢时光茶饮销售系统");
		frame.setResizable(false);
		frame.setBounds(100, 100, 999, 583);
		//frame.setBackground(Color.WHITE);
		frame.setLocation(600, 100);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(10, 10, 99, 474);
		scrollPane.setSize( 99, 474);
		frame.getContentPane().add(scrollPane);

		JPanel panel_3 = new JPanel();
		panel_3.setPreferredSize(new Dimension(94,0));
		panel_3.setSize(new Dimension(94, 400));
		FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
		flowLayout.setVgap(10);
		scrollPane.add(panel_3);
		scrollPane.setViewportView(panel_3);
		
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_1.setBounds(111, 10, 182, 474);		
		scrollPane_1.setSize(153, 474);
		frame.getContentPane().add(scrollPane_1);
		panel_4.setPreferredSize(new Dimension(135, 0));
		panel_4.setSize(new Dimension(135, 450));
		panel_4.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		scrollPane_1.add(panel_4);
		scrollPane_1.setViewportView(panel_4);
		
		

		panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(274, 10, 164, 474);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		B1.setSelected(true);
		buttonGroup.add(B1);
		B1.setBounds(10, 47, 69, 23);
		panel.add(B1);

		buttonGroup.add(B2);
		B2.setBounds(81, 47, 69, 23);
		panel.add(B2);

		buttonGroup.add(B3);
		B3.setBounds(10, 72, 69, 23);
		panel.add(B3);

		buttonGroup.add(B4);
		B4.setBounds(81, 72, 69, 23);
		panel.add(B4);

		buttonGroup.add(B5);
		B5.setBounds(10, 95, 74, 23);
		panel.add(B5);

		T1 = new JRadioButton("\u6B63\u5E38");
		T1.setSelected(true);
		buttonGroup_1.add(T1);
		T1.setBounds(10, 173, 69, 23);
		panel.add(T1);

		T2 = new JRadioButton("\u534A\u5858");
		buttonGroup_1.add(T2);
		T2.setBounds(88, 173, 62, 23);
		panel.add(T2);

		T3 = new JRadioButton("\u65E0\u7CD6");
		buttonGroup_1.add(T3);
		T3.setBounds(10, 198, 69, 23);
		panel.add(T3);

		S1 = new JRadioButton("\u5927\u676F");
		buttonGroup_2.add(S1);
		S1.setBounds(10, 255, 69, 23);
		panel.add(S1);

		S2 = new JRadioButton("\u4E2D\u676F");
		S2.setSelected(true);
		buttonGroup_2.add(S2);
		S2.setBounds(88, 255, 62, 23);
		panel.add(S2);

		S3 = new JRadioButton("\u5C0F\u676F");
		buttonGroup_2.add(S3);
		S3.setBounds(10, 280, 69, 23);
		panel.add(S3);

		spinner_1 = new JSpinner();
		spinner_1.setModel(new SpinnerNumberModel(1, 1, 10, 1));
		spinner_1.setBounds(88, 416, 41, 25);
		panel.add(spinner_1);

		btnNewButton = new JButton("\u6DFB\u52A0");

		btnNewButton.setBounds(46, 448, 72, 23);
		panel.add(btnNewButton);

		chckbxNewCheckBox.setBounds(7, 337, 69, 23);
		panel.add(chckbxNewCheckBox);

		checkBox.setBounds(88, 337, 62, 23);
		panel.add(checkBox);

		checkBox_1.setBounds(7, 362, 62, 23);
		panel.add(checkBox_1);

		chckbxNewCheckBox_1.setBounds(88, 362, 62, 23);
		panel.add(chckbxNewCheckBox_1);

		chckbxNewCheckBox_2.setBounds(7, 387, 72, 23);
		panel.add(chckbxNewCheckBox_2);

		chckbxNewCheckBox_3.setBounds(88, 387, 62, 23);
		panel.add(chckbxNewCheckBox_3);

		JLabel label_12 = new JLabel("杯数:");
		label_12.setBounds(30, 419, 54, 15);
		panel.add(label_12);
		
		JLabel label_16 = new JLabel("温度");
		label_16.setBounds(63, 22, 54, 15);
		panel.add(label_16);
		
		JLabel label_17 = new JLabel("甜度");
		label_17.setBounds(63, 152, 54, 15);
		panel.add(label_17);
		
		JLabel label_18 = new JLabel("大小");
		label_18.setBounds(63, 234, 54, 15);
		panel.add(label_18);
		
		JLabel label_19 = new JLabel("加料");
		label_19.setBounds(63, 316, 54, 15);
		panel.add(label_19);

		panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setBounds(448, 10, 218, 249);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		label = new JLabel("\u4F1A\u5458");
		label.setBounds(10, 10, 54, 15);
		panel_1.add(label);

		JSeparator separator = new JSeparator();
		separator.setBounds(20, 45, 172, 2);
		panel_1.add(separator);

		JLabel label_1 = new JLabel("\u624B\u673A\u53F7");
		label_1.setBounds(25, 57, 54, 15);
		panel_1.add(label_1);

		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER ) {
					if(textField.getText().length()!=11)JOptionPane.showMessageDialog(null,"手机号格式不对!");						
					else {
						lblN.setText("");
						textField_1.setText("");
						if (radioButtonMenuItem_5.isSelected()) {

							try {
								String nameSex = Tool.fillLabel(textField.getText(), lblN, textField);
								if (nameSex == "" && textField.getText().length() == 11) {
									JOptionPane.showMessageDialog(null, "无此会员!");
								}
								if (nameSex != "") {
									String name = nameSex.substring(0, 1);
									String sex = nameSex.substring(1);
									textField_1.setText(name);

									if (sex.equals("男")) {
										radioButtonMenuItem_3.setSelected(true);
									} else {
										radioButtonMenuItem_4.setSelected(true);
									}

								}
							}

							catch (ClassNotFoundException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}

						}
					}
				}
			}
		});
		
		
		//#start
	/*	textField.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				if(textField.getText().length()!= 11) {return;}
				lblN.setText("");
				textField_1.setText("");
				if (radioButtonMenuItem_5.isSelected()) {

					try {
						String nameSex = Tool.fillLabel(textField.getText(), lblN, textField);
						if (nameSex == "" && textField.getText().length() == 11) {
							JOptionPane.showMessageDialog(null, "无此会员!");
						}
						if (nameSex != "") {
							String name = nameSex.substring(0, 1);
							String sex = nameSex.substring(1);
							textField_1.setText(name);

							if (sex.equals("男")) {
								radioButtonMenuItem_3.setSelected(true);
							} else {
								radioButtonMenuItem_4.setSelected(true);
							}

						}
					}

					catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}

			}
		});
	*/	//#end
		
		
		textField.setBounds(108, 54, 99, 21);
		panel_1.add(textField);
		textField.setColumns(10);

		JLabel label_2 = new JLabel("\u5F00\u901A\u4F1A\u5458");
		label_2.setBounds(10, 94, 54, 15);
		panel_1.add(label_2);

		JLabel label_3 = new JLabel("\u59D3\u6C0F");
		label_3.setBounds(95, 120, 36, 15);
		panel_1.add(label_3);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(20, 208, 172, 2);
		panel_1.add(separator_1);

		JLabel label_4 = new JLabel("\u4ECA\u65E5\u6298\u6263");
		label_4.setBounds(10, 220, 54, 15);
		panel_1.add(label_4);
		spinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				
				label_10.setText(spinner.getModel().getValue().toString()+"%");
				if(radioButtonMenuItem_5.isSelected()==true)
					zk = Float.parseFloat(spinner.getModel().getValue().toString()) / 100;	
				else {
				zk = Float.parseFloat(spinner.getModel().getValue().toString()) / 100;	
				allzk=zk;
				}

			}
		});

		spinner.setModel(new SpinnerNumberModel(100, 5, 100, 5));
		spinner.setBounds(152, 217, 55, 25);
		panel_1.add(spinner);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(141, 117, 66, 21);
		panel_1.add(textField_1);

		buttonGroup_3.add(radioButtonMenuItem_3);
		radioButtonMenuItem_3.setSelected(true);
		radioButtonMenuItem_3.setBounds(89, 141, 61, 22);
		panel_1.add(radioButtonMenuItem_3);

		buttonGroup_3.add(radioButtonMenuItem_4);
		radioButtonMenuItem_4.setBounds(148, 141, 64, 22);
		panel_1.add(radioButtonMenuItem_4);

		button.setBounds(68, 173, 88, 23);
		panel_1.add(button);

	
		
	

		radioButtonMenuItem_6 = new JRadioButton("\u5426");
		radioButtonMenuItem_6.setSelected(true);
		buttonGroup_4.add(radioButtonMenuItem_6);
		radioButtonMenuItem_6.setBounds(152, 10, 56, 22);
		panel_1.add(radioButtonMenuItem_6);
		
		radioButtonMenuItem_5 = new JRadioButton("是");		
		buttonGroup_4.add(radioButtonMenuItem_5);
		radioButtonMenuItem_5.setBounds(82, 10, 61, 22);
		panel_1.add(radioButtonMenuItem_5);
		
		
		
		

		lblN.setHorizontalAlignment(SwingConstants.RIGHT);
		lblN.setBounds(10, 119, 40, 15);
		panel_1.add(lblN);

		label_15.setBounds(52, 119, 32, 15);
		panel_1.add(label_15);

		button_2.setEnabled(false);
		button_2.setVisible(false);
		button_2.setBounds(63, 173, 93, 23);

		panel_1.add(button_2);
		lblN.setVisible(false);
		label_15.setVisible(false);

		panel_2 = new JPanel();
		panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_2.setBounds(448, 269, 218, 215);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);

		JLabel label_5 = new JLabel("\u603B\u4EF7");
		label_5.setBounds(10, 27, 54, 15);
		panel_2.add(label_5);

		JLabel label_6 = new JLabel("\u6298\u6263");
		label_6.setBounds(10, 66, 54, 15);
		panel_2.add(label_6);

		JLabel label_7 = new JLabel("\u5E94\u6536");
		label_7.setBounds(10, 102, 54, 15);
		panel_2.add(label_7);

		JLabel label_8 = new JLabel("\u5B9E\u6536");
		label_8.setBounds(10, 135, 54, 15);
		panel_2.add(label_8);

		JLabel label_9 = new JLabel("\u627E\u96F6");
		label_9.setBounds(10, 169, 54, 15);
		panel_2.add(label_9);

		label_14.setBounds(129, 27, 54, 15);
		panel_2.add(label_14);

		label_10.setBounds(129, 66, 54, 15);
		panel_2.add(label_10);

		label_11.setBounds(129, 102, 54, 15);
		panel_2.add(label_11);

		label_13.setBounds(129, 169, 54, 15);
		panel_2.add(label_13);

		textField_2 = new JTextField();

		textField_2.setText("0");
		textField_2.setBounds(129, 132, 66, 21);
		panel_2.add(textField_2);
		textField_2.setColumns(10);

		scrollPane_2 = new JScrollPane();
		scrollPane_2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_2.setBounds(674, 10, 269, 433);
		scrollPane_2.setSize(269, 433);
		frame.getContentPane().add(scrollPane_2);

		scrollPane_2.add(panel_5);
		scrollPane_2.setViewportView(panel_5);
		panel_5.setPreferredSize(new Dimension(237, 0));
		panel_5.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JButton button_1 = new JButton("\u63D0\u4EA4\u8BA2\u5355");
		button_1.setBounds(705, 464, 93, 23);
		frame.getContentPane().add(button_1);
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ConfigFrame().setVisible(true);
				
			}
		});
		button_3.setBounds(837, 464, 93, 23);
		
		frame.getContentPane().add(button_3);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(0, 0, 993, 554);
		frame.getContentPane().add(panel_6);
		//zk = Float.parseFloat(spinner.getModel().getValue().toString()) / 100;

		conn = Tool.getConnection();
		st = conn.createStatement();
		ResultSet rs = st.executeQuery("select * from tb_category where status='正常'");
		while (rs.next()) {
			if (panel_3.getComponentCount()>=8) {
				panel_3.setSize(new Dimension(94,panel_3.getHeight()+100));	
				panel_3.setPreferredSize(new Dimension(94,panel_3.getHeight()+50));
			
			}
			panel_3.add(new C_label(rs.getString("c_name"), panel_4));
		}

		rs = st.executeQuery("select * from tb_drink where status='在售'");
		while (rs.next()) {
			if (panel_4.getComponentCount()>6) {
				panel_4.setSize(new Dimension(135,panel_4.getHeight()+82));
				panel_4.setPreferredSize(new Dimension(135,panel_4.getHeight()+82));
				
			}
			Drink_label tp = new Drink_label(rs.getString("d_name"), rs.getString("price"));
			labelList.add(tp);
			panel_4.add(tp);

		}

		frame.setVisible(true);
		new FrontFrame().setVisible(true);
	
	
	//添加按钮
		btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(isOver3()) {
						JOptionPane.showMessageDialog(null,"最多选三种配料！");
						return;
					}
					
					if(radioButtonMenuItem_5.isSelected()){
						if(textField.getText().equals("")) {
							JOptionPane.showMessageDialog(null,"请先输入会员号！");
							return;
						}
						
					}
					
					
					Drink drink=new Drink();
					String swi=null;
					if (B1.isSelected()) 
						swi="B1";
					else if (B2.isSelected())
						swi="B2";
					else if (B3.isSelected())
						swi="B3";
					else if (B4.isSelected())
						swi="B4";
					else if (B5.isSelected())
						swi="B5";
					
					switch (swi) {
					case "B1":
						drink.setIce(ICE.NOMAL);
						break;
					case "B2":
						drink.setIce(ICE.LESS);
						break;
					case "B3":
						drink.setIce(ICE.NONE);
						break;
					case "B4":
						drink.setIce(ICE.WARM);
						break;
					case "B5":
						drink.setIce(ICE.HOT);
						break;					
						
					default:drink.setIce(ICE.NOMAL);
						break;
					}
					
					
					if (T1.isSelected()) 
						swi="T1";
					else if (T2.isSelected())
						swi="T2";
					else if (T3.isSelected())
						swi="T3";

					switch (swi) {
					case "T1":
						drink.setSuger(SUGER.NOMAL);
						break;
					case "T2":
						drink.setSuger(SUGER.HALF);
						break;
					case "T3":
						drink.setSuger(SUGER.NONE);
						break;
					default:drink.setSuger(SUGER.NOMAL);
					break;
					}
					
					
					if (S1.isSelected()) 
						swi="S1";
					else if (S2.isSelected())
						swi="S2";
					else if (S3.isSelected())
						swi="S3";

					switch (swi) {
					case "S1":
						drink.setSize(SIZE.L);
						break;
					case "S2":
						drink.setSize(SIZE.M);
						break;
					case "S3":
						drink.setSize(SIZE.S);
						break;
					default:drink.setSize(SIZE.M);
					break;
					}
					
				
					
					
					
					float t;
					
					for (Drink_label drink2 : labelList) {					
						if(drink2.isSelect) {
							drink.setName(drink2.lblNewLabel.getText());
							drink.setPrice(Integer.parseInt(drink2.lblNewLabel_1.getText()));
							if (drink.size.desc.equals("大杯")) {								
								 drink.setPrice(drink.getPrice()+2);
								 t=drink.price;
								 t*=zk;
								 t = (float)(Math.round(t*10))/10;	
								 drink.setAfprice(t);							
								
								
								
							}else if (drink.size.desc.equals("小杯")) {
								 drink.setPrice(drink.getPrice()-2);
								  t=drink.price;
								  System.out.println(zk);
									t*=zk;
									t = (float)(Math.round(t*10))/10;													
									drink.setAfprice(t);	
																						
							}else {		
									 t=drink.price;
									t*=zk;
									t = (float)(Math.round(t*10))/10;	
									drink.setAfprice(t);														
							}		
							
							drink.setNum(Integer.parseInt(MainFrame.spinner_1.getModel().getValue().toString()));
						
							detaillist.add(drink);
							}
					}		
					
					
					
					
			
					try {
						Tool.fillDrink(conn, drink, drink.getName(),st);
						if(detaillist.get(0).num==0) {return;}
				int	tmpprice=0;
				for (Drink drink2 : detaillist) {				
					tmpprice+=drink2.price*drink2.num;
				}					
						label_14.setText(String.valueOf(tmpprice));
						FrontFrame.label_3.setText(label_14.getText());
						
					
					// zk=Float.parseFloat(spinner.getModel().getValue().toString())/100;							
						float	yingshou	=	 tmpprice*zk;
						yingshou = (float)(Math.round(yingshou*10))/10;			
						label_11.setText(String.valueOf(yingshou));
						FrontFrame.label_4.setText(label_11.getText());
						if(!textField_2.getText().equals("0")) {
							int shishou;	
							shishou=Integer.parseInt(textField_2.getText()) ;
						label_13.setText(String.valueOf(shishou-yingshou));
						
						spinner_1.setValue(1);
						
						
						
						}
					} catch (SQLException e1) {
					
					}catch (IndexOutOfBoundsException e2) {
						JOptionPane.showMessageDialog(null,"请选择饮品!");
						return;
					}
					
					
						float tpprice=0;
						tpprice=drink.afprice;
				
				String other="加";
				if (chckbxNewCheckBox.isSelected()) {				
					other+=chckbxNewCheckBox.getText()+" ";
				}
				if (chckbxNewCheckBox_1.isSelected()) {
					other+=chckbxNewCheckBox_1.getText()+" ";
				}if (chckbxNewCheckBox_2.isSelected()) {
					other+=chckbxNewCheckBox_2.getText()+" ";
				}if (chckbxNewCheckBox_3.isSelected()) {
					other+=chckbxNewCheckBox_3.getText()+" ";
				}if (checkBox.isSelected()) {
					other+=checkBox.getText()+" ";
				}if (checkBox_1.isSelected()) {
					other+=checkBox_1.getText()+" ";
				}
				
						
				
				sis=drink.getIce().toString()+","+drink.getSuger().toString()+","+drink.getSize().toString();
				
				if (other=="加") {other="";}
			//	System.out.println("afprice:"+drink.afprice);
					DetailLabel tmp=new DetailLabel(drink.name, String.valueOf(drink.num),sis, String.valueOf(tpprice),panel_5,other);
					DetailLabel tmp1=new DetailLabel(drink.name, String.valueOf(drink.num),sis, String.valueOf(tpprice),panel_5,other);
					panel_5.add(tmp);
					tmp1.btnNewButton.setVisible(false);
					FrontFrame.panel.add(tmp1);
					FrontFrame.panel.updateUI();
					
						detailLabelList.add(tmp);
						fdetailLabelList.add(tmp1);
						//detailLabelList.notifyAll();
					
					
					
					panel_5.updateUI();
					
					if (panel_5.getComponentCount()>4) {
						panel_5.setPreferredSize(new Dimension(237,panel_5.getHeight()+105));
						FrontFrame.panel.setPreferredSize(new Dimension(237,panel_5.getHeight()+105));
						scrollPane_2.getViewport().setViewPosition(new Point(0, scrollPane_2.getVerticalScrollBar().getMaximum()));
						FrontFrame.scrollPane.getViewport().setViewPosition(new Point(0, scrollPane_2.getVerticalScrollBar().getMaximum()));
					}
			
					
					
					
				}
			});

		
		
		


	//开通会员
	button.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
	
			String m_id=textField.getText();
			String name=textField_1.getText();
			String sex;
			if (radioButtonMenuItem_3.isSelected()) {
				sex="男";
			} else {
				sex="女";
			}
			if(textField_1.getText().equals("")) {
				 JOptionPane.showMessageDialog(null,"请输入姓氏！");
				 return;
			}
			if(textField.getText().length()!=11) {
				 JOptionPane.showMessageDialog(null,"请输入11位的手机号！");
				 return;
			}
			
			
			Connection conn=null;
		try {
			Tool.addMember(conn, m_id, name, sex);				
			 JOptionPane.showMessageDialog(null,"加入成功！");
			 
			 
		} catch (ClassNotFoundException e1) {
			
			 JOptionPane.showMessageDialog(null,"失败成功！");
			e1.printStackTrace();
		} catch (SQLException e1) {
			 JOptionPane.showMessageDialog(null,"已经是会员！");
			e1.printStackTrace();
		}	
			
		
			
			
		}
	});

	
	
	//是否会员
	radioButtonMenuItem_5.addChangeListener(new ChangeListener() {
		public void stateChanged(ChangeEvent e) {
			if (radioButtonMenuItem_5.isSelected()==true) {
				textField_1.setEnabled(false);
				spinner.setValue(85);
				radioButtonMenuItem_3.setEnabled(false);
				radioButtonMenuItem_4.setEnabled(false);
				button.setEnabled(false);
				membzk=Float.parseFloat(spinner.getModel().getValue().toString())/100;
				zk=membzk;
				label_10.setText(spinner.getModel().getValue().toString()+"%");	
				lblN.setVisible(true);
				label_15.setVisible(true);
				button_2.setEnabled(true);
				button_2.setVisible(true);
				button.setVisible(false);
				lblN.setText("");
			}else { textField_1.setEnabled(true);			
			spinner.setValue(allzk*100);
			radioButtonMenuItem_3.setEnabled(true);
			radioButtonMenuItem_4.setEnabled(true);
			button.setEnabled(true);
			label_10.setText("0");
			zk=allzk;		
			lblN.setVisible(false);
			label_15.setVisible(false);
			textField_1.setText("");
			button.setVisible(true);
			button_2.setVisible(false);
			}
		}
	});

	
	
	//积分兑换		
	button_2.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String date="";
			try {
				if(detaillist.size()==1) {
					if(textField_1.getText().equals("")) {
						JOptionPane.showMessageDialog(null,"无此会员，不能兑换！");
						return;
					}
				 date= Tool.pointChange(lblN.getText(), textField.getText());
				 if(pointEnough)
				new CheckFrame("积分兑换", e_id, date, "", "", detaillist, sis);
				panel_5.removeAll();
				panel_5.updateUI();
				FrontFrame.panel.removeAll();
				FrontFrame.panel.updateUI();
				label_14.setText("0");
				label_11.setText("0");
				label_13.setText("0");
				textField_2.setText("0");
				FrontFrame.label_3.setText("0");
				FrontFrame.label_4.setText("0");
				B1.setSelected(true);
				T1.setSelected(true);
				S2.setSelected(true);
				detaillist.clear();
				detailLabelList.clear();
				pointEnough=true;
				textField.setText("");
				
				
				radioButtonMenuItem_6.setSelected(true);
				}else if(detaillist.size()>1) {	JOptionPane.showMessageDialog(null,"一次兑换只限一杯！");return;}
				else {
					JOptionPane.showMessageDialog(null,"请选择饮品！");
					return;
				}
				
			} catch (ClassNotFoundException e1) {
				
				e1.printStackTrace();
			} catch (SQLException e1) {
			
				e1.printStackTrace();
			}
		}
	});
	
	
	
	//计算
	textField_2.addKeyListener(new KeyAdapter() {
		@Override
		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode()==KeyEvent.VK_ENTER) {
				try {if(Integer.parseInt(textField_2.getText())<0) {
					JOptionPane.showMessageDialog(null,"输入必须大于零!");
					textField_2.setText("");
					return;
				}
				//13=t2-11
				float tmp=0;															
				tmp=Float.parseFloat(textField_2.getText())-Float.parseFloat(label_11.getText());
				tmp=(float)(Math.round(tmp*10))/10;
				label_13.setText(String.valueOf(tmp));
				}catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null,"请输入大于0的数字!");
					textField_2.setText("");
				}
				
			}
			
			
		}
	});
	
	
	
	//提交订单
	button_1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {	
			if(detaillist.size()==0) {JOptionPane.showMessageDialog(null,"请先添加饮品");return;}
			if(textField.getText().equals("")&&radioButtonMenuItem_5.isSelected()) {JOptionPane.showMessageDialog(null,"请输入手机号!");return;}
			if(textField_1.getText().equals("")&&radioButtonMenuItem_5.isSelected()) {JOptionPane.showMessageDialog(null,"会员不存在!请正确填写!");return;}		
			String m_id="";
			String isMeb;
			int point=0;
		try {
			if (radioButtonMenuItem_5.isSelected()) {
				isMeb="是";
				m_id=textField.getText();
				
				for (Drink drink : detaillist) {
					point+=drink.getNum();					
				}
				
			}else {
				isMeb="否";
			}
			//TODO 要加e_id
			String numAndDate  = Tool.commit(conn, st, detaillist,m_id,isMeb,point,e_id);
			
			
			new CheckFrame(numAndDate.substring(0, 4), e_id, numAndDate.substring(4), label_14.getText(), label_11.getText(),detaillist,sis);
			
			
			
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null,"提交失败！");
			e1.printStackTrace();
			return;
			
		}
			
			panel_5.removeAll();
			panel_5.setPreferredSize(new Dimension(237, 0));
			panel_5.updateUI();
			FrontFrame.panel.removeAll();
			FrontFrame.panel.updateUI();
			label_14.setText("0");
			label_11.setText("0");
			label_13.setText("0");
			textField_2.setText("0");
			FrontFrame.label_3.setText("0");
			FrontFrame.label_4.setText("0");
			FrontFrame.	panel.setPreferredSize(new Dimension(237, 0));
			panel_5.updateUI();
			B1.setSelected(true);
			T1.setSelected(true);
			S2.setSelected(true);
			detaillist.clear();
			detailLabelList.clear();
			fdetailLabelList.clear();
			radioButtonMenuItem_6.setSelected(true);
			
		}
	});

	
	
	
	}
	
	//判断加料数量
	public boolean isOver3() {
		int i=0;
		if(chckbxNewCheckBox.isSelected()) {i++;}		
		if(checkBox.isSelected()) {i++;}
		if(checkBox_1.isSelected()) {i++;}
		if(chckbxNewCheckBox_1.isSelected()) {i++;}
		if(chckbxNewCheckBox_2.isSelected()) {i++;}
		if(chckbxNewCheckBox_3.isSelected()) {i++;}
		
		if(i>3)return true;
		else return false;
		
	}
}
