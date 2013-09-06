package client.ui.studentInfor;

import java.awt.AWTEvent;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import client.connDb.ClientMsgHelper;
import conn.common.ClassInfor;

public class CreateClassWindow extends JFrame{	
	private JPanel contentPanel;	
	private AddStudentInfor asi;
	ClassInfor createClass = new ClassInfor();

	public CreateClassWindow(AddStudentInfor asiIn) {	
		this.asi = asiIn;		
		setResizable(false);
		setTitle("创建新班级");	
		setBounds(100, 100, 400, 200);
		enableEvents(AWTEvent.WINDOW_EVENT_MASK);
		setLocationRelativeTo(getOwner());	
		setType(Type.POPUP);
		
		JPanel jp = new JPanel();
		jp.setOpaque(false);		
	    getContentPane().add(jp);	
	    ((JPanel) getContentPane()).setOpaque(false);
		jp.setLayout(null);
		
	    JLabel label = new JLabel();
	    label.setText("请输入您所在的班级");
	    label.setBounds(30, 30, 120, 40);
	    jp.add(label);
	    
	    final JTextField textfield = new JTextField();
	    textfield.setBounds(30, 80, 200, 40);
	    textfield.setText("");
	    textfield.setBackground(new Color(248, 248, 255));
	    jp.add(textfield);
	    
	    JButton btnOK = new JButton("确定");
	    btnOK.setBorderPainted(true);
	    btnOK.setBounds(270, 40, 80, 30);
	    jp.add(btnOK);
	    btnOK.addMouseListener(new MouseAdapter() 
	    {		
	    	@Override		
	    	public void mouseClicked(MouseEvent arg0) 
	    	{		
	    		createClass.setClassId(textfield.getText().trim());
	    		createClass.setClassMajor("CSE");
	    		createClass.setClassNumber(createClass.getClassId().substring(5));
	    		if(createClass.getClassId().equals(""))
	    		{
	    			JOptionPane.showMessageDialog(null,"班级不能为空");
	    		}
	    		
	    		else if(createClass.getClassId().length()!=6)
	    		{
	    			JOptionPane.showMessageDialog(null,"班级输入错误");
	    		}
	    		
	    		else
	    		{
	    			
	    			try {

	    				ClientMsgHelper cmh = new ClientMsgHelper();
	    				cmh.isExistMsg("vcClass", "cClassID", createClass.getClassId());
	    				cmh.sendMsg();
	    				cmh.recieveMsg();
	    				cmh.disconnect();
						if(cmh.getStatus())
						{
							JOptionPane.showMessageDialog(null,"该班级已经存在");
						}
						else
						{
							String[] cgColumArray = {"cClassID", "cMajor", "cClass"};
							String[] cgDataArray = { createClass.getClassId(), createClass.getClassMajor(), createClass.getClassNumber()};
							cmh.create("vcClass", cgColumArray, cgDataArray);
							cmh.sendMsg();
							dispose();
						}
					} catch (HeadlessException e) {
						e.printStackTrace();
					}
	    		}
	    	}	
	    	
		
	    });
	    
	    JButton btnCancel = new JButton("取消");
	    btnCancel.setBorderPainted(true);
	    btnCancel.setBounds(270, 85, 80, 30);
	    jp.add(btnCancel);
	    btnCancel.addMouseListener(new MouseAdapter() 
	    {		
	    	@Override		
	    	public void mouseClicked(MouseEvent e) 
	    	{	
	    		dispose(); 			
	    	}		
		
	    });
	}
	
	 
}