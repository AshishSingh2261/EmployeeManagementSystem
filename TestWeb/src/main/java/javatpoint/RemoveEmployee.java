package javatpoint;

import java.sql.*;
import java.util.ArrayList;

public class RemoveEmployee{
	String name;
	
	public String getName() {  
	    return name;  
	}  
	public void setName(String name) {  
	    this.name = name;  
	}  
	
	public String execute(){  
		 try{  
			 Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Ashish\\eclipse-workspace\\TestWeb\\src\\main\\java\\javatpoint\\test.db");
			 String sql = """
			 		SELECT id FROM employees WHERE name=?
	            """;
			 	PreparedStatement pstmt = conn.prepareStatement(sql);
	            pstmt.setString(1, name);
	            ResultSet rs = pstmt.executeQuery();
	            
	            int id = rs.getInt("id");
	            
	            sql = "SELECT manager_id FROM managers where child_id = ?";
	            pstmt = conn.prepareStatement(sql);
	            pstmt.setInt(1, id);
	            rs = pstmt.executeQuery();
	            ArrayList<Integer> managers = new ArrayList<Integer>();
	            while(rs.next()) {
	            	managers.add(rs.getInt("manager_id"));
	            	
	            }
	            
	            sql = "SELECT child_id FROM managers where manager_id = ?";
	            pstmt = conn.prepareStatement(sql);
	            pstmt.setInt(1, id);
	            rs = pstmt.executeQuery();
	            ArrayList<Integer> childs = new ArrayList<Integer>();
	            while(rs.next()) {
	            	childs.add(rs.getInt("child_id"));	            	
	            }
	            
	            System.out.println(managers.size());
	            System.out.println(childs.size());
	            
	            sql = "DELETE FROM managers WHERE manager_id= ? OR child_id=?";
	            pstmt = conn.prepareStatement(sql);
	            pstmt.setInt(1, id);
	            pstmt.setInt(2, id);
	            pstmt.executeUpdate();
	            
	            System.out.println("delete hona chaiye be");
	            
	            for (int i=0; i<managers.size();i++) {
	            	for (int j=0;j<childs.size();j++) {
	            		
	            		sql = "INSERT INTO managers(manager_id,child_id) VALUES(?,?)";
	    	            pstmt = conn.prepareStatement(sql);
	    	            pstmt.setInt(1, managers.get(i));
	    	            pstmt.setInt(2, childs.get(j));
	    	            pstmt.executeUpdate();
	            		
	            	}
	            }
	            
	            System.out.println("delete hona chaiye be");
	            
	            
	            sql = "DELETE FROM employees WHERE id= ?";
	            pstmt = conn.prepareStatement(sql);
	            pstmt.setInt(1, id);
	            pstmt.executeUpdate();
	            System.out.println("Employee successfully deleted");
	            
	            sql = "SELECT MAX(level) AS max FROM employees ";
	            pstmt = conn.prepareStatement(sql);
	            rs = pstmt.executeQuery();
	            
	            javatpoint.InsertEmployee.maxLevel = rs.getInt("max");
	                
	            conn.close();
	            return "success";

	            }catch (SQLException e) {
	                System.out.println(e.getMessage());
	            }
		 return "error";  
	}
}
		 