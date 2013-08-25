import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.util.Hashtable;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTree;
import javax.swing.border.LineBorder;


public class ClientHospitalAppointmentTeacher {
	static String headOfTable[]={"预约人","预约科室","预约时间","预约状态"}; 
	static String dataOfTable[][]={{"呆逼t","妇科","2013年8月1日","待同意"},{"呆逼t","男科","2014年2月29日","待同意"}};
	public ClientHospitalAppointmentTeacher(){
		JFrame frame=new JFrame("看病预约-医生");
		Container c = frame.getContentPane();
		frame.setSize(500,300);
		JPanel pane = new JPanel();
		pane.setLayout(null);
		//内容
		
		//String[] s1={"谈晓伟","熊海潇","李渴","张伟旗"}; 
	  //  String[] s2={"本机磁盘(C:)","本机磁盘(D:)","本机磁盘(E:)"};
	   // String[] s3={"奇摩站","职棒消息","网络书店"}; 
	  //  Hashtable hashtable1=new Hashtable();
	  //  Hashtable hashtable2=new Hashtable();
	   // hashtable1.put("病人名单",s1);
	   // hashtable1.put("我的电脑",s2);
	    //hashtable1.put("收藏夹",hashtable2);
	   // hashtable2.put("网站列表",s3);
	    
	    Font font = new Font("Dialog", Font.PLAIN, 12);

	   // JTree tree=new JTree(hashtable1);
	   //  JScrollPane scrollPane=new JScrollPane();
	   //  scrollPane.setViewportView(tree);    
	   //  pane.add(scrollPane);
		
		//内容
		JTable tbMessage = new JTable(dataOfTable,headOfTable);
		JScrollPane spMessage = new JScrollPane(tbMessage); 
		JTextArea taMessage = new JTextArea("输入内容");
		JButton btAgree = new JButton("同意预约");
		JButton btCancel = new JButton("撤销预约");
		JButton btDelete = new JButton("删除预约");
		JButton btClose = new JButton("关闭");
		//布局
		//tbMessage.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tbMessage.getColumnModel().getColumn(0).setPreferredWidth(60);//设置第一列“留言人”性质
		tbMessage.getColumnModel().getColumn(0).setMaxWidth(60);
		tbMessage.getColumnModel().getColumn(0).setMinWidth(60);
		tbMessage.getColumnModel().getColumn(1).setPreferredWidth(70);//设置第二列“留言信息”性质
		tbMessage.getColumnModel().getColumn(1).setMaxWidth(70);
		tbMessage.getColumnModel().getColumn(1).setMinWidth(70);
		tbMessage.getColumnModel().getColumn(2).setPreferredWidth(130);//设置第二列“留言信息”性质
		tbMessage.getColumnModel().getColumn(2).setMaxWidth(130);
		tbMessage.getColumnModel().getColumn(2).setMinWidth(130);
		//tbMessage.setAutoResizeMode(tbMessage.AUTO_RESIZE_OFF);
		//tbMessage.setCellSelectionEnabled(false);
		tbMessage.setPreferredScrollableViewportSize(new Dimension(100,100));
		taMessage.setBorder(new LineBorder(new java.awt.Color(127,157,185), 1, false));//设置留言框边框
		spMessage.setBounds(10, 10,320, 240);
		taMessage.setBounds(340,10,200,180);
		btAgree.setBounds(350,20,112,40);
		btCancel.setBounds(350,75,112,40);
		btDelete.setBounds(350,130,112,40);
		btClose.setBounds(350,185,112,40);
		//scrollPane.setBounds(10, 10, 140, 240);
		pane.add(spMessage);
		//pane.add(taMessage);
		pane.add(btAgree);
		pane.add(btCancel);
		pane.add(btDelete);
		pane.add(btClose);
		c.add(pane);
		frame.setSize(500,300);
		frame.setVisible(true);

}
}
