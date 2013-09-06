package conn.common;
/**
 * 消息类型
 * @author xindervella
 *
 */
public interface MessageType {
	//CLIENT
	String C_REQ_LOGIN 			= "C_REQ_LOGIN"; //传递登陆信息
	String C_REQ_CREATE 		= "C_REQ_CREATE";
	String C_REQ_UPDATE 		= "C_REQ_UPDATE";
	String C_REQ_STATUS			= "C_REQ_STATUS";
	String C_REQ_QUERY 			= "C_REQ_QUERY";
	String C_REQ_DELETE 		= "C_REQ_DELETE";	
	
	
	String C_REQ_QUERYUSER		= "C_REQ_QUERYUSER";
	String C_REQ_QUERYSTU		= "C_REQ_QUERYSTU";
	String C_REQ_CREATE_USER 	= "C_REQ_CREATE_USER";
	
	
	
	//SERVER
	String S_RET_STATUS 	= "S_RET_STATUS"; //用于执行某些sql语句后返回是否成功
	String S_RET_DATA		= "S_RET_DATA";


	
}

