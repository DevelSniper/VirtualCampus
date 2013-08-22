package conn.common;

import java.io.Serializable;

/**
 * 消息类
 * @author xindervella
 *
 */
public class Message implements Serializable {
	protected static final long serialVersionUID = -2034483694793482528L;
	protected String type; // 消息类型
	protected Client client; // 客户端身份（避免发错数据）

	protected String username;
	protected String password;
	protected Object data;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
}
