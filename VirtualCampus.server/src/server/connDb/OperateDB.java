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

	
	public boolean create(String table, String cgColum, String cgData) throws SQLException {
		String sql;
		try{
  			Class.forName(DRIVER_NAME);
  			conn = DriverManager.getConnection(CONN_URL, USER_NAME, PASSWORD);
  			
  			sql = String.format("INSERT INTO %s (%s) VALUES (%s)", table, cgColum, cgData);
  			Statement stmt = conn.createStatement(); 
  			stmt.executeUpdate(sql);
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
	public boolean isExist(String table, String cdColum, String cdData) throws SQLException {
		
		String sql;
		boolean status=false;
		try{
  			Class.forName(DRIVER_NAME);
  			conn = DriverManager.getConnection(CONN_URL, USER_NAME, PASSWORD);
  			
  			sql = String.format("SELECT * FROM %s WHERE %s ='%s'", table, cdColum, cdData);
  			Statement stmt = conn.createStatement(); 
  			stmt.executeQuery(sql);
            ResultSet rs = stmt.executeQuery(sql);
              
            if (rs.first())     
    		{            
            	status = true;                    
    		}            	       	
  				
  		} catch (Exception e){
  			e.printStackTrace();
  		} finally {
  			conn.close();
  		}
		return status;
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
	public Vector<Vector<String>> query(String table, String sql, String[] colum) throws SQLException {
		Vector<Vector<String>> result = new Vector<Vector<String>>();
		try {
			Class.forName(DRIVER_NAME);
			conn = DriverManager.getConnection(CONN_URL, USER_NAME, PASSWORD);
			
			Statement stmt = conn.createStatement();
			sql = String.format("SELECT * FROM %s WHERE 1=1 %s", table, sql); 
			ResultSet rsQuery = stmt.executeQuery(sql);
			
			while(rsQuery.next()){
				Vector<String> temp = new Vector<String>();
				for (int i=0; i<colum.length; i++)
					temp.add(rsQuery.getString(colum[i]));
				result.add(temp);
			}
			
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			conn.close();
		}	
		return result;
	}

	
	public Vector<Vector<String>> query(String table, String[] colum) throws SQLException {
		Vector<Vector<String>> result = new Vector<Vector<String>>();
		String sql;
		try {
			Class.forName(DRIVER_NAME);
			conn = DriverManager.getConnection(CONN_URL, USER_NAME, PASSWORD);
			
			Statement stmt = conn.createStatement();
			sql = String.format("SELECT * FROM %s", table); 
			ResultSet rsQuery = stmt.executeQuery(sql);
			
			while(rsQuery.next()){
				Vector<String> temp = new Vector<String>();
				for (int i=0; i<colum.length; i++)
					temp.add(rsQuery.getString(colum[i]));
				result.add(temp);
			}
			
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			conn.close();
		}	
		return result;
	}
	
	
	public Vector<Vector<String>> query(String table, String cdColum,
			String cdData, String[] colum) throws SQLException {
		Vector<Vector<String>> result = new Vector<Vector<String>>();
		String sql;
		try {
			Class.forName(DRIVER_NAME);
			conn = DriverManager.getConnection(CONN_URL, USER_NAME, PASSWORD);
			
			Statement stmt = conn.createStatement();
			sql = String.format("SELECT * FROM %s WHERE %s='%s'", table, cdColum, cdData); 
			ResultSet rsQuery = stmt.executeQuery(sql);
			
			while(rsQuery.next()){
				Vector<String> temp = new Vector<String>();
				for (int i=0; i<colum.length; i++)
					temp.add(rsQuery.getString(colum[i]));
				result.add(temp);
			}
			
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			conn.close();
		}	
		return result;
	}
	public void delete(String table, String colum, String data) throws SQLException {
		String sql;
		try{
			Class.forName(DRIVER_NAME);
			conn = DriverManager.getConnection(CONN_URL, USER_NAME, PASSWORD);
			
			Statement stmt = conn.createStatement();
			
			sql = String.format("DELETE FROM %s WHERE %s='%s'", table, colum, data);
			stmt.executeUpdate(sql);	
			
		} catch (Exception e){
			e.printStackTrace();
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


}
