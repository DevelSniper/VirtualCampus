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
		setTitle("ѧ��������Ϣ�鿴");	
		setBounds(100, 100, 600, 450);
		enableEvents(AWTEvent.WINDOW_EVENT_MASK);
		setLocationRelativeTo(getOwner());	
		setType(Type.POPUP);
		
		JPanel jp = new JPanel();
		jp.setOpaque(false);		
	    getContentPane().add(jp);	
	    ((JPanel) getContentPane()).setOpaque(false);
		jp.setLayout(null);
		
	    JLabel label = new JLabel();
	    label.setText("����");
	    label.setBounds(50, 20, 30, 40);
	    jp.add(label);
	    
	    JLabel label1 = new JLabel();
	    label1.setText("�Ա�");
	    label1.setBounds(340, 20, 30, 40);
	    jp.add(label1);
	    
	    JLabel label2 = new JLabel();
	    label2.setText("ѧ��");
	    label2.setBounds(50, 110, 30, 40);
	    jp.add(label2);
	    
	    JLabel label3 = new JLabel();
	    label3.setText("һ��ͨ��");
	    label3.setBounds(340, 110, 60, 40);
	    jp.add(label3);
	    
	    JLabel label4 = new JLabel();
	    label4.setText("�༶");
	    label4.setBounds(50, 200, 30, 40);
	    jp.add(label4);
	    
	    JLabel label5 = new JLabel();
	    label5.setText("��������");
	    label5.setBounds(340, 200, 60, 40);
	    jp.add(label5);
	    
	    JLabel label6 = new JLabel();
	    label6.setText("����");
	    label6.setBounds(50, 290, 30, 40);
	    jp.add(label6);
	    
	    JLabel label7 = new JLabel();
	    label7.setText("רҵ");
	    label7.setBounds(340, 290, 30, 40);
	    jp.add(label7);
	    
	    JTextField textfield = new JTextField();
	    textfield.setBounds(80, 20, 150, 40);
	    textfield.setText("");
	    textfield.setBackground(new Color(248, 248, 255));
	    jp.add(textfield);
	    
	    JTextField textfield1 = new JTextField();
	    textfield1.setBounds(400, 20, 150, 40);
	    textfield1.setText("");
	    textfield1.setBackground(new Color(248, 248, 255));
	    jp.add(textfield1);
	    
	    JTextField textfield2 = new JTextField();
	    textfield2.setBounds(80, 110, 150, 40);
	    textfield2.setText("");
	    textfield2.setBackground(new Color(248, 248, 255));
	    jp.add(textfield2);
	    
	    JTextField textfield3 = new JTextField();
	    textfield3.setBounds(400, 110, 150, 40);
	    textfield3.setText("");
	    textfield3.setBackground(new Color(248, 248, 255));
	   jp.add(textfield3);
	    
	    JTextField textfield4 = new JTextField();
	    textfield4.setBounds(80, 200, 150, 40);
	    textfield4.setText("");
	    textfield4.setBackground(new Color(248, 248, 255));
	   jp.add(textfield4);
	    
	    JTextField textfield5 = new JTextField();
	    textfield5.setBounds(400, 200, 150, 40);
	    textfield5.setText("");
	    textfield5.setBackground(new Color(248, 248, 255));
	    jp.add(textfield5);
	    
	    JTextField textfield6 = new JTextField();
	    textfield6.setBounds(80, 290, 150, 40);
	    textfield6.setText("");
	    textfield6.setBackground(new Color(248, 248, 255));
	    jp.add(textfield6);
	    
	    JTextField textfield7 = new JTextField();
	    textfield7.setBounds(400, 290, 150, 40);
	    textfield7.setText("");
	    textfield7.setBackground(new Color(248, 248, 255));
	    jp.add(textfield7);
	    
	    JButton btnOK = new JButton("ȷ��");
	    btnOK.setBorderPainted(true);
	    btnOK.setBounds(150, 380, 80, 30);
	    jp.add(btnOK);
	    
	    JButton btnExit = new JButton("�˳�");
	    btnExit.setBorderPainted(true);
	    btnExit.setBounds(370, 380, 80, 30);
	    jp.add(btnExit);
	    
	}
	    
}
