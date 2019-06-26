package cn.time.manage;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.time.Tool;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class PointRecordFrame extends JFrame {

	private JPanel contentPane;
	
	 Object[] columnTitle = {"日期" , "剩余积分"};
	 JTable table;
	 DefaultTableModel model;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					/*PointRecordFrame frame = new PointRecordFrame();
					frame.setVisible(true);*/
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
	public PointRecordFrame(String m_id) throws ClassNotFoundException, SQLException {
		setResizable(false);
		setTitle("积分兑换记录");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 314, 429);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 238, 320);
		contentPane.add(scrollPane);
		
		model=new DefaultTableModel(findData(m_id), columnTitle){public boolean isCellEditable(int row, int column){return false;}};			
		table = new JTable(model);
		table.getColumnModel().getColumn(0).setPreferredWidth(190);
		table .getTableHeader().setReorderingAllowed(false);
		scrollPane.setViewportView(table);
		
		

	}
	List<Entry> mlist=new ArrayList<>();
	
	
	
	public Object[][] findData(String m_id) throws ClassNotFoundException, SQLException {
		
		Connection connection=Tool.getConnection();
		Statement st= connection.createStatement();
		ResultSet rs=	st.executeQuery("select date,restpoint from tb_change where m_id='"+m_id+"' order by date desc");
		
		while (rs.next()) {			
		mlist.add(new Entry(rs.getString(1), rs.getInt(2))) ;			
		}
		
		Object data[][]= new Object[mlist.size()][2];
		
		for (int i = 0; i < mlist.size(); i++) { 					 		
	 	 		data[i][0]=mlist.get(i).getDate();
	 	 		data[i][1]=mlist.get(i).getPoint(); 	 	
			}
		
		
		return data;

		
	}
	class Entry{
		private String date ;
		private int point;
		public Entry(String date,int point) {
			this.date=date;
			this.point=point;
		}
		public String getDate() {
			return date;
		}
		public void setDate(String date) {
			this.date = date;
		}
		public int getPoint() {
			return point;
		}
		public void setPoint(int point) {
			this.point = point;
		}
		
		
	}

}

	