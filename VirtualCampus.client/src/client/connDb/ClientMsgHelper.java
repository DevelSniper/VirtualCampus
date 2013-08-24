package client.connDb;

import conn.common.Message;
import conn.common.MessageType;

public class ClientMsgHelper {
	protected Message msg;
	protected ClientSrv clientsrv;
	
	public Message getMsg() {
		return msg;
	}

	public ClientMsgHelper(){
		this.msg = new Message();
	}
	
	public void clearMsg(){
		this.msg = new Message();
	}

	public void sendMsg() {
		// 发送消息
		if( clientsrv == null){
			clientsrv = new ClientSrv();
		}
		clientsrv.send(msg);
			
	}

	public void recieveMsg() {
		// 接收消息
		if( clientsrv == null){
			clientsrv = new ClientSrv();
		}
		this.msg = clientsrv.receive();
		
	}

	public Object getDataInMsg(){
		return msg.getData();
	}

	public void disconnect() {
		// 关闭当前连接
		if(clientsrv != null){
			clientsrv = null;
		}
		
	}
	
	public void loginMsg(String username, String password) {
		// 登陆
		clearMsg();
		this.msg.setType(MessageType.C_REQ_LOGIN);
		this.msg.setUsername(username);
		this.msg.setPassword(password);
	}

	public void createUserMsg(String username, String password, String role) {
		// 创建新用户
		clearMsg();
		this.msg.setType(MessageType.C_REQ_CREATE);
		this.msg.setUsername(username);
		this.msg.setPassword(password);
		this.msg.setRole(role);
	}

	public void queryUser() {
		// 查询全部用户
		clearMsg();
		this.msg.setType(MessageType.C_REQ_QUERYUSER);
		
	}

	public void updatePwd(String username, String password) {
		// 修改用户密码
		clearMsg();
		this.msg.setType(MessageType.C_REQ_UPDATE);
		this.msg.setUsername(username);
		this.msg.setPassword(password);
		
	}

	public void queryStudent(String username) {
		// 查询用户详细信息
		clearMsg();
		this.msg.setType(MessageType.C_REQ_QUERYSTU);
		this.msg.setUsername(username);
		
	}

	/**
	 * 执行Update相关操作
	 * @param table 需更新数据表
	 * @param cdColum 条件列
	 * @param cdData 条件
	 * @param cgColum 需更改列
	 * @param cgData 更改数据
	 */
	public void update(String table, String cdColum, String cdData,
			String cgColum, String cgData) {
		clearMsg();
		this.msg.setType(MessageType.C_REQ_UPDATE);
		this.msg.setTable(table);
		this.msg.setCdColum(cdColum);
		this.msg.setCdData(cdData);
		this.msg.setCgColum(cgColum);
		this.msg.setCgData(cgData);
		
	}

}
