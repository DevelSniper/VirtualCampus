package StuInfoMngApp;

import java.awt.AWTEvent;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
/** * @author C5102 * * TODO To change the template for this generated type comment go to * Window - Preferences - Java - Code Style - Code Templates */

public class QueryByCard extends JFrame{	
	/**	 * Comment for <code>serialVersionUID</code>	 */	
	private JPanel contentPanel;	
	private StuInfoQuery siq;
	/**	 * @param window	 */	
	public QueryByCard(StuInfoQuery siqIn) {	
		this.siq = siqIn;		
		setTitle("按一卡通号查询");	
		setBounds(100, 100, 800, 550);
		enableEvents(AWTEvent.WINDOW_EVENT_MASK);
		setLocationRelativeTo(getOwner());	
		setType(Type.POPUP);
		
		JPanel jp = new JPanel();
		jp.setOpaque(false);		
	    getContentPane().add(jp,BorderLayout.NORTH);	
	    ((JPanel) getContentPane()).setOpaque(false);
	
		
	    JLabel label = new JLabel();
	    label.setText("请输入一卡通号");
	    label.setBounds(200, 30, 112, 40);
	    jp.add(label);
	    
	    JTextField textfield = new JTextField(12);
	    textfield.setBounds(300, 30, 112, 40);
	    textfield.setText("");
	    textfield.setBackground(new Color(248, 248, 255));
	    jp.add(textfield);
	    
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
	    
	    JButton btnSubmit = new JButton("提交");
	    btnSubmit.setBorderPainted(true);
	    btnSubmit.setBounds(450, 30, 80, 30);
	    jp.add(btnSubmit);
	    
	    JButton btnExit = new JButton("退出");
	    btnExit.setBorderPainted(true);
	    btnExit.setBounds(550, 30, 80, 30);
	    jp.add(btnExit);
	    
	}
	    
}