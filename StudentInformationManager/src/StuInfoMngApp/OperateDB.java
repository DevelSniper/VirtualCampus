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
	
	
	public void AddStuInfo(String aname, String asex, String aid, String acard, String aclass , String abirthday , String abirthplace ) throws SQLException{
		
		String sql;
		try{
			Class.forName(DRIVER_NAME);
			conn = DriverManager.getConnection(CONN_URL, USER_NAME, PASSWORD);
			
			Statement stmt = conn.createStatement();
			sql = "INSERT INTO `xindervella_VirtualCampus`.`vcStudent` (sCard, sID, sName, sSex, sClassID, sBirthday, sHometown) VALUES ('"+acard+"','"+ aid+"','"+ aname+"','"+ asex+"','" +aclass+ "','"+ abirthday +"', '"+abirthplace+"')" ;
			
			stmt.executeUpdate(sql);	
			
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			conn.close();
		}
	}
	
public void EditStuInfo(String aname, String asex, String aid, String acard, String aclass , String abirthday , String abirthplace ) throws SQLException{
		
		String sql;
		try{
			Class.forName(DRIVER_NAME);
			conn = DriverManager.getConnection(CONN_URL, USER_NAME, PASSWORD);
			
			sql = "SELECT * FROM vcStudent";
			Statement stmt = conn.createStatement();
			stmt.executeQuery(sql);
            ResultSet rs1 = stmt.executeQuery(sql);
            
            while(rs1.next())
            {
            	if(rs1.getString(2).equals(aid))
            	{
            		rs1.updateString("sCard",acard);
            		rs1.updateString("sID",aid);
            		rs1.updateString("sName",aname);
            		rs1.updateString("sSex",asex);
            		rs1.updateString("sClassID",aclass);
            		rs1.updateString("sBirthday",abirthday);
            		rs1.updateString("sHometown",abirthplace);
            		rs1.updateRow();
            	}
            }
			
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			conn.close();
		}
	}
	
public void AddClass(String aclass) throws SQLException{
		
		String sql;
		String amajor;
		String aclass1;
		try{
			Class.forName(DRIVER_NAME);
			conn = DriverManager.getConnection(CONN_URL, USER_NAME, PASSWORD);
			
			Statement stmt = conn.createStatement();
			
			amajor = aclass.substring(0, 3);
			aclass1 = aclass.substring(5);
			
			if(amajor.equals("090"))
			{
				amajor = "CSE" ;
			}
			sql = "INSERT INTO `xindervella_VirtualCampus`.`vcClass` (cClassID, cMajor, cClass) VALUES ('"+aclass+"','"+ amajor+"','"+ aclass1+"')" ;
			
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
			
			sql = "SELECT * FROM vcStudent";
			Statement stmt = conn.createStatement();
			stmt.executeQuery(sql);
            ResultSet rs1 = stmt.executeQuery(sql);
            
            while (rs1.next())
            {
            	if(rs1.getString(2).equals(aid))
            	{
            		occupied = true ;
            		break;
            	}
            	
            	else if(rs1.next()==false)
            	{
            		occupied = false ;
            		break;
            	}
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
  			
  			sql = "SELECT * FROM vcClass";
  			Statement stmt = conn.createStatement();
  			stmt.executeQuery(sql);
            ResultSet rs1 = stmt.executeQuery(sql);
              
            while (rs1.next())
              {
              	if(rs1.getString(1).equals(aclass))
              	{
              		occupied = true ;
              		break;
              	}
              	
              	else if(rs1.next()==false)
              	{
              		occupied = false ;
              		break;
              	}
              }
  				
  			
  		} catch (Exception e){
  			e.printStackTrace();
  		} finally {
  			conn.close();
  		}
  		
  		return occupied ;
  	}
      
      
      public Vector <String> GetClass() throws SQLException{			
    	  String sqlClass;
    	  Vector<String> result = new Vector<String>();
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
    			  result.add(rsClass.getString("cClassID"));
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
