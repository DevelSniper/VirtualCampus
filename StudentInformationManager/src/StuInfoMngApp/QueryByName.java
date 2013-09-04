package StuInfoMngApp;

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

public class QueryByName extends JFrame{
	String aid;
	String aname;
	String aclass;
	String asex;
	String abirthday;
	String abirthplace;
	String acard;
    JPanel jp5 = new JPanel();
    final Vector<Vector<String>> rowData = new Vector<Vector<String>>();
    final Vector<Vector<String>> rowData1 = new Vector<Vector<String>>();
    Vector columnData = new Vector();
    Vector columnData1 = new Vector();
    OperateDB dbConnMng = new OperateDB();
    private static QueryByName window;
    
	public JPanel jpInit() throws SQLException
	{
		jp5.setOpaque(false);		
	    getContentPane().add(jp5);	
	    ((JPanel) getContentPane()).setOpaque(false);
	    jp5.setLayout(null);
		
		jp5.setOpaque(false);		
	    getContentPane().add(jp5);	
	    ((JPanel) getContentPane()).setOpaque(false);
		jp5.setLayout(null);
		
		 JLabel label = new JLabel();
		    label.setText("请输入姓名");
		    label.setBounds(200, 30, 112, 40);
		    jp5.add(label);
		    
		    final JTextField textfield = new JTextField(12);
		    textfield.setBounds(300, 35, 112, 30);
		    textfield.setText("");
		    textfield.setBackground(new Color(248, 248, 255));
		    jp5.add(textfield);
		    
		    columnData.add("一卡通号");
		    columnData.add("学号");
		    columnData.add("姓名");
		    columnData.add("性别");
		    columnData1.add("班级");
		    columnData1.add("生日");
		    columnData1.add("籍贯");
			
			final JTable table = new JTable(rowData, columnData);
			final JScrollPane scrollpane = new JScrollPane(table);
			scrollpane.setBounds(100, 100, 600, 100); 
			table.setRowHeight(50); 
		    table.setPreferredScrollableViewportSize(new Dimension(100,100));
		    jp5.add(scrollpane);
		    
		    final JTable table1 = new JTable(rowData1,columnData1); 
		    final JScrollPane scrollpane1 = new JScrollPane(table1);  
		    scrollpane1.setBounds(100, 250, 600, 100);  
		    table1.setRowHeight(50); 
		    table1.setPreferredScrollableViewportSize(new Dimension(100,100));
		    jp5.add(scrollpane1);

		 
		    
		    JButton btnSubmit = new JButton("提交");
		    btnSubmit.setBorderPainted(true);
		    btnSubmit.setBounds(450, 35, 80, 30);
		    jp5.add(btnSubmit);
		    btnSubmit.addMouseListener(new MouseAdapter() 
		    {		
		    	@Override		
		    	public void mouseClicked(MouseEvent arg0) 
		    	{
		    		rowData.removeAllElements();
		    		rowData1.removeAllElements();
		    		
		    		aname = textfield.getText().trim();
		    		
		    		if(aname.equals(""))
		    		{
		    			JOptionPane.showMessageDialog(null,"姓名不能为空");
		    		}
		    		
		    		else
		    		{	
		    			try {
							if(dbConnMng.StuNameExist(aname)==false)
							{
								JOptionPane.showMessageDialog(null,"该学生不存在");
							}
							
							else
							{
								try {
											for(int i=0;i<dbConnMng.GetStuName(aname).size();i++)
											{
												Vector<String> data = new Vector<String>();
												Vector<String> data1 = new Vector<String>();
												data.add(dbConnMng.GetStuInfo().get(i).getacard());
												data.add(dbConnMng.GetStuInfo().get(i).getaid());
												data.add(dbConnMng.GetStuInfo().get(i).getaname());
												data.add(dbConnMng.GetStuInfo().get(i).getasex());
												data1.add(dbConnMng.GetStuInfo().get(i).getaclassid());
			    	    						data1.add(dbConnMng.GetStuInfo().get(i).getabirthday());
			    	    						data1.add(dbConnMng.GetStuInfo().get(i).getabirthplace());
			    	    						rowData.add(data);
			    	    						rowData1.add(data1);
											}
										    table.updateUI();
										    table1.updateUI();
						
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
						} catch (HeadlessException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		    		}
		    	}
		    });
		    
		    JButton btnExit = new JButton("退出");
		    btnExit.setBorderPainted(true);
		    btnExit.setBounds(550, 35, 80, 30);
		    jp5.add(btnExit);
		    btnExit.addMouseListener(new MouseAdapter() 
		    {		
		    	@Override		
		    	public void mouseClicked(MouseEvent e) 
		    	{	
		    		System.exit(0); 			
		    	}		
			
		    });	
		    
		    return jp5;
	}


}
