package server.connDb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import conn.common.Student;
import conn.common.User;

public class OperateDB {
	public static String DRIVER_NAME = "com.mysql.jdbc.Driver";
	public static String CONN_URL = "jdbc:mysql://121.248.63.106:3306/xindervella_VirtualCampus";
	public static String USER_NAME = "xindervella";
	public static String PASSWORD = "hu@idi@nn@0";
	public Statement connStat;
	protected Connection conn;
	
	public boolean longin(User user) throws SQLException{
		String sqlLogin;
		int uID = Integer.parseInt(user.getuID());
		String uPwd = user.getuPassword();
		
		try {
			Class.forName(DRIVER_NAME);
			conn = DriverManager.getConnection(CONN_URL, USER_NAME, PASSWORD);
			
			Statement stmt = conn.createStatement();
			sqlLogin = "SELECT * FROM vcUser WHERE uID=" + uID; 
			ResultSet rsLogin = stmt.executeQuery(sqlLogin);
			
			try{
				if(rsLogin.first()){
					String passwordInDB = rsLogin.getString("uPwd");
					if (passwordInDB.equals(uPwd) && uPwd!="" && uPwd!=null){
						user.setLogin(true);
						user.setuRole(rsLogin.getString("uRole"));
						return true;
					}
				}
			}catch (SQLException e){
				e.printStackTrace();
				user.setLogin(false);
				return false;
				
			}
			
		} catch (Exception e){
			e.printStackTrace();
			return false;
		} finally {
			conn.close();
		}
		return false;
	}

	public boolean createUser(int username, String pwd, String role) throws SQLException {
		String sqlCreateUser;
		int uID = username;
		String uPwd = pwd;
		String uRole = role;
		try {
			Class.forName(DRIVER_NAME);
			conn = DriverManager.getConnection(CONN_URL, USER_NAME, PASSWORD);
			
			Statement stmt = conn.createStatement();
			sqlCreateUser = String.format("INSERT INTO `vcUser` (`uID`, `uPwd`, `uRole`) VALUES ('%s', '%s', '%s')", uID, uPwd, uRole);
			stmt.executeUpdate(sqlCreateUser);
			return true;
			
		}catch (SQLException e){
			e.printStackTrace();
			return false;
		} catch (Exception e){
			e.printStackTrace();
			return false;
		} finally {
			conn.close();
		}
	}

	public Vector<User> queryUser() throws SQLException {
		Vector<User> users = new Vector<User>();
		String sqlQueryUser;
		
		try {
			Class.forName(DRIVER_NAME);
			conn = DriverManager.getConnection(CONN_URL, USER_NAME, PASSWORD);
			
			Statement stmt = conn.createStatement();
			sqlQueryUser = "SELECT * FROM vcUser"; 
			ResultSet rsQueryUser = stmt.executeQuery(sqlQueryUser);
			
			while(rsQueryUser.next()){
				users.add(new User(rsQueryUser.getString("uID"), rsQueryUser.getString("uPwd"), rsQueryUser.getString("uRole")));
			}
			
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			conn.close();
		}	
		
		return users;
	}


	public boolean update(String table, String cdColum, String cdData,
			String cgColum, String cgData) throws SQLException {
		String sqlQuery;
		String sqlUpdate;
		try {
			Class.forName(DRIVER_NAME);
			conn = DriverManager.getConnection(CONN_URL, USER_NAME, PASSWORD);
			
			Statement stmt = conn.createStatement();
			sqlQuery = String.format("SELECT * FROM `%s` WHERE `%s`='%s'", table, cdColum, cdData);
			ResultSet rsQuery = stmt.executeQuery(sqlQuery);
			if(rsQuery.first()){
				sqlUpdate = String.format("UPDATE `%s` SET `%s`='%s' WHERE `%s`='%s'", table, cgColum, cgData, cdColum, cdData);
				stmt.executeUpdate(sqlUpdate);
				return true;
			}else{
				return false;
			}
		}catch (SQLException e){
			e.printStackTrace();
			return false;
		} catch (Exception e){
			e.printStackTrace();
			return false;
		} finally {
			conn.close();
		}
	}

	public Student queryStudent(int username) throws SQLException {
		Student stu = new Student();
		String sqlQueryStu;
		
		try {
			Class.forName(DRIVER_NAME);
			conn = DriverManager.getConnection(CONN_URL, USER_NAME, PASSWORD);
			
			Statement stmt = conn.createStatement();
			sqlQueryStu = String.format("SELECT * FROM vcUser INNER JOIN vcStudent ON uID=sCard and uID='%s'",username); 
			ResultSet rsQueryStu = stmt.executeQuery(sqlQueryStu);
			
			if(rsQueryStu.first()){
				stu.setUserCard(String.valueOf(username));
				stu.setUserRole(rsQueryStu.getString("uRole"));
				stu.setUserID(rsQueryStu.getString("sID"));
				stu.setUserName(rsQueryStu.getString("sName"));
				stu.setUserSex(rsQueryStu.getString("sSex"));
				stu.setUserClass(rsQueryStu.getString("sClassID"));
				stu.setUserBirthday(rsQueryStu.getString("sBirthday"));
				stu.setUserHometown(rsQueryStu.getString("sHometown"));
			}
			
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			conn.close();
		}	
		
		return stu;
	}

	
}
