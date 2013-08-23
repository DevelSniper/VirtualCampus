package client.ui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import conn.common.Student;
import conn.common.User;
import client.connDb.ClientMsgHelper;

public class ClientProfileWindow extends JFrame{
	private static final long serialVersionUID = 9207226989362655847L;
	private User user;
	private Student student;
	
	public ClientProfileWindow(User userIn){
		this.user = userIn;
		
		ClientMsgHelper cmh = new ClientMsgHelper();
		cmh.queryStudent(user.getuID());
		cmh.sendMsg();
		cmh.recieveMsg();
		this.student = (Student) cmh.getDataInMsg();
		setResizable(false);
		setTitle("Profile");
		setBounds(100, 100, 600, 300);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setLocationRelativeTo(getOwner());
		JPanel profilePanel = new JPanel();
		profilePanel.setOpaque(false);
		getContentPane().add(profilePanel);
		((JPanel) getContentPane()).setOpaque(false);
		profilePanel.setLayout(null);
		
		JLabel lbCard = new JLabel("Card:");
		lbCard.setBounds(30, 20, 100, 30);
		lbCard.setHorizontalAlignment(SwingConstants.LEFT);
		lbCard.setVisible(true);
		profilePanel.add(lbCard);				
		JTextField tfCard = new JTextField(student.getUserCard());
		tfCard.setBounds(80, 20,  180, 30);
		tfCard.setEditable(false);
		tfCard.setHorizontalAlignment(SwingConstants.LEFT);
		tfCard.setVisible(true);
		profilePanel.add(tfCard);

		JLabel lbRole = new JLabel(student.getUserRole());
		lbRole.setBounds(350, 20, 225, 30);
		lbRole.setHorizontalAlignment(SwingConstants.RIGHT);
		lbRole.setVisible(true);
		profilePanel.add(lbRole);	
		
		JLabel lbName = new JLabel("Name:");
		lbName.setBounds(30, 60, 100, 30);
		lbName.setHorizontalAlignment(SwingConstants.LEFT);
		lbName.setVisible(true);
		profilePanel.add(lbName);	
		JTextField tfName = new JTextField(student.getUserName());
		tfName.setBounds(80, 60,  180, 30);
		tfName.setEditable(false);
		tfName.setHorizontalAlignment(SwingConstants.LEFT);
		tfName.setVisible(true);
		profilePanel.add(tfName);
		
		JLabel lbID = new JLabel("ID:");
		lbID.setBounds(330, 60, 100, 30);
		lbID.setHorizontalAlignment(SwingConstants.LEFT);
		lbID.setVisible(true);
		profilePanel.add(lbID);	
		JTextField tfID = new JTextField(student.getUserID());
		tfID.setBounds(400, 60,  180, 30);
		tfID.setEditable(false);
		tfID.setHorizontalAlignment(SwingConstants.LEFT);
		tfID.setVisible(true);
		profilePanel.add(tfID);
		
		JLabel lbSex = new JLabel("Sex:");
		lbSex.setBounds(30, 100, 100, 30);
		lbSex.setHorizontalAlignment(SwingConstants.LEFT);
		lbSex.setVisible(true);
		profilePanel.add(lbSex);	
		JTextField tfSex = new JTextField(student.getUserSex());
		tfSex.setBounds(80, 100,  180, 30);
		tfSex.setEditable(false);
		tfSex.setHorizontalAlignment(SwingConstants.LEFT);
		tfSex.setVisible(true);
		profilePanel.add(tfSex);
		
		JLabel lbClass = new JLabel("Class:");
		lbClass.setBounds(330, 100, 100, 30);
		lbClass.setHorizontalAlignment(SwingConstants.LEFT);
		lbClass.setVisible(true);
		profilePanel.add(lbClass);	
		JTextField tfClass = new JTextField(student.getUserClass());
		tfClass.setBounds(400, 100,  180, 30);
		tfClass.setEditable(false);
		tfClass.setHorizontalAlignment(SwingConstants.LEFT);
		tfClass.setVisible(true);
		profilePanel.add(tfClass);		
		
		JLabel lbBirthday = new JLabel("Birtday:");
		lbBirthday.setBounds(30, 140, 100, 30);
		lbBirthday.setHorizontalAlignment(SwingConstants.LEFT);
		lbBirthday.setVisible(true);
		profilePanel.add(lbBirthday);	
		JTextField tfBirthday = new JTextField(student.getUserBirthday());
		tfBirthday.setBounds(80, 140,  180, 30);
		tfBirthday.setEditable(false);
		tfBirthday.setHorizontalAlignment(SwingConstants.LEFT);
		tfBirthday.setVisible(true);
		profilePanel.add(tfBirthday);
		

		JLabel lbHometown = new JLabel("Home:");
		lbHometown.setBounds(30, 180, 100, 30);
		lbHometown.setHorizontalAlignment(SwingConstants.LEFT);
		lbHometown.setVisible(true);
		profilePanel.add(lbHometown);	
		JTextField tfHometown = new JTextField(student.getUserHometown());
		tfHometown.setBounds(80, 180,  180, 30);
		tfHometown.setEditable(false);
		tfHometown.setHorizontalAlignment(SwingConstants.LEFT);
		tfHometown.setVisible(true);
		profilePanel.add(tfHometown);
		
		JLabel lbPassword = new JLabel("New Pwd:");
		lbPassword.setBounds(330, 140, 100, 30);
		lbPassword.setHorizontalAlignment(SwingConstants.LEFT);
		lbPassword.setVisible(true);
		profilePanel.add(lbPassword);	
		final JPasswordField tfPassword = new JPasswordField("");
		tfPassword.setBounds(400, 140,  180, 30);
		tfPassword.setHorizontalAlignment(SwingConstants.CENTER);
		profilePanel.add(tfPassword);
		
		JLabel lbConPassword = new JLabel("Confirm:");
		lbConPassword.setBounds(330, 180, 100, 30);
		lbConPassword.setHorizontalAlignment(SwingConstants.LEFT);
		lbConPassword.setVisible(true);
		profilePanel.add(lbConPassword);	
		final JPasswordField tfConPassword = new JPasswordField("");
		tfConPassword.setBounds(400, 180,  180, 30);
		tfConPassword.setHorizontalAlignment(SwingConstants.CENTER);
		profilePanel.add(tfConPassword);
		
		JButton btnChangePwd = new JButton("Change Password");
		btnChangePwd.setBorderPainted(true);
		btnChangePwd.setBounds(330, 240, 250, 30);
		btnChangePwd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String password = String.valueOf(tfPassword.getPassword());
				String confirm = String.valueOf(tfConPassword.getPassword());
				
				if (!password.equals(confirm)){
					JOptionPane.showMessageDialog(null, "两次密码不相同！", "错误", JOptionPane.ERROR_MESSAGE);
				}else{
					ClientMsgHelper cmh = new ClientMsgHelper();
					cmh.update("vcUser","uID",user.getuID() , "uPwd",  password);
					cmh.sendMsg();
					cmh.recieveMsg();
					boolean cStatus = cmh.getMsg().isSuccess();
					if(cStatus){
						JOptionPane.showMessageDialog(null, "成功！", "信息", JOptionPane.INFORMATION_MESSAGE);
					}else {
						JOptionPane.showMessageDialog(null, "不成功！", "错误", JOptionPane.ERROR_MESSAGE);
					}
				}
		
			}
		});
		profilePanel.add(btnChangePwd);
		
	}

}
