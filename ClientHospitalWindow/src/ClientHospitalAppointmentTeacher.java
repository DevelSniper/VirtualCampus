import java.awt.Container;
import java.util.Vector; 
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;
import java.lang.System; 
import java.util.*; 

import javax.swing.*;
import javax.swing.border.LineBorder;

import java.sql.*;

public class ClientHospitalAppointmentTeacher {
	//{"预约人","性别","预约科室","预约时间","预约状态"}; 
	//static String dataOfTable[][]={{"谈晓伟","男","妇科","2013年8月1日","待同意"},{"txw","男","男科","2014年2月29日","待同意"}};
	public ClientHospitalAppointmentTeacher() throws SQLException{
		//建立一个vector用于存放tbAppointment的头
		Vector headOfTable = new Vector();
		headOfTable.addElement("一卡通号");
		headOfTable.addElement("预约人");
		headOfTable.addElement("性别");
		headOfTable.addElement("预约科室");
		headOfTable.addElement("预约时间");
		headOfTable.addElement("预约状态");
		//建立一个vector用于存放tbAppointment的头
		
		//建立一个vector用于存放tbAppointment的数据
		final Vector dataOfTable = new Vector();
		Vector data1OfTable = new Vector();
		dataOfTable.addElement(data1OfTable);
		data1OfTable.addElement("sdsdsd");
		data1OfTable.addElement("sdsdsd");
		data1OfTable.addElement("sdsdsd");
		data1OfTable.addElement("sdsdsd");
		data1OfTable.addElement("sdsdsd");
		//建立一个vector用于存放tbAppointment的数据	
		JFrame frame=new JFrame("看病预约-医生");
		
		Container c = frame.getContentPane();
		frame.setSize(500,300);
		JPanel pane = new JPanel();
		pane.setLayout(null);
		//内容

		//内容
		final JTable tbMessage = new JTable(dataOfTable,headOfTable);
		JScrollPane spMessage = new JScrollPane(tbMessage); 
		JTextArea taMessage = new JTextArea("输入内容");
		JButton btAgree = new JButton("同意预约");
		JButton btCancel = new JButton("撤销预约");
		JButton btDelete = new JButton("删除预约");
		JButton btClose = new JButton("关闭");
		updateTable(dataOfTable,tbMessage);
		//事件监听
		btDelete.addActionListener(new ActionListener(){//删除预约的监听
			public void actionPerformed(ActionEvent e){
				int selectedRow=tbMessage.getSelectedRow();
				if(selectedRow!=-1){
					String cardID = (String)tbMessage.getValueAt(selectedRow,0);
					try {
						new ClientHospitalOperateDB().deleteAppointment(cardID);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					updateTable(dataOfTable,tbMessage);
				}	
			}
		});
		//同意预约的监听
		btAgree.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				int selectedRow=tbMessage.getSelectedRow();
				if(selectedRow!=-1){
					String cardID = (String)tbMessage.getValueAt(selectedRow,0);
					try {
						new ClientHospitalOperateDB().agreeAppointment(cardID);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					updateTable(dataOfTable,tbMessage);
				}	
			}
		});
		//撤销预约的监听
		btCancel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				int selectedRow=tbMessage.getSelectedRow();
				if(selectedRow!=-1){
					String cardID = (String)tbMessage.getValueAt(selectedRow,0);
					try {
						new ClientHospitalOperateDB().cancelAppointment(cardID);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					updateTable(dataOfTable,tbMessage);
				}	
			}
		});
		
		
		
		//System.out.println(rs.getString(1));
		/*while(rs.next())
		{
			//rs.absolute(2);
			//rs.getString(2);
		}
		*/
		
		
		//获取预约信息并放在tbMessage中
		//布局
		//tbMessage.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tbMessage.getColumnModel().getColumn(0).setPreferredWidth(80);//设置第一列“留言人”性质
		tbMessage.getColumnModel().getColumn(0).setMaxWidth(80);
		tbMessage.getColumnModel().getColumn(0).setMinWidth(80);
		tbMessage.getColumnModel().getColumn(1).setPreferredWidth(50);//设置第二列“留言信息”性质
		tbMessage.getColumnModel().getColumn(1).setMaxWidth(50);
		tbMessage.getColumnModel().getColumn(1).setMinWidth(50);
		tbMessage.getColumnModel().getColumn(2).setPreferredWidth(30);//设置第二列“留言信息”性质
		tbMessage.getColumnModel().getColumn(2).setMaxWidth(30);
		tbMessage.getColumnModel().getColumn(2).setMinWidth(30);
		//tbMessage.setAutoResizeMode(tbMessage.AUTO_RESIZE_OFF);
		//tbMessage.setCellSelectionEnabled(false);
		tbMessage.setPreferredScrollableViewportSize(new Dimension(100,100));
		taMessage.setBorder(new LineBorder(new java.awt.Color(127,157,185), 1, false));//设置留言框边框
		spMessage.setBounds(10, 10,370, 240);
		taMessage.setBounds(340,10,250,180);
		btAgree.setBounds(400,20,112,40);
		btCancel.setBounds(400,75,112,40);
		btDelete.setBounds(400,130,112,40);
		btClose.setBounds(400,185,112,40);
		//scrollPane.setBounds(10, 10, 140, 240);
		pane.add(spMessage);
		//pane.add(taMessage);
		pane.add(btAgree);
		pane.add(btCancel);
		pane.add(btDelete);
		pane.add(btClose);
		c.add(pane);
		frame.setSize(550,300);
		frame.setVisible(true);

}
	
	protected void updateTable(Vector dataOfTable,JTable tbMessage){
		//获取预约信息并放在tbMessage中
				dataOfTable.clear();
				try {
					new ClientHospitalOperateDB().getAppointment(dataOfTable);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				tbMessage.updateUI();
	}
}
