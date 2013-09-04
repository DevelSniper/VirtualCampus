package StuInfoMngApp;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

public class EditStuInfo extends JFrame{
	String aid;
	String aname;
	String aclass;
	String asex;
	String abirthday;
	String abirthplace;
	String acard;
	int col;
	int row;
	String changed;
	String oldvalue=null;
    JPanel jp2 = new JPanel();
    Vector<String> data = new Vector<String>();
    Vector<Vector<String>> rowData = new Vector<Vector<String>>();
    Vector colChanged = new Vector();
    Vector rowChanged = new Vector();
    Vector columnData = new Vector();
    OperateDB dbConnMng = new OperateDB();
    private static EditStuInfo window;
    
	public JPanel jpInit() throws SQLException
	{
		jp2.setOpaque(false);		
	    getContentPane().add(jp2);	
	    ((JPanel) getContentPane()).setOpaque(false);
	    jp2.setLayout(null);
		
	    columnData.add("一卡通号");
	    columnData.add("学号");
	    columnData.add("姓名");
	    columnData.add("性别");
	    columnData.add("班级");
	    columnData.add("生日");
	    columnData.add("籍贯");
	    
	    
	    
		 final JTable table = new JTable(rowData, columnData){ 
			public boolean isCellEditable(int row, int column) 
			{  
				if (column == 1) 
				{//让column为2那一列不可用   
					return false; 
					}
				else 
					return true;  
				} 
			};
			

	    
		final JScrollPane scrollpane = new JScrollPane(table);
		scrollpane.setBounds(100, 35, 600, 350); 
		table.setRowHeight(50); 
	    table.setPreferredScrollableViewportSize(new Dimension(100,100));
	    jp2.add(scrollpane);
	    
	    table.addMouseListener(new MouseAdapter(){
	         public void mouseClicked(MouseEvent e){
	           //记录进入编辑状态前单元格得数据
	              oldvalue = table.getValueAt(table.getSelectedRow(),table.getSelectedColumn()).toString();
	             }     
	         });

	    
	    table.getModel().addTableModelListener(new TableModelListener()
	    { 
	          @Override
	          public void tableChanged(TableModelEvent e) {
	                   col = e.getColumn();                   
	                   row = e.getFirstRow(); 
	                   colChanged.add(col);
	                   rowChanged.add(row);
	                   aid = (String) table.getValueAt(row, 1);
	                   changed = (String)table.getValueAt(row, col);
	                   try {
						if(col == 4&&!dbConnMng.ClassExist(changed))
						   {
									JOptionPane.showMessageDialog(null,"班级不存在，请先创建班级!");
									table.setValueAt(oldvalue, row, col);
						   }
						   
						   else
						   {
							   try {
								dbConnMng.EditStuInfo(aid,row,col,changed);
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
						   }
					} catch (HeadlessException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	          		}
	    }); 
	    
	    JButton btnRefresh = new JButton("刷新");
	    btnRefresh.setBorderPainted(true);
	    btnRefresh.setBounds(360, 450, 80, 30);
	    jp2.add(btnRefresh);
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

	    JButton btnEdit = new JButton("修改");
	    btnEdit.setBorderPainted(true);
	    btnEdit.setBounds(250, 450, 80, 30);
	    jp2.add(btnEdit);
	    btnEdit.addMouseListener(new MouseAdapter() 
	    {		
	    	@Override		
	    	public void mouseClicked(MouseEvent arg0) 
	    	{		
	    		if(colChanged.isEmpty()&&rowChanged.isEmpty())
	    		{					
	    			JOptionPane.showMessageDialog(null,"没有要修改的数据!");	
	    		}
	    		
	    		else
	    		{	
	    				try 
	    					{	
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
	    									
	    						}
	    					catch (SQLException e) {	
	    						// TODO Auto-generated catch block		
	    						e.printStackTrace();		
	    						}					
	    					}
	    			
					
	    	}		
		
	    });
	    
	    JButton btnExit = new JButton("退出");
	    btnExit.setBorderPainted(true);
	    btnExit.setBounds(470, 450, 80, 30);
	    jp2.add(btnExit);
	    btnExit.addMouseListener(new MouseAdapter() 
	    {		
	    	@Override		
	    	public void mouseClicked(MouseEvent e) 
	    	{	
	    		System.exit(0); 		
	    	}		
		
	    });	
	    
	    return jp2;
	}

	

	
}
