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

public class StuInfoQuery extends JFrame{	
	/**	 * Comment for <code>serialVersionUID</code>	 */	
	private JPanel contentPanel;	
	private MainWindow mw;
	private static StuInfoQuery window;
	/**	 * @param window	 */	
	public StuInfoQuery(MainWindow mwIn) {	
		this.mw = mwIn;		
		setResizable(false);
		setTitle("学生信息查询");	
		setBounds(100, 100, 250, 400);
		enableEvents(AWTEvent.WINDOW_EVENT_MASK);
		setLocationRelativeTo(getOwner());	
		setType(Type.POPUP);
		
		JPanel jp = new JPanel();
		jp.setOpaque(false);		
	    getContentPane().add(jp);	
	    ((JPanel) getContentPane()).setOpaque(false);
		jp.setLayout(null);
		
	    JButton btnQueryId = new JButton("按学号查询");
	    btnQueryId.setBorderPainted(true);
	    btnQueryId.setBounds(65, 50, 112, 40);
	    btnQueryId.addMouseListener(new MouseAdapter() 
	    {		
	    	@Override		
	    	public void mouseClicked(MouseEvent arg0) 
	    	{		
	    		QueryById sbi = new QueryById(window);		
				sbi.setVisible(true);			
	    	}		
		
	    });
	    jp.add(btnQueryId);
	    
	    JButton btnQueryName = new JButton("按姓名查询");
	    btnQueryName.setBorderPainted(true);
	    btnQueryName.setBounds(65, 160, 112, 40);
	    btnQueryName.addMouseListener(new MouseAdapter() 
	    {		
	    	@Override		
	    	public void mouseClicked(MouseEvent arg0) 
	    	{		
	    		QueryByName sbn = new QueryByName(window);		
				sbn.setVisible(true);			
	    	}		
		
	    });
	    jp.add(btnQueryName);
	    
	    JButton btnQueryCard = new JButton("按一卡通号查询");
	    btnQueryCard.setBorderPainted(true);
	    btnQueryCard.setBounds(65, 270, 112, 40);
	    btnQueryCard.addMouseListener(new MouseAdapter() 
	    {		
	    	@Override		
	    	public void mouseClicked(MouseEvent arg0) 
	    	{		
	    		QueryByCard sbc = new QueryByCard(window);		
				sbc.setVisible(true);			
	    	}		
		
	    });
	    jp.add(btnQueryCard);
	    
	  	
		}
	}
