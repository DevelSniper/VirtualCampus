package client.ui.studentInfor;

import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import conn.common.Student;
import client.connDb.ClientMsgHelper;

public class UpdateStudentInfor extends JFrame{
	String studentCard;
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
//    OperateDB dbConnMng = new OperateDB();
    private static UpdateStudentInfor window;
    
	public JPanel jpInit()
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
			String cgColum = "";
			studentCard = (String) table.getValueAt(row, 0);
			changed = (String)table.getValueAt(row, col);
			ClientMsgHelper cmh = new ClientMsgHelper();
			switch(col)
			{
				case 1:cgColum = "sID";break;
				case 2:cgColum = "sName";break;
				case 3:cgColum = "sSex";break;
				case 4:cgColum = "sClassID";break;
				case 5:cgColum = "sBirthday";break;
				case 6:cgColum = "sHometown";break;
			}
			cmh.update("vcStudent", "sCard", studentCard, cgColum, changed);
			cmh.sendMsg();
			cmh.recieveMsg();
			cmh.disconnect();
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
	    		ClientMsgHelper  cmh = new ClientMsgHelper();
	    		String[] colum = {"sCard", "sID", "sName", "sSex", "sClassID", "sBirthday", "sHometown"};
	    		cmh.query("vcStudent", colum);
	    		cmh.sendMsg();
	    		cmh.recieveMsg();
	    		Vector<Vector<String>> result =  (Vector<Vector<String>>) cmh.getDataInMsg();
	    		rowData.addAll(result);
	    	    table.updateUI();
	    	}
	    });

	    JButton btnEdit = new JButton("删除");
	    btnEdit.setBorderPainted(true);
	    btnEdit.setBounds(250, 450, 80, 30);
	    jp2.add(btnEdit);
	    btnEdit.addMouseListener(new MouseAdapter() 
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
					ClientMsgHelper  cmh = new ClientMsgHelper();
					studentCard = (String) table.getValueAt(row, 0);
		    		cmh.delete("vcStudent", "sCard", studentCard);
		    		cmh.sendMsg();
		    		cmh.disconnect();
					rowData.removeAllElements();
		    		
		    		String[] colum = {"sCard", "sID", "sName", "sSex", "sClassID", "sBirthday", "sHometown"};
		    		cmh.query("vcStudent", colum);
		    		cmh.sendMsg();
		    		cmh.recieveMsg();
		    		Vector<Vector<String>> result =  (Vector<Vector<String>>) cmh.getDataInMsg();
		    		rowData.addAll(result);
		    	    table.updateUI();
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
