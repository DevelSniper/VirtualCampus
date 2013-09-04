//package conn.common;

import java.io.Serializable;
/**
 * 用户类 基础类（超类）
 * @author xindervella
 *
 */
public class User implements Serializable {

	protected static final long serialVersionUID = 5577101422194718856L;
	protected String uID;
	protected String uPassword;
	protected String uRole;
	protected String uSex;
	protected boolean isLogin = false;
	

	public User(String uID, String uPassword, String uRole) {
		super();
		this.uID = uID;
		this.uPassword = uPassword;
		this.uRole = uRole;
	}

	public User(String uID, String uPassword) {
		super();
		this.uID = uID;
		this.uPassword = uPassword;
	}

	public User(String uID) {
		super();
		this.uID = uID;
	}

	public String getuID() {
		return uID;
	}

	public void setuID(String uID) {
		this.uID = uID;
	}

	public String getuPassword() {
		return uPassword;
	}

	public void setuPassword(String uPassword) {
		this.uPassword = uPassword;
	}

	public String getuRole() {
		return uRole;
	}
	

	public void setuRole(String uRole) {
		this.uRole = uRole;
	}


	public boolean isLogin() {
		return isLogin;
	}

	public void setLogin(boolean isLogin) {
		this.isLogin = isLogin;
	}

}
