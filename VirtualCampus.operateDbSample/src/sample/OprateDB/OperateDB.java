package sample.OprateDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OperateDB {
	public static String DRIVER_NAME = "com.mysql.jdbc.Driver";
	public static String CONN_URL = "jdbc:mysql://121.248.63.106:3306/xindervella_VirtualCampus";
	public static String USER_NAME = "xindervella";
	public static String PASSWORD = "hu@idi@nn@0";
	public Statement connStat;
	protected Connection conn;
	
	
	/**
	 * 输出数据库中所有用户
	 * @throws SQLException
	 */
	public void printAllUserInDB() throws SQLException{
		//在终端打印出相应结果
		
		String sqlPrintUser;	//储存sql语句
		try {
			Class.forName(DRIVER_NAME);	//加载 mysql jdbc
			conn = DriverManager.getConnection(CONN_URL, USER_NAME, PASSWORD); //链接远程数据库
			

			Statement stmt = conn.createStatement();  //用于在已经建立链接的基础上向数据库发送要执行的sql语句
			sqlPrintUser = "SELECT * FROM vcUser";   //要执行的sql语句 
			// 常用sql语句 http://www.cnblogs.com/yubinfeng/archive/2010/11/02/1867386.html
			ResultSet rsPrintUser = stmt.executeQuery(sqlPrintUser);  //通过执行sql语句生成数据库结果集的数据表
			
			
			while(rsPrintUser.next()){
				// 打印出 rsUser结果集 中的全部用户信息
				System.out.println("一卡通： " + rsPrintUser.getString("uID") + "\t" 
									+ "密码： " + rsPrintUser.getString("uPWD") + "\t"
									+ "身份： " + rsPrintUser.getString("uRole"));
			}
			
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			// 关闭与数据库链接 ！！ 必须要写！！
			conn.close();
		}
	}
	
	/**
	 * 在数据库中插入新的用户信息
	 * @param userID
	 * @param password
	 * @param role
	 * @throws SQLException
	 */
	public void insertUserToDB(String userID, String password, String role) throws SQLException{
		//向数据库中增加新用户
		
		String sqlInsertUser;
		try{
			Class.forName(DRIVER_NAME);
			conn = DriverManager.getConnection(CONN_URL, USER_NAME, PASSWORD);
			
			Statement stmt = conn.createStatement();
			sqlInsertUser = String.format("INSERT INTO `xindervella_VirtualCampus`.`vcUser` (`uID`, `uPwd`, `uRole`) VALUES ('%s', '%s', '%s')", userID, password, role);
			//如果传递进来参数为  insertUserToDB( "213110561", "11111", "student")
			// sqlInsertUser 就是 "INSERT INTO `xindervella_VirtualCampus`.`vcUser` (`uID`, `uPwd`, `uRole`) VALUES ('213110561', '1111', 'student')"
			stmt.executeUpdate(sqlInsertUser);	//直接执行sql语句  创建新用户不需要获取信息 所以不需要生成结果数据集
		
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			conn.close();
		}
	}
}
