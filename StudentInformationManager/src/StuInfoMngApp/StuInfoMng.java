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

public class StuInfoMng extends JFrame{	
	/**	 * Comment for <code>serialVersionUID</code>	 */	
	private JPanel contentPanel;	
	private MainWindow mw;
	private static StuInfoMng window;
	/**	 * @param window	 */	
	public StuInfoMng(MainWindow mwIn) {	
		this.mw = mwIn;		
		setResizable(false);
		setTitle("学生信息管理");	
		setBounds(100, 100, 250, 400);
		enableEvents(AWTEvent.WINDOW_EVENT_MASK);
		setLocationRelativeTo(getOwner());	
		setType(Type.POPUP);
		
		JPanel jp = new JPanel();
		jp.setOpaque(false);		
	    getContentPane().add(jp);	
	    ((JPanel) getContentPane()).setOpaque(false);
		jp.setLayout(null);
		
	    JButton btnAddInfo = new JButton("添加学生信息");
	    btnAddInfo.setBorderPainted(true);
	    btnAddInfo.setBounds(65, 50, 112, 40);
	    btnAddInfo.addMouseListener(new MouseAdapter() 
	    {		
	    	@Override		
	    	public void mouseClicked(MouseEvent arg0) 
	    	{		
	    		AddStuInfo asi = new AddStuInfo(window);		
				asi.setVisible(true);			
	    	}		
		
	    });
	    jp.add(btnAddInfo);
	    
	    JButton btnEditInfo = new JButton("修改学生信息");
	    btnEditInfo.setBorderPainted(true);
	    btnEditInfo.setBounds(65, 160, 112, 40);
	    btnEditInfo.addMouseListener(new MouseAdapter() 
	    {		
	    	@Override		
	    	public void mouseClicked(MouseEvent arg0) 
	    	{		
	    		EditStuInfo asi = new EditStuInfo(window);		
				asi.setVisible(true);			
	    	}		
		
	    });
	    jp.add(btnEditInfo);
	    
	    JButton btnDelInfo = new JButton("删除学生信息");
	    btnDelInfo.setBorderPainted(true);
	    btnDelInfo.setBounds(65, 270, 112, 40);
	    btnDelInfo.addMouseListener(new MouseAdapter() 
	    {		
	    	@Override		
	    	public void mouseClicked(MouseEvent arg0) 
	    	{		
	    		DelStuInfo asi = new DelStuInfo(window);		
				asi.setVisible(true);			
	    	}		
		
	    });
	    jp.add(btnDelInfo);
	    
	  	
		}
	}