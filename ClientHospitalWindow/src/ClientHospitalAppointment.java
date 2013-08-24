import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ClientHospitalAppointment {
	static String kindOfDisease[]={"内科","外科","口腔科","皮肤科","眼科","放射科"};
	static String yearOfAppointment[]={"2013","2014","2015"};
	static String monthOfAppointment[]={"1","2","3","4","5","6","7","8","9","10","11","12"};
	static String dayOfAppointment31[]={"1","2","3","4","5","6","7","8","9","10","11","12",
		"13","14","15","16","17","18","19","20","21","22","23",
		"24","25","26","27","28","29","30","31"};
	static String dayOfAppointment30[]={"1","2","3","4","5","6","7","8","9","10","11","12",
		"13","14","15","16","17","18","19","20","21","22","23",
		"24","25","26","27","28","29","30"};
	static String dayOfAppointment28[]={"1","2","3","4","5","6","7","8","9","10","11","12",
		"13","14","15","16","17","18","19","20","21","22","23",
		"24","25","26","27","28"};
	
	public ClientHospitalAppointment(){
		JFrame frame=new JFrame("看病预约");
		Container c = frame.getContentPane();
		frame.setSize(500,300);
		JPanel pane = new JPanel();
		pane.setLayout(null);
		c.add(pane);
		final JLabel label1 = new JLabel("科室:");
		final JLabel label2 = new JLabel("时间:");
		JComboBox cobDisease= new JComboBox(kindOfDisease);
		JComboBox cobYear= new JComboBox(yearOfAppointment);
		JComboBox cobMonth= new JComboBox(monthOfAppointment);
		JComboBox cobDay= new JComboBox();
		if(cobMonth.getSelectedItem()=="1"){
			for(int i=1;i<=31;i++){
				cobDay.addItem(i+"");
			}
			cobDay.repaint();
			cobDay.updateUI();
		}
		if(cobMonth.getSelectedItem()=="2"){
			for(int i=1;i<=30;i++){
				cobDay.addItem(i+"");
			}
			cobDay.repaint();
			cobDay.updateUI();
		}
		cobYear.setBounds(160, 20, 60, 20);
		cobMonth.setBounds(230, 20, 40, 20);
		cobDay.setBounds(280, 20, 40, 20);
		cobDisease.setBounds(50, 20, 70, 20);
		label1.setBounds(10,10,112,40);
		label2.setBounds(125,10,112,40);
		
		pane.add(label1);
		pane.add(label2);
		pane.add(cobYear);
		pane.add(cobMonth);
		pane.add(cobDay);
		pane.add(cobDisease);
		
		//frame.setLocationRelativeTo(null);
		frame.setLocationByPlatform(true);//设置frame 位置

		
		
		frame.setSize(350,250);
		frame.setVisible(true);
		
	}

}
