package conn.common;
/**
 * 消息类型
 * @author xindervella
 *
 */
public interface MessageType {
	//CLIENT
	String C_REQ_LOGIN 		= "C_REQ_LOGIN"; //传递登陆信息
	String C_REQ_CREATE 	= "C_REQ_CREATE";
	String C_REQ_QUERYUSER	= "C_REQ_QUERYUSER";
	String C_REQ_UPDATEPWD 	= "C_REQ_UPDATEPWD";
	String C_REQ_QUERYSTU	= "C_REQ_QUERYSTU";

	//SERVER
	String S_RET_STATUS 	= "S_RET_STATUS"; //用于执行某些sql语句后返回是否成功
	String S_RET_DATA		= "S_RET_DATA";
}

