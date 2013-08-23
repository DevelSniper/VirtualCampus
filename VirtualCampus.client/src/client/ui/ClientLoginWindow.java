package client.ui;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import conn.common.User;
import client.connDb.ClientMsgHelper;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ClientLoginWindow {

	public JFrame frame;
	private JTextField textUserID;
	private JPasswordField passwordField;
	private static ClientLoginWindow window;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new ClientLoginWindow();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ClientLoginWindow() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setTitle("Easy SEU Virtual Campus");
		frame.setBounds(100, 100, 400, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(frame.getOwner());
		
		
		JPanel jp = new JPanel();
		jp.setOpaque(false);
		frame.getContentPane().add(jp);
		((JPanel) frame.getContentPane()).setOpaque(false);
		ImageIcon img = new ImageIcon(getClass().getResource("/res/background.png"));
		JLabel background = new JLabel(img);
		frame.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));
		background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());

		jp.setLayout(null);
		textUserID = new JTextField();
		textUserID.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				if(!Character.isDigit(arg0.getKeyChar()))
					arg0.consume();
			}


		});
		textUserID.setBounds(80, 205, 220, 30);
		jp.add(textUserID);
		textUserID.setColumns(10);
		passwordField = new JPasswordField();
		passwordField.setBounds(80, 290, 220, 30);
		jp.add(passwordField);

		JButton btnLogin = new JButton("");
		btnLogin.setBorderPainted(false);	
		btnLogin.setIcon(new ImageIcon(getClass().getResource("/res/login.png")));
		btnLogin.setPressedIcon(new ImageIcon(
				"src/res/login1.png"));
		btnLogin.setBounds(80, 350, 112, 40);

		btnLogin.addMouseListener(new MouseAdapter() {
			// 登陆按钮监听
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String username = textUserID.getText();
				String password = String.valueOf(passwordField.getPassword());
				
				if (username.isEmpty() || password.isEmpty()){
					JOptionPane.showMessageDialog(null, "用户名/密码不能为空！", "错误",JOptionPane.ERROR_MESSAGE);			
				}else{
					ClientMsgHelper cmh = new ClientMsgHelper();
					cmh.loginMsg(username, password);
					cmh.sendMsg();
					cmh.recieveMsg();
					User userInMsg = (User) cmh.getDataInMsg();
					if (userInMsg == null){
						JOptionPane.showMessageDialog(null, "用户名/密码错误！", "错误",JOptionPane.ERROR_MESSAGE);
					} else {
						ClientMenuWindow cmw = new ClientMenuWindow(window, userInMsg);
						cmw.setVisible(true);
					}
					cmh.disconnect();
//					User user = new User("213110561", "123456", "student");
//					ClientMenuWindow cmw = new ClientMenuWindow(window, user);
//					cmw.setVisible(true);
				}			
			}
		});
		jp.add(btnLogin);
		
		JButton btnReset = new JButton("");
		btnReset.setIcon(new ImageIcon(getClass().getResource("/res/reset.png")));
		btnReset.setPressedIcon(new ImageIcon(
				"src/res/reset1.png"));
		btnReset.setBorderPainted(false);
		btnReset.setBounds(190, 350, 112, 40);
		btnReset.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				textUserID.setText("");
				passwordField.setText("");
			}
		});

		jp.add(btnReset);
		
		frame.setVisible(true);
	}

	public static ClientLoginWindow getWindow() {
		return window;
	}

	public static void setWindow(ClientLoginWindow window) {
		ClientLoginWindow.window = window;
		
	}

}
