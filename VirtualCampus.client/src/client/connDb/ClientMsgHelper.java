package client.connDb;

import conn.common.Message;
import conn.common.MessageType;

public class ClientMsgHelper {
	protected Message msg;
	protected ClientSrv clientsrv;
	
	public ClientMsgHelper(){
		msg = new Message();
	}
	
	public void clearMsg(){
		this.msg = new Message();
	}
	
	public void loginMsg(String username, String password) {
		//登陆
		clearMsg();
		this.msg.setType(MessageType.C_REQ_LOGIN);
		this.msg.setUsername(username);
		this.msg.setPassword(password);
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
		if(msg.getType().equals(MessageType.S_RET_STATUS)){
			return msg.getData();
		}else{
			return null;
		}
	}

	public void disconnect() {
		//关闭当前连接
		if(clientsrv != null){
			clientsrv = null;
		}
		
	}

}
