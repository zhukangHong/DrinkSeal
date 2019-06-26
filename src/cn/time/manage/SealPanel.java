package cn.time.manage;

import java.awt.Dimension;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.demo.BarChartDemo1;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.experimental.chart.swt.ChartComposite;

import com.time.Tool;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class SealPanel extends JPanel {
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	JRadioButton rdbtnNewRadioButton = new JRadioButton("按年查看");
	JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("按季查看");
	JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("按月查看");
	JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("饮品销量统计");
	JRadioButton rdbtnNewRadioButton_4 = new JRadioButton("总销量统计");
	int mode=1;
	  ChartPanel cp=null;
	
	/**
	 * Create the panel.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public SealPanel() throws ClassNotFoundException, SQLException {
		setLayout(null);
		//setPreferredSize(new Dimension(width, height));
		setSize(new Dimension(665, 597));
		
		
		
		buttonGroup_1.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setBounds(58, 70, 121, 23);
		add(rdbtnNewRadioButton);
		
		buttonGroup_1.add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.setBounds(265, 70, 121, 23);
		add(rdbtnNewRadioButton_1);
		
		buttonGroup_1.add(rdbtnNewRadioButton_2);
		rdbtnNewRadioButton_2.setBounds(451, 70, 121, 23);
		add(rdbtnNewRadioButton_2);
		
		buttonGroup.add(rdbtnNewRadioButton_3);
		
		rdbtnNewRadioButton_3.setBounds(133, 25, 121, 23);
		add(rdbtnNewRadioButton_3);
		
		buttonGroup.add(rdbtnNewRadioButton_4);
		rdbtnNewRadioButton_4.setBounds(357, 25, 121, 23);
		add(rdbtnNewRadioButton_4);

		
		
		rdbtnNewRadioButton.setSelected(true);
		rdbtnNewRadioButton_3.setSelected(true);
		
		ChangeListener c=			new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				mode= whichSelect(mode);
			
				try {
					remove(cp);
					//cp = new    ChartPanel();
					cp.setChart(Tool.getChartData(mode));
				     
			        add(cp);
			        updateUI();
					
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			      
			}
		};
		
		rdbtnNewRadioButton_3.addChangeListener(c);
		rdbtnNewRadioButton_4.addChangeListener(c);
		rdbtnNewRadioButton.addChangeListener(c);
		rdbtnNewRadioButton_1.addChangeListener(c);
		rdbtnNewRadioButton_2.addChangeListener(c);
		
	/*	饼图
		 DefaultPieDataset dpd=new DefaultPieDataset(); //建立一个默认的饼图
	        dpd.setValue("柠檬汽泡", 25);  //输入数据
	        dpd.setValue("芝士莓莓", 25);
	        dpd.setValue("翠峰茉莉", 45);
	        dpd.setValue("其他", 10);	
		      JFreeChart chart=ChartFactory.createPieChart3D("饮品销量图",dpd,true,true,false); 
        //可以查具体的API文档,第一个参数是标题，第二个参数是一个数据集，第三个参数表示是否显示Legend，第四个参数表示是否显示提示，第五个参数表示图中是否存在URL
        */
 
			 cp=new    ChartPanel(Tool.getChartData(mode));
	        cp.setPreferredSize(new Dimension(500, 500));
	        cp.setBounds(30, 100, 500, 500);	     
	        add(cp);
	        updateUI();

	        
	        
	}
	
	public int whichSelect(int mode) {
		
		if(rdbtnNewRadioButton.isSelected()&&rdbtnNewRadioButton_3.isSelected()) mode=1;
		   else if(rdbtnNewRadioButton_1.isSelected()&&rdbtnNewRadioButton_3.isSelected()) mode=2;
		   else	if(rdbtnNewRadioButton_2.isSelected()&&rdbtnNewRadioButton_3.isSelected()) mode=3;
		   else	if(rdbtnNewRadioButton.isSelected()&&rdbtnNewRadioButton_4.isSelected()) mode=4;
		   else	if(rdbtnNewRadioButton_1.isSelected()&&rdbtnNewRadioButton_4.isSelected()) mode=5;
		   else	if(rdbtnNewRadioButton_2.isSelected()&&rdbtnNewRadioButton_4.isSelected()) mode=6;
		return mode;
	}
	
	
}
