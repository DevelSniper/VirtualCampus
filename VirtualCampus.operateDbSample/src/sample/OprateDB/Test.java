package sample.OprateDB;

import java.sql.SQLException;
import java.util.Scanner;

public class Test {
	 public static void main(String[] args) throws SQLException {
		 OperateDB opdb = new OperateDB();
		 opdb.printAllUserInDB();
		 
//		 String userID;
//		 String password;
//		 String role;
//		 
//		 Scanner in = new Scanner(System.in);
//		 System.out.print("输入一卡通:");
//		 userID = in.next();
//		 System.out.print("输入密码:");
//		 password = in.next();
//		 System.out.print("输入身份:");
//		 role = in.next();
//		 opdb.insertUserToDB(userID, password, role);

//		 opdb.printAllUserInDB();
	 }
}
