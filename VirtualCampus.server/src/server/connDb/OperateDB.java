package server.connDb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
		int uID = user.getuID();
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
		} finally {
			conn.close();
		}
		return false;
	}

}
