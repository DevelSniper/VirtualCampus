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

public class QueryByCard extends JFrame{
	String aid;
	String aname;
	String aclass;
	String asex;
	String abirthday;
	String abirthplace;
	String acard;
    JPanel jp6 = new JPanel();
    final Vector<Vector<String>> rowData = new Vector<Vector<String>>();
    final Vector<Vector<String>> rowData1 = new Vector<Vector<String>>();
    Vector columnData = new Vector();
    Vector columnData1 = new Vector();
    OperateDB dbConnMng = new OperateDB();
    private static QueryByCard window;
    
	public JPanel jpInit() throws SQLException
	{
		jp6.setOpaque(false);		
	    getContentPane().add(jp6);	
	    ((JPanel) getContentPane()).setOpaque(false);
	    jp6.setLayout(null);		
		
	    JLabel label = new JLabel();
	    label.setText("������һ��ͨ��");
	    label.setBounds(200, 30, 112, 40);
	    jp6.add(label);
	    
	    final JTextField textfield = new JTextField(12);
	    textfield.setBounds(300, 35, 112, 30);
	    textfield.setText("");
	    textfield.setBackground(new Color(248, 248, 255));
	    jp6.add(textfield);
	    
	    columnData.add("һ��ͨ��");
	    columnData.add("ѧ��");
	    columnData.add("����");
	    columnData.add("�Ա�");
	    columnData1.add("�༶");
	    columnData1.add("����");
	    columnData1.add("����");
	    
	    
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
	    
	    JButton btnSubmit = new JButton("�ύ");
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
	    		
	    		acard = textfield.getText().trim();
	    		
	    		if(acard.equals(""))
	    		{
	    			JOptionPane.showMessageDialog(null,"һ��ͨ�Ų���Ϊ��");
	    		}
	    		
	    		else
	    		{	
	    			try {
						if(dbConnMng.StuCardExist(acard)==false)
						{
							JOptionPane.showMessageDialog(null,"��ѧ��������");
						}
						
						else
						{
							try {
								Vector<String> data = new Vector<String>();
								 Vector<String> data1 = new Vector<String>();
								 data.add(dbConnMng.GetStuCard(acard).getacard());
	    						 data.add(dbConnMng.GetStuCard(acard).getaid());
	    						 data.add(dbConnMng.GetStuCard(acard).getaname());
	    						 data.add(dbConnMng.GetStuCard(acard).getasex());
	    						 data1.add(dbConnMng.GetStuCard(acard).getaclassid());
	    						 data1.add(dbConnMng.GetStuCard(acard).getabirthday());
	    						 data1.add(dbConnMng.GetStuCard(acard).getabirthplace());
								 rowData.add(data);
								 rowData1.add(data1);
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
	    
	    JButton btnExit = new JButton("�˳�");
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
