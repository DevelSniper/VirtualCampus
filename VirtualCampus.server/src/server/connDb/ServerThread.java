package server.connDb;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.ResultSet;
import java.util.Vector;

import server.util.ServerSrvThreadMgr;
import conn.common.Message;
import conn.common.MessageType;
import conn.common.Student;
import conn.common.User;

/**
 * 接受多个客户端发送信息线程
 * @author xindervella
 *
 */
public class ServerThread extends Thread {
	protected Socket client;
	protected boolean isClosed;
	protected OperateDB opdb;
	protected String clientID;// 客户端线程编号(现在使用线程编号)

	public ServerThread(Socket s, String cID) {
		this.client = s;
		this.isClosed = false;
		this.clientID = cID;
		opdb = new OperateDB();
	}

	public void closeThread() {
		this.isClosed = true;
		// 关闭线程
	}

	
	@Override
	public void run() {
		while (!this.isClosed) {
			try {
				ObjectInputStream ois = new ObjectInputStream(client.getInputStream());
				Message msg = (Message) ois.readObject();
				String type = msg.getType();
				
				if(type.equals(MessageType.C_REQ_LOGIN)){
					ServerThread sth = ServerSrvThreadMgr.get(clientID);
					String username = msg.getUsername();
					String password = (String) msg.getPassword();
					User ulg = new User(username, password);
					boolean loginStatus = opdb.longin(ulg);

					Message msgRsp = new Message();
					msgRsp.setType(MessageType.S_RET_STATUS);
					if (loginStatus == true){
						msgRsp.setData(ulg);
					}
					
					ObjectOutputStream oos = new ObjectOutputStream(sth.getClient().getOutputStream());
					oos.writeObject(msgRsp);
					oos.flush();
					ServerSrvThreadMgr.remove(clientID);
				}else if (type.equals(MessageType.C_REQ_CREATE)){
					ServerThread sth = ServerSrvThreadMgr.get(clientID);
					String[] cgColumArray = msg.getCgColumArray();
					String[] cgDataArray = msg.getCgDataArray();
					String table = msg.getTable();
					String cgColum = "";
					String cgData = "";
					for (int i=0; i<cgColumArray.length; i++){
						cgColum += cgColumArray[i];
						cgData += "'" + cgDataArray[i] + "'";
						if (i!= cgColumArray.length-1){
							cgColum += ",";
							cgData += ",";
						}	
					}
					boolean createStatus = opdb.create(table, cgColum, cgData);
					Message msgRsp = new Message();
					msgRsp.setType(MessageType.S_RET_STATUS);
					if(createStatus){
						msgRsp.setSuccess(true);
					}else {
						msgRsp.setSuccess(false);
					}
					
					ObjectOutputStream oos = new ObjectOutputStream(sth.getClient().getOutputStream());
					oos.writeObject(msgRsp);
					oos.flush();
					ServerSrvThreadMgr.remove(clientID);
				
				}
				
				else if(type.equals(MessageType.C_REQ_UPDATE)){
					ServerThread sth = ServerSrvThreadMgr.get(clientID);
					String table = msg.getTable();
					String cdColum = msg.getCdColum();
					String cdData = msg.getCdData();
					String cgColum = msg.getCgColum();
					String cgData = msg.getCgData();
					boolean createStatus = opdb.update(table, cdColum, cdData, cgColum, cgData);
					Message msgRsp = new Message();
					msgRsp.setType(MessageType.S_RET_STATUS);
					if(createStatus){
						msgRsp.setSuccess(true);
					}else {
						msgRsp.setSuccess(false);
					}
					
					ObjectOutputStream oos = new ObjectOutputStream(sth.getClient().getOutputStream());
					oos.writeObject(msgRsp);
					oos.flush();
					ServerSrvThreadMgr.remove(clientID);
				}
				
				else if (type.equals(MessageType.C_REQ_STATUS)){
					ServerThread sth = ServerSrvThreadMgr.get(clientID);
					String table = msg.getTable();
					String cdColum = msg.getCdColum();
					String cdData = msg.getCdData();
					boolean status = opdb.isExist(table, cdColum, cdData);
					Message msgRsp = new Message();
					msgRsp.setType(MessageType.S_RET_STATUS);
					if(status){
						msgRsp.setStatues(true);
					}else{
						msgRsp.setStatues(false);
					}
					
					ObjectOutputStream oos = new ObjectOutputStream(sth.getClient().getOutputStream());
					oos.writeObject(msgRsp);
					oos.flush();
					ServerSrvThreadMgr.remove(clientID);
				}
				else if (type.equals(MessageType.C_REQ_QUERY)){
					ServerThread sth = ServerSrvThreadMgr.get(clientID);
					String table = msg.getTable();
					String[] columArray = msg.getCgColumArray();
					String cdColum = msg.getCdColum();
					String cdData = msg.getCdData();
					String sql = msg.getSql();
					int colum = msg.getColum();
					Vector<Vector<String>> result = new Vector<Vector<String>>();
					if (sql != null){
						result = opdb.query(table, sql, columArray);
					}
					else if (cdColum != null){
						result = opdb.query(table,cdColum, cdData, columArray);
					}else{
						result = opdb.query(table, columArray);
					}
					Message msgRsp = new Message();
					msgRsp.setType(MessageType.S_RET_DATA);
					msgRsp.setData(result);
					ObjectOutputStream oos = new ObjectOutputStream(sth.getClient().getOutputStream());
					oos.writeObject(msgRsp);
					oos.flush();
					ServerSrvThreadMgr.remove(clientID);
				}
				else if (type.equals(MessageType.C_REQ_DELETE)){
					ServerThread sth = ServerSrvThreadMgr.get(clientID);
					String table = msg.getTable();
					String colum = msg.getCgColum();
					String data = msg.getCgData();
					opdb.delete(table, colum, data);
				}
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				else if (type.equals(MessageType.C_REQ_CREATE_USER)){
					ServerThread sth = ServerSrvThreadMgr.get(clientID);
					int username = Integer.parseInt(msg.getUsername());
					String password = (String) msg.getPassword();
					String role = (String) msg.getRole();
					boolean createStatus = opdb.createUser(username, password, role);
					Message msgRsp = new Message();
					msgRsp.setType(MessageType.S_RET_STATUS);
					if(createStatus){
						msgRsp.setSuccess(true);
					}else {
						msgRsp.setSuccess(false);
					}
					
					ObjectOutputStream oos = new ObjectOutputStream(sth.getClient().getOutputStream());
					oos.writeObject(msgRsp);
					oos.flush();
					ServerSrvThreadMgr.remove(clientID);
				
				}
				else if(type.equals(MessageType.C_REQ_QUERYUSER)){
					ServerThread sth = ServerSrvThreadMgr.get(clientID);
					Vector<User> users = opdb.queryUser();
					Message msgRsp = new Message();
					msgRsp.setType(MessageType.S_RET_DATA);
					msgRsp.setData(users);
					ObjectOutputStream oos = new ObjectOutputStream(sth.getClient().getOutputStream());
					oos.writeObject(msgRsp);
					oos.flush();
					ServerSrvThreadMgr.remove(clientID);
				
				}
				else if (type.equals(MessageType.C_REQ_QUERYSTU)){
					ServerThread sth = ServerSrvThreadMgr.get(clientID);
					int username = Integer.parseInt(msg.getUsername());
					Student stu  = opdb.queryStudent(username);
					Message msgRsp = new Message();
					msgRsp.setType(MessageType.S_RET_DATA);
					msgRsp.setData(stu);
					ObjectOutputStream oos = new ObjectOutputStream(sth.getClient().getOutputStream());
					oos.writeObject(msgRsp);
					oos.flush();
					ServerSrvThreadMgr.remove(clientID);
				
				}
				
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}

	protected Socket getClient() {
		return client;
	}

}
