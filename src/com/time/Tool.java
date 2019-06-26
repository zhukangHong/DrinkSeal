package com.time;

import java.awt.Color;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer3D;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.TextAnchor;

import com.time.front.FrontFrame;


public class Tool {
	
	
	private static  Connection conn;

	
	//#start   getConnection()
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		
		  String URL="jdbc:mysql://127.0.0.1:3306/timedb?useUnicode=true&amp;characterEncoding=utf-8";
	  		String USER="root";
	        String PASSWORD="123";
	      
	       Class.forName("com.mysql.jdbc.Driver");
	         conn= DriverManager.getConnection(URL, USER, PASSWORD);
	      return conn;	   			
 }
	//#end	
	
	public static void printDrink(Connection conn,JPanel panel,String name) throws SQLException {
		  MainFrame.labelList.clear();
		 Statement st=conn.createStatement();
	       ResultSet rs=st.executeQuery("select * from tb_drink,tb_category where tb_drink.c_id=tb_category.c_id and tb_drink.status ='在售' and tb_category.status='正常'");
	       while(rs.next()){	

	    	   if (rs.getString(7).equals(name)) {
	    		   Drink_label tp =new Drink_label(rs.getString("d_name"),rs.getString("price"));
	    		   if (panel.getComponentCount()>=6) {
	    			   panel.setSize(new Dimension(135,panel.getHeight()+75));
	    			   panel.setPreferredSize(new Dimension(135,panel.getHeight()+75));
	    			 
	   				
	   			}
	    		   panel.add(tp);	    		
	    		  MainFrame.labelList.add(tp);
	    		   
  }
	    	   else  continue;
	            
	       	        }
	      panel.revalidate();
	       	        
	       	      
	       	         rs.close();
	       	         st.close();
	       	         conn.close();
		
		
	}
	
	
	public static void clearSelect(List<Drink_label> drinklist) {
		
		for (Drink_label  drink: drinklist) {
			drink.isSelect=false;
		}
		
	}

	
	public static Drink fillDrink(Connection conn,Drink drink,String name,Statement st) throws SQLException {
		
		
		
		 ResultSet rs=st.executeQuery("select c_id,d_id from tb_drink where d_name='"+name+"'");
		     while(rs.next()){
		    	
		    	  drink.setC_id(rs.getString(1));
			       drink.setD_id(rs.getString(2));	 
		     }
		String temp=drink.getC_id();
		
	     
		     rs=st.executeQuery("select c_name from tb_category where c_id='"+temp+"'"); 
	        while(rs.next()){	
	       
	       drink.setC_name(rs.getString(1));
	     
	        }
	            
		return drink;
	}
		
	
	public static String commit(Connection conn,Statement st,List<Drink> dList,String m_id,String isMeb,int point,int e_id) throws SQLException {
		Date date=new Date();
		DateFormat dateformat = new SimpleDateFormat("yyyyMMdd");
		DateFormat dateformat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String daynum=null;
		String dd_id;
		String dd_date;
		float total=0;
		String strdate="";
		String today="";
		int num=0;
		
		 ResultSet	 rs=st.executeQuery("select dd_id from tb_deal"); 
		 while(rs.next()) {			 
			 daynum= rs.getString(1).toString();
			strdate=daynum.substring(0, 8);
			daynum=daynum.substring(8);
			
		 }
		 today=dateformat.format(date);
		
		 
		 dd_date=dateformat2.format(date);	
		
		 
		 //如果不是同一天就从0开始;
		 
		 if(today.equals(strdate)) {
		 int inum= Integer.parseInt(daynum)+1;
		 daynum=	 String.valueOf(Integer.parseInt(daynum)+1) ;
		 if (inum<10) {
			 daynum=	"000"+ String.valueOf(inum) ;
		}else if (inum>=10&&inum<100) {
			daynum=	"00"+ String.valueOf(inum) ;
		}
		else if (inum>=100&&inum<1000) {
			daynum=	"0"+ String.valueOf(inum) ;
		}
		 }else daynum="0001";
	dd_id=	 dateformat.format(date);
		dd_id+=daynum;
		dd_date=dateformat2.format(date);	
		
		dList= rmRepeat(dList);
		
		for (Drink drink : dList) {
			float i=(float)drink.num;
			total+=drink.afprice*i;	
			num+=drink.num;
		}					
		
		//try {

		ResultSet rt=null;
		st.execute("insert into tb_deal values('"+dd_id+"','"+dd_date+"','"+total+"','"+e_id+"','"+isMeb+"','"+m_id+"',"+point+","+num+",'有效') ");
			
			for (Drink drink : dList) {
				st.execute("insert into tb_detail(dd_id,c_id,c_name,d_id,d_name,num,price)   values('"+dd_id+"','"+drink.getC_id()+"','"+drink.getC_name()+"','"+drink.getD_id()+"','"+drink.getName()+"','"+drink.num+"',"+drink.afprice*drink.num+") ");
				
			}
			
			if(isMeb.equals("是")) {
				rt=	st.executeQuery("select m_id,point from tb_member where m_id="+m_id);
				while (rt.next()) {
					point+= rt.getInt(2);			
				}
					
					
					st.execute("update tb_member set point="+point+" where m_id="+m_id);
			}
			
		
			
			JOptionPane.showMessageDialog(null,"下单成功！");
			
	//	} catch (SQLException e) {
		//	JOptionPane.showMessageDialog(null,"提交失败！");
		
		//	e.printStackTrace();
		//}
		
			return daynum+dd_date;
		
	}
	
	
	
	public static int cancel(List<DetailLabel> dList,String name,List<Drink> drinkList,String other) {
		int num=0;
		for (DetailLabel detailLabel : dList) {
		if(detailLabel.name.equals(name)&&detailLabel.other.equals(other)&&detailLabel.isRemove==true){
				//System.out.println("移除");
				num= dList.indexOf(detailLabel);								
			}		
		}
		dList.remove(num);
		int rint=num;
		if(drinkList!=null) {
		for (Drink	drink : drinkList) {
			if(drink.name.equals(name)){
					num= drinkList.indexOf(drink);								
				}		
			}
		drinkList.remove(num);
		}
		
		return rint;
	}
	
	public static void cancel(List<DetailLabel> dList,String name,List<Drink> drinkList,String other,int rnum) {
		int num=0;
		for (DetailLabel detailLabel : dList) {
		if(detailLabel.name.equals(name)&&detailLabel.other.equals(other)&&detailLabel.isRemove==true){
				//System.out.println("移除");
				num= dList.indexOf(detailLabel);								
			}		
		}
		dList.remove(rnum);
		
		if(drinkList!=null) {
		for (Drink	drink : drinkList) {
			if(drink.name.equals(name)){
					num= drinkList.indexOf(drink);								
				}		
			}
		drinkList.remove(num);
		}
		
		
	}
	
	
	
	
	public static void   printDetail(List<DetailLabel> dList,JPanel panel) {
		panel.removeAll();
		
		for (DetailLabel detailLabel : dList) {
			panel.add(detailLabel);
		
		
		}
		panel.updateUI();
	
	}


	public static void addMember(Connection coon,String m_id,String name,String sex) throws ClassNotFoundException, SQLException {
		conn= getConnection();
		String sql="insert into tb_member values(?,?,?,0)";
		PreparedStatement st =conn.prepareStatement(sql);
		st.setString(1, m_id);
		st.setString(2, name);
		st.setString(3, sex);
		st.execute();
		
	}

	
	
	public static String fillLabel(String m_id,JLabel point,JTextField mField) throws SQLException, ClassNotFoundException {
		String namesex="";
		conn=getConnection();
		if(m_id.length()==11) {
		String sql="select point,sex,name from tb_member where m_id=?";
		PreparedStatement st =conn.prepareStatement(sql);
		st.setString(1, m_id);
		ResultSet rs=		st.executeQuery();			
		
		while (rs.next()) {
		point.setText(String.valueOf(rs.getInt(1)));	
		namesex=rs.getString(3)+rs.getString(2);
		}
		
		return namesex;
		}
		if(m_id.length()>11){
			JOptionPane.showMessageDialog(null,"手机号码超过长度!");
		//	m_id=m_id.substring(0, 11);					
		}
		return "";
	}


	public static String pointChange(String ponit,String m_id) throws SQLException, ClassNotFoundException {
		
		conn=getConnection();
		Date date=new Date();		
		DateFormat dateformat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");		
		String strDate=dateformat2.format(date);	
	
		
		int points=Integer.parseInt(ponit);	
		
		if(m_id.length()==11) {
			if (points>=5) {
				points-=5;
				String sql="UPDATE tb_member set point=? where m_id=?";
				PreparedStatement st =conn.prepareStatement(sql);
				st.setInt(1, points);
				st.setString(2, m_id);
				st.executeUpdate();
				
				sql="insert into tb_change values(?,?,?)";
				conn=Tool.getConnection();
				st=conn.prepareStatement(sql);		
				st.setString(1, m_id);
				st.setString(2, strDate);
				st.setInt(3, points);
				st.executeUpdate();

				JOptionPane.showMessageDialog(null,"兑换成功!");
			}else {JOptionPane.showMessageDialog(null,"积分不够!");MainFrame.pointEnough=false;return "";}
		}else {JOptionPane.showMessageDialog(null,"手机号错误!");return "";}
		return strDate;		
	}
	
	public static List<Drink> rmRepeat(List<Drink> dList) {
			
		Drink drink,drink2;
		
		for (int i = 0; i < dList.size(); i++) {
			for (int j = i+1; j < dList.size(); j++) {
				drink=dList.get(i);
				drink2=dList.get(j);
				if(drink.getD_id().equals(drink2.getD_id())) {
					if(drink.getAfprice()==drink2.getAfprice()) {
						dList.remove(j);
						j--;
						drink.setNum(drink.getNum()+1);						
					}
	
				}
				
			}			
		}
		

		return dList;
		
		
	}

	
	
	/*
	 * @param mode
	 * 1.饮品按年
	 * 2.饮品按季
	 * 3.饮品按月
	 * 4.总按年
	 * 5.总按季
	 * 6.总按月
	 * 
	 * */
	
	
	//#start getChartData(int mode)
	public static  JFreeChart getChartData(int mode) throws ClassNotFoundException, SQLException {
		
		
		conn=Tool.getConnection();
		String sql=null;
		PreparedStatement st=null;
		Map<Integer, Integer> yearMap=new HashMap<>();
		Map<Integer, Float> numMap=new HashMap<>();
		Map<String, Integer> seasonMap=new HashMap<>();
		Map<String, Integer> monthMap=new HashMap<>();
		Map<String,Map<String, Integer>> drinkYearMap=new HashMap<>();
		Map<String, Integer> drinkMap=new HashMap<>();
		JFreeChart chart=null;
		String ddid="";
		int ddint=0;
		DefaultCategoryDataset dpd; 
		//sql="select * from tb_detail ";
		sql="select x.dd_id,c_id,c_name,d_id,d_name,x.num,price  from tb_detail as x LEFT JOIN tb_deal as y on x.dd_id=y.dd_id where status<>'无效'";
		String dname="";
		int num=0;
		String season="";
		String year="";
		String month="";
		 
		st =conn.prepareStatement(sql);
		ResultSet rs = st.executeQuery();		
		
		switch(mode) {
		
	//case 1
	//#start
		case 1:								
			while (rs.next()) {
				
				ddid=	rs.getString(1).substring(0, 4);
				if(!isRecentYear(ddid)) {continue;}
				dname=rs.getString(5);
				num=rs.getInt(6);
			//	System.out.println(num);
			//	ddint=Integer.valueOf(ddid);
			Map<String, Integer> tpmap=	 new HashMap<String, Integer>();
				tpmap.put(dname, num);
				
				
				if(!drinkYearMap.containsKey(ddid)) {
					drinkYearMap.put(ddid,  tpmap)	;	
					drinkMap=new HashMap<String, Integer>();
				}else {	
				
				
				if(!drinkMap.containsKey(dname))
					{drinkMap.put(dname, num);}
				else {
				drinkMap.put(dname,drinkMap.get(dname).intValue()+num );}
				//System.out.println(drinkMap.get(dname).intValue());
				drinkYearMap.put(ddid, drinkMap);											
				}	
				
			}
				 dpd = new DefaultCategoryDataset( ); 
			        
			        for (Entry<String, Map<String, Integer>> entry : drinkYearMap.entrySet()) { 
			        	//System.out.println(entry);
			        	for (Entry<String, Integer> entry1 : entry.getValue().entrySet()) { 			        	
			        	  dpd.setValue(entry1.getValue(), entry1.getKey(), entry.getKey()); 
			        	//System.out.println(entry1);
			        	  }
			        }
				
			    chart = ChartFactory.createBarChart3D(
			        		"饮品销售情况",             
			                "年份",             
			                "数量",             
			                dpd,            
			                PlotOrientation.VERTICAL,             
			                true, true, false);			
			break;
	//#end		
			
	//case 2		
	//#start		
		case 2:
			 season="";
			 year="";
			while (rs.next()) {
				ddid=	rs.getString(1).substring(2, 6);
				dname=rs.getString(5);
				num=rs.getInt(6);
				year=ddid.substring(0,2);	
				
				season=getSeason(ddid.substring(2));			
				if(!isRecentSeason(year,season)) {continue;}
				if(ddid.substring(2).equals("01")||ddid.substring(2).equals("02")) {
					year=String.valueOf(Integer.valueOf(year)-1);
				}
				String mkey=year+season;	
				
			Map<String, Integer> tpmap=	 new HashMap<String, Integer>();
				tpmap.put(dname, num);
				if(!drinkYearMap.containsKey(mkey)) {
					drinkYearMap.put(mkey,  tpmap)	;	
					drinkMap=new HashMap<String, Integer>();
				}else {	
				
			
				if(!drinkMap.containsKey(dname))
					{drinkMap.put(dname, num);}
				else
				drinkMap.put(dname,drinkMap.get(dname).intValue()+1 );				
				drinkYearMap.put(mkey, drinkMap);							
				}								
			}
				 dpd = new DefaultCategoryDataset( ); 
			        
			        for (Entry<String, Map<String, Integer>> entry : drinkYearMap.entrySet()) { 
			        	// System.out.println(entry);
			        	for (Entry<String, Integer> entry1 : entry.getValue().entrySet()) { 
			        	
			        	  dpd.setValue(entry1.getValue(), entry1.getKey(), entry.getKey()); 
			        	  }
			        }
				
			    chart = ChartFactory.createBarChart3D(
			        		"饮品销售情况",             
			                "季节",             
			                "数量",             
			                dpd,            
			                PlotOrientation.VERTICAL,             
			                true, true, false);
		
			break;
	//#end		
		
			
	//case 3
	//#start
		case 3:
					
			while (rs.next()) {
				ddid=	rs.getString(1).substring(2, 6);
				dname=rs.getString(5);
				num=rs.getInt(6);
				year=ddid.substring(0,2);
				month=ddid.substring(2);
				if(!isRecentMonth(year,month)) {continue;}
				String mkey=year+month;					
				
			Map<String, Integer> tpmap=	 new HashMap<String, Integer>();
				tpmap.put(dname, num);
				if(!drinkYearMap.containsKey(mkey)) {
					drinkYearMap.put(mkey,  tpmap)	;	
					drinkMap=new HashMap<String, Integer>();
				}else {	
				
			
				if(!drinkMap.containsKey(dname))
					{drinkMap.put(dname, num);}
				else
				drinkMap.put(dname,drinkMap.get(dname).intValue()+1 );				
				drinkYearMap.put(mkey, drinkMap);							
				}								
			}
				 dpd = new DefaultCategoryDataset( ); 
			        
			        for (Entry<String, Map<String, Integer>> entry : drinkYearMap.entrySet()) { 
			        	// System.out.println(entry);
			        	for (Entry<String, Integer> entry1 : entry.getValue().entrySet()) { 
			        	
			        	  dpd.setValue(entry1.getValue(), entry1.getKey(), entry.getKey()); 
			        	  }
			        }
				
			    chart = ChartFactory.createBarChart3D(
			        		"饮品销售情况",             
			                "月份",             
			                "数量",             
			                dpd,            
			                PlotOrientation.VERTICAL,             
			                true, true, false);						
			break;
	//#end			
			
			
	//case 4		
	//#start
		case 4:
					while (rs.next()) {
				ddid=	rs.getString(1).substring(0, 4);
				ddint=Integer.valueOf(ddid);
				if(!yearMap.containsKey(ddint)) {
					yearMap.put(ddint, 0);	
					numMap.put(ddint, 0f);
				}									
						yearMap.put(ddint, yearMap.get(ddint).intValue()+1);
						numMap.put(ddint,numMap.get(ddint).floatValue()+rs.getFloat(6));
					
				}							
				
				 dpd = new DefaultCategoryDataset( ); 
			        
			        for (Map.Entry<Integer, Float> entry : numMap.entrySet()) { 			        	
			        	  dpd.setValue(entry.getValue(), entry.getKey(), entry.getKey()); 
			        }
				
			     chart = ChartFactory.createBarChart3D(
			        		"饮品销售情况",             
			                "年份",             
			                "数量",             
			                dpd,            
			                PlotOrientation.VERTICAL,             
			                true, true, false);
			break;
	//#end	
			
	//case 5		
	//#start		
		case 5:
			
			
			while (rs.next()) {
			ddid=	rs.getString(1).substring(2, 6);//180101
			
		
		
			
			 year=ddid.substring(0, 2);	
			 season="";	
			
			season=getSeason(ddid.substring(2));
			
			String mkey=year+season;	

			if(!seasonMap.containsKey(mkey)) {
				seasonMap.put(mkey, 0);
			}
			seasonMap.put(mkey, seasonMap.get(mkey).intValue()+1);
		
			}//while结束
					
		
			dpd = new DefaultCategoryDataset( ); 								 
			for (Map.Entry<String, Integer> entry : seasonMap.entrySet()) { 			        	
				dpd.setValue(entry.getValue(), entry.getKey(), entry.getKey()); 
			   
			}						
			chart = ChartFactory.createBarChart3D(
			        		"饮品销售情况",             
			                "季节",             
			                "数量",             
			                dpd,            
			                PlotOrientation.VERTICAL,             
			                true, true, false);	
			break;
	//#end		
	
	//case 6		
	//#start 		
		case 6:
			
			while (rs.next()) {
			ddid=	rs.getString(1).substring(2, 6);//180101
		
			 year=ddid.substring(0, 2);	
			 month=ddid.substring(2, 4);	
		
			String mkey=	year+month;	

			if(!monthMap.containsKey(mkey)) {
				monthMap.put(mkey, 0);
			}
			monthMap.put(mkey, monthMap.get(mkey).intValue()+1);
		
			}//while结束
					
		
			dpd = new DefaultCategoryDataset( ); 								 
			for (Map.Entry<String, Integer> entry : monthMap.entrySet()) { 			        	
				dpd.setValue(entry.getValue(), entry.getKey(), entry.getKey()); 
			   
			}						
			chart = ChartFactory.createBarChart3D(
			        		"饮品销售情况",             
			                "月份",             
			                "数量",             
			                dpd,            
			                PlotOrientation.VERTICAL,             
			                true, true, false);		
			
			break;	
		//#end	
			
		}
		BarRenderer3D renderer = new BarRenderer3D();
		CategoryPlot plot = chart.getCategoryPlot();
		 plot.setRenderer(renderer);
		NumberAxis na = (NumberAxis) plot.getRangeAxis(); 
		na.setAutoRangeIncludesZero(true); 
		DecimalFormat df = new DecimalFormat("#0"); 
		//数据轴数据标签的显示格式 
		na.setNumberFormatOverride(df); 
		
		renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator()); 
		renderer.setBaseItemLabelsVisible(true); 
		renderer.setBaseItemLabelPaint(Color.BLACK);
		renderer.setBasePositiveItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.OUTSIDE12, TextAnchor.CENTER_LEFT));
		renderer.setItemLabelAnchorOffset(15); 
		
		return chart;
	}
	//#end	
	
	//#start getSeason(String month)	
	public static String  getSeason(String month) {
		String season="";
			
		switch(month) {
		case "03":
		case "04":
		case "05":{
			season="春季";
			break;}
		
		case "06":
		case "07":
		case "08":{
			season="夏季";
			break;	}
			
		case "09":
		case "10":
		case "11":{
			season="秋季";
			break;	}
		
		case "12":
		case "01":
		case "02":{
			season="冬季";
			break;	}
			
		}	

		return season;				
	}
	//#end
	
	
	
	//#start isRecentYear(String year)
	public static boolean isRecentYear(String year) {
		
		
		Date date=new Date();		
		DateFormat yearformat = new SimpleDateFormat("yyyy");		
		String nowYear =yearformat.format(date);
		
		int parrYear=Integer.valueOf(year);
		int intnowYear=Integer.valueOf(nowYear);
		
		if(parrYear==intnowYear||parrYear==intnowYear-1) return true;
		
		else return false;
		
	}
	//#end	
	
	//#start isRecentSeason(String year,String season) 
		public static boolean isRecentSeason(String year,String season) {
			
			
			Date date=new Date();		
			DateFormat yearformat = new SimpleDateFormat("yyyy");		
			String nowYear =yearformat.format(date).substring(2);
			
			int parrYear=Integer.valueOf(year);			
			int intnowYear=Integer.valueOf(nowYear);
			
			if(parrYear==intnowYear||parrYear==intnowYear-1) return true;
			
			else return false;
			
		}
		//#end	
	

	//#start isRecentMonth(String year,String month)
			public static boolean isRecentMonth(String year,String month) {
				
				
				Date date=new Date();		
				DateFormat yearformat = new SimpleDateFormat("yyyyMM");		
				String nowYear =yearformat.format(date).substring(2,4);
				String nowMonth =yearformat.format(date).substring(4);
				
				int parrYear=Integer.valueOf(year);	
				int parrMonth=Integer.valueOf(month);	
				
				int intnowYear=Integer.valueOf(nowYear);
				int intnowMonth=Integer.valueOf(nowMonth);
				
				if(parrYear==intnowYear||parrYear==intnowYear-1) {
					if((parrMonth==12&&parrYear<intnowYear)||(parrMonth==11&&parrYear<intnowYear)||(parrMonth==10&&parrYear<intnowYear))return true;
					if(parrMonth==intnowMonth||parrMonth==intnowMonth-1||parrMonth==intnowMonth-2||parrMonth==intnowMonth-3) {
						return true;
					}else  {return false;} 
				}
				else {return false;} 
				
			}
			//#end	
		
}
