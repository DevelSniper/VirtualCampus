package conn.common;
/**
 * 消息类型
 * @author xindervella
 *
 */
public interface MessageType {
	//CLIENT
	String C_REQ_UPDATE = "C_REQ_UPDATE";
	String C_REQ_QUERY = "C_REQ_QUERY";
	String C_REQ_LOGIN = "C_REQ_LOGIN"; // 请求登录,使用content传用户名，data传密码
	String C_REQ_REGISTER = "C_REQ_REGISTER"; // 用户注册请求
	String C_REQ_EDITUSER = "C_REQ_EDITUSER";
	String C_MSG = "C_MSG";

	//SERVER
	String S_UPD_SUCC = "S_UPD_SUCC";
	String S_UPD_FAIL = "S_UPD_FAIL";
	String S_RET_USER = "S_RET_USER"; // 返回查询结果(用户)
	String S_RET_LOGIN = "S_RET_LOGIN"; // 返回登录结果（成功/失败 用户数据）,
										// 登录是否成功可以由.data是否为空判断，返回User类型具体值即登陆成功
	String S_MSG = "S_MSG";
}

