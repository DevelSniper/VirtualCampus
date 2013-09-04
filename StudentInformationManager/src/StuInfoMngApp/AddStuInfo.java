package StuInfoMngApp;

import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddStuInfo extends JFrame{
	JPanel jp1 = new JPanel();
	CreatClass cc = new CreatClass(null);
	StudentData StudentData = new StudentData(null,null,null,null,null,null,null);
    OperateDB dbConnMng = new OperateDB();
    private static AddStuInfo window;
    
	public JPanel jpInit()
	{
		 
		jp1.setOpaque(false);		
	    	
	    jp1.setLayout(null);
		
		
		JLabel label = new JLabel();
	    label.setText("����");
	    label.setBounds(80, 50, 30, 40);
	    jp1.add(label);
	    
	    JLabel label1 = new JLabel();
	    label1.setText("�Ա�");
	    label1.setBounds(450, 50, 30, 40);
	    jp1.add(label1);
	    
	    JLabel label2 = new JLabel();
	    label2.setText("ѧ��");
	    label2.setBounds(80, 150, 30, 40);
	    jp1.add(label2);
	    
	    JLabel label3 = new JLabel();
	    label3.setText("һ��ͨ��");
	    label3.setBounds(450, 150, 60, 40);
	    jp1.add(label3);
	    
	    JLabel label4 = new JLabel();
	    label4.setText("�༶");
	    label4.setBounds(80, 250, 30, 40);
	    jp1.add(label4);
	    
	    JLabel label5 = new JLabel();
	    label5.setText("��������");
	    label5.setBounds(450, 250, 60, 40);
	    jp1.add(label5);
	    
	    JLabel label6 = new JLabel();
	    label6.setText("����");
	    label6.setBounds(230, 350, 30, 40);
	    jp1.add(label6);
	    
	    final JTextField textfield = new JTextField();
	    textfield.setBounds(150, 50, 150, 40);
	    textfield.setText("");
	    textfield.setBackground(new Color(248, 248, 255));
	    jp1.add(textfield);
	    
	    final JTextField textfield1 = new JTextField();
	    textfield1.setBounds(150, 150, 150, 40);
	    textfield1.setText("");
	    textfield1.setBackground(new Color(248, 248, 255));
	    textfield1.addKeyListener(new KeyAdapter() 
	    {	
	    	@Override			
	    	public void keyTyped(KeyEvent arg0) 
	    	{		
	    		if(!Character.isDigit(arg0.getKeyChar()))			
				arg0.consume();		
			}		
		});
	    jp1.add(textfield1);
	    
	    final JTextField textfield2 = new JTextField();
	    textfield2.setBounds(520, 150, 150, 40);
	    textfield2.setText("");
	    textfield2.setBackground(new Color(248, 248, 255));
	    textfield2.addKeyListener(new KeyAdapter() 
	    {	
	    	@Override			
	    	public void keyTyped(KeyEvent arg0) 
	    	{		
	    		if(!Character.isDigit(arg0.getKeyChar()))			
				arg0.consume();		
			}		
		});
	    jp1.add(textfield2);
	    
	    final JTextField textfield4 = new JTextField();
	    textfield4.setBounds(520, 250, 150, 40);
	    textfield4.setText("");
	    textfield4.setBackground(new Color(248, 248, 255));
	    jp1.add(textfield4);
	    
	    final JTextField textfield5 = new JTextField();
	    textfield5.setBounds(300, 350, 200, 40);
	    textfield5.setText("");
	    textfield5.setBackground(new Color(248, 248, 255));
	    jp1.add(textfield5);
	    
	    final JComboBox combobox = new JComboBox();
	    combobox.addItem("��");
	    combobox.addItem("Ů");
	    combobox.setBounds(520, 50, 150, 40);
	    combobox.setBackground(new Color(248, 248, 255));
	    jp1.add(combobox);
	    
	    final JComboBox combobox1 = new JComboBox();
	    combobox1.setBounds(150, 250, 150, 40);
	    combobox1.setBackground(new Color(248, 248, 255));
	    jp1.add(combobox1);
	    
	   
	    
	    combobox1.addMouseListener(new MouseAdapter() 
	    {		
	    	@Override		
	    	public void mouseClicked(MouseEvent arg0) 
	    	{
	    		try {
	    			if(combobox1.getItemCount()<dbConnMng.GetClass().size())
					    {
	    				combobox1.removeAllItems();
					    
					    for(int i=0;i<dbConnMng.GetClass().size();i++)
					    {
							combobox1.addItem(dbConnMng.GetClass().get(i).getaclassid());
						    
					    }
					    combobox1.updateUI();
	    		}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    		
	    	}	
		
	    });
		
	    
	    JButton btnSubmit = new JButton("����");
	    btnSubmit.setBorderPainted(true);
	    btnSubmit.setBounds(250, 450, 80, 30);
	    jp1.add(btnSubmit);
	    btnSubmit.addMouseListener(new MouseAdapter() 
	    {		
	    	@Override		
	    	public void mouseClicked(MouseEvent arg0) 
	    	{		
	    		StudentData.setaname(textfield.getText().trim());
	    		StudentData.setaid(textfield1.getText().trim());
	    		StudentData.setasex((String)combobox.getSelectedItem());
	    		StudentData.setaclassid((String)combobox1.getSelectedItem());
	    		StudentData.setabirthday(textfield4.getText().trim());
	    		StudentData.setacard(textfield2.getText().trim());
	    		StudentData.setabirthplace(textfield5.getText().trim());
	    		
	    		if(StudentData.getaid().equals(""))
	    		{
	    			JOptionPane.showMessageDialog(null,"ѧ�Ų���Ϊ��");
	    		}
	    		
	    		else if(StudentData.getaid().length()!=8)
	    		{
	    			JOptionPane.showMessageDialog(null,"ѧ���������");
	    		}
	    		
	    		else if(StudentData.getaname().equals(""))
	    		{
	    			JOptionPane.showMessageDialog(null,"��������Ϊ��");
	    		}
	    		
	    		
	    		else
	    		{	
	    			try {
						if(dbConnMng.StuExist(StudentData.getaid())==true)
						{
							JOptionPane.showMessageDialog(null,"��ѧ���Ѿ�����");
						}
						
						else
						{
							try {
								dbConnMng.AddStuInfo(StudentData);
								
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
	    
	    
	    JButton btnCreat = new JButton("�����༶");
	    btnCreat.setBorderPainted(true);
	    btnCreat.setBounds(310, 255, 100, 30);
	    btnCreat.addMouseListener(new MouseAdapter() 
	    {		
	    	@Override		
	    	public void mouseClicked(MouseEvent arg0) 
	    	{		
	    		CreatClass cc = new CreatClass(window);		
				cc.setVisible(true);			
	    	}		
		
	    });	
	    jp1.add(btnCreat);
	    
	    JButton btnExit = new JButton("�˳�");
	    btnExit.setBorderPainted(true);
	    btnExit.setBounds(470, 450, 80, 30);
	    jp1.add(btnExit);
	    btnExit.addMouseListener(new MouseAdapter() 
	    {		
	    	@Override		
	    	public void mouseClicked(MouseEvent e) 
	    	{	
	    		System.exit(0); 			
	    	}		
		
	    });
	    
	    return jp1;
	}
	
	
}
