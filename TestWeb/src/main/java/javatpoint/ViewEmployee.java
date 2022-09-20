package javatpoint;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ViewEmployee{
	
	ArrayList<User> list=new ArrayList<User>();  
	String name;	
	
	public ArrayList<User> getList() {  
	    return list;  
	}  
	public void setList(ArrayList<User> list) {  
	    this.list = list;  
	}  
	
	public String getName() {  
	    return name;  
	}  
	public void setName(String name) {  
	    this.name = name;  
	}  
	
	public String execute(){  
		 try{  
			 String sql = "SELECT * FROM employees WHERE email = ?";
			 //String sql = "SELECT * FROM employees";
			 Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Ashish\\eclipse-workspace\\TestWeb\\src\\main\\java\\javatpoint\\test.db");
			 //Connection conn = Login.conn;   
			 PreparedStatement pstmt = conn.prepareStatement(sql);
	         pstmt.setString(1, javatpoint.Login.sessionmap.get("username"));
	         ResultSet rs = pstmt.executeQuery();
	            
	         sql = """
	         		SELECT name FROM employees WHERE id=(SELECT manager_id FROM managers WHERE child_id = ?);
	         		""";
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setInt(1,rs.getInt("id"));
	         
	         
	         ResultSet rs2 = pstmt.executeQuery();
	         
	         
	         
	            System.out.println(javatpoint.Login.sessionmap.get("username"));
	            //System.out.println(javatpoint.Login.sessionmap.get("login"));

	            
	        
	            if(!rs.next()){
	                System.out.println("Name doesn't exist in the directory");
	                return "error";
	            }
	            
	            do {
	            	
	               User user=new User();  
	               
	               //user.setData(rs.getInt(1),rs.getString(2),rs.getString(2),rs.getString(2),rs.getInt(5),rs.getInt(5),rs.getInt(5));
            	   user.setId(rs.getInt("id"));  
            	   user.setName(rs.getString("name")); 
            	   user.setEmail(rs.getString("email"));
            	   user.setPassword(rs.getString("password"));  
            	   user.setRole(rs.getString("role"));  
            	   user.setLevel(rs.getInt("level"));
            	   user.setAdmin(rs.getInt("admin"));
            	   ArrayList<String> temp = new ArrayList<String>();
            	   while(rs2.next()) {
            		   temp.add(rs2.getString("name"));
      	         	}
            	   user.setManagerName(temp);
            	   list.add(user);  
            	   
            	   System.out.println(rs.getInt("id") +  "\t" +
                           rs.getString("name") + "\t" +
                           rs.getString("role") + "\t "+
                           rs.getInt("level") + "\t "+
                           rs.getInt("admin"));
	            	
            	   
	            }while (rs.next());
	            conn.close();
	            return "success";

	            }catch (SQLException e) {
	                System.out.println(e.getMessage());
	            }
		 return "error";  
	}
}
		 