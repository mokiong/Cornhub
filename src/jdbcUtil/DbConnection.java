package jdbcUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
	
	private static Connection connection;
	
	private DbConnection(){
		
	}
	
//	private Connection getConnectionInstance() {
//		Connection connection = null;
//		
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sfelect220db",
//					"root", "");
//		}catch(ClassNotFoundException cfne) {
//			cfne.getMessage();
//			System.out.println("shit");
//		}catch(SQLException sqle) {
//			sqle.getMessage();
//		}
//		return connection;	
//	}
	
	private static Connection getConnectionInstance() {
		if (connection == null) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				connection = DriverManager
				.getConnection(
					"jdbc:mysql://localhost:3306/sfelect220db",
					"root", "");
			} catch(ClassNotFoundException cfne) {
				cfne.getMessage();		
			} catch (SQLException sqle) {
				sqle.printStackTrace();
				System.out.println("ERROR DITOOO");
			}
		}
		return connection;
	}
	
	public static Connection getConnection() {
		return (connection == null) ? getConnectionInstance() : connection;		
	}
	
}
