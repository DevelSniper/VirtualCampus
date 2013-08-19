package server.connDb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JOptionPane;

import server.util.UserConvUtil;

import conn.common.User;
/**
 * 数据库连接服务类
 * @author xindervella
 *
 */
public class UserDbConnSrv {
	public String SCHEMA_NAME;
	public String TABLE_NAME;
	public static String DRIVER_NAME = "com.mysql.jdbc.Driver";
	public static String CONN_URL = "jdbc:mysql://localhost:3306/";
	public Statement connStat;
	protected Connection conn;

	public UserDbConnSrv() {
		try {
			Class.forName(DRIVER_NAME);
			conn = DriverManager.getConnection(CONN_URL, "root", "123212321");

			connStat = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			System.out.println("UserDbConnSrv : Connected to DBServer.");
			SCHEMA_NAME = "holyshit";
			TABLE_NAME = "user";
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setTableName(String tn) {
		this.TABLE_NAME = tn;
	}

	public void setSchemaName(String sn) {
		this.SCHEMA_NAME = sn;
	}

	public UserDbConnSrv(String schemaName, String tableName, String username,
			String password) {
		// 构造函数
		// SCHEMA名称， 数据库表名称 ， 数据库访问用户名 ，数据库访问密码
		try {
			Class.forName(DRIVER_NAME);
			conn = DriverManager.getConnection(CONN_URL, username, password);

			connStat = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			System.out.println("UserDbConnSrv : Connected to DBServer.");
			SCHEMA_NAME = schemaName;
			TABLE_NAME = tableName;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public UserDbConnSrv(String tableName, String username, String password) {
		// 构造函数
		// 数据库表名称 ， 数据库访问用户名 ，数据库访问密码

		try {
			Class.forName(DRIVER_NAME);
			conn = DriverManager.getConnection(CONN_URL, username, password);

			connStat = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			System.out.println("UserDbConnSrv : Connected to DBServer.");
			SCHEMA_NAME = "holyshit";
			TABLE_NAME = tableName;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public UserDbConnSrv(String username, String password) {
		try {
			Class.forName(DRIVER_NAME);
			Connection conn = DriverManager.getConnection(CONN_URL, username,
					password);

			connStat = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			System.out.println("UserDbConnSrv : Connected to DBServer.");
			System.err
					.println("UserDbConnSrv : Schema and table names are not set.");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	/**
	 * 快速执行SQL UPDATE语句（无参）
	 * @param updateQuery
	 * @return
	 */
	public boolean execDbUpdate(String updateQuery) {
		try {
			System.out.println("UserDbConnSrv:Execute sql update >"
					+ updateQuery);
			connStat.execute(updateQuery);
			return true;
		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * 快速执行SQL语句
	 * @param sqlStr
	 * @return
	 */
	public ResultSet getResultDirectly(String sqlStr) {
		try {
			System.out.println("SQL COMMAND: " + sqlStr);
			return connStat.executeQuery(sqlStr);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "语句错误，请检查语法。");
			return null;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 标准 SQL UPDATE 返回状态
	 * @param sql
	 * @param paras
	 * @return
	 */
	public boolean sqlUpdate(String sql, String[] paras)
	{
		PreparedStatement ps = null;
		boolean b = true;
		try {

			ps = conn.prepareStatement(sql);
			// 给ps的问号赋值
			for (int i = 0; i < paras.length; i++) {
				ps.setString(i + 1, paras[i]);
			}

			// 执行操作
			ps.executeUpdate();

		} catch (Exception e) {
			b = false;
			e.printStackTrace();
		} finally {
			// 关闭资源
			try {
				if (ps != null)
					ps.close();

			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return b;
	}

	/**
	 * 直接通过SQL查询语句获取用户查询结果
	 * @param sql
	 * @param paras
	 * @return
	 */
	public Vector<User> sqlQueryForUser(String sql, String[] paras) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Vector<User> users = null;

		try {
			ps = conn.prepareStatement(sql);
			for (int i = 0; i < paras.length; i++) {
				ps.setString(i + 1, paras[i]);
			}
			System.out.println("UserDbConnSrv: " + ps.toString());
			rs = ps.executeQuery();
			users = UserConvUtil.getUserListFromResultSet(rs);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 关闭资源
			try {
				if (rs != null)
					rs.close();
				if (ps != null)
					ps.close();

			} catch (Exception e) {

			}
		}
		return users;

	}

	/**
	 * 添加新用户 返回是否成功
	 * @param u
	 * @return
	 */
	public boolean addUserToDb(User u) {
		String name = u.getNAME();
		String pswd = u.getPassword();
		int id = u.getsID();
		int type = u.getType();

		String sql = "insert into " + SCHEMA_NAME + "." + TABLE_NAME
				+ "(sID,password,type,name) " + "values(" + id + "," + "\'"
				+ pswd + "\'" + "," + type + "," + "\'" + name + "\'" + ")";
		boolean state = execDbUpdate(sql);
		return state;
	}

	/**
	 * 编辑用户
	 * @param id
	 * @param u
	 * @return
	 */
	public boolean editUserToDb(int id, User u) {
		String name = u.getNAME();
		String pswd = u.getPassword();
		int newid = u.getsID();
		int type = u.getType();

		String sql = "update " + SCHEMA_NAME + "." + TABLE_NAME + "set"
				+ " sID=" + newid + ", password=" + "\'" + pswd + "\'"
				+ ", type=" + type + ", name=" + "\'" + name + "\'"
				+ " where sID=" + id;
		return execDbUpdate(sql);
	}

	public boolean editUserToDb(int id, String[] vars, String[] paras) {
		String sql = "update " + SCHEMA_NAME + "." + TABLE_NAME + " set";
		for (int i = 0; i < vars.length; i++) {
			if (i > 0)
				sql += " ,";
			sql += (" " + vars[i] + "=?");
		}
		sql += " where sID=" + id;
		System.out.println("UserDbConnSrv:" + sql);
		return sqlUpdate(sql, paras);
	}

	public Vector<User> getUserById(int id) {
		String sql = "select * from " + SCHEMA_NAME + "." + TABLE_NAME
				+ " where sID=?";
		String[] paras = { String.valueOf(id) };
		return sqlQueryForUser(sql, paras);
	}

	public Vector<User> getUser(String[] vars, String[] paras) {
		String sql = "select * from " + SCHEMA_NAME + "." + TABLE_NAME
				+ " where";
		for (int i = 0; i < vars.length; i++) {
			if (i > 0)
				sql += " and";
			sql += (" " + vars[i] + "=?");
		}
		return sqlQueryForUser(sql, paras);
	}

}
