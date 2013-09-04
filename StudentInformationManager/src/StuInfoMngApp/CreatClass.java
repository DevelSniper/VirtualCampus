package StuInfoMngApp;

import java.awt.AWTEvent;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
/** * @author C5102 * * TODO To change the template for this generated type comment go to * Window - Preferences - Java - Code Style - Code Templates */

public class CreatClass extends JFrame{	
	/**	 * Comment for <code>serialVersionUID</code>	 */	
	private JPanel contentPanel;	
	private AddStuInfo asi;
	ClassData ClassData = new ClassData(null,null,null);
	OperateDB dbConnMng = new OperateDB();

	/**	 * @param window	 */	
	public CreatClass(AddStuInfo asiIn) {	
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
	    		ClassData.setaclassid(textfield.getText().trim());
	    		ClassData.setamajor("CSE");
				ClassData.setaclass(ClassData.aclassid.substring(5));
	    		
	    		if(ClassData.getaclassid().equals(""))
	    		{
	    			JOptionPane.showMessageDialog(null,"班级不能为空");
	    		}
	    		
	    		else if(ClassData.getaclassid().length()!=6)
	    		{
	    			JOptionPane.showMessageDialog(null,"班级输入错误");
	    		}
	    		
	    		else
	    		{
	    			
	    			try {
						if(dbConnMng.ClassExist(ClassData.getaclassid())==true)
						{
							JOptionPane.showMessageDialog(null,"该班级已经存在");
						}
						
						else
						{
							try {
								dbConnMng.AddClass(ClassData);
								dispose();
								

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

