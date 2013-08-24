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

public class DelStuInfo extends JFrame{	
	/**	 * Comment for <code>serialVersionUID</code>	 */	
	private JPanel contentPanel;	
	private StuInfoMng sim;
	/**	 * @param window	 */	
	public DelStuInfo(StuInfoMng simIn) {	
		this.sim = simIn;		
		setResizable(false);
		setTitle("删除学生信息");	
		setBounds(100, 100, 600, 550);
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
	    label.setBounds(160, 80, 30, 40);
	    jp.add(label);
	    
	    JLabel label1 = new JLabel();
	    label1.setText("性别");
	    label1.setBounds(160, 200, 30, 40);
	    jp.add(label1);
	    
	    JLabel label2 = new JLabel();
	    label2.setText("学号");
	    label2.setBounds(160, 320, 30, 40);
	    jp.add(label2);
	    
	    JTextField textfield = new JTextField();
	    textfield.setBounds(230, 80, 200, 40);
	    textfield.setText("");
	    textfield.setBackground(new Color(248, 248, 255));
	    jp.add(textfield);
	    
	    JTextField textfield1 = new JTextField();
	    textfield1.setBounds(230, 200, 200, 40);
	    textfield1.setText("");
	    textfield1.setBackground(new Color(248, 248, 255));
	   jp.add(textfield1);
	    
	    JTextField textfield2 = new JTextField();
	    textfield2.setBounds(230,320, 200, 40);
	    textfield2.setText("");
	    textfield2.setBackground(new Color(248, 248, 255));
	    jp.add(textfield2);
	    
	    JButton btnDelete = new JButton("删除");
	    btnDelete.setBorderPainted(true);
	    btnDelete.setBounds(150, 440, 80, 30);
	    jp.add(btnDelete);
	    
	    JButton btnExit = new JButton("退出");
	    btnExit.setBorderPainted(true);
	    btnExit.setBounds(350, 440, 80, 30);
	    jp.add(btnExit);
	    
	}
}
