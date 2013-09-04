package StuInfoMngApp;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class OperateDB {
	public static String DRIVER_NAME = "com.mysql.jdbc.Driver";
	public static String CONN_URL = "jdbc:mysql://121.248.63.106:3306/xindervella_VirtualCampus";
	public static String USER_NAME = "xindervella";
	public static String PASSWORD = "hu@idi@nn@0";
	public Statement connStat;
	protected Connection conn;
	
	
	public void AddStuInfo( StudentData StudentData) throws SQLException{
		
		String sql;
		String aname = StudentData.getaname(); 
		String asex = StudentData.getasex(); 
		String aid = StudentData.getaid();
		String acard = StudentData.getacard();
		String aclassid = StudentData.getaclassid();
		String abirthday = StudentData.getabirthday();
		String abirthplace = StudentData.getabirthplace();
		try{
			Class.forName(DRIVER_NAME);
			conn = DriverManager.getConnection(CONN_URL, USER_NAME, PASSWORD);
			Statement stmt = conn.createStatement();
			sql = "INSERT INTO `xindervella_VirtualCampus`.`vcStudent` (sCard, sID, sName, sSex, sClassID, sBirthday, sHometown) VALUES ('"+acard+"','"+ aid+"','"+ aname+"','"+ asex+"','" +aclassid+ "','"+ abirthday +"', '"+abirthplace+"')" ;
			
			stmt.executeUpdate(sql);	
			
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			conn.close();
		}
	}
	
public void EditStuInfo(String aid, int row , int col , Object changed) throws SQLException{
	String sql = null;
	try{
		Class.forName(DRIVER_NAME);
		conn = DriverManager.getConnection(CONN_URL, USER_NAME, PASSWORD);
		switch(col)
		{
		    case 0:sql = "UPDATE `xindervella_VirtualCampus`.`vcStudent` SET sCard="+changed+" WHERE sID = "+aid;break;
		    case 2:sql = "UPDATE `xindervella_VirtualCampus`.`vcStudent` SET sName='"+changed+"' WHERE sID = "+aid;break;
		    case 3:sql = "UPDATE `xindervella_VirtualCampus`.`vcStudent` SET sSex='"+changed+"' WHERE sID = "+aid;break;
		    case 4:sql = "UPDATE `xindervella_VirtualCampus`.`vcStudent` SET sClassID='"+changed+"' WHERE sID = "+aid;break;
		    case 5:sql = "UPDATE `xindervella_VirtualCampus`.`vcStudent` SET sBirthday='"+changed+"' WHERE sID = "+aid;break;
		    case 6:sql = "UPDATE `xindervella_VirtualCampus`.`vcStudent` SET sHometown='"+changed+"' WHERE sID = "+aid;break;
		}
		Statement stmt = conn.createStatement();
		stmt.executeUpdate(sql);
		
	} catch (Exception e){
		e.printStackTrace();
	} finally {
		conn.close();
	}
		
	}




public void DelStuInfo(String aid) throws SQLException{
	
	String sql;
	try{
		Class.forName(DRIVER_NAME);
		conn = DriverManager.getConnection(CONN_URL, USER_NAME, PASSWORD);
		
		Statement stmt = conn.createStatement();
		
		sql = "DELETE FROM `xindervella_VirtualCampus`.`vcStudent`  WHERE sID="+aid ;
		
		stmt.executeUpdate(sql);	
		
	} catch (Exception e){
		e.printStackTrace();
	} finally {
		conn.close();
	}
}
	
public void AddClass(ClassData ClassData) throws SQLException{
		
		String sql;
		String aclassid=ClassData.getaclassid();
		String amajor=ClassData.getamajor();
		String aclass=ClassData.getaclass();
		try{
			Class.forName(DRIVER_NAME);
			conn = DriverManager.getConnection(CONN_URL, USER_NAME, PASSWORD);
			Statement stmt = conn.createStatement();
			
			sql = "INSERT INTO `xindervella_VirtualCampus`.`vcClass` (cClassID, cMajor, cClass) VALUES ('"+aclassid+"','"+ amajor+"','"+ aclass+"')" ;
			
			stmt.executeUpdate(sql);	
			
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			conn.close();
		}
	}
	
	
public boolean StuExist( String aid ) throws SQLException{	
	String sql;		
	boolean occupied =false ;		
	try{			
		Class.forName(DRIVER_NAME);		
		conn = DriverManager.getConnection(CONN_URL, USER_NAME, PASSWORD);		
		sql = "SELECT * FROM vcStudent WHERE sID ='"+aid+"'";		
		Statement stmt = conn.createStatement();		
		stmt.executeQuery(sql);          
		ResultSet rs1 = stmt.executeQuery(sql);       
		if (rs1.next())     
		{            
			occupied = true ;                    
		}            	      
			
		else          
		{            	
			occupied = false ;                
		}          	
		} catch (Exception e){	
			e.printStackTrace();	
			} finally {		
				conn.close();	
				}		
	return occupied ;	
	}

public boolean StuNameExist( String aname ) throws SQLException{	
	String sql;		
	boolean occupied = false ;		
	try{			
		Class.forName(DRIVER_NAME);		
		conn = DriverManager.getConnection(CONN_URL, USER_NAME, PASSWORD);		
		sql = "SELECT * FROM vcStudent WHERE sName ='"+aname+"'";
		Statement stmt = conn.createStatement();	       
		ResultSet rs1 = stmt.executeQuery(sql);       
		if (rs1.next())     
		{            
			occupied = true ;                    
		}            	      
			
		else          
		{            	
			occupied = false ;                
		}          	
		} catch (Exception e){	
			e.printStackTrace();	
			} finally {		
				conn.close();	
				}		
	return occupied ;	
	}

public boolean StuCardExist( String acard ) throws SQLException{	
	String sql;		
	boolean occupied = false ;		
	try{			
		Class.forName(DRIVER_NAME);		
		conn = DriverManager.getConnection(CONN_URL, USER_NAME, PASSWORD);		
		sql = "SELECT * FROM vcStudent WHERE sCard ='"+acard+"'";		
		Statement stmt = conn.createStatement();		
		stmt.executeQuery(sql);          
		ResultSet rs1 = stmt.executeQuery(sql);       
		if (rs1.next())     
		{            
			occupied = true ;                    
		}            	      
			
		else          
		{            	
			occupied = false ;                
		}          		
		} catch (Exception e){	
			e.printStackTrace();	
			} finally {		
				conn.close();	
				}		
	return occupied ;	
	}
      
      public boolean ClassExist( String aclass ) throws SQLException{
  		
  		String sql;
  		boolean occupied =false ;
  		try{
  			Class.forName(DRIVER_NAME);
  			conn = DriverManager.getConnection(CONN_URL, USER_NAME, PASSWORD);
  			
  			sql = "SELECT * FROM vcClass WHERE cClassID ='"+aclass+"'";
  			Statement stmt = conn.createStatement(); 
  			stmt.executeQuery(sql);
            ResultSet rs1 = stmt.executeQuery(sql);
              
            if (rs1.next())     
    		{            
    			occupied = true ;                    
    		}            	      
    			
    		else          
    		{            	
    			occupied = false ;                
    		}          	
  				
  			
  		} catch (Exception e){
  			e.printStackTrace();
  		} finally {
  			conn.close();
  		}
  		
  		return occupied ;
  	}
      
      public Vector<StudentData> GetStuInfo() throws SQLException{			
    	  String sqlStudent;
    	  Vector<StudentData> result = new Vector<StudentData>();
   
    	  //储存sql语句		
    	  try 
    	  {		
    		  Class.forName(DRIVER_NAME);	//加载 mysql jdbc	
    		  conn = DriverManager.getConnection(CONN_URL, USER_NAME, PASSWORD); //链接远程数据库			
    		  Statement stmt = conn.createStatement();  //用于在已经建立链接的基础上向数据库发送要执行的sql语句	
    		  sqlStudent = "SELECT * FROM vcStudent ";   //要执行的sql语句 
    		  // 常用sql语句 http://www.cnblogs.com/yubinfeng/archive/2010/11/02/1867386.html	
    		  ResultSet rsStudent = stmt.executeQuery(sqlStudent);  //通过执行sql语句生成数据库结果集的数据表	
    		  while(rsStudent.next())
    		  {
    			  StudentData student = new StudentData(null,null,null,null,null,null,null);
    			  student.setacard(rsStudent.getString(1));
    			  student.setaid(rsStudent.getString(2));
    			  student.setaname(rsStudent.getString(3));
    			  student.setasex(rsStudent.getString(4));
    			  student.setaclassid(rsStudent.getString(5));
    			  student.setabirthday(rsStudent.getString(6));
    			  student.setabirthplace(rsStudent.getString(7));
    			  result.add(student);
    		  }
    		  
    	  } catch (Exception e){	
    			  e.printStackTrace();	
    			  } finally {	
    				  // 关闭与数据库链接 ！！ 必须要写！！	
    				  conn.close();		
    				  }	
    	  
    	  return result;
    	  }
      
      public StudentData GetStudent(String aid) throws SQLException{			
    	 String sqlStudent;
    	 StudentData Student = new StudentData(null,null,null,null,null,null,null);
    	  //储存sql语句		
    	  try 
    	  {		
    		  Class.forName(DRIVER_NAME);	//加载 mysql jdbc	
    		  conn = DriverManager.getConnection(CONN_URL, USER_NAME, PASSWORD); //链接远程数据库			
    		  Statement stmt = conn.createStatement();  //用于在已经建立链接的基础上向数据库发送要执行的sql语句	
    		  sqlStudent = "SELECT * FROM vcStudent  WHERE sID ="+aid;   //要执行的sql语句 
    		  // 常用sql语句 http://www.cnblogs.com/yubinfeng/archive/2010/11/02/1867386.html	
    		  ResultSet rsStudent = stmt.executeQuery(sqlStudent);  //通过执行sql语句生成数据库结果集的数据表	
    		  while(rsStudent.next())
    		  {
    			  Student.setacard(rsStudent.getString(1));
    			  Student.setaid(rsStudent.getString(2));
    			  Student.setaname(rsStudent.getString(3));
    			  Student.setasex(rsStudent.getString(4));
    			  Student.setaclassid(rsStudent.getString(5));
    			  Student.setabirthday(rsStudent.getString(6));
    			  Student.setabirthplace(rsStudent.getString(7));
    		  }
    		  
    	  } catch (Exception e){	
    			  e.printStackTrace();	
    			  } finally {	
    				  // 关闭与数据库链接 ！！ 必须要写！！	
    				  conn.close();		
    				  }	
    	  
    	  return Student;
    	  }
      
      public Vector <StudentData> GetStuName(String aname) throws SQLException{			
    	  String sqlStudent;
    	  Vector<StudentData> result = new Vector<StudentData>();
    	  //储存sql语句		
    	  try 
    	  {		
    		  Class.forName(DRIVER_NAME);	//加载 mysql jdbc	
    		  conn = DriverManager.getConnection(CONN_URL, USER_NAME, PASSWORD); //链接远程数据库			
    		  Statement stmt = conn.createStatement();  //用于在已经建立链接的基础上向数据库发送要执行的sql语句	
    		  sqlStudent = "SELECT * FROM vcStudent WHERE sName ='"+aname+"'";   //要执行的sql语句 
    		  // 常用sql语句 http://www.cnblogs.com/yubinfeng/archive/2010/11/02/1867386.html	
    		  ResultSet rsStudent = stmt.executeQuery(sqlStudent);  //通过执行sql语句生成数据库结果集的数据表	
    		  while(rsStudent.next())
    		  {
    			  StudentData student = new StudentData(null,null,null,null,null,null,null);
    			  student.setacard(rsStudent.getString(1));
    			  student.setaid(rsStudent.getString(2));
    			  student.setaname(rsStudent.getString(3));
    			  student.setasex(rsStudent.getString(4));
    			  student.setaclassid(rsStudent.getString(5));
    			  student.setabirthday(rsStudent.getString(6));
    			  student.setabirthplace(rsStudent.getString(7));
    			  result.add(student);
    		  }
    		  
    	  } catch (Exception e){	
    			  e.printStackTrace();	
    			  } finally {	
    				  // 关闭与数据库链接 ！！ 必须要写！！	
    				  conn.close();		
    				  }	
    	  
    	  return result;
    	  }
      
      public StudentData GetStuCard(String acard) throws SQLException{			
    	  String sqlStudent;
    	  StudentData Student = new StudentData(null,null,null,null,null,null,null);
    	  //储存sql语句		
    	  try 
    	  {		
    		  Class.forName(DRIVER_NAME);	//加载 mysql jdbc	
    		  conn = DriverManager.getConnection(CONN_URL, USER_NAME, PASSWORD); //链接远程数据库			
    		  Statement stmt = conn.createStatement();  //用于在已经建立链接的基础上向数据库发送要执行的sql语句	
    		  sqlStudent = "SELECT * FROM vcStudent WHERE sCard ='"+acard+"'";   //要执行的sql语句 
    		  // 常用sql语句 http://www.cnblogs.com/yubinfeng/archive/2010/11/02/1867386.html	
    		  ResultSet rsStudent = stmt.executeQuery(sqlStudent);  //通过执行sql语句生成数据库结果集的数据表	
    		  while(rsStudent.next())
    		  {
    			  Student.setacard(rsStudent.getString(1));
    			  Student.setaid(rsStudent.getString(2));
    			  Student.setaname(rsStudent.getString(3));
    			  Student.setasex(rsStudent.getString(4));
    			  Student.setaclassid(rsStudent.getString(5));
    			  Student.setabirthday(rsStudent.getString(6));
    			  Student.setabirthplace(rsStudent.getString(7));
    		  }
    	  } catch (Exception e){	
    			  e.printStackTrace();	
    			  } finally {	
    				  // 关闭与数据库链接 ！！ 必须要写！！	
    				  conn.close();		
    				  }	
    	  
    	  return Student;
    	  }
      
      public Vector <ClassData> GetClass() throws SQLException{			
    	  String sqlClass;
    	  Vector<ClassData> result = new Vector<ClassData>();
    	  //储存sql语句		
    	  try 
    	  {		
    		  Class.forName(DRIVER_NAME);	//加载 mysql jdbc	
    		  conn = DriverManager.getConnection(CONN_URL, USER_NAME, PASSWORD); //链接远程数据库			
    		  Statement stmt = conn.createStatement();  //用于在已经建立链接的基础上向数据库发送要执行的sql语句	
    		  sqlClass = "SELECT * FROM vcClass";   //要执行的sql语句 
    		  // 常用sql语句 http://www.cnblogs.com/yubinfeng/archive/2010/11/02/1867386.html	
    		  ResultSet rsClass = stmt.executeQuery(sqlClass);  //通过执行sql语句生成数据库结果集的数据表	
    		  while(rsClass.next())
    		  {		
    			  ClassData classdata = new ClassData(null,null,null);
    			  classdata.setaclassid(rsClass.getString(1));
    			  classdata.setamajor(rsClass.getString(2));
    			  classdata.setaclass(rsClass.getString(3));
    			  result.add(classdata);
    		  }
    		  
    	  } catch (Exception e){	
    			  e.printStackTrace();	
    			  } finally {	
    				  // 关闭与数据库链接 ！！ 必须要写！！	
    				  conn.close();		
    				  }	
    	  
    	  return result;
    	  }
      
      public Vector <StudentData> Statistic(String aclass ,String asex ,String abirthday1 ,String abirthday2) throws SQLException{			
    	  String sqlStudent = "SELECT * FROM vcStudent WHERE 1=1";
    	  Vector<StudentData> result = new Vector<StudentData>();
    	  
    	  //储存sql语句		
    	  try 
    	  {		
    		  Class.forName(DRIVER_NAME);	//加载 mysql jdbc	
    		  conn = DriverManager.getConnection(CONN_URL, USER_NAME, PASSWORD); //链接远程数据库			
    		  Statement stmt = conn.createStatement();  //用于在已经建立链接的基础上向数据库发送要执行的sql语句	
    		  if(!aclass.isEmpty())
    		  {
    			  sqlStudent = sqlStudent + " AND sClassID = "+aclass;
    		  }
    		  
    		  if(!asex.equals("性别"))
    		  {
    			  sqlStudent = sqlStudent + " AND sSex = '"+asex+"'";
    		  }
    	  
    		  if(!abirthday1.isEmpty())
    		  {
    			  sqlStudent = sqlStudent + " AND sBirthday > '"+abirthday1+"'";
    		  }
    	  

    		  if(!abirthday2.isEmpty())
    		  {
    			  sqlStudent = sqlStudent + " AND sBirthday < '"+abirthday2+"'";
    		  }   
    		  // 常用sql语句 http://www.cnblogs.com/yubinfeng/archive/2010/11/02/1867386.html	
    		  ResultSet rsStudent = stmt.executeQuery(sqlStudent);  //通过执行sql语句生成数据库结果集的数据表	
    		  while(rsStudent.next())
    		  {
    			  StudentData Student = new StudentData(null,null,null,null,null,null,null);
    			  Student.setacard(rsStudent.getString(1));
    			  Student.setaid(rsStudent.getString(2));
    			  Student.setaname(rsStudent.getString(3));
    			  Student.setasex(rsStudent.getString(4));
    			  Student.setaclassid(rsStudent.getString(5));
    			  Student.setabirthday(rsStudent.getString(6));
    			  Student.setabirthplace(rsStudent.getString(7));
    			  result.add(Student);
    		  }
    		  
    	  } catch (Exception e){	
    			  e.printStackTrace();	
    			  } finally {	
    				  // 关闭与数据库链接 ！！ 必须要写！！	
    				  conn.close();		
    				  }	
    	  
    	  return result;
    	  }

	

	

}
