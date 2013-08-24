import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.*;
public class ClientHospitalMessageStudent {
	static String headOfTable[]={"留言人","留言内容"}; 
	static String dataOfTable[][]={{"呆逼t","我的脑袋疼"},{"呆逼t","脑袋疼"}};
	public ClientHospitalMessageStudent(){
		JFrame frame=new JFrame("在线留言");
		Container c = frame.getContentPane();
		frame.setSize(500,300);
		JPanel pane = new JPanel();
		pane.setLayout(null);
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
		spMessage.setBounds(10, 10,260, 240);
		taMessage.setBounds(280,10,200,180);
		btMessage.setBounds(320,200,112,40);
		pane.add(spMessage);
		pane.add(taMessage);
		pane.add(btMessage);
		c.add(pane);
		frame.setSize(500,300);
		frame.setVisible(true);
	}

}
