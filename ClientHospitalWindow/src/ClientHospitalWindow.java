import javax.swing.*;

import java.sql.*;
import java.awt.*;
import java.awt.event.*;


public class ClientHospitalWindow {
	
	private static ClientHospitalWindow window;
	public static void main(String[] args) {
		//新建一个Student测试对象student
		final Student student = new Student();
		student.setUserBirthday("1983-09-25");
		student.setUserCard("213111423");
		student.setUserClass("090111");
		student.setUserHometown("伊拉克");
		student.setUserID("213111455");
		student.setUserName("张伟旗");
		student.setUserRole("呵呵");
		student.setUserSex("男");
	//	System.out.println(student.getUserHometown());
		//新建一个Student测试对象student
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new ClientHospitalWindow(student);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public ClientHospitalWindow(final Student student){
		JFrame frame=new JFrame("校园医疗系统");
		Container c=frame.getContentPane();
		JPanel pane=new JPanel();
		c.add(pane);
		pane.setLayout(null);
		JButton btnAppointment = new JButton("看病预约");
		JButton btnMessage = new JButton("在线留言");
		JButton btnClose = new JButton("关闭");
		
		final JLabel label0 = new JLabel("个人资料");
		final JLabel label1 = new JLabel("一卡通号：");
		final JLabel label2 = new JLabel("姓        名：");
		final JLabel label3 = new JLabel("性        别：");
		final JLabel label4 = new JLabel("身        份：");
		final JLabel label5 = new JLabel("预约状态：");
		JLabel lbCard = new JLabel(student.getUserCard());
		JLabel lbName = new JLabel(student.getUserName());
		JLabel lbSex = new JLabel(student.getUserSex());
		JLabel lbRole = new JLabel("学生");
		

		
		
		
		btnAppointment.setBounds(350, 30, 112, 40);
		btnMessage.setBounds(350, 90, 112, 40);
		btnClose.setBounds(350, 150, 112, 40);
		label0.setBounds(90, 10, 112, 40);//个人资料
		label1.setBounds(40, 40, 112, 40);
		label2.setBounds(40, 70, 112, 40);
		label3.setBounds(40, 100, 112, 40);
		label4.setBounds(40, 130, 112, 40);
		label5.setBounds(40, 160, 112, 40);
		pane.add(btnAppointment);
		pane.add(btnMessage);
		pane.add(btnClose);
		pane.add(label5);
		pane.add(label0);
		pane.add(label1);
		pane.add(label2);
		pane.add(label3);
		pane.add(label4);
		//对按钮的事件处理
		btnAppointment.addActionListener(new ActionListener(){//预约按钮的监听器
			public void actionPerformed(ActionEvent e){
				//new ClientHospitalAppointment(student);
				try {
					new ClientHospitalAppointmentTeacher();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnMessage.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//label1.setText("挂尼玛");
				new ClientHospitalMessageStudent(student);
			}
		});
		frame.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		//frame.setLocationRelativeTo(null);
		frame.setLocationByPlatform(true);  //设置frame位置

		frame.setSize(500,300);
		frame.setVisible(true);
	}
	

}
