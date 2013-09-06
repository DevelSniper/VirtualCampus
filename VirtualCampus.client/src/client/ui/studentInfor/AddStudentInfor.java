package client.ui.studentInfor;

import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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
import javax.swing.JTextField;

import client.connDb.ClientMsgHelper;

public class AddStudentInfor extends JFrame{
	JPanel jp1 = new JPanel();
    private static AddStudentInfor window;
    
	public JPanel jpInit()
	{
		 
		jp1.setOpaque(false);		
	    	
	    jp1.setLayout(null);
		
		
		JLabel label = new JLabel();
	    label.setText("姓名");
	    label.setBounds(80, 50, 30, 40);
	    jp1.add(label);
	    
	    JLabel label1 = new JLabel();
	    label1.setText("性别");
	    label1.setBounds(450, 50, 30, 40);
	    jp1.add(label1);
	    
	    JLabel label2 = new JLabel();
	    label2.setText("学号");
	    label2.setBounds(80, 150, 30, 40);
	    jp1.add(label2);
	    
	    JLabel label3 = new JLabel();
	    label3.setText("一卡通号");
	    label3.setBounds(450, 150, 60, 40);
	    jp1.add(label3);
	    
	    JLabel label4 = new JLabel();
	    label4.setText("班级");
	    label4.setBounds(80, 250, 30, 40);
	    jp1.add(label4);
	    
	    JLabel label5 = new JLabel();
	    label5.setText("出生日期");
	    label5.setBounds(450, 250, 60, 40);
	    jp1.add(label5);
	    
	    JLabel label6 = new JLabel();
	    label6.setText("籍贯");
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
	    combobox.addItem("男");
	    combobox.addItem("女");
	    combobox.setBounds(520, 50, 150, 40);
	    combobox.setBackground(new Color(248, 248, 255));
	    jp1.add(combobox);
	    
	    final JComboBox combobox1 = new JComboBox();
	    combobox1.setBounds(150, 250, 150, 40);
	    combobox1.setBackground(new Color(248, 248, 255));
	    jp1.add(combobox1);
		
	    ClientMsgHelper  cmh = new ClientMsgHelper();
		String[] colum = {"cClassID"};
		cmh.query("vcClass", colum);
		cmh.sendMsg();
		cmh.recieveMsg();
		Vector<Vector<String>> result =  (Vector<Vector<String>>) cmh.getDataInMsg();
		for (int i=0; i<result.size(); i++){
			combobox1.addItem(result.get(i).get(0));
		}
		combobox1.updateUI();

		
	    
	    JButton btnSubmit = new JButton("增加");
	    btnSubmit.setBorderPainted(true);
	    btnSubmit.setBounds(250, 450, 80, 30);
	    jp1.add(btnSubmit);
	    btnSubmit.addMouseListener(new MouseAdapter() 
	    {		
	    	@Override		
	    	public void mouseClicked(MouseEvent arg0) 
	    	{		
	    		
	    		String studentName = textfield.getText().trim();
	    		String studentID = textfield1.getText().trim();
	    		String studentSex = (String)combobox.getSelectedItem();
	    		String studentClassID = (String)combobox1.getSelectedItem();
	    		String studentBirthday = textfield4.getText().trim();
	    		String studentCard = textfield2.getText().trim();
	    		String studentHomeTown = textfield5.getText().trim();
	    		ClientMsgHelper cmh = new ClientMsgHelper();
				String[] cgColumArray = {"sCard", "sID", "sName", "sSex", "sClassID", "sBirthday", "sHometown"};
				String[] cgDataArray = {studentCard, studentID, studentName, studentSex, studentClassID, studentClassID, studentHomeTown};
				cmh.create("vcStudent", cgColumArray, cgDataArray);
				cmh.sendMsg();
	    				
	    	}
		
	    });
	    
	    
	    JButton btnCreat = new JButton("创建班级");
	    btnCreat.setBorderPainted(true);
	    btnCreat.setBounds(310, 255, 100, 30);
	    btnCreat.addMouseListener(new MouseAdapter() 
	    {		
	    	@Override		
	    	public void mouseClicked(MouseEvent arg0) 
	    	{		
	    		CreateClassWindow ccw = new CreateClassWindow(window);		
				ccw.setVisible(true);			
	    	}		
		
	    });	
	    jp1.add(btnCreat);
	    
	    JButton btnExit = new JButton("退出");
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