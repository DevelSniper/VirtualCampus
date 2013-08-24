package StuInfoMngApp;
import java.awt.EventQueue;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class  ClientLoginWindow
{	
	public JFrame frame;	
	private JTextField textUserID;
	private JPasswordField passwordField;
	private static ClientLoginWindow window;	
	public static void main(String[] args) 
	{		
		
		EventQueue.invokeLater(new Runnable()

		{		
			public void run()

			{			
				try
				{					
					window = new ClientLoginWindow();	
				} 
				catch (Exception e)
				{		
						e.printStackTrace();		
				}		
		
			}		
			
		});	
		
	}	
	public ClientLoginWindow()

	{		
		
	
		frame = new JFrame();	
	    frame.setResizable(false);	
	    frame.setTitle("Easy SEU Virtual Campus");	
	    frame.setBounds(100, 100, 400, 550);	
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	    frame.setLocationRelativeTo(frame.getOwner());		
	    //背景		
	    JPanel jp = new JPanel();	
	    jp.setOpaque(false);		
	    frame.getContentPane().add(jp);	
	    ((JPanel) frame.getContentPane()).setOpaque(false);	
	    ImageIcon img = new ImageIcon(getClass().getResource("/res/background.png"));	
	    JLabel background = new JLabel(img);	
	    frame.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));	
	    background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
	    jp.setLayout(null);
	    //		直接画在背景上
	    //		JLabel lblUserID = new JLabel("一卡通号/UserID:");
	    //		lblUserID.setBounds(23, 145, 96, 17);
	    //		lblUserID.setHorizontalAlignment(SwingConstants.CENTER);
	    //		lblUserID.setVisible(true);
	    //		jp.add(lblUserID);		
	    textUserID = new JTextField();	
	    textUserID.addKeyListener(new KeyAdapter() 
	    {	
	    	@Override			
	    	public void keyTyped(KeyEvent arg0) 
	    	{		
	    		if(!Character.isDigit(arg0.getKeyChar()))			
				arg0.consume();		
			}		
		});		
	    textUserID.setBounds(80, 205, 220, 30);	
	    jp.add(textUserID);	
	    textUserID.setColumns(10);
	    //		直接画在背景上
	    //		JLabel lblPassword = new JLabel("密码/Password:");
	    //		lblPassword.setBounds(35, 196, 84, 15);
	    //		jp.add(lblPassword);
	    //		lblPassword.setVisible(true);	
	    passwordField = new JPasswordField();	
	    passwordField.setBounds(80, 290, 220, 30);	
	    jp.add(passwordField);
	    JButton btnLogin = new JButton("");
		btnLogin.setBorderPainted(false);	
	    btnLogin.setIcon(new ImageIcon(getClass().getResource("/res/login.png")));	
	    btnLogin.setPressedIcon(new ImageIcon(				"src/res/login1.png"));	
	    btnLogin.setBounds(80, 350, 112, 40);	
	    btnLogin.addMouseListener(new MouseAdapter() 
	    {		
	    	@Override			
	    	public void mouseClicked(MouseEvent arg0) 
	    	{
	    		//				String loginID = textUserID.getText();
	    		//				String password = String.valueOf(passwordField.getPassword());
			MainWindow mw = new MainWindow(window);		
			StuWindow sw = new StuWindow(window);
			mw.setVisible(true);
			sw.setVisible(true);
			}		
		});
	    jp.add(btnLogin);
	    JButton btnReset = new JButton("");
	    btnReset.setIcon(new ImageIcon(getClass().getResource("/res/reset.png")));	
	    btnReset.setPressedIcon(new ImageIcon(				"src/res/reset1.png"));	
	    btnReset.setBorderPainted(false);	
	    btnReset.setBounds(190, 350, 112, 40);	
	    btnReset.addMouseListener(new MouseAdapter() 
	    {		
	    	@Override		
	    	public void mouseClicked(MouseEvent arg0) 
	    	{		
	    		textUserID.setText("");			
	    		passwordField.setText("");			
	    	}		
		
	    });		
	    jp.add(btnReset);
	    frame.setVisible(true);	
	}	
	
	
	
	
	
}
