package conn.common;

import java.io.Serializable;
/**
 * 用户类 基础类（超类）
 * @author xindervella
 *
 */
public class User implements Serializable {

	protected static final long serialVersionUID = 5577101422194718856L;
	protected int uID;
	protected String uPassword;
	protected String uRole;
	protected boolean isLogin = false;
	

	public User(int uID, String uPassword, String uRole) {
		super();
		this.uID = uID;
		this.uPassword = uPassword;
		this.uRole = uRole;
	}

	public User(int uID, String uPassword) {
		super();
		this.uID = uID;
		this.uPassword = uPassword;
	}

	public User(int uID) {
		super();
		this.uID = uID;
	}

	public int getuID() {
		return uID;
	}

	public void setuID(int uID) {
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


	public int getsID() {
		return uID;
	}


	public boolean isLogin() {
		return isLogin;
	}

	public void setLogin(boolean isLogin) {
		this.isLogin = isLogin;
	}

	public String getIdAsString(){
		return String.valueOf(this.uID);
	}

}
