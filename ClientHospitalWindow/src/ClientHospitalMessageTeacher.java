import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.*;
import java.util.Hashtable;
public class ClientHospitalMessageTeacher {
	static String headOfTable[]={"留言人","留言内容"}; 
	static String dataOfTable[][]={{"呆逼t","我的脑袋疼"},{"呆逼t","脑袋疼"}};
	public ClientHospitalMessageTeacher(){
		JFrame frame=new JFrame("在线留言");
		Container c = frame.getContentPane();
		frame.setSize(500,300);
		JPanel pane = new JPanel();
		pane.setLayout(null);
		//内容
		
		String[] s1={"谈晓伟","熊海潇","李渴","张伟旗"}; 
	    String[] s2={"本机磁盘(C:)","本机磁盘(D:)","本机磁盘(E:)"};
	    String[] s3={"奇摩站","职棒消息","网络书店"}; 
	    Hashtable hashtable1=new Hashtable();
	    Hashtable hashtable2=new Hashtable();
	    hashtable1.put("病人名单",s1);
	   // hashtable1.put("我的电脑",s2);
	    //hashtable1.put("收藏夹",hashtable2);
	   // hashtable2.put("网站列表",s3);
	    
	    Font font = new Font("Dialog", Font.PLAIN, 12);

	    JTree tree=new JTree(hashtable1);
	    JScrollPane scrollPane=new JScrollPane();
	    scrollPane.setViewportView(tree);
	    
	    pane.add(scrollPane);
		
		//内容
		JTable tbMessage = new JTable(dataOfTable,headOfTable);
		JScrollPane spMessage = new JScrollPane(tbMessage); 
		JTextArea taMessage = new JTextArea("输入内容");
		JButton btMessage = new JButton("提交留言");
		//布局
		//tbMessage.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tbMessage.getColumnModel().getColumn(0).setPreferredWidth(60);//设置第一列“留言人”性质
		tbMessage.getColumnModel().getColumn(0).setMaxWidth(60);
		tbMessage.getColumnModel().getColumn(0).setMinWidth(60);
		tbMessage.getColumnModel().getColumn(1).setPreferredWidth(200);//设置第二列“留言信息”性质
		tbMessage.getColumnModel().getColumn(1).setMaxWidth(200);
		tbMessage.getColumnModel().getColumn(1).setMinWidth(200);
		//tbMessage.setAutoResizeMode(tbMessage.AUTO_RESIZE_OFF);
		//tbMessage.setCellSelectionEnabled(false);
		tbMessage.setPreferredScrollableViewportSize(new Dimension(100,100));
		taMessage.setBorder(new LineBorder(new java.awt.Color(127,157,185), 1, false));//设置留言框边框
		spMessage.setBounds(160, 10,260, 240);
		taMessage.setBounds(430,10,200,180);
		btMessage.setBounds(470,210,112,40);
		scrollPane.setBounds(10, 10, 140, 240);
		pane.add(spMessage);
		pane.add(taMessage);
		pane.add(btMessage);
		c.add(pane);
		frame.setSize(660,300);
		frame.setVisible(true);
	}
	void initializeTree(JPanel pane){
	    
	}

}
