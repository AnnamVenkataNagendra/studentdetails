package Text;

import java.sql.Connection;
import java.sql.DriverManager;
public class DbConnection {
	private static Connection con=null;
	private DbConnection() {}
	
	static {
		try {
			
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","java");
			
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static Connection getCon() {
		return con;
	}
}
