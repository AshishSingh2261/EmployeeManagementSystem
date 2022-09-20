package javatpoint;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

public class ViewAll{
	
	ArrayList<User> allList=new ArrayList<User>(); 
	static int maxLevel;
	
	public ArrayList<User> getAllList() {  
	    return allList;  
	}  
	public void setAllList(ArrayList<User> allList) {  
	    this.allList = allList;  
	}  
	
	public int getMaxLevel() {
		return maxLevel;
	}
	
	public void setMaxLevel(int maxLevel) {
		ViewAll.maxLevel = maxLevel;
	}
	
	public String execute(){  
		 try{  
			 String sql = """
			 		SELECT MAX(level) AS maxlev FROM employees ;
			 		""";
			 Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Ashish\\eclipse-workspace\\TestWeb\\src\\main\\java\\javatpoint\\test.db");
			 //Connection conn = Login.conn;   
			 PreparedStatement pstmt = conn.prepareStatement(sql);
	         ResultSet rs = pstmt.executeQuery();
	         maxLevel=rs.getInt("maxlev");
			 
			 
			 
			 sql = """
			 		
					SELECT 
						* 
				
					FROM
						employees
					;

			 		""";
			 
			 
			 
			 //String sql = "SELECT * FROM employees";
			 
			 //conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Ashish\\eclipse-workspace\\TestWeb\\src\\main\\java\\javatpoint\\test.db");
			 //Connection conn = Login.conn;   
			 pstmt = conn.prepareStatement(sql);
	         rs = pstmt.executeQuery();
			 
	            
	            while (rs.next()) {
	            	
	               User user=new User();  
	               
	               //user.setData(rs.getInt(1),rs.getString(2),rs.getString(2),rs.getString(2),rs.getInt(5),rs.getInt(5),rs.getInt(5));
            	   user.setId(rs.getInt("id"));  
            	   user.setName(rs.getString("name")); 
//            	   user.setEmail(rs.getString("email"));
//            	   user.setPassword(rs.getString("password"));  
//            	   user.setRole(rs.getString("role")); 
//            	   user.setPath(rs.getString("path")); 
//            	   user.setManagerId(rs.getInt("manager_id"));
            	   user.setLevel(rs.getInt("level"));
//            	   user.setAdmin(rs.getInt("admin"));
            	  // user.setNumChild(rs.getInt("numchild"));
            	  
            	   allList.add(user);  
            
            	   
	            };
	            conn.close();
	            return "success";

	            }catch (SQLException e) {
	                System.out.println(e.getMessage());
	            }
		 return "error";  
	}
}
		 