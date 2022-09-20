package javatpoint;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InsertOther{
	String departmentName,headDeptName;	

	public String getDepartmentName() {
		return departmentName;
	}


	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	
	public String getHeadDeptName() {
		return departmentName;
	}


	public void setHeadDeptName(String headDeptName) {
		this.headDeptName = headDeptName;
	}
	
	
	public String execute(){
		try{  
			String sql = """
					INSERT INTO departments(name,parent_id) VALUES(?,(SELECT id FROM departments WHERE name=?))
					""";
			Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Ashish\\eclipse-workspace\\TestWeb\\src\\main\\java\\javatpoint\\test.db");
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, departmentName);
		    pstmt.setString(2, headDeptName);
		    pstmt.executeUpdate();
			
			conn.close();
			
			return "success";	
					
			
            }catch (SQLException e) {
                System.out.println(e.getMessage());
            }
		 return "error";  
	}
}
		 