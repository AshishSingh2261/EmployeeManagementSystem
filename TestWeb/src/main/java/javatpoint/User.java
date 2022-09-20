package javatpoint;

import java.util.ArrayList;
import java.util.List;

public class User {  
	int id,level,admin,numChild;
	String name,email,password,role,path,departmentName;
	
	ArrayList<String> managerName;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id=id;
	}
	
	public String getName() {  
	    return name;  
	}  
	  
	public void setName(String name) {  
	    this.name = name;  
	}  
	
	public String getEmail() {  
	    return email;  
	}  
	  
	public void setEmail(String email) {  
	    this.email = email;  
	}  
	
	public String getPassword() {  
	    return password;  
	}  
	  
	public void setPassword(String password) {  
	    this.password = password;  
	}  
	
	public String getRole() {  
		return role;  
	}  
	  
	public void setRole(String role) {  
	    this.role = role;  
	}  
	
	public String getPath() {  
		return path;  
	}  
	  
	public void setPath(String path) {  
	    this.path = path;  
	}  
	
	public ArrayList<String> getManagerName() {
		return managerName;
	}

	public void setManagerName(ArrayList<String> managerName) {
		this.managerName = managerName;
	}

	public Integer getLevel() {
		return level;
	}
	
	public void setLevel(Integer level) {
		this.level=level;
	}
	
	public Integer getAdmin() {
		return admin;
	}
	
	public void setAdmin(Integer admin) {
		this.admin=admin;
	}
	
	public Integer getNumChild() {
		return numChild;
	}
	
	public void setNumChild(Integer numChild) {
		this.numChild=numChild;
	}
	
	public String getDepartmentName() {
		return departmentName;
	}


	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
		
}



