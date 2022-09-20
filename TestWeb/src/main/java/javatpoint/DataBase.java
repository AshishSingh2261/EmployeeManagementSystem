package javatpoint;
import java.sql.*;

public class DataBase {
    public static void main( String[] args ) throws SQLException {
        Connection conn = null;

        try {
            //Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Ashish\\eclipse-workspace\\TestWeb\\src\\main\\java\\javatpoint\\test.db");
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Opened database successfully");
        createDepartmentsTable(conn);

        createEmployeeTable(conn);
        
        System.out.println("Employee Table created successfully");
        //viewRecords(conn);
        //System.out.println("All records are printed");
        try{
            conn.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }

    }

    public static void createEmployeeTable(Connection conn){
        String sql = """
                CREATE TABLE IF NOT EXISTS employees (
                 id integer PRIMARY KEY,
                 name text NOT NULL,
                 email text NOT NULL,
                 password text NOT NULL,
                 role text NOT NULL,
                 manager_id integer,               
                 department_id integer,                 
                 level integer,
                 admin integer,
                 FOREIGN KEY (department_id) REFERENCES departments(id)
                );""";
        try{
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void createDepartmentsTable(Connection conn){
        try{
        	String sql = """
                    CREATE TABLE IF NOT EXISTS departments(
                     id integer PRIMARY KEY,
                     parent_id integer,
                     name text NOT NULL,
                     level integer,
                     head_id integer
                    );""";
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
           
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void viewRecords(Connection conn){
        String sql = """
                SELECT * FROM employees
                """;
        try{
            Statement stmt = conn.createStatement();
            //stmt.execute(sql);
            ResultSet rs    = stmt.executeQuery(sql);

            while (rs.next()) {
                System.out.println(rs.getInt("id") +  "\t" +
                        rs.getString("name") + "\t" +
                        rs.getString("role") + "\t"+
                                   rs.getInt("manager_id") + "\t"+
                                   rs.getInt("level"));
            }
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}