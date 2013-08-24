package StuInfoMngApp;

import java.awt.AWTEvent;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Vector;

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

public class AddStuInfo extends JFrame{	
	/**	 * Comment for <code>serialVersionUID</code>	 */	
	private JPanel contentPanel;	
	private StuInfoMng sim;
	private static AddStuInfo window;
	OperateDB dbConnMng = new OperateDB();
	
	String aid;
	String aname;
	String aclass;
	String asex;
	String abirthday;
	String abirthplace;
	String acard;
	
	/**	 * @param window	 */	
	public AddStuInfo(StuInfoMng simIn) {	
		this.sim = simIn;		
		setResizable(false);
		setTitle("添加学生信息");	
		setBounds(100, 100, 800, 550);
		enableEvents(AWTEvent.WINDOW_EVENT_MASK);
		setLocationRelativeTo(getOwner());	
		setType(Type.POPUP);
		
		final JPanel jp = new JPanel();
		jp.setOpaque(false);		
	    getContentPane().add(jp);	
	    ((JPanel) getContentPane()).setOpaque(false);
		jp.setLayout(null);
		
	    JLabel label = new JLabel();
	    label.setText("姓名");
	    label.setBounds(80, 30, 30, 40);
	    jp.add(label);
	    
	    JLabel label1 = new JLabel();
	    label1.setText("性别");
	    label1.setBounds(450, 30, 30, 40);
	    jp.add(label1);
	    
	    JLabel label2 = new JLabel();
	    label2.setText("学号");
	    label2.setBounds(80, 150, 30, 40);
	    jp.add(label2);
	    
	    JLabel label3 = new JLabel();
	    label3.setText("一卡通号");
	    label3.setBounds(450, 150, 60, 40);
	    jp.add(label3);
	    
	    JLabel label4 = new JLabel();
	    label4.setText("班级");
	    label4.setBounds(80, 270, 30, 40);
	    jp.add(label4);
	    
	    JLabel label5 = new JLabel();
	    label5.setText("出生日期");
	    label5.setBounds(450, 270, 60, 40);
	    jp.add(label5);
	    
	    JLabel label6 = new JLabel();
	    label6.setText("籍贯");
	    label6.setBounds(230, 390, 30, 40);
	    jp.add(label6);
	    
	    final JTextField textfield = new JTextField();
	    textfield.setBounds(150, 30, 150, 40);
	    textfield.setText("");
	    textfield.setBackground(new Color(248, 248, 255));
	    jp.add(textfield);
	    
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
	    jp.add(textfield1);
	    
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
	    jp.add(textfield2);
	    
	    final JTextField textfield4 = new JTextField();
	    textfield4.setBounds(520, 270, 150, 40);
	    textfield4.setText("");
	    textfield4.setBackground(new Color(248, 248, 255));
	   jp.add(textfield4);
	    
	    final JTextField textfield5 = new JTextField();
	    textfield5.setBounds(300, 390, 200, 40);
	    textfield5.setText("");
	    textfield5.setBackground(new Color(248, 248, 255));
	    jp.add(textfield5);
	    
	    final JComboBox combobox = new JComboBox();
	    combobox.addItem("男");
	    combobox.addItem("女");
	    combobox.setBounds(520, 30, 150, 40);
	    combobox.setBackground(new Color(248, 248, 255));
	    jp.add(combobox);
	    
	    final JComboBox combobox1 = new JComboBox();
	    combobox1.setBounds(150, 270, 150, 40);
	    combobox1.setBackground(new Color(248, 248, 255));
	    jp.add(combobox1);
		try 
		{
			for(int i=0;i<dbConnMng.GetClass().size();i++)
			{
				combobox1.addItem(dbConnMng.GetClass().get(i));
				combobox1.updateUI();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    combobox1.addMouseListener(new MouseAdapter() 
	    {		
	    	@Override		
	    	public void mouseClicked(MouseEvent arg0) 
	    	{
	    		try {
					if(dbConnMng.GetClass().size()>combobox1.getItemCount())
					{
						combobox1.removeAllItems();
					    for(int i=0;i<dbConnMng.GetClass().size();i++)
					    {
							combobox1.addItem(dbConnMng.GetClass().get(i));
						    combobox1.updateUI();
					    }
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    		
	    	}	
		
	    });
	    
	    JButton btnSubmit = new JButton("增加");
	    btnSubmit.setBorderPainted(true);
	    btnSubmit.setBounds(250, 480, 80, 30);
	    jp.add(btnSubmit);
	    btnSubmit.addMouseListener(new MouseAdapter() 
	    {		
	    	@Override		
	    	public void mouseClicked(MouseEvent arg0) 
	    	{		
	    		aname = textfield.getText().trim();
	    		aid = textfield1.getText().trim();
	    		asex = (String)combobox.getSelectedItem();
	    		aclass = (String)combobox1.getSelectedItem();
	    		abirthday = textfield4.getText().trim();
	    		acard = textfield2.getText().trim();
	    		abirthplace = textfield5.getText().trim();
	    		
	    		if(aid.equals(""))
	    		{
	    			JOptionPane.showMessageDialog(null,"学号不能为空");
	    		}
	    		
	    		else if(aid.length()!=8)
	    		{
	    			JOptionPane.showMessageDialog(null,"学号输入错误");
	    		}
	    		
	    		else if(aname.equals(""))
	    		{
	    			JOptionPane.showMessageDialog(null,"姓名不能为空");
	    		}
	    		
	    		else
	    		{	
	    			try {
						if(dbConnMng.StuExist(aid)==true)
						{
							JOptionPane.showMessageDialog(null,"该学生已经存在");
						}
						
						else
						{
							try {
								dbConnMng.AddStuInfo(aname,asex,aid,acard,aclass,abirthday,abirthplace);
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
	    
	    
	    JButton btnCreat = new JButton("创建班级");
	    btnCreat.setBorderPainted(true);
	    btnCreat.setBounds(310, 275, 100, 30);
	    btnCreat.addMouseListener(new MouseAdapter() 
	    {		
	    	@Override		
	    	public void mouseClicked(MouseEvent arg0) 
	    	{		
	    		CreatClass cc = new CreatClass(window);		
				cc.setVisible(true);			
	    	}		
		
	    });	
	    jp.add(btnCreat);
	    
	    JButton btnExit = new JButton("退出");
	    btnExit.setBorderPainted(true);
	    btnExit.setBounds(470, 480, 80, 30);
	    jp.add(btnExit);
	    btnExit.addMouseListener(new MouseAdapter() 
	    {		
	    	@Override		
	    	public void mouseClicked(MouseEvent e) 
	    	{	
	    		dispose(); 			
	    	}		
		
	    });
	    
	   
	}
	
	
}
