import java.sql.Connection;
import java.sql.DriverManager;


public class DBC {
	
	String username="root";
	String password="tiger";
	
	static final String DB_URL="jdbc:mysql://localhost:3306/ev_db";

	public Connection getConnection() {
		// TODO Auto-generated method stub
		Connection conn=null;
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			
			conn=DriverManager.getConnection(DB_URL,username,password);
			System.out.println("Connected to database successfully");
			
		}
		catch(Exception e){
			System.out.println(e);
		}
		
		return conn;
		
	}

}
