import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Vector;
public class ClientHospitalOperateDB {
	public static String DRIVER_NAME = "com.mysql.jdbc.Driver";
	public static String CONN_URL = "jdbc:mysql://121.248.63.106:3306/xindervella_VirtualCampus";
	public static String USER_NAME = "xindervella";
	public static String PASSWORD = "hu@idi@nn@0";
	public Statement connStat;
	protected Connection conn;
	
	public String getAppointmentStatus(String cardID)throws SQLException{
		//获取指定cardID的预约信息
		String sql;
		try{
			Class.forName(DRIVER_NAME);
			//System.out.println("d");
			conn = DriverManager.getConnection(CONN_URL, USER_NAME, PASSWORD);
			Statement stmt = conn.createStatement();
			sql = "SELECT * FROM vcHospitalAppointment";
			stmt.executeQuery(sql);
			ResultSet rs = stmt.executeQuery(sql);//获取所有预约信息存于rs中
			while(rs.next()){
				if(rs.getString(1).equals(cardID))
					return (rs.getString(4)+"  "+rs.getString(5)+"  "+rs.getString(6));
			}
			return "未预约";
		
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			conn.close();
		}
		return null;

	}
	
	public boolean makeAppointment(String Card,String Name,String Sex,String Kind ,String Date,String Status)throws SQLException{
		//学生make预约
		String sql;
		try{
			Class.forName(DRIVER_NAME);
			conn = DriverManager.getConnection(CONN_URL, USER_NAME, PASSWORD);
			Statement stmt = conn.createStatement();
			sql = "SELECT * FROM vcHospitalAppointment WHERE aCardID='"+Card+"'";
			stmt.executeQuery(sql);
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next())
				return false;//如果已经有该学生的预约，则直接返回
			
			Class.forName(DRIVER_NAME);
			//System.out.println("d");
			conn = DriverManager.getConnection(CONN_URL, USER_NAME, PASSWORD);
			stmt = conn.createStatement();
			sql = "INSERT INTO `xindervella_VirtualCampus`.`vcHospitalAppointment` (aCardID, aName, aSex, aKind, aDate,aStatus) VALUES ('"+ Card+"','"+ Name+"','"+ Sex+"','" +Kind+ "','"+ Date +"','"+ Status +"')" ;
			
			stmt.executeUpdate(sql);	
			
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			conn.close();
		}
		return true;
	}
	
	public void getAppointment(Vector dataOfTable)throws SQLException{
		//获取预约信息
		String sql;
		try{
			Class.forName(DRIVER_NAME);
			//System.out.println("d");
			conn = DriverManager.getConnection(CONN_URL, USER_NAME, PASSWORD);
			Statement stmt = conn.createStatement();
			sql = "SELECT * FROM vcHospitalAppointment";
			stmt.executeQuery(sql);
			ResultSet rs = stmt.executeQuery(sql);//获取所有预约信息存于rs中
			while(rs.next()){
				Vector temp = new Vector();
				for(int i=1;i<7;i++)
					temp.addElement(rs.getString(i));
				dataOfTable.addElement(temp);
			}
			stmt.close();
		
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			conn.close();
		}

	}
	
	public void deleteAppointment(String cardID) throws SQLException{
		//传入cardID，删除此人的预约
		String sql;
		try{
			Class.forName(DRIVER_NAME);
			//System.out.println("d");
			conn = DriverManager.getConnection(CONN_URL, USER_NAME, PASSWORD);
			Statement stmt = conn.createStatement();
			sql = "DELETE FROM vcHospitalAppointment WHERE aCardID='"+cardID+"'";
			
			stmt.executeUpdate(sql);	
			
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			conn.close();
		}
		
	}
	
	
	
	public void agreeAppointment(String cardID) throws SQLException{
		//传入cardID，同意此人的预约
		String sql;
		try{
			Class.forName(DRIVER_NAME);
			//System.out.println("d");
			conn = DriverManager.getConnection(CONN_URL, USER_NAME, PASSWORD);
			Statement stmt = conn.createStatement();
			sql = "UPDATE vcHospitalAppointment SET aStatus = '同意' WHERE aCardID='"+cardID+"'";
			stmt.executeUpdate(sql);		
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			conn.close();
		}
		
	}
	
	public void cancelAppointment(String cardID) throws SQLException{
		//传入cardID，撤销此人的预约
		String sql;
		try{
			Class.forName(DRIVER_NAME);
			//System.out.println("d");
			conn = DriverManager.getConnection(CONN_URL, USER_NAME, PASSWORD);
			Statement stmt = conn.createStatement();
			sql = "UPDATE vcHospitalAppointment SET aStatus = '待受理' WHERE aCardID='"+cardID+"'";
			stmt.executeUpdate(sql);		
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			conn.close();
		}
		
	}
	
	public void getMessage(Vector dataOfTable,String Name) throws SQLException{
		//传入Name，搜寻所有和此人有关的留言并存入dataOfTable
		String sql;
		try{
			dataOfTable.clear();//清空显示的留言表
			Class.forName(DRIVER_NAME);
			//System.out.println("d");
			conn = DriverManager.getConnection(CONN_URL, USER_NAME, PASSWORD);
			Statement stmt = conn.createStatement();
			sql = "SELECT * FROM vcHospitalMessage";
			stmt.executeQuery(sql);
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				Vector<String> temp = new Vector<String>();
				String fromName=rs.getString(2);
				String toName=rs.getString(3);
				if(fromName.equals(Name)||toName.equals(Name)){
					temp.addElement(fromName);
					temp.addElement(rs.getString(4));
					dataOfTable.addElement(temp);
				}													
			}
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			conn.close();
		}
		
	}
	public void leaveMessage(String fromName,String toName,String message)throws SQLException{
		//留下留言
		String sql;
		try{
			Class.forName(DRIVER_NAME);
			//System.out.println("d");
			conn = DriverManager.getConnection(CONN_URL, USER_NAME, PASSWORD);
			Statement stmt = conn.createStatement();
			//获取留言ID号
			/*
			sql = "SELECT * FROM vcHospitalMessage";
			ResultSet rs=stmt.executeQuery(sql);
			int numOfMessage=0;
			if(!rs.next())
				numOfMessage++;
			else{
				do
					numOfMessage=Integer.parseInt(rs.getString(1));
				while(rs.next());
				numOfMessage++;
			}     
			 */
					
			//增加新的留言
			sql = "INSERT INTO vcHospitalMessage (mFrom,mTo,mMessage) VALUES ('"+ fromName+"','"+ toName+"','" +message+ "')" ;//留言ID号已经设置为自增
			stmt.executeUpdate(sql);
				
			
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			conn.close();
		}
	}
	public void getMessageNameList(Vector listOfName) throws SQLException{
		//获取留言人员树
		String sql;
		try{
			listOfName.clear();//清空显示的留言表
			Class.forName(DRIVER_NAME);
			//System.out.println("d");
			conn = DriverManager.getConnection(CONN_URL, USER_NAME, PASSWORD);
			Statement stmt = conn.createStatement();
			sql = "SELECT * FROM vcHospitalMessage";
			stmt.executeQuery(sql);
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				String fromName=rs.getString(2);
				String toName=rs.getString(3);
				if(toName.equals("ALL")){
					int flag=1;
					for(int i=0;i<listOfName.size();i++)
						if(listOfName.get(i).equals(fromName)){
							flag=0;
							break;
						}
					if(flag==1)
						listOfName.addElement(fromName);
				}													
			}
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			conn.close();
		}
		
	}
	public void getMessageOf(Vector dataOfTable,String selName) throws SQLException{
		//传入Name，搜寻所有和此人有关的留言并存入dataOfTable
		String sql;
		try{
			dataOfTable.clear();//清空显示的留言表
			Class.forName(DRIVER_NAME);
			//System.out.println("d");
			conn = DriverManager.getConnection(CONN_URL, USER_NAME, PASSWORD);
			Statement stmt = conn.createStatement();
			sql = "SELECT * FROM vcHospitalMessage";
			stmt.executeQuery(sql);
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				String fromName=rs.getString(2);
				String toName=rs.getString(3);
				if(fromName.equals(selName)||toName.equals(selName)){
					Vector temp = new Vector();
					temp.addElement(fromName);
					//temp.addElement(toName);
					temp.addElement(rs.getString(4));
					dataOfTable.addElement(temp);
				}													
			}
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			conn.close();
		}
		
	}
	
	public void createPatient(String name,String sex,String time,String kind,String inOrNot,String inTime,String outTime,String roomNumber,String symptom)throws SQLException{
		//增加病人信息
		String sql;
		try{
			Class.forName(DRIVER_NAME);
			//System.out.println("d");
			conn = DriverManager.getConnection(CONN_URL, USER_NAME, PASSWORD);
			Statement stmt = conn.createStatement();
			sql = "INSERT INTO vcHospitalPatient (pName,pSex,pTime,pKind,pSymptom,pInOrNot,pInTime,pOutTime,pRoomNumber) VALUES ('"+ name+"','"+ sex+"','"+ time+"','" +kind+ "','"+ symptom +"','"+ inOrNot +"','"+ inTime +"','"+ outTime +"','"+ roomNumber +"')" ;
			stmt.executeUpdate(sql);	
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			conn.close();
		}
	}
	
	public void getPatient(Vector dataOfTable)throws SQLException{
		//查询所有病人信息
		String sql;
		dataOfTable.clear();
		try{
			Class.forName(DRIVER_NAME);
			//System.out.println("d");
			conn = DriverManager.getConnection(CONN_URL, USER_NAME, PASSWORD);
			Statement stmt = conn.createStatement();
			sql = "SELECT * FROM vcHospitalPatient";
			stmt.executeQuery(sql);
			ResultSet rs = stmt.executeQuery(sql);//获取所有预约信息存于rs中
			while(rs.next()){
				Vector temp = new Vector();
				for(int i=2;i<11;i++)
					temp.addElement(rs.getString(i));
				dataOfTable.addElement(temp);
			}
			stmt.close();
		
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			conn.close();
		}

	}
	public void deletePatient(String selectName) throws SQLException{
		//传入病人name，删除此人
				String sql;
				try{
					Class.forName(DRIVER_NAME);
					//System.out.println("d");
					conn = DriverManager.getConnection(CONN_URL, USER_NAME, PASSWORD);
					Statement stmt = conn.createStatement();
					sql = "DELETE FROM vcHospitalPatient WHERE pName='"+selectName+"'";
					stmt.executeUpdate(sql);	
					
				} catch (Exception e){
					e.printStackTrace();
				} finally {
					conn.close();
				}
	}
	
	public void searchPatient(Vector dataOfTable,String searchName) throws SQLException{
		//传入病人name，获取并只返回此人信息
				String sql;
				dataOfTable.clear();
				try{
					//System.out.println("1");
					dataOfTable.clear();
					Class.forName(DRIVER_NAME);
					//System.out.println("d");
					conn = DriverManager.getConnection(CONN_URL, USER_NAME, PASSWORD);
					Statement stmt = conn.createStatement();
					sql = "SELECT * FROM vcHospitalPatient WHERE pName='"+searchName+"'";
					stmt.executeQuery(sql);
					ResultSet rs = stmt.executeQuery(sql);//获取所有预约信息存于rs中
				//	System.out.println(rs.getString(1));
					while(rs.next()){
						System.out.println(rs.getString(1));
						Vector temp = new Vector();
						for(int i=2;i<11;i++)
							temp.addElement(rs.getString(i));
						dataOfTable.addElement(temp);
					}
					stmt.close();	
					
				} catch (Exception e){
					e.printStackTrace();
				} finally {
					conn.close();
				}
	}
	public Student getStudentInfo(String cardId) throws SQLException{
		//查询并返回指定cardId的学生对象
		String sql;
		try{
			Student testStudent = new Student();
			Class.forName(DRIVER_NAME);
			//System.out.println("d");
			conn = DriverManager.getConnection(CONN_URL, USER_NAME, PASSWORD);
			Statement stmt = conn.createStatement();
			sql = "SELECT * FROM vcStudent WHERE sCard='"+cardId+"'";
			stmt.executeQuery(sql);
			ResultSet rs = stmt.executeQuery(sql);//获取所有预约信息存于rs中
			while(rs.next()){
					testStudent.setUserCard(rs.getString(1));
					testStudent.setUserID(rs.getString(2));
					testStudent.setUserName(rs.getString(3));
					testStudent.setUserSex(rs.getString(4));
					testStudent.setUserClass(rs.getString(5));
					testStudent.setUserBirthday(rs.getString(6));
					testStudent.setUserHometown(rs.getString(7));
					
			}
			stmt.close();	
			return testStudent;
			
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			conn.close();
		}
		return null;
	}
	
	public Teacher getTeacherInfo(String cardId) throws SQLException{
		//查询并返回指定cardId的老师对象
		String sql;
		try{
			Teacher testTeacher = new Teacher();
			Class.forName(DRIVER_NAME);
			//System.out.println("d");
			conn = DriverManager.getConnection(CONN_URL, USER_NAME, PASSWORD);
			Statement stmt = conn.createStatement();
			sql = "SELECT * FROM vcTeacher WHERE tCard='"+cardId+"'";
			stmt.executeQuery(sql);
			ResultSet rs = stmt.executeQuery(sql);//获取所有预约信息存于rs中
			while(rs.next()){
					testTeacher.setUserCard(rs.getString(1));
					testTeacher.setUserID(rs.getString(2));
					testTeacher.setUserName(rs.getString(3));
					testTeacher.setUserSex(rs.getString(4));
					testTeacher.setUserClass(rs.getString(5));
					
			}
			stmt.close();	
			return testTeacher;
			
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			conn.close();
		}
		return null;
	}


}



//public void makeAppointment
