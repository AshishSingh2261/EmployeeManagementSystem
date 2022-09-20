package javatpoint;

import java.sql.*;
import java.util.ArrayList;

public class Children{
	
	ArrayList<User> allList=new ArrayList<User>(); 
	Integer currLimit=0, currLevel;
	Integer maxLevel = javatpoint.ViewAll.maxLevel;
	
	public Integer getCurrLimit() {
		return currLimit;
	}
	public void setCurrLimit(Integer currLimit) {
		this.currLimit = currLimit;
	}
	public ArrayList<User> getAllList() {  
	    return allList;  
	}  
	public void setAllList(ArrayList<User> allList) {  
	    this.allList = allList;  
	}  
	
	public Integer getCurrLevel() {
		return currLevel;
	}
	
	public void setCurrLevel(Integer currLevel) {
		this.currLevel = currLevel;
	}
	
	public Integer getMaxLevel() {
		return maxLevel;
	}
	
	public void setMaxLevel() {
		this.maxLevel = javatpoint.ViewAll.maxLevel;
	}
	
	public String execute(){  
		 try{  
			 String sql0 = """
					SELECT id,name,level,(SELECT name FROM departments WHERE id = department_id) AS d_name 
					FROM employees WHERE level = ? 
					ORDER BY d_name
					LIMIT ?,?;
			 		""";		
			 //String sql = "SELECT * FROM employees";
			 Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Ashish\\eclipse-workspace\\TestWeb\\src\\main\\java\\javatpoint\\test.db");
			 //Connection conn = Login.conn;   
			 PreparedStatement pstmt = conn.prepareStatement(sql0);
			 pstmt.setInt(1, currLevel);
			 pstmt.setInt(2, (currLimit+1)*4);
			 pstmt.setInt(3, 4);
	            ResultSet rs = pstmt.executeQuery();
	            
	            while (rs.next()) {
	            	
	               User user=new User();  
	               
            	   user.setId(rs.getInt("id"));  
            	   user.setName(rs.getString("name")); 
            	   user.setLevel(rs.getInt("level"));
            	   user.setDepartmentName(rs.getString("d_name"));
            	  
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
		 