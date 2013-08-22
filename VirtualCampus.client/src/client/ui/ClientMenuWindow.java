/*
 * Created on 2013-8-21
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package client.ui;

import javax.swing.JFrame;
import javax.swing.JPanel;


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
	/**
	 * @param window
	 */
	public ClientMenuWindow(ClientLoginWindow clwIn) {
		this.clw = clwIn;
		setResizable(false);
		setTitle("Menu");
		setBounds(100, 100, 800, 550);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(getOwner());
		setType(Type.POPUP);
		
		clw.frame.setVisible(false);
		
	}
	public JPanel getContentPanel() {
		return contentPanel;
	}
	public void setContentPanel(JPanel contentPanel) {
		this.contentPanel = contentPanel;
	}

}
