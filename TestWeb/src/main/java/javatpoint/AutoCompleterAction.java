package javatpoint;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

public class AutoCompleterAction extends ActionSupport{
	
	private List<String> nameList = new ArrayList<String>();
	private List<String> departmentList = new ArrayList<String>();
	
	public List<String> getDepartmentList() {
		return departmentList;
	}


	public void setDepartmentList(List<String> departmentList) {
		this.departmentList = departmentList;
	}

	public List<String> getNameList() {
		return nameList;
	}


	public void setNameList(List<String> nameList) {
		this.nameList = nameList;
	}


	public AutoCompleterAction(){
		
		try {
			String sql = """
			 		SELECT name
		                FROM employees
			 		""";
			 
			 
			 Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Ashish\\eclipse-workspace\\TestWeb\\src\\main\\java\\javatpoint\\test.db");
			 
			 PreparedStatement pstmt = conn.prepareStatement(sql);
	         ResultSet rs = pstmt.executeQuery();
	         while (rs.next()) {
	        	 nameList.add(rs.getString("name"));
	         }
	         
	         sql = """
				 		SELECT name
			                FROM departments
				 		""";
		
				 
				//conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Ashish\\eclipse-workspace\\TestWeb\\src\\main\\java\\javatpoint\\test.db");
				pstmt = conn.prepareStatement(sql);
		        rs = pstmt.executeQuery();
		         while (rs.next()) {
		        	 departmentList.add(rs.getString("name"));
		         }
	         
	        
	         conn.close();
			
		}catch (SQLException e) {
            System.out.println(e.getMessage());
        }
	}
	

	public String display() {
		return NONE;
	}
	
}