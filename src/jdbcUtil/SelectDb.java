package jdbcUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import utility.Security;

public class SelectDb implements SelectQue {
	
	public static String searchUser(Connection connection, String email, String password) {
			
		boolean isSuccess = false;
		if(connection !=null) {
			try {
				Statement st = connection.createStatement();
				ResultSet rs = st.executeQuery(SEARCH_USER);
				if(connection != null) {
					while (rs.next() && isSuccess == false) {
						if(email.equals(rs.getString("Email"))) {
							if(password.equals(Security.decrypt(rs.getString("Password")))) {
								
								isSuccess = true;
								return rs.getString("First_name");
							}
						}	
					}
				}
				
			}catch(SQLException sqle){
				System.err.println(sqle);
				return null;
			}
		} 
		return null;
	} 
}
