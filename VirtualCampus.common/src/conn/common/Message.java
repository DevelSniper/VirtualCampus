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
	
	protected String schema;
	protected String table;
	protected String cdColum;
	protected String cdData;
	protected String cgColum;
	protected String cgData;

	protected String username;
	protected String password;
	protected String role;
	protected Object data;
	protected boolean isSuccess;
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
	public String getSchema() {
		return schema;
	}
	public void setSchema(String schema) {
		this.schema = schema;
	}
	public String getTable() {
		return table;
	}
	public void setTable(String table) {
		this.table = table;
	}
	public String getCdColum() {
		return cdColum;
	}
	public void setCdColum(String cdColum) {
		this.cdColum = cdColum;
	}
	public String getCdData() {
		return cdData;
	}
	public void setCdData(String cdData) {
		this.cdData = cdData;
	}
	public String getCgColum() {
		return cgColum;
	}
	public void setCgColum(String cgColum) {
		this.cgColum = cgColum;
	}
	public String getCgData() {
		return cgData;
	}
	public void setCgData(String cgData) {
		this.cgData = cgData;
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
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public boolean isSuccess() {
		return isSuccess;
	}
	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}
	

}
