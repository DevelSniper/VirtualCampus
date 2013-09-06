package client.ui.studentInfor;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import client.connDb.ClientMsgHelper;

public class QueryByCard extends JFrame{
	String studentCard;
    JPanel jp6 = new JPanel();
    final Vector<Vector<String>> rowData = new Vector<Vector<String>>();
    final Vector<Vector<String>> rowData1 = new Vector<Vector<String>>();
    Vector columnData = new Vector();
    Vector columnData1 = new Vector();
//    OperateDB dbConnMng = new OperateDB();
    private static QueryByCard window;
    
	public JPanel jpInit()
	{
		jp6.setOpaque(false);		
	    getContentPane().add(jp6);	
	    ((JPanel) getContentPane()).setOpaque(false);
	    jp6.setLayout(null);		
		
	    JLabel label = new JLabel();
	    label.setText("请输入一卡通号");
	    label.setBounds(200, 30, 112, 40);
	    jp6.add(label);
	    
	    final JTextField textfield = new JTextField(12);
	    textfield.setBounds(300, 35, 112, 30);
	    textfield.setText("");
	    textfield.setBackground(new Color(248, 248, 255));
	    jp6.add(textfield);
	    
	    columnData.add("一卡通号");
	    columnData.add("学号");
	    columnData.add("姓名");
	    columnData.add("性别");
	    columnData1.add("班级");
	    columnData1.add("生日");
	    columnData1.add("籍贯");
	    
	    
		final JTable table = new JTable(rowData, columnData);
		final JScrollPane scrollpane = new JScrollPane(table);
		scrollpane.setBounds(100, 100, 600, 75); 
		table.setRowHeight(50); 
	    table.setPreferredScrollableViewportSize(new Dimension(100,100));
	    jp6.add(scrollpane);
	    
	    final JTable table1 = new JTable(rowData1,columnData1); 
	    final JScrollPane scrollpane1 = new JScrollPane(table1);  
	    scrollpane1.setBounds(100, 250, 600, 75);  
	    table1.setRowHeight(50); 
	    table1.setPreferredScrollableViewportSize(new Dimension(100,100));
	    jp6.add(scrollpane1);
	    
	    JButton btnSubmit = new JButton("提交");
	    btnSubmit.setBorderPainted(true);
	    btnSubmit.setBounds(450, 35, 80, 30);
	    jp6.add(btnSubmit);
	    btnSubmit.addMouseListener(new MouseAdapter() 
	    {		
	    	@Override		
	    	public void mouseClicked(MouseEvent arg0) 
	    	{
	    		rowData.removeAllElements();
	    		rowData1.removeAllElements();
	    		
	    		studentCard = textfield.getText().trim();
	    		
	    		if(studentCard.equals(""))
	    		{
	    			JOptionPane.showMessageDialog(null,"一卡通号不能为空");
	    		}
	    		
	    		else
	    		{	
		    		rowData.removeAllElements();
		    		rowData1.removeAllElements();
		    		ClientMsgHelper  cmh = new ClientMsgHelper();
		    		String[] colum = {"sCard", "sID", "sName", "sSex"}; //, "sClassID", "sBirthday", "sHometown"
		    		cmh.query("vcStudent", "sCard", studentCard, colum);
		    		cmh.sendMsg();
		    		cmh.recieveMsg();
		    		cmh.disconnect();
		    		Vector<Vector<String>> result =  (Vector<Vector<String>>) cmh.getDataInMsg();
		    		rowData.addAll(result);
		    		String[] colum1 = {"sClassID", "sBirthday", "sHometown"}; 
		    		cmh.query("vcStudent", "sCard", studentCard, colum1);
		    		cmh.sendMsg();
		    		cmh.recieveMsg();
		    		cmh.disconnect();
		    		Vector<Vector<String>> result1 =  (Vector<Vector<String>>) cmh.getDataInMsg();
		    		rowData1.addAll(result1);
		    	    table.updateUI();
		    	    table1.updateUI();
	    		}
	    	}
	    });
	    
	    JButton btnExit = new JButton("退出");
	    btnExit.setBorderPainted(true);
	    btnExit.setBounds(550, 35, 80, 30);
	    jp6.add(btnExit);
	    btnExit.addMouseListener(new MouseAdapter() 
	    {		
	    	@Override		
	    	public void mouseClicked(MouseEvent e) 
	    	{	
	    		System.exit(0);
	    	}		
		
	    });	
	    
	    return jp6;
	}

	
}
