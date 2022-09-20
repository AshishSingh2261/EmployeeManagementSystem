package javatpoint;

import java.sql.*;
public class LoginDao { 
	public static int admin;
	
  
public static Integer validate(String username,String userpass){  
 //boolean status=false;  
  try{  
	  Connection conn = null;
	  Class.forName("org.sqlite.JDBC");
	  conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Ashish\\eclipse-workspace\\TestWeb\\src\\main\\java\\javatpoint\\test.db");
	  //Connection conn = Login.conn;  
	  PreparedStatement ps=conn.prepareStatement("select * from employees where email=? and password=?");  
	  ps.setString(1,username);  
	  ps.setString(2,userpass);  
	  ResultSet rs=ps.executeQuery();
	  admin = rs.getInt("admin");
	  conn.close();
	  return admin;
	  
	  
	  //status=rs.next();  
  }catch(Exception e){e.printStackTrace();}  
 return -1;  
}  
}  
