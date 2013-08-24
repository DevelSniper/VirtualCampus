package StuInfoMngApp;

import java.awt.AWTEvent;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
/** * @author C5102 * * TODO To change the template for this generated type comment go to * Window - Preferences - Java - Code Style - Code Templates */

public class StuInfoStatis extends JFrame{	
	/**	 * Comment for <code>serialVersionUID</code>	 */	
	private JPanel contentPanel;	
	private MainWindow mw;
	/**	 * @param window	 */	
	public StuInfoStatis(MainWindow mwIn) {	
		this.mw = mwIn;		
		setTitle("学生信息统计");	
		setBounds(100, 100, 800, 550);
		enableEvents(AWTEvent.WINDOW_EVENT_MASK);
		setLocationRelativeTo(getOwner());	
		setType(Type.POPUP);
		
		JPanel jp = new JPanel();
		jp.setOpaque(false);		
	    getContentPane().add(jp,BorderLayout.NORTH);	
	    ((JPanel) getContentPane()).setOpaque(false);
		
	    JLabel label = new JLabel();
	    label.setText("班级");
	    label.setBounds(5, 30, 30, 40);
	    jp.add(label);
	    
	    JTextField textfield = new JTextField(8);
	    textfield.setBounds(40, 30, 90, 40);
	    textfield.setText("");
	    textfield.setBackground(new Color(248, 248, 255));
	    jp.add(textfield);
	    
	    JComboBox combobox = new JComboBox();
	    combobox.addItem("性别");
	    combobox.addItem("男");
	    combobox.addItem("女");
	    combobox.setBounds(140, 30, 90, 40);
	    combobox.setBackground(new Color(248, 248, 255));
	    jp.add(combobox);
	    
	    JLabel label1 = new JLabel();
	    label1.setText("生日");
	    label1.setBounds(240, 30, 30, 40);
	    jp.add(label1);
	    
	    JLabel label2 = new JLabel();
	    label2.setText("从");
	    label2.setBounds(270, 30, 20, 40);
	    jp.add(label2);
	    
	    JTextField textfield1 = new JTextField(8);
	    textfield1.setBounds(300, 30, 90, 40);
	    textfield1.setText("");
	    textfield1.setBackground(new Color(248, 248, 255));
	    jp.add(textfield1);
	    
	    JLabel label3 = new JLabel();
	    label3.setText("到");
	    label3.setBounds(400, 30, 20, 40);
	    jp.add(label3);
	    
	    
	    
	    
	    
	    JTextField textfield2 = new JTextField(8);
	    textfield2.setBounds(430, 30, 90, 40);
	    textfield2.setText("");
	    textfield2.setBackground(new Color(248, 248, 255));
	    jp.add(textfield2);
	    
	    
	    
	    JButton btnSubmit = new JButton("提交");
	    btnSubmit.setBorderPainted(true);
	    btnSubmit.setBounds(550, 30, 80, 30);
	    jp.add(btnSubmit);
	    
	    JButton btnExit = new JButton("退出");
	    btnExit.setBorderPainted(true);
	    btnExit.setBounds(650, 30, 80, 30);
	    jp.add(btnExit);
	    
	    Object[][] rowData = {{1,1,1,1},{2,2,2,2},{3,3,3,3},{4,4,4,4},{5,5,5,5}};;//建数据	
	    String[] columnData = {"姓名","班级","专业","学历"};//建一个表头     
	    JTable table = new JTable(rowData, columnData);      
	    	//初始化JScrollPane     
	   
	    JScrollPane scrollpane = new JScrollPane();    
	    	//将table添加到JScrollPane上 这里使用下面的第一种方法不能添加     
	    	//使用第一个先获得JViewPort对象，然后再添加     // 
	    scrollpane.setBounds(550, 30, 80, 30);      
	    scrollpane.getViewport().add(table);  
	    getContentPane().add(scrollpane,BorderLayout.CENTER);
	    
	}
	    
}
