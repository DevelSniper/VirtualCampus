package conn.common;
/**
 * 消息类型
 * @author xindervella
 *
 */
public interface MessageType {
	//CLIENT
	String C_REQ_LOGIN = "C_REQ_LOGIN"; //传递登陆信息

	//SERVER
	String S_RET_STATUS = "S_RET_STATUS"; //用于执行某些sql语句后返回是否成功
}

