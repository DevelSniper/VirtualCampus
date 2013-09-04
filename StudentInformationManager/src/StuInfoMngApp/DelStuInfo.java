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

public class DelStuInfo extends JFrame{
	String aid;
	String aname;
	String aclass;
	String asex;
	String abirthday;
	String abirthplace;
	String acard;
    JPanel jp3 = new JPanel();
    Vector<Vector<String>> rowData = new Vector<Vector<String>>();
    Vector columnData = new Vector();
    OperateDB dbConnMng = new OperateDB();
    private static DelStuInfo window;
    
	public JPanel jpInit() throws SQLException
	{
		jp3.setOpaque(false);		
	    getContentPane().add(jp3);	
	    ((JPanel) getContentPane()).setOpaque(false);
	    jp3.setLayout(null);
		
	    columnData.add("一卡通号");
	    columnData.add("学号");
	    columnData.add("姓名");
	    columnData.add("性别");
	    columnData.add("班级");
	    columnData.add("生日");
	    columnData.add("籍贯");
	    
	    
		final JTable table = new JTable(rowData, columnData);
		final JScrollPane scrollpane = new JScrollPane(table);
		scrollpane.setBounds(100, 35, 600, 350); 
		table.setRowHeight(50); 
	    table.setPreferredScrollableViewportSize(new Dimension(100,100));
	    jp3.add(scrollpane);
	    
	    JButton btnRefresh = new JButton("刷新");
	    btnRefresh.setBorderPainted(true);
	    btnRefresh.setBounds(360, 450, 80, 30);
	    jp3.add(btnRefresh);
	    btnRefresh.addMouseListener(new MouseAdapter() 
	    {		
	    	@Override		
	    	public void mouseClicked(MouseEvent arg0) 
	    	{
	    		rowData.removeAllElements();
				try {
					for(int i=0;i<dbConnMng.GetStuInfo().size();i++)
					{
						Vector<String> data = new Vector<String>();
						data.add(dbConnMng.GetStuInfo().get(i).getacard());
						data.add(dbConnMng.GetStuInfo().get(i).getaid());
						data.add(dbConnMng.GetStuInfo().get(i).getaname());
						data.add(dbConnMng.GetStuInfo().get(i).getasex());
						data.add(dbConnMng.GetStuInfo().get(i).getaclassid());
						data.add(dbConnMng.GetStuInfo().get(i).getabirthday());
						data.add(dbConnMng.GetStuInfo().get(i).getabirthplace());
						rowData.add(data);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    	    
	    	    table.updateUI();
	    	}
	    });
			
		    
		    JButton btnDelete = new JButton("删除");
		    btnDelete.setBorderPainted(true);
		    btnDelete.setBounds(250, 450, 80, 30);
		    jp3.add(btnDelete);
		    btnDelete.addMouseListener(new MouseAdapter() 
    	    {		
    	    	@Override		
    	    	public void mouseClicked(MouseEvent arg0) 
    	    	{	
    	    		
    	    		int row = table.getSelectedRow();		
    	    		if(row == -1)
    	    		{					
    	    			JOptionPane.showMessageDialog(null,"请选择要删除的行!");	
    	    		}
    	    		
    	    		else
    	    		{	
    	    			try {
    	    				    aid = (String) table.getValueAt(row, 1);
    	    					dbConnMng.DelStuInfo(aid);	
    	    					rowData.removeAllElements();
    	    					for(int i=0;i<dbConnMng.GetStuInfo().size();i++)
    	    					{
    	    						Vector<String> data = new Vector<String>();
    	    						data.add(dbConnMng.GetStuInfo().get(i).getacard());
    	    						data.add(dbConnMng.GetStuInfo().get(i).getaid());
    	    						data.add(dbConnMng.GetStuInfo().get(i).getaname());
    	    						data.add(dbConnMng.GetStuInfo().get(i).getasex());
    	    						data.add(dbConnMng.GetStuInfo().get(i).getaclassid());
    	    						data.add(dbConnMng.GetStuInfo().get(i).getabirthday());
    	    						data.add(dbConnMng.GetStuInfo().get(i).getabirthplace());
    	    						rowData.add(data);
    	    					}
    	    				    
    	    					table.updateUI();	
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
		    btnExit.setBounds(470, 450, 80, 30);
		    jp3.add(btnExit);			
		    btnExit.addMouseListener(new MouseAdapter() 
    	    {		
    	    	@Override		
    	    	public void mouseClicked(MouseEvent e) 
    	    	{	
    	    		System.exit(0); 		
    	    	}		
    		
    	    });	
		    
		    return jp3;
	}
	
	
}
