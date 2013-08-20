package client.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;
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
					setWindow(new ClientLoginWindow());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ClientLoginWindow() {
		initialize();
	}

	protected void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setTitle("Easy SEU Virtual Campus");
		frame.setBounds(100, 100, 600, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(frame.getOwner());
		JPanel jp = new JPanel();

		jp.setOpaque(false);
		frame.getContentPane().add(jp);
		setBackground();
		jp.setLayout(null);
		JLabel lblUserID = new JLabel("一卡通号/UserID:");
		lblUserID.setBounds(23, 145, 96, 17);
		lblUserID.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserID.setVisible(true);
		jp.add(lblUserID);
		textUserID = new JTextField();
		textUserID.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				if(!Character.isDigit(arg0.getKeyChar()))
					arg0.consume();
			}


		});
		textUserID.setBounds(151, 146, 276, 40);
		jp.add(textUserID);
		textUserID.setColumns(10);
		JLabel lblPassword = new JLabel("密码/Password:");
		lblPassword.setBounds(35, 196, 84, 15);
		jp.add(lblPassword);
		lblPassword.setVisible(true);
		passwordField = new JPasswordField();
		passwordField.setBounds(151, 212, 276, 40);
		jp.add(passwordField);

		JButton btnLogin = new JButton("登陆");
		btnLogin.setBorderPainted(true);

		btnLogin.setBounds(443, 146, 112, 40);

		btnLogin.addMouseListener(new MouseAdapter() {

		});
		jp.add(btnLogin);

		JButton btnReset = new JButton("重置");
		btnReset.setBorderPainted(true);
		btnReset.setBounds(443, 212, 112, 40);
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

	private void setBackground() {
		((JPanel) frame.getContentPane()).setOpaque(true);
	}

	public static ClientLoginWindow getWindow() {
		return window;
	}

	public static void setWindow(ClientLoginWindow window) {
		ClientLoginWindow.window = window;
	}

}
