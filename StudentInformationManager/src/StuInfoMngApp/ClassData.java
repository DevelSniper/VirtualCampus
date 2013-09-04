package StuInfoMngApp;

import java.io.Serializable;

public class ClassData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected String aclassid;
	protected String aclass;
	protected String amajor;
	
	public ClassData(String aclassid, String aclass, String amajor) 
	{
		super();
		this.aclassid=aclassid;
		this.aclass=aclass;
		this.amajor=amajor;
	}
	
	public String getaclassid()
	{
		return aclassid;
	}
	
	public void setaclassid(String aclassid)
	{
		this.aclassid = aclassid;
	}
	
	public String getaclass() 
	{
		return aclass;
	}
	
	public void setaclass(String aclass)
	{
		this.aclass = aclass;
	}
	
	public String getamajor()
	{
		return amajor;
	}
	
	public void setamajor(String amajor)
	{
		this.amajor = amajor;
	}


}
