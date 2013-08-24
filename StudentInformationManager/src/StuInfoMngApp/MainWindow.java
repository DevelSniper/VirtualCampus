package StuInfoMngApp;

import java.awt.AWTEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
/** * @author C5102 * * TODO To change the template for this generated type comment go to * Window - Preferences - Java - Code Style - Code Templates */

public class MainWindow extends JFrame{	
	/**	 * Comment for <code>serialVersionUID</code>	 */	
	private JPanel contentPanel;	
	private ClientLoginWindow clw;
	private static MainWindow window;
	/**	 * @param window	 */	
	public MainWindow(ClientLoginWindow clwIn) {	
		this.clw = clwIn;		
		setResizable(false);
		setTitle("学生学籍管理系统");	
		setBounds(100, 100, 800, 550);
		enableEvents(AWTEvent.WINDOW_EVENT_MASK);
		setLocationRelativeTo(getOwner());	
		setType(Type.POPUP);
		
		JPanel jp = new JPanel();	
	    jp.setOpaque(false);		
	    getContentPane().add(jp);	
	    ((JPanel) getContentPane()).setOpaque(false);	
	    ImageIcon img = new ImageIcon(getClass().getResource("/res/mainwindow.png"));	
	    JLabel background = new JLabel(img);	
	    getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));	
	    background.setBounds(-75, -15, img.getIconWidth(), img.getIconHeight());
	    jp.setLayout(null);
	    
	    JButton btnInfoMng = new JButton("学生信息管理");
	    btnInfoMng.setBorderPainted(true);
	    btnInfoMng.setBounds(600, 70, 112, 40);
	    btnInfoMng.addMouseListener(new MouseAdapter() 
	    {		
	    	@Override		
	    	public void mouseClicked(MouseEvent arg0) 
	    	{		
	    		StuInfoMng sim = new StuInfoMng(window);		
				sim.setVisible(true);			
	    	}		
		
	    });	
	    jp.add(btnInfoMng);
	    
	    JButton btnQuery = new JButton("学生信息查询");
	    btnQuery.setBorderPainted(true);
	    btnQuery.setBounds(600, 180, 112, 40);
	    btnQuery.addMouseListener(new MouseAdapter() 
	    {		
	    	@Override		
	    	public void mouseClicked(MouseEvent arg0) 
	    	{		
	    		StuInfoQuery siq = new StuInfoQuery(window);		
				siq.setVisible(true);			
	    	}		
		
	    });	
	    jp.add(btnQuery);
	    
	    JButton btnStatistic = new JButton("学生信息统计");
	    btnStatistic.setBorderPainted(true);
	    btnStatistic.setBounds(600, 290, 112, 40);
	    btnStatistic.addMouseListener(new MouseAdapter() 
	    {		
	    	@Override		
	    	public void mouseClicked(MouseEvent arg0) 
	    	{		
	    		StuInfoStatis sis = new StuInfoStatis(window);		
				sis.setVisible(true);			
	    	}		
		
	    });
	    jp.add(btnStatistic);
	    
	    JButton btnHelp = new JButton("帮助");
	    btnHelp.setBorderPainted(true);
	    btnHelp.setBounds(600, 400, 112, 40);	
	    jp.add(btnHelp);
	    
	    
		clw.frame.setVisible(false);	
		}
	}