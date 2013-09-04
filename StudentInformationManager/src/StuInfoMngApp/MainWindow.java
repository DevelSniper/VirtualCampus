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
		setTitle("ѧ��ѧ������ϵͳ");	
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
	    jtp.addTab("���ѧ����Ϣ",asi.jpInit());
	    jtp.addTab("�޸�ѧ����Ϣ",esi.jpInit());
	    jtp.addTab("ɾ��ѧ����Ϣ",dsi.jpInit());
	    jtp.addTab("��ѧ�Ų�ѯ",qbi.jpInit());
	    jtp.addTab("��������ѯ",qbn.jpInit());
	    jtp.addTab("��һ��ͨ�Ų�ѯ",qbc.jpInit());
	    jtp.addTab("ѧ����Ϣͳ��",sis.jpInit());
	    jtp.addTab("����",null);
	    jtp.setBounds(0,0,800,550);
	    
	    jp.add(jtp);

	    
		clw.frame.setVisible(false);
		}
	
	}