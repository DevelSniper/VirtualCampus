package server.connDb;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import server.util.ServerSrvThreadMgr;
import conn.common.Message;
import conn.common.MessageType;
import conn.common.User;

/**
 * 接受多个客户端发送信息线程
 * @author xindervella
 *
 */
public class ServerThread extends Thread {
	protected Socket client;
	protected boolean isClosed;
	protected UserDbConnSrv myDb;
	protected String clientID;// 客户端线程编号(现在使用线程编号)

	public ServerThread(Socket s, String cID) {
		this.client = s;
		this.isClosed = false;
		this.clientID = cID;
		myDb = new UserDbConnSrv();
	}

	public void closeThread() {
		this.isClosed = true;
		// 关闭线程
	}

	/**
	 * 尝试登陆
	 * @param u
	 * @return
	 */
	public boolean tryLogin(User u) {
		String USER_TABLE_NAME = "holyshit.user";

		String DB_USER = "root";
		String DB_PSWD = "123212321";
		UserDbConnSrv myConnSrv = new UserDbConnSrv("HOLYSHIT",
				USER_TABLE_NAME, DB_USER, DB_PSWD);
		ResultSet result = myConnSrv.getResultDirectly("select * from "
				+ USER_TABLE_NAME + " where sID=" + u.getsID());
		try {
			if (result.first()) {
				// 找到相应的用户
				String passwordFromDb = result.getString("password");
				if (passwordFromDb.equals(u.getPassword()) && u.getPassword() != null
						&& u.getPassword() != "") {
					u.setLogin(true);;
					// 登录成功后，导入用户基本信息
					u.setNAME(result.getString("name"));
					u.setType(result.getInt("type"));
					return true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			u.setLogin(false);
			return false;
		}
		return false;
	}
	@Override
	public void run() {
		while (!this.isClosed) {
			try {
				ObjectInputStream ois = new ObjectInputStream(
						client.getInputStream());
				Message msg = (Message) ois.readObject();
				String type = msg.getType();

				//SELECT MESSAGE TYPE AND DEAL WITH IT!
				if (type.equals(MessageType.C_REQ_QUERY)) {
					// 查询用户(User)
					ServerThread sc = ServerSrvThreadMgr.get(clientID);

					String[] vars = msg.getVars();
					String[] paras = msg.getParas();
					Vector<User> users = myDb.getUser(vars, paras);
					Message m = new Message();
					m.setType(MessageType.S_RET_USER);
					m.setUsers(users);
					ObjectOutputStream oos = new ObjectOutputStream(sc
							.getClient().getOutputStream());
					oos.writeObject(m);
					oos.flush();
					ServerSrvThreadMgr.remove(clientID);
				} else if (type.equals(MessageType.C_REQ_UPDATE)) {
					ServerThread sc = ServerSrvThreadMgr.get(clientID);

					String sql = msg.getContent();
					String[] paras = msg.getParas();
					boolean state = myDb.sqlUpdate(sql, paras);
					Message m = new Message();
					if (false == state) {
						m.setType(MessageType.S_UPD_FAIL);
					} else {
						m.setType(MessageType.S_UPD_SUCC);
					}
					ObjectOutputStream oos = new ObjectOutputStream(sc
							.getClient().getOutputStream());
					oos.writeObject(m);
					oos.flush();
					ServerSrvThreadMgr.remove(clientID);
				} else if (type.equals(MessageType.C_REQ_LOGIN)) {
					ServerThread sc = ServerSrvThreadMgr.get(clientID);

					int loginID = Integer.parseInt(msg.getContent()); // 从消息中获得需要登录的ID
					User u = new User(loginID);
					String pswd = (String) msg.getData(); // data来传输密码
					u.setPassword(pswd);
					boolean loginState = tryLogin(u);
					Message m = new Message();
					m.setType(MessageType.S_RET_LOGIN);
					if (true == loginState) {
						// 登录成功
						m.setData(u);
					}
					ObjectOutputStream oos = new ObjectOutputStream(sc
							.getClient().getOutputStream());
					oos.writeObject(m);
					oos.flush();

					ServerSrvThreadMgr.remove(clientID);

				} else if (type.equals(MessageType.C_REQ_REGISTER)) {
					ServerThread sc = ServerSrvThreadMgr.get(clientID);

					User u = (User) msg.getData();
					boolean isAdded = myDb.addUserToDb(u);
					Message m = new Message();
					if (true == isAdded) {
						// 添加用户成功
						m.setType(MessageType.S_UPD_SUCC);
					} else {
						m.setType(MessageType.S_UPD_FAIL);
					}
					ObjectOutputStream oos = new ObjectOutputStream(sc
							.getClient().getOutputStream());
					oos.writeObject(m);
					oos.flush();

					ServerSrvThreadMgr.remove(clientID);
				} else if (type.equals(MessageType.C_REQ_EDITUSER)) {
					ServerThread sc = ServerSrvThreadMgr.get(clientID);

					int oldID = Integer.valueOf(msg.getContent());
					String[] vars = msg.getVars();
					String[] paras = msg.getParas();
					boolean isEdited = myDb.editUserToDb(oldID, vars, paras);
					Message m = new Message();
					if (true == isEdited) {
						// 添加用户成功
						m.setType(MessageType.S_UPD_SUCC);
					} else {
						m.setType(MessageType.S_UPD_FAIL);
					}
					ObjectOutputStream oos = new ObjectOutputStream(sc
							.getClient().getOutputStream());
					oos.writeObject(m);
					oos.flush();

					ServerSrvThreadMgr.remove(clientID);
				}else if (type.equals(MessageType.C_MSG)) {
					// DO SOMETHING WHEN RECEIVED A MSG..?
					ServerSrvThreadMgr.remove(clientID);
				}else{
					System.err.println("ServerThread:ERROR:NO SUCH MESSAGE TYPE!!!!!");
					ServerSrvThreadMgr.remove(clientID);
				}
			} catch (java.net.SocketException e) {
				System.err.println("ServerThread:Oh~!A connection failed...\nHe must have closed the window.");
				break;
			} catch (IOException e) {
				e.printStackTrace();
				break;
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				break;
			}
		}
	}

	protected Socket getClient() {
		return client;
	}

}
