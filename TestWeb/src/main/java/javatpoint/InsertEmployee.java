package javatpoint;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InsertEmployee{
	
	String name,role,managerName,email;
	public static int maxLevel=0;
	String departmentName;
	
	public String getName() {  
	    return name;  
	}  
	public void setName(String name) {  
	    this.name = name;  
	}  
	
	public String getRole() {  
	    return role;  
	}  
	public void setRole(String role) {  
	    this.role = role;  
	}  
	
	public String getManagerName() {  
	    return name;  
	}  
	public void setManagerName(String managerName) {  
	    this.managerName = managerName;  
	}  
	
	
	public String getEmail() {  
	    return email;  
	}  
	public void setEmail(String email) {  
	    this.email = email;  
	}  
	
	public String getDepartmentName() {
		return departmentName;
	}


	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	
	
	
	
	
	public String execute() throws ClassNotFoundException{  
		 try{   
			 Class.forName("org.sqlite.JDBC");
			 String sql1 = "SELECT id,level FROM employees WHERE name=?";
		     String sql2 = """
		                INSERT INTO employees(name, role,email,password,department_id, level, admin)
		                VALUES(?,?,?,?,(SELECT id FROM departments WHERE name=?),?,?)
		                """;
			
			 Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Ashish\\eclipse-workspace\\TestWeb\\src\\main\\java\\javatpoint\\test.db");
			System.out.println("Connection made");
		    PreparedStatement pstmt = conn.prepareStatement(sql1);
		    pstmt.setString(1, managerName);
			ResultSet rs    = pstmt.executeQuery();
			
			int manager_id = rs.getInt("id");
			int level = rs.getInt("level");
			System.out.println(manager_id);
			System.out.println(level);
			
			pstmt = conn.prepareStatement(sql2);
			pstmt.setString(1, name);
			pstmt.setString(2, role);
			pstmt.setString(3, email);
			pstmt.setString(4, "pass");
			pstmt.setString(5,departmentName);
			pstmt.setInt(6,level+1);
			pstmt.setInt(7,0);
			pstmt.executeUpdate();
			
			String sql3 = "INSERT INTO managers(manager_id, child_id) VALUES(?, (SELECT MAX(id) FROM employees));";
			pstmt = conn.prepareStatement(sql3);
			pstmt.setInt(1,manager_id);
			pstmt.executeUpdate();
            
            
            if (level+1>maxLevel) {
            	maxLevel=level+1;
            }
            
         
            
            conn.close();

            return "success";
            
            
            }catch (SQLException e) {
                System.out.println(e.getMessage());
            }
		 return "error";  
	}
}
		 