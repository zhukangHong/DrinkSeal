package cn.time.test;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashSet;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FileTest {

	private JFrame frame;
	JButton btnNewButton;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FileTest window = new FileTest();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FileTest() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		btnNewButton = new JButton("上传");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				JFileChooser chooser = new JFileChooser();
				chooser.setMultiSelectionEnabled(true);				
				 int returnVal = chooser.showOpenDialog(btnNewButton);
				  if (returnVal == JFileChooser.APPROVE_OPTION) {
					/** 得到选择的文件* */
					File[] arrfiles = chooser.getSelectedFiles();
					if (arrfiles == null || arrfiles.length == 0) {
						return;
					}
					FileInputStream input = null;
					FileOutputStream out = null;
					String path = "img/";
					try {
						for (File f : arrfiles) {
							File dir = new File(path);
							/** 目标文件夹 * */
							File[] fs = dir.listFiles();
							HashSet<String> set = new HashSet<String>();
							for (File file : fs) {
								set.add(file.getName());
							}
							/** 判断是否已有该文件* */
						/*	if (set.contains(f.getName())) {
								JOptionPane.showMessageDialog(new JDialog(), "已有该文件！");
								return;
							}*/
							input = new FileInputStream(f);
							byte[] buffer = new byte[1024];
							File des = new File(path, "timg2.jpg");
							out = new FileOutputStream(des);
							int len = 0;
							while (-1 != (len = input.read(buffer))) {
								out.write(buffer, 0, len);
							}
							
							out.close();
							input.close();
						}
						  JOptionPane.showMessageDialog(null, "上传成功！", "提示",
							      JOptionPane.INFORMATION_MESSAGE);
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}

		
			}
		});
		
			
		btnNewButton.setBounds(63, 98, 74, 33);
		frame.getContentPane().add(btnNewButton);
	
		
	

}
}
