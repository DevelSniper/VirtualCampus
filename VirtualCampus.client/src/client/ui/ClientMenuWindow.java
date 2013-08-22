/*
 * Created on 2013-8-21
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package client.ui;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import client.connDb.ClientMsgHelper;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import conn.common.User;


/**
 * @author C5102
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class ClientMenuWindow extends JFrame{
	/**
	 * Comment for <code>serialVersionUID</code>
	 */
	private static final long serialVersionUID = 3617579318470127671L;
	private JPanel contentPanel;
	private ClientLoginWindow clw;
	private User user;
	/**
	 * @param window
	 */
	public ClientMenuWindow(ClientLoginWindow clwIn, User userIn) {
		this.clw = clwIn;
		this.user = userIn;

		setResizable(false);
		setTitle("Menu");
		setBounds(100, 100, 800, 550);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(getOwner());
		setType(Type.POPUP);

		JPanel jp = new JPanel();
		jp.setOpaque(false);
		getContentPane().add(jp);
		((JPanel) getContentPane()).setOpaque(false);
		jp.setLayout(null);
		
		JLabel lbUserRole = new JLabel(user.getuRole());
		lbUserRole.setBounds(700, 10, 50, 20);
		lbUserRole.setHorizontalAlignment(SwingConstants.CENTER);
		lbUserRole.setVisible(true);
		jp.add(lbUserRole);
		
		if (user.getuRole().equals("admin")){		
			JButton btnCreate = new JButton("Create");
			btnCreate.setBorderPainted(true);
			btnCreate.setBounds(650, 350, 100, 30);
			btnCreate.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					ClientCreateUserWindow ccuw = new ClientCreateUserWindow();
					ccuw.setVisible(true);
				}
			});
			jp.add(btnCreate);
		}
		JButton btnProfile = new JButton("Profile");
		btnProfile.setBorderPainted(true);
		btnProfile.setBounds(650, 400, 100, 30);
		btnProfile.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ClientProfileWindow cpw = new ClientProfileWindow(user);
				cpw.setVisible(true);
			}

		});
		jp.add(btnProfile);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setBorderPainted(true);
		btnLogout.setBounds(650, 450, 100, 30);
		btnLogout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				setVisible(false);
				clw.frame.setVisible(true);
				
			}

		});
		jp.add(btnLogout);
		
		clw.frame.setVisible(false);
		
	}
	public JPanel getContentPanel() {
		return contentPanel;
	}
	public void setContentPanel(JPanel contentPanel) {
		this.contentPanel = contentPanel;
	}

}
