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

public class QueryByName extends JFrame{	
	/**	 * Comment for <code>serialVersionUID</code>	 */	
	private JPanel contentPanel;	
	private StuInfoQuery siq;
	/**	 * @param window	 */	
	public QueryByName(StuInfoQuery siqIn) {	
		this.siq = siqIn;		
		setTitle("��������ѯ");	
		setBounds(100, 100, 800, 550);
		enableEvents(AWTEvent.WINDOW_EVENT_MASK);
		setLocationRelativeTo(getOwner());	
		setType(Type.POPUP);
		
		JPanel jp = new JPanel();
		jp.setOpaque(false);		
	    getContentPane().add(jp,BorderLayout.NORTH);	
	    ((JPanel) getContentPane()).setOpaque(false);
		
	    JLabel label = new JLabel();
	    label.setText("����������");
	    label.setBounds(200, 30, 112, 40);
	    jp.add(label);
	    
	    JTextField textfield = new JTextField(12);
	    textfield.setBounds(300, 30, 112, 40);
	    textfield.setText("");
	    textfield.setBackground(new Color(248, 248, 255));
	    jp.add(textfield);
	    
	    Object[][] rowData = {{1,1,1,1},{2,2,2,2},{3,3,3,3},{4,4,4,4},{5,5,5,5}};;//������	
	    String[] columnData = {"����","�༶","רҵ","ѧ��"};//��һ����ͷ     
	    JTable table = new JTable(rowData, columnData);      
	    	//��ʼ��JScrollPane     
	   
	    JScrollPane scrollpane = new JScrollPane();    
	    	//��table��ӵ�JScrollPane�� ����ʹ������ĵ�һ�ַ����������     
	    	//ʹ�õ�һ���Ȼ��JViewPort����Ȼ�������     // 
	    scrollpane.setBounds(550, 30, 80, 30);      
	    scrollpane.getViewport().add(table);  
	    getContentPane().add(scrollpane,BorderLayout.CENTER);
	    
	    JButton btnSubmit = new JButton("�ύ");
	    btnSubmit.setBorderPainted(true);
	    btnSubmit.setBounds(450, 30, 80, 30);
	    jp.add(btnSubmit);
	    
	    JButton btnExit = new JButton("�˳�");
	    btnExit.setBorderPainted(true);
	    btnExit.setBounds(550, 30, 80, 30);
	    jp.add(btnExit);
	    
	}
	    
}