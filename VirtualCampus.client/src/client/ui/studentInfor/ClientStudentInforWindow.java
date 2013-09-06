package client.ui.studentInfor;

import java.awt.AWTEvent;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class ClientStudentInforWindow extends JFrame{
	private JPanel contentPanel;
	private static ClientStudentInforWindow window;
	int selectedIndex;
	AddStudentInfor asi = new AddStudentInfor();
	UpdateStudentInfor usi = new UpdateStudentInfor();
	QueryById qbi = new QueryById();
	QueryByName qbn = new QueryByName();
	QueryByCard qbc = new QueryByCard();
	StuInfoStatistic sis = new StuInfoStatistic();
//	OperateDB dbConnMng = new OperateDB();
	
	/**	 * @param window	 
	 * @throws SQLException */	
	public ClientStudentInforWindow(){	
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
	    jtp.addTab("编辑学生信息",usi.jpInit());
	    jtp.addTab("按学号查询",qbi.jpInit());
	    jtp.addTab("按姓名查询",qbn.jpInit());
	    jtp.addTab("按一卡通号查询",qbc.jpInit());
	    jtp.addTab("学生信息统计",sis.jpInit());
//	    jtp.addTab("删除学生信息",null);
//	    jtp.addTab("按学号查询",null);
//	    jtp.addTab("按姓名查询",null);
//	    jtp.addTab("按一卡通号查询",null);
//	    jtp.addTab("学生信息统计",null);
	    jtp.addTab("帮助",null);
	    jtp.setBounds(0,0,800,550);
	    
	    jp.add(jtp);
	}
	
}