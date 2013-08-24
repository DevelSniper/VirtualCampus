package StuInfoMngApp;

import java.awt.AWTEvent;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
/** * @author C5102 * * TODO To change the template for this generated type comment go to * Window - Preferences - Java - Code Style - Code Templates */

public class StuWindow extends JFrame{	
	/**	 * Comment for <code>serialVersionUID</code>	 */	
	private JPanel contentPanel;	
	private ClientLoginWindow clw;
	/**	 * @param window	 */	
	public StuWindow(ClientLoginWindow clwIn) {	
		this.clw = clwIn;		
		setResizable(false);
		setTitle("学生个人信息查看");	
		setBounds(100, 100, 800, 550);
		enableEvents(AWTEvent.WINDOW_EVENT_MASK);
		setLocationRelativeTo(getOwner());	
		setType(Type.POPUP);
		
		JPanel jp = new JPanel();
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
	    label6.setBounds(80, 390, 30, 40);
	    jp.add(label6);
	    
	    JLabel label7 = new JLabel();
	    label7.setText("专业");
	    label7.setBounds(450, 390, 30, 40);
	    jp.add(label7);
	    
	    JTextField textfield = new JTextField();
	    textfield.setBounds(150, 30, 150, 40);
	    textfield.setText("");
	    textfield.setBackground(new Color(248, 248, 255));
	    jp.add(textfield);
	    
	    JTextField textfield1 = new JTextField();
	    textfield1.setBounds(520, 30, 150, 40);
	    textfield1.setText("");
	    textfield1.setBackground(new Color(248, 248, 255));
	    jp.add(textfield1);
	    
	    JTextField textfield2 = new JTextField();
	    textfield2.setBounds(150, 150, 150, 40);
	    textfield2.setText("");
	    textfield2.setBackground(new Color(248, 248, 255));
	    jp.add(textfield2);
	    
	    JTextField textfield3 = new JTextField();
	    textfield3.setBounds(520, 150, 150, 40);
	    textfield3.setText("");
	    textfield3.setBackground(new Color(248, 248, 255));
	   jp.add(textfield3);
	    
	    JTextField textfield4 = new JTextField();
	    textfield4.setBounds(150, 270, 150, 40);
	    textfield4.setText("");
	    textfield4.setBackground(new Color(248, 248, 255));
	   jp.add(textfield4);
	    
	    JTextField textfield5 = new JTextField();
	    textfield5.setBounds(520, 270, 150, 40);
	    textfield5.setText("");
	    textfield5.setBackground(new Color(248, 248, 255));
	    jp.add(textfield5);
	    
	    JTextField textfield6 = new JTextField();
	    textfield6.setBounds(150, 390, 150, 40);
	    textfield6.setText("");
	    textfield6.setBackground(new Color(248, 248, 255));
	    jp.add(textfield6);
	    
	    JTextField textfield7 = new JTextField();
	    textfield7.setBounds(520, 390, 150, 40);
	    textfield7.setText("");
	    textfield7.setBackground(new Color(248, 248, 255));
	    jp.add(textfield7);
	    
	    JButton btnOK = new JButton("确定");
	    btnOK.setBorderPainted(true);
	    btnOK.setBounds(250, 480, 80, 30);
	    jp.add(btnOK);
	    
	    JButton btnExit = new JButton("退出");
	    btnExit.setBorderPainted(true);
	    btnExit.setBounds(470, 480, 80, 30);
	    jp.add(btnExit);
	    
	}
	    
}

