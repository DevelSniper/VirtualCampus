package StuInfoMngApp;

import java.awt.AWTEvent;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
/** * @author C5102 * * TODO To change the template for this generated type comment go to * Window - Preferences - Java - Code Style - Code Templates */

public class MainWindow extends JFrame{	
	/**	 * Comment for <code>serialVersionUID</code>	 */	
	private JPanel contentPanel;	
	private ClientLoginWindow clw;
	private static MainWindow window;
	int selectedIndex;
	AddStuInfo asi = new AddStuInfo();
	
	EditStuInfo esi = new EditStuInfo();
	DelStuInfo dsi = new DelStuInfo();
	QueryById qbi = new QueryById();
	QueryByName qbn = new QueryByName();
	QueryByCard qbc = new QueryByCard();
	StuInfoStatistic sis = new StuInfoStatistic();
	OperateDB dbConnMng = new OperateDB();
	
	/**	 * @param window	 
	 * @throws SQLException */	
	public MainWindow(ClientLoginWindow clwIn) throws SQLException {	
		this.clw = clwIn;		
		setResizable(false);
		setTitle("学生学籍管理系统");	
		setBounds(100, 100, 800, 550);
		enableEvents(AWTEvent.WINDOW_EVENT_MASK);
		setLocationRelativeTo(getOwner());	
		setType(Type.POPUP);
		
		final JPanel jp = new JPanel();	

	    jp.setOpaque(false);		
	    getContentPane().add(jp);	
	    ((JPanel) getContentPane()).setOpaque(false);	
	    
	   
	    jp.setLayout(null);
	   
	    final JTabbedPane jtp = new JTabbedPane ();
	    jtp.addTab("添加学生信息",asi.jpInit());
	    jtp.addTab("修改学生信息",esi.jpInit());
	    jtp.addTab("删除学生信息",dsi.jpInit());
	    jtp.addTab("按学号查询",qbi.jpInit());
	    jtp.addTab("按姓名查询",qbn.jpInit());
	    jtp.addTab("按一卡通号查询",qbc.jpInit());
	    jtp.addTab("学生信息统计",sis.jpInit());
	    jtp.addTab("帮助",null);
	    jtp.setBounds(0,0,800,550);
	    
	    jp.add(jtp);

	    
		clw.frame.setVisible(false);
		}
	
	}