package conn.common;

import java.io.Serializable;

public class ClassInfor implements Serializable {

	private static final long serialVersionUID = -2918238206544689588L;
	protected String classId;
	protected String classNumber;
	protected String classMajor;
	
	public ClassInfor() {
		super();
	}

	public ClassInfor(String classId, String classNumber, String classMajor) 
	{
		super();
		this.classId=classId;
		this.classNumber=classNumber;
		this.classMajor=classMajor;
	}

	public String getClassId() {
		return classId;
	}

	public void setClassId(String classId) {
		this.classId = classId;
	}

	public String getClassNumber() {
		return classNumber;
	}

	public void setClassNumber(String classNumber) {
		this.classNumber = classNumber;
	}

	public String getClassMajor() {
		return classMajor;
	}

	public void setClassMajor(String classMajor) {
		this.classMajor = classMajor;
	}
	
}
