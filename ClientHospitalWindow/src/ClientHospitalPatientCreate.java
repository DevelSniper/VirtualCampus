import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.tree.DefaultMutableTreeNode;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.Vector;
public class ClientHospitalPatientCreate {
	static String kindOfDisease[]={"内科","外科","口腔科","皮肤科","眼科","放射科","妇科"};
	static String yearOfAppointment[]={"2013","2014","2015"};
	static String monthOfAppointment[]={"01","02","03","04","05","06","07","08","09","10","11","12"};
	static String dayOfAppointment31[]={"01","02","03","04","05","06","07","08","09","10","11","12",
		"13","14","15","16","17","18","19","20","21","22","23",
		"24","25","26","27","28","29","30","31"};
	
	public ClientHospitalPatientCreate(){
		//表内信息
		final Vector dataOfTable = new Vector();
		final Vector headOfTable = new Vector();
		headOfTable.addElement("姓名");
		headOfTable.addElement("性别");
		headOfTable.addElement("就诊日期");
		headOfTable.addElement("就诊科室");
		headOfTable.addElement("症状");
		headOfTable.addElement("是否住院");
		headOfTable.addElement("入院日期");
		headOfTable.addElement("出院日期");
		headOfTable.addElement("病房号");
		
		//表头结束
		JFrame frame=new JFrame("医院病人信息录入");
		Container c=frame.getContentPane();
		JPanel pane=new JPanel();
		c.add(pane);
		pane.setLayout(null);
		JLabel lbName = new JLabel("姓名");
		JLabel lbSex = new JLabel("性别");
		JLabel lbKind = new JLabel("就诊科室");
		JLabel lbTime = new JLabel("就诊日期");
		JLabel lbSymptom = new JLabel("症状");
		JLabel lbMedicine = new JLabel("药品名称");
		JLabel lbInornot = new JLabel("是否住院");
		JLabel lbIntm = new JLabel("入院日期");
		JLabel lbOuttm = new JLabel("离院日期");
		JLabel lbRoomNumber = new JLabel("病房号");
		JLabel searchName = new JLabel("按姓名搜索");
		final JTextField tfName = new JTextField();
		String sex[] = {"男","女"};
		final JComboBox cobSex = new JComboBox(sex);
		final JComboBox cobKind = new JComboBox(kindOfDisease);
		JTextField tfTime = new JTextField();
		JTextField tfSymptom = new JTextField();
		JTextField tfMedicine = new JTextField();
		JTextField tfInornot = new JTextField();
		JTextField tfIntm = new JTextField();
		JTextField tfOuttm = new JTextField();
		final JTextField tfSearchName = new JTextField();
		final JComboBox cobYear1= new JComboBox(yearOfAppointment);
		final JComboBox cobMonth1= new JComboBox(monthOfAppointment);
		final JComboBox cobDay1= new JComboBox(dayOfAppointment31);
		final JComboBox cobYear2= new JComboBox(yearOfAppointment);
		final JComboBox cobMonth2= new JComboBox(monthOfAppointment);
		final JComboBox cobDay2= new JComboBox(dayOfAppointment31);
		final JComboBox cobYear3= new JComboBox(yearOfAppointment);
		final JComboBox cobMonth3= new JComboBox(monthOfAppointment);
		final JComboBox cobDay3= new JComboBox(dayOfAppointment31);
		JButton btnAppointment = new JButton("看病预约");
		JButton btnMessage = new JButton("在线留言");
		JButton btnClose = new JButton("关闭");
		final JTextArea taSymptom = new JTextArea("输入病人症状");
		final JCheckBox cbInornot = new JCheckBox("是否住院"); 
		final JTextField tfRoomNumber = new JTextField();
		final JTable tbMessage = new JTable(dataOfTable,headOfTable);
		JScrollPane spMessage = new JScrollPane(tbMessage); 
		JButton btnCreatePatient = new JButton("新增病人");
		JButton btnDeletePatient = new JButton("删除病人");
		JButton btnSearchPatient = new JButton("搜索");
		
		
		//组件设置
		lbName.setBounds(10, 15, 60, 15);
		tfName.setBounds(40, 10, 60, 25);
		lbSex.setBounds(110, 15, 60, 15);
		cobSex.setBounds(140, 10, 60, 25);
		lbTime.setBounds(220, 10, 60, 25);
		cobYear1.setBounds(275, 10, 55, 25);
		cobMonth1.setBounds(335, 10, 40, 25);
		cobDay1.setBounds(375, 10, 40, 25);
		lbKind.setBounds(440, 15, 60, 15);
		cobKind.setBounds(495, 10, 60, 25);
		taSymptom.setBounds(570,10,200,110);
		taSymptom.setLineWrap(true);
		taSymptom.setBorder(new LineBorder(new java.awt.Color(127,157,185), 1, false));
		cbInornot.setBounds(10, 50, 80, 40);
		lbIntm.setBounds(90, 50, 80, 40);
		cobYear2.setBounds(145, 55, 55, 25);
		cobMonth2.setBounds(200, 55, 40, 25);
		cobDay2.setBounds(240, 55, 40, 25);
		lbOuttm.setBounds(290, 50, 80, 40);
		cobYear3.setBounds(345, 55, 55, 25);
		cobMonth3.setBounds(400, 55, 40, 25);
		cobDay3.setBounds(440, 55, 40, 25);
		lbRoomNumber.setBounds(485, 55, 40, 25);
		tfRoomNumber.setBounds(525, 55, 40, 25);
		spMessage.setBounds(10, 130, 765, 400);
		btnCreatePatient.setBounds(10,90,112,30);
		btnDeletePatient.setBounds(150,90,112,30);
		btnSearchPatient.setBounds(430,90,112,30);
		searchName.setBounds(290, 90, 90, 30);
		tfSearchName.setBounds(360, 93, 60, 25);
		
		cobYear2.setEnabled(false);
		cobMonth2.setEnabled(false);
		cobDay2.setEnabled(false);
		cobYear3.setEnabled(false);
		cobMonth3.setEnabled(false);
		cobDay3.setEnabled(false);
		tfRoomNumber.setEnabled(false);	
		
		
		tbMessage.getColumnModel().getColumn(0).setPreferredWidth(50);//设置第一列“姓名”性质
		tbMessage.getColumnModel().getColumn(0).setMaxWidth(50);
		tbMessage.getColumnModel().getColumn(0).setMinWidth(50);
		tbMessage.getColumnModel().getColumn(1).setPreferredWidth(30);//设置第二列“性别”性质
		tbMessage.getColumnModel().getColumn(1).setMaxWidth(30);
		tbMessage.getColumnModel().getColumn(1).setMinWidth(30);
		tbMessage.getColumnModel().getColumn(2).setPreferredWidth(80);//设置第三列
		tbMessage.getColumnModel().getColumn(2).setMaxWidth(80);
		tbMessage.getColumnModel().getColumn(2).setMinWidth(80);
		tbMessage.getColumnModel().getColumn(3).setPreferredWidth(55);//设置第三列
		tbMessage.getColumnModel().getColumn(3).setMaxWidth(55);
		tbMessage.getColumnModel().getColumn(3).setMinWidth(55);
		//tbMessage.getColumnModel().getColumn(4).setPreferredWidth(55);//设置第三列
		//tbMessage.getColumnModel().getColumn(4).setMaxWidth(55);
		//tbMessage.getColumnModel().getColumn(4).setMinWidth(55);
		tbMessage.getColumnModel().getColumn(5).setPreferredWidth(55);//设置第三列
		tbMessage.getColumnModel().getColumn(5).setMaxWidth(55);
		tbMessage.getColumnModel().getColumn(5).setMinWidth(55);
		tbMessage.getColumnModel().getColumn(6).setPreferredWidth(80);//设置第6列
		tbMessage.getColumnModel().getColumn(6).setMaxWidth(80);
		tbMessage.getColumnModel().getColumn(6).setMinWidth(80);
		tbMessage.getColumnModel().getColumn(7).setPreferredWidth(80);//设置第6列
		tbMessage.getColumnModel().getColumn(7).setMaxWidth(80);
		tbMessage.getColumnModel().getColumn(7).setMinWidth(80);
		tbMessage.getColumnModel().getColumn(8).setPreferredWidth(40);//设置第6列
		tbMessage.getColumnModel().getColumn(8).setMaxWidth(40);
		tbMessage.getColumnModel().getColumn(8).setMinWidth(40);
		try {
			new ClientHospitalOperateDB().getPatient(dataOfTable);
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		String InHospital;
		//各种事件监听
		cbInornot.addActionListener(new ActionListener(){
			@Override
			//是否住院的监听
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(cbInornot.isSelected()){
					cobYear2.setEnabled(true);
					cobMonth2.setEnabled(true);
					cobDay2.setEnabled(true);
					cobYear3.setEnabled(true);
					cobMonth3.setEnabled(true);
					cobDay3.setEnabled(true);
					tfRoomNumber.setEnabled(true);	
				}
				else{
					cobYear2.setEnabled(false);
					cobMonth2.setEnabled(false);
					cobDay2.setEnabled(false);
					cobYear3.setEnabled(false);
					cobMonth3.setEnabled(false);
					cobDay3.setEnabled(false);
					tfRoomNumber.setEnabled(false);	
				}
					
				
			}
			
		});
		btnCreatePatient.addActionListener(new ActionListener(){
			//添加病人按钮监听
			public void actionPerformed(ActionEvent e){
				String name = tfName.getText();
				String sex = (String) cobSex.getSelectedItem();
				String time = cobYear1.getSelectedItem()+"-"+cobMonth1.getSelectedItem()+"-"+cobDay1.getSelectedItem();
				String kind = (String) cobKind.getSelectedItem();
				String inOrNot;
				String inTime; 
				String outTime;
				String roomNumber;
				String symptom = taSymptom.getText();
				if(cbInornot.isSelected()){
					inOrNot = "是";
					inTime = cobYear2.getSelectedItem()+"-"+cobMonth2.getSelectedItem()+"-"+cobDay2.getSelectedItem();
					roomNumber = tfRoomNumber.getText();
					outTime = cobYear3.getSelectedItem()+"-"+cobMonth3.getSelectedItem()+"-"+cobDay3.getSelectedItem();
					
				}
				else{
					inOrNot = "否";
					inTime = " ";
					roomNumber = " ";
					outTime = " ";
				}
				
				//调用添加病人函数
				try {
					new ClientHospitalOperateDB().createPatient(name, sex, time, kind, inOrNot, inTime, outTime, roomNumber, symptom);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//刷新jtable
				updateTable(dataOfTable,tbMessage);
				
			}
		});
		btnDeletePatient.addActionListener(new ActionListener(){
			//删除病人按钮的监听
			public void actionPerformed(ActionEvent e){
				int selectedRow=tbMessage.getSelectedRow();
				if(selectedRow!=-1){
					String selectName = (String)tbMessage.getValueAt(selectedRow,0);
					try {
						new ClientHospitalOperateDB().deletePatient(selectName);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					updateTable(dataOfTable,tbMessage);
				}	
			}
		});
		btnSearchPatient.addActionListener(new ActionListener(){
			//搜索病人按钮的监听
			public void actionPerformed(ActionEvent e){
					try {
						new ClientHospitalOperateDB().searchPatient(dataOfTable, tfSearchName.getText());
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					tbMessage.updateUI();
			}
		});
		cobYear1.addItemListener(new ItemListener(){
			//设置天数
            public void itemStateChanged(ItemEvent event){
                if (event.getStateChange() == ItemEvent.SELECTED){
                    cobDay1.removeAllItems();
                    int days = getDayInMonth(Integer.parseInt((String)cobYear1.getSelectedItem()), Integer.parseInt((String)cobMonth1.getSelectedItem()));
                    for (int i = 1; i <= days; i++){
                        cobDay1.addItem(i);
                    }
                    cobDay1.validate();
                }
            }
        });
		cobMonth1.addItemListener(new ItemListener()
        {
			//设置天数
            public void itemStateChanged(ItemEvent event)
            {
                if (event.getStateChange() == ItemEvent.SELECTED)
                {
                    cobDay1.removeAllItems();
                    int days = getDayInMonth(Integer.parseInt((String)cobYear1.getSelectedItem()), Integer.parseInt((String)cobMonth1.getSelectedItem()));
                    for (int i = 1; i <= days; i++)
                    {
                    	if(i<10)
                    		cobDay1.addItem('0'+String.valueOf(i));
                    	else
                    		cobDay1.addItem(i);
                    	
                    }
                    cobDay1.validate();
                }
            }
        });
		
		cobYear2.addItemListener(new ItemListener(){
			//设置天数2
            public void itemStateChanged(ItemEvent event){
                if (event.getStateChange() == ItemEvent.SELECTED){
                    cobDay2.removeAllItems();
                    int days = getDayInMonth(Integer.parseInt((String)cobYear2.getSelectedItem()), Integer.parseInt((String)cobMonth2.getSelectedItem()));
                    for (int i = 1; i <= days; i++){
                        cobDay2.addItem(i);
                    }
                    cobDay2.validate();
                }
            }
        });
		cobMonth2.addItemListener(new ItemListener()
        {
			//设置天数2
            public void itemStateChanged(ItemEvent event)
            {
                if (event.getStateChange() == ItemEvent.SELECTED)
                {
                    cobDay2.removeAllItems();
                    int days = getDayInMonth(Integer.parseInt((String)cobYear2.getSelectedItem()), Integer.parseInt((String)cobMonth2.getSelectedItem()));
                    for (int i = 1; i <= days; i++)
                    {
                    	if(i<10)
                    		cobDay2.addItem('0'+String.valueOf(i));
                    	else
                    		cobDay2.addItem(i);
                    	
                    }
                    cobDay2.validate();
                }
            }
        });
		cobYear3.addItemListener(new ItemListener(){
			//设置天数2
            public void itemStateChanged(ItemEvent event){
                if (event.getStateChange() == ItemEvent.SELECTED){
                    cobDay3.removeAllItems();
                    int days = getDayInMonth(Integer.parseInt((String)cobYear3.getSelectedItem()), Integer.parseInt((String)cobMonth3.getSelectedItem()));
                    for (int i = 1; i <= days; i++){
                        cobDay3.addItem(i);
                    }
                    cobDay3.validate();
                }
            }
        });
		cobMonth3.addItemListener(new ItemListener()
        {
			//设置天数2
            public void itemStateChanged(ItemEvent event)
            {
                if (event.getStateChange() == ItemEvent.SELECTED)
                {
                    cobDay3.removeAllItems();
                    int days = getDayInMonth(Integer.parseInt((String)cobYear3.getSelectedItem()), Integer.parseInt((String)cobMonth3.getSelectedItem()));
                    for (int i = 1; i <= days; i++)
                    {
                    	if(i<10)
                    		cobDay3.addItem('0'+String.valueOf(i));
                    	else
                    		cobDay3.addItem(i);
                    	
                    }
                    cobDay3.validate();
                }
            }
        });
		
		//各种事件结束
		
		//组件加入pane
		pane.add(lbName);
		pane.add(tfName);
		pane.add(lbSex);
		pane.add(cobSex);
		pane.add(lbKind);
		pane.add(lbTime);
		pane.add(lbSymptom);
		pane.add(lbMedicine);
		pane.add(lbInornot);
		pane.add(lbIntm);
		pane.add(lbOuttm);
		pane.add(cobDay1);
		pane.add(cobMonth1);
		pane.add(cobYear1);
		pane.add(cobDay2);
		pane.add(cobMonth2);
		pane.add(cobYear2);
		pane.add(cobKind);
		pane.add(taSymptom);
		pane.add(cbInornot);
		pane.add(cobDay3);
		pane.add(cobMonth3);
		pane.add(cobYear3);
		pane.add(lbRoomNumber);
		pane.add(tfRoomNumber);
		pane.add(spMessage);
		pane.add(btnCreatePatient);
		pane.add(btnDeletePatient);
		pane.add(btnSearchPatient);
		pane.add(tfSearchName);
		pane.add(searchName);
		
		
		
		frame.setLocationByPlatform(true);  //设置frame位置
		frame.setSize(800,600);
		frame.setVisible(true);
	}
	
	
	protected void updateTable(Vector dataOfTable,JTable tbMessage){
		//调用更新jtable的数据的函数
		 try {
			new ClientHospitalOperateDB().getPatient(dataOfTable);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 //刷新ui
		 tbMessage.updateUI();
	}

	private int getDayInMonth(int year, int month)//输入年份，月份，判断天数
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
