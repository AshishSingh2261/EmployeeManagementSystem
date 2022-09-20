package javatpoint;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;  
import org.apache.struts2.dispatcher.SessionMap;  
import org.apache.struts2.interceptor.SessionAware;  
  
public class Login implements SessionAware{  
private String username,userpass;  
static SessionMap<String,String> sessionmap; 

public static Connection getConnection(){
	Connection conn=null;
	try {
		conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Ashish\\eclipse-workspace\\TestWeb\\src\\main\\java\\javatpoint\\test.db");
		System.out.println("Connection made");
	}catch (SQLException e) {
	    System.out.println(e.getMessage());
	}
	return conn;
}

static Connection conn=getConnection();


  
public String getUsername() {  
    return username;  
}  
  
public void setUsername(String username) {  
    this.username = username;  
}  
  
public String getUserpass() {  
    return userpass;  
}  
  
public void setUserpass(String userpass) {  
    this.userpass = userpass;  
}  
  
public String execute(){  
	int admin = LoginDao.validate(username, userpass);
    if(admin==1){  
    	sessionmap.put("username",username);
        return "success-admin";  
    }  
    else if(admin==0) {
    	sessionmap.put("username",username);
    	return "success-standard";
    }
    else{  
        return "error";  
    }  
}  
  
public void setSession(Map map) {  
    sessionmap=(SessionMap)map;  
    sessionmap.put("login","true");
    

}  
  
public String logout(){  
    sessionmap.invalidate();  
    return "success";  
}  
  
}  
