import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
//此类用于学生进行看病预约
import java.sql.SQLException;

public class ClientHospitalAppointment {
//	Student stu = new Student();
	static String kindOfDisease[]={"内科","外科","口腔科","皮肤科","眼科","放射科","妇科"};
	static String yearOfAppointment[]={"2013","2014","2015"};
	static String monthOfAppointment[]={"01","02","03","04","05","06","07","08","09","10","11","12"};
	static String dayOfAppointment31[]={"01","02","03","04","05","06","07","08","09","10","11","12",
		"13","14","15","16","17","18","19","20","21","22","23",
		"24","25","26","27","28","29","30","31"};
	private JComboBox cobDisease= new JComboBox(kindOfDisease);
	private JComboBox cobYear= new JComboBox(yearOfAppointment);
	private JComboBox cobMonth= new JComboBox(monthOfAppointment);
	private JComboBox cobDay= new JComboBox(dayOfAppointment31);
	public ClientHospitalAppointment(final Student student){
		JFrame frame=new JFrame("看病预约");
		Container c = frame.getContentPane();
		frame.setSize(500,300);
		JPanel pane = new JPanel();
		pane.setLayout(null);
		c.add(pane);
		final JLabel label1 = new JLabel("科室:");
		final JLabel label2 = new JLabel("时间:");
		
		JButton btnMakeApt = new JButton("确认预约");
		JButton btnCancel = new JButton("取消");
		
		
		//设置day数
		cobYear.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent event){
                if (event.getStateChange() == ItemEvent.SELECTED){
                    cobDay.removeAllItems();
                    int days = getDayInMonth(Integer.parseInt((String)cobYear.getSelectedItem()), Integer.parseInt((String)cobMonth.getSelectedItem()));
                    for (int i = 1; i <= days; i++){
                        cobDay.addItem(i);
                    }
                    cobDay.validate();
                }
            }
        });
		cobMonth.addItemListener(new ItemListener()
        {
            public void itemStateChanged(ItemEvent event)
            {
                if (event.getStateChange() == ItemEvent.SELECTED)
                {
                    cobDay.removeAllItems();
                    int days = getDayInMonth(Integer.parseInt((String)cobYear.getSelectedItem()), Integer.parseInt((String)cobMonth.getSelectedItem()));
                    for (int i = 1; i <= days; i++)
                    {
                    	if(i<10)
                    		cobDay.addItem('0'+String.valueOf(i));
                    	else
                    		cobDay.addItem(i);
                    	
                    }
                    cobDay.validate();
                }
            }
        });
		////////////////添加预约
		//获取ComboBox内容
		
		
		
		
		btnMakeApt.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
			//	System.out.println(month);
				//获取ComboBox的内容并传入数据库
				String kind=cobDisease.getSelectedItem().toString();
				String year=cobYear.getSelectedItem().toString();
				String month=cobMonth.getSelectedItem().toString();
				String day=cobDay.getSelectedItem().toString();
				String date=year+'-'+month+'-'+day;
				try {
					new ClientHospitalOperateDB().makeAppointment(student.getUserCard(), student.getUserName(), student.getUserSex(), kind, date,"待受理");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		

	
		cobYear.setBounds(160, 35, 60, 20);
		cobMonth.setBounds(230, 35, 40, 20);
		cobDay.setBounds(280, 35, 40, 20);
		cobDisease.setBounds(50, 35, 70, 20);
		label1.setBounds(10,25,112,40);
		label2.setBounds(125,25,112,40);
		btnMakeApt.setBounds(40,100,112,40);
		btnCancel.setBounds(190,100,112,40);
		
		pane.add(label1);
		pane.add(label2);
		pane.add(cobYear);
		pane.add(cobMonth);
		pane.add(cobDay);
		pane.add(cobDisease);
		pane.add(btnMakeApt);
		pane.add(btnCancel);
		
		//frame.setLocationRelativeTo(null);
		frame.setLocationByPlatform(true);//设置frame 位置

		
		
		frame.setSize(350,220);
		frame.setVisible(true);
		
	}
	
	private int getDayInMonth(int year, int month)
    {
        boolean yunnian = false;
         
        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0)
        {
            yunnian = true;
        }
        switch (month)
        {
        case 1:
        case 3:
        case 5:
        case 7:
        case 8:
        case 10:
        case 12:
            return 31;
        case 2:
            return yunnian ? 29 : 28;
        default:
            return 30;
        }
    }

}
