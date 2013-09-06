package conn.common;

import java.io.Serializable;

public class Teacher implements Serializable {

	private static final long serialVersionUID = -8595326531037713998L;
	
	protected String userCard;
	protected String userRole;
	protected String userID;
	protected String userName;
	protected String userSex;
	protected String userClass;
	public String getUserCard() {
		return userCard;
	}
	public void setUserCard(String userCard) {
		this.userCard = userCard;
	}
	public String getUserRole() {
		return userRole;
	}
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserSex() {
		return userSex;
	}
	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}
	public String getUserClass() {
		return userClass;
	}
	public void setUserClass(String userClass) {
		this.userClass = userClass;
	}
	
	
}
