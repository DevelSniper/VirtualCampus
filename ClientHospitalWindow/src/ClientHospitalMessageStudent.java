//package conn.common
import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.Vector;
public class ClientHospitalMessageStudent {

	public ClientHospitalMessageStudent(final Student student){
		Vector headOfTable = new Vector();
		final Vector dataOfTable = new Vector();
		final JFrame frame=new JFrame("在线留言");
		Container c = frame.getContentPane();
		frame.setSize(500,300);
		JPanel pane = new JPanel();
		pane.setLayout(null);
		headOfTable.addElement("留言人");
		headOfTable.addElement("留言内容");
		
		//内容
		
		final JTable tbMessage = new JTable(dataOfTable,headOfTable);
		JScrollPane spMessage = new JScrollPane(tbMessage); 
		final JTextArea taMessage = new JTextArea("输入内容");
		taMessage.setLineWrap(true);
		JButton btMessage = new JButton("提交留言");
		JButton btClose = new JButton("关闭");
		updateMessage(dataOfTable,tbMessage,student);//刷新student的留言信息
		
		//添加留言的监听
				btMessage.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						String message=taMessage.getText();
						if(!message.equals("")){
							try {
								new ClientHospitalOperateDB().leaveMessage(student.getUserName(), "ALL", message);
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							updateMessage(dataOfTable,tbMessage,student);
						}	
					}
				});
				//关闭按钮监听
				btClose.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						frame.dispose();
					}
				});
		//
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
		taMessage.setBounds(280,10,240,180);
		btMessage.setBounds(280,200,112,40);
		btClose.setBounds(400, 200, 112, 40);
		pane.add(spMessage);
		pane.add(taMessage);
		pane.add(btMessage);
		pane.add(btClose);
		c.add(pane);
		frame.setSize(540,300);
		frame.setVisible(true);
	}
	protected void updateMessage(Vector dataOfTable,JTable tbMessage,Student student){
		try {
			new ClientHospitalOperateDB().getMessage(dataOfTable, student.getUserName());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tbMessage.updateUI();
		
	}

}
