import javax.swing.*;

import java.sql.*;
import java.util.Vector;
import java.awt.*;
import java.awt.event.*;


public class ClientHospitalWindow {
	Student testStudent = new Student();//存放学生
	Teacher testTeacher = new Teacher();//存放老师
	
	private static ClientHospitalWindow window;
	//用于模块测试的main函数
	public static void main(String[] args) {
		//新建一个Student测试对象student
		/*
		final Student student = new Student();
		student.setUserBirthday("1983-09-25");
		student.setUserCard("213111444");
		student.setUserClass("090111");
		student.setUserHometown("伊拉克");
		student.setUserID("213111455");
		student.setUserName("张伟旗");
		student.setUserRole("呵呵");
		student.setUserSex("男");*/
	//	System.out.println(student.getUserHometown());
		//新建一个Student测试对象student
		
		final User testUserT = new User("213111455", "1", "teacher");
		final User testUserS = new User("213112403","1","student");
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new ClientHospitalWindow(testUserT);//传入student或teacher类型的User
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public ClientHospitalWindow(final User testUser) throws SQLException{
		JFrame frame=new JFrame("校园医疗系统");
		Container c=frame.getContentPane();
		JPanel pane=new JPanel();
		c.add(pane);
		pane.setLayout(null);
		//获取当前User信息
		final String userRole = testUser.getuRole();///////////////////////////////////
		String userCardID = testUser.getuID();//一卡通号
		String userStatus = "预约状态";
		if("teacher".equals(userRole)){
			testTeacher = new ClientHospitalOperateDB().getTeacherInfo(userCardID);
		}
		
		if("student".equals(userRole)){		
			userStatus = getAppointmentStatus(userCardID);
			testStudent = new ClientHospitalOperateDB().getStudentInfo(userCardID);
			
		}
		//当前user信息获取完毕
		JButton btnAppointment = new JButton("看病预约");
		JButton btnMessage = new JButton("在线留言");
		JButton btnClose = new JButton("关闭");
		JButton btnPatient = new JButton("病人信息录入");
		final JLabel label0 = new JLabel("个人资料");
		final JLabel label1 = new JLabel("一卡通号：");
		final JLabel label2 = new JLabel("姓        名：");
		final JLabel label3 = new JLabel("性        别：");
		final JLabel label4 = new JLabel("身        份：");
		final JLabel label5 = new JLabel("预约状态：");
		JLabel lbCard = new JLabel(userCardID);
		JLabel lbName = new JLabel("student".equals(userRole)?testStudent.getUserName():testTeacher.getUserName());
		JLabel lbSex = new JLabel("student".equals(userRole)?testStudent.getUserSex():testTeacher.getUserSex());
		JLabel lbRole = new JLabel("student".equals(userRole)?"学生":"老师");
		JLabel lbStatus = new JLabel(userStatus);
		
		if(userRole.equals("student"))
			btnPatient.setEnabled(false);
		btnAppointment.setBounds(300, 10, 112, 40);
		btnMessage.setBounds(300, 60, 112, 40);
		btnPatient.setBounds(300, 110, 112, 40);
		btnClose.setBounds(300, 160, 112, 40);
		label0.setBounds(90, 10, 112, 30);//个人资料
		label1.setBounds(40, 40, 112, 40);//一卡通
		lbCard.setBounds(110, 40, 112, 40);
		label2.setBounds(40, 70, 112, 40);//姓名
		lbName.setBounds(110, 70, 112, 40);
		label3.setBounds(40, 100, 112, 40);//性别
		lbSex.setBounds(110, 100, 112, 40);
		label4.setBounds(40, 130, 112, 40);//身份
		lbRole.setBounds(110, 130, 112, 40);
		label5.setBounds(40, 160, 112, 40);//状态
		lbStatus.setBounds(110, 160, 200, 40);
		lbStatus.setForeground(Color.blue);
		
		
		pane.add(btnAppointment);
		pane.add(btnMessage);
		pane.add(btnPatient);
		pane.add(btnClose);
		pane.add(label0);
		pane.add(label1);
		pane.add(label2);
		pane.add(label3);
		pane.add(label4);
		pane.add(lbCard);
		pane.add(lbName);
		pane.add(lbSex);
		pane.add(lbRole);
		if("student".equals(userRole)){
			pane.add(label5);
			pane.add(lbStatus);
		}
		
		//对按钮的事件处理
		//预约按钮的监听器
		btnAppointment.addActionListener(new ActionListener(){//预约按钮的监听器
			public void actionPerformed(ActionEvent e){
				try {
					if(userRole.equals("student"))
						new ClientHospitalAppointment(testStudent);
					else
						new ClientHospitalAppointmentTeacher();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		//留言按钮的监听
		btnMessage.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(userRole.equals("student"))
					new ClientHospitalMessageStudent(testStudent);
				else
					new ClientHospitalMessageTeacher(testTeacher);
			}
		});
		//新增病人按钮监听
		btnPatient.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				new ClientHospitalPatientCreate();
			}
		});
				frame.addWindowListener(new WindowAdapter(){
					public void windowClosing(WindowEvent e){
						System.exit(0);
					}
				});
		
		
		//frame.setLocationRelativeTo(null);
		frame.setLocationByPlatform(true);  //设置frame位置

		frame.setSize(450,250);
		frame.setVisible(true);
	}
	
	public String getAppointmentStatus(String cardID){
		try {
			return(new ClientHospitalOperateDB().getAppointmentStatus(cardID));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
