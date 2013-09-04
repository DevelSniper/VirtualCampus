package StuInfoMngApp;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class StuInfoStatistic extends JFrame{
	String aclass;
	String asex;
	String abirthday1;
	String abirthday2;
    JPanel jp7 = new JPanel();
    OperateDB dbConnMng = new OperateDB();
    final Vector<Vector<String>> rowData = new Vector<Vector<String>>();
    Vector columnData = new Vector();
    private static StuInfoStatistic window;
    
	public JPanel jpInit() throws SQLException
	{
		jp7.setOpaque(false);		
	    getContentPane().add(jp7);	
	    ((JPanel) getContentPane()).setOpaque(false);
	    jp7.setLayout(null);
		
		
	JLabel label = new JLabel();
    label.setText("�༶");
    label.setBounds(25, 30, 30, 40);
    jp7.add(label);
    
    final JTextField textfield = new JTextField(8);
    textfield.setBounds(60, 35, 90, 30);
    textfield.setText("");
    textfield.setBackground(new Color(248, 248, 255));
    jp7.add(textfield);
    
    final JComboBox combobox = new JComboBox();
    combobox.addItem("�Ա�");
    combobox.addItem("��");
    combobox.addItem("Ů");
    combobox.setBounds(160, 35, 90, 30);
    combobox.setBackground(new Color(248, 248, 255));
    jp7.add(combobox);
    
    JLabel label1 = new JLabel();
    label1.setText("����");
    label1.setBounds(260, 30, 30, 40);
    jp7.add(label1);
    
    JLabel label2 = new JLabel();
    label2.setText("��");
    label2.setBounds(290, 30, 20, 40);
    jp7.add(label2);
    
    final JTextField textfield1 = new JTextField(8);
    textfield1.setBounds(320, 35, 90, 30);
    textfield1.setText("");
    textfield1.setBackground(new Color(248, 248, 255));
    jp7.add(textfield1);
    
    JLabel label3 = new JLabel();
    label3.setText("��");
    label3.setBounds(420, 30, 20, 40);
    jp7.add(label3);
    
    
    final JTextField textfield2 = new JTextField(8);
    textfield2.setBounds(450, 35, 90, 30);
    textfield2.setText("");
    textfield2.setBackground(new Color(248, 248, 255));
    jp7.add(textfield2);
			
	columnData.add("һ��ͨ��");
	columnData.add("ѧ��");
	columnData.add("����");
	columnData.add("�Ա�");
	columnData.add("�༶");
	columnData.add("����");
	columnData.add("����");
	
	
	final JTable table = new JTable(rowData,columnData); 
    final JScrollPane scrollpane = new JScrollPane(table);  
	scrollpane.setBounds(100, 100, 600, 150);  
	table.setRowHeight(50); 
	table.setPreferredScrollableViewportSize(new Dimension(100,100));
	jp7.add(scrollpane);
	
    JButton btnSubmit = new JButton("�ύ");
    btnSubmit.setBorderPainted(true);
    btnSubmit.setBounds(570, 35, 80, 30);
    jp7.add(btnSubmit);
    btnSubmit.addMouseListener(new MouseAdapter() 
    {		
    	@Override		
    	public void mouseClicked(MouseEvent arg0) 
    	{
    		rowData.removeAllElements();
    		aclass = textfield.getText().trim();
    		asex = (String)combobox.getSelectedItem();
    		abirthday1 = textfield1.getText().trim();
    		abirthday2 = textfield2.getText().trim();
    		
    		if(aclass.equals("")&&asex.equals("�Ա�")&&abirthday1.equals("")&&abirthday2.equals(""))
    		{
    			JOptionPane.showMessageDialog(null,"��������ȫΪ��");
    		}
    		
    		else
    		{	
    			try {
    				if(dbConnMng.Statistic(aclass,asex,abirthday1,abirthday2).isEmpty())
    				{
    					JOptionPane.showMessageDialog(null,"����������ѧ��������");
    				}
    				else
    				{
    					for(int i=0;i<dbConnMng.Statistic(aclass,asex,abirthday1,abirthday2).size();i++)
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
    btnExit.setBounds(670, 35, 80, 30);
    jp7.add(btnExit);
    btnExit.addMouseListener(new MouseAdapter() 
    {		
    	@Override		
    	public void mouseClicked(MouseEvent e) 
    	{	
    		System.exit(0); 			
    	}		
	
    });	
    
    return jp7;
	}
	

}
