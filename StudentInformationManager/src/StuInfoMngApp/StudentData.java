package StuInfoMngApp;

import java.io.Serializable;

public class StudentData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -143350152487622363L;

	protected String aid;
	protected String aname;
	protected String asex;
	protected String acard;
	protected String abirthday;
	protected String abirthplace;
	protected String aclassid;
	
	public StudentData(String aname, String asex, String aid,String acard, String aclassid, String birthday,String abirthplace) 
	{
		super();
		this.aname=aname;
		this.asex=asex;
		this.aid=aid;
		this.acard=acard;
		this.aclassid=aclassid;
		this.abirthday=abirthday;
		this.abirthplace=abirthplace;
	}

	public String getaid() {
		return aid;
	}

	public void setaid(String aid) {
		this.aid = aid;
	}

	public  String getaname() {
		return aname;
	}

	public void setaname(String aname) {
		this.aname = aname;
	}

	public String getasex() {
		return asex;
	}

	public void setasex(String asex) {
		this.asex = asex;
	}

	public String getacard() {
		return acard;
	}

	public  void setacard(String acard) {
		this.acard = acard;
	}

	public String getabirthday() {
		return abirthday;
	}

	public void setabirthday(String abirthday) {
		this.abirthday = abirthday;
	}

	public String getabirthplace() {
		return abirthplace;
	}

	public void setabirthplace(String abirthplace) {
		this.abirthplace = abirthplace;
	}

	public String getaclassid() {
		return aclassid;
	}

	public void setaclassid(String aclassid) {
		this.aclassid = aclassid;
	}

}
