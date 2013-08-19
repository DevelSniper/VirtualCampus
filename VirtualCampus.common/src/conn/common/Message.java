package conn.common;

import java.io.Serializable;
import java.util.Vector;

/**
 * 消息类
 * @author xindervella
 *
 */
public class Message implements Serializable {
	protected static final long serialVersionUID = -2034483694793482528L;
	protected String type; // 消息类型
	protected Client client; // 客户端身份（避免发错数据）
	protected String content; // 文字数据
	protected Vector<User> userdata;
	protected Object data;
	protected String[] paras;
	protected String[] vars; // 查询语句用的，见MessageType

	public String[] getVars() {
		return this.vars;
	}

	public String[] getParas() {
		return this.paras;
	}

	public String getClientID() {
		return Client.clientID;
	}

	public void setParas(String[] p) {
		this.paras = p;
	}

	public String getType() {
		return type;
	}

	public void setType(String t) {
		this.type = t;
	}

	public Client getClint() {
		return client;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String c) {
		this.content = c;
	}

	public Vector<User> getUsers() {
		return userdata;
	}

	public void setUsers(Vector<User> u) {
		this.userdata = u;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object d) {
		this.data = d;
	}

	public void setClientID(String cID) {
		Client.clientID = cID;
	}

}
