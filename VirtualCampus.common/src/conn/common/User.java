package conn.common;

import java.io.Serializable;
/**
 * 用户类 基础类（超类）
 * 数据库字段：
 * 一卡通号	sID			(int)
 * 密码		password	(str)
 * 用户类型	type		(int)
 * 姓名		name		(str)
 * @author xindervella
 *
 */
public class User implements Serializable {
	/**
	 *
	 */
	protected static final long serialVersionUID = 5577101422194718856L;
	protected int sID;
	protected String NAME;
	protected String password;
	protected int type;
	protected boolean isLogin = false;
	protected String USER_TABLE_NAME = "holyshit.user";

	protected String DB_USER = "root";
	protected String DB_PSWD = "123212321";

	public User(int id, String name, int utype) {
		sID = id;
		NAME = name;
		type = utype;
	}

	public User(int id) {
		sID = id;
	}

	public int getsID() {
		return sID;
	}

	public void setsID(int sID) {
		this.sID = sID;
	}

	public String getNAME() {
		return NAME;
	}

	public void setNAME(String nAME) {
		NAME = nAME;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public boolean isLogin() {
		return isLogin;
	}

	public void setLogin(boolean isLogin) {
		this.isLogin = isLogin;
	}


}
