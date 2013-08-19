package server.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import conn.common.User;

/**
 * 用于转换数据
 * @author xindervella
 *
 */
public class UserConvUtil {
	public static Vector<User> getUserListFromResultSet(ResultSet rs){
		Vector<User> users = new Vector<User>();
		try {
			while(rs.next()){
				User u = new User(rs.getInt("sID"), rs.getString("name"), rs.getInt("type"));
				users.add(u);
			}
			System.out.println("UserConvUtil: DONE.");
			return users;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
