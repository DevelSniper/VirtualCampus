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
	
	public void makeAppointment(String Card,String Name,String Sex,String Kind ,String Date,String Status)throws SQLException{
		String sql;
		try{
			Class.forName(DRIVER_NAME);
			//System.out.println("d");
			conn = DriverManager.getConnection(CONN_URL, USER_NAME, PASSWORD);
			Statement stmt = conn.createStatement();
			sql = "INSERT INTO `xindervella_VirtualCampus`.`vcHospitalAppointment` (aCardID, aName, aSex, aKind, aDate,aStatus) VALUES ('"+ Card+"','"+ Name+"','"+ Sex+"','" +Kind+ "','"+ Date +"','"+ Status +"')" ;
			
			stmt.executeUpdate(sql);	
			
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			conn.close();
		}
	}
	
	public void getAppointment(Vector dataOfTable)throws SQLException{
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
		//传入cardID，删除此人的预约
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
				if(fromName.equals(Name)||toName==Name){
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
	public void getListOfName(Vector listOfName) throws SQLException{
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
	
	
	
	

}



//public void makeAppointment
