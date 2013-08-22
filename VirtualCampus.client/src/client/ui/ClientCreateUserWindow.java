package client.ui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import client.connDb.ClientMsgHelper;
import conn.common.User;

public class ClientCreateUserWindow extends JFrame{
	
	private static final long serialVersionUID = -2552182133838952543L;
	public ClientCreateUserWindow(){
	
		setResizable(false);
		setTitle("Create new user");
		setBounds(100, 100, 750, 300);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setLocationRelativeTo(getOwner());
		
		JPanel createPanel = new JPanel();
		createPanel.setOpaque(false);
		getContentPane().add(createPanel);
		((JPanel) getContentPane()).setOpaque(false);
		createPanel.setLayout(null);
		
		JLabel lbUserList = new JLabel("User List:");
		lbUserList.setBounds(30, 20, 100, 30);
		lbUserList.setHorizontalAlignment(SwingConstants.LEFT);
		lbUserList.setVisible(true);
		createPanel.add(lbUserList);
		
		ClientMsgHelper cmh = new ClientMsgHelper();
		cmh.queryUser();
		cmh.sendMsg();
		cmh.recieveMsg();
		Vector<String> tableHead = new Vector<String>();
	    tableHead.add("username");
	    tableHead.add("role");
		Vector<User> users = (Vector<User>)cmh.getDataInMsg();
		final Vector<Vector<String>> data = new Vector<Vector<String>>();
		final Vector<String> user = new Vector<String>();
		for(int i=0;i<users.size();i++){
			user.add(users.get(i).getuID());
			user.add(users.get(i).getuRole());
			data.add((Vector<String>) user.clone());
			user.removeAllElements();
		}
		final JTable table = new JTable(data, tableHead);
		final JScrollPane scrollpane = new JScrollPane(table);
		scrollpane.setBounds(30, 60, 170, 150);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		scrollpane.setViewportView(table);
		scrollpane.setRowHeaderView(table.getTableHeader());
		createPanel.add(scrollpane);	
		
		JLabel lbcUsername = new JLabel("Username");
		lbcUsername.setBounds(250, 60, 80, 20);
		lbcUsername.setHorizontalAlignment(SwingConstants.LEFT);
		lbcUsername.setVisible(true);
		createPanel.add(lbcUsername);
		final JTextField usernameField = new JTextField();
		usernameField.setBounds(340, 60, 180, 20);
		createPanel.add(usernameField);
		
		JLabel lbcPassword = new JLabel("Password");
		lbcPassword.setBounds(250, 120, 80, 20);
		lbcPassword.setHorizontalAlignment(SwingConstants.LEFT);
		lbcPassword.setVisible(true);
		createPanel.add(lbcPassword);
		final JPasswordField passwordField = new JPasswordField();
		passwordField.setBounds(340, 120, 180, 20);
		createPanel.add(passwordField);
		
		JLabel lbcConfirm = new JLabel("Confirm Password");
		lbcConfirm.setBounds(250, 180, 80, 20);
		lbcConfirm.setHorizontalAlignment(SwingConstants.LEFT);
		lbcConfirm.setVisible(true);
		createPanel.add(lbcConfirm);
		final JPasswordField confirmField = new JPasswordField();
		confirmField.setBounds(340, 180, 180, 30);
		createPanel.add(confirmField);
		
		String[] roleList = {"Student", "Teacher", "Admin" };
		final JComboBox cbcRole = new JComboBox(roleList);
		cbcRole.setBounds(570, 55, 150, 30);
		cbcRole.setVisible(true);
		createPanel.add(cbcRole);
		
	
		JButton btncCreate = new JButton("Create");
		btncCreate.setBorderPainted(true);
		btncCreate.setBounds(570, 180, 150, 30);
		btncCreate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String username = usernameField.getText();
				String password = String.valueOf(passwordField.getPassword());
				String confirm = String.valueOf(confirmField.getPassword());
				String role = String.valueOf(cbcRole.getSelectedItem());	
				if (username.isEmpty() || password.isEmpty() || confirm.isEmpty()){
					JOptionPane.showMessageDialog(null, "用户名/密码不能为空！", "错误", JOptionPane.ERROR_MESSAGE);			
				}
				if (!password.equals(confirm)){
					JOptionPane.showMessageDialog(null, "两次密码不相同！", "错误", JOptionPane.ERROR_MESSAGE);
				}else{
					ClientMsgHelper cmh = new ClientMsgHelper();
					cmh.createUserMsg(username, password, role);
					cmh.sendMsg();
					cmh.recieveMsg();
					boolean cStatus = cmh.getMsg().isSuccess();
					if(cStatus){
						JOptionPane.showMessageDialog(null, "成功！", "信息", JOptionPane.INFORMATION_MESSAGE);
						user.add(username);
						user.add(role);
						data.add(0, (Vector<String>) user.clone());
						user.removeAllElements();
						table.updateUI();
					}else {
						JOptionPane.showMessageDialog(null, "不成功！", "错误", JOptionPane.ERROR_MESSAGE);
					}
				}
				
			}
		});
		createPanel.add(btncCreate);
	}

}
