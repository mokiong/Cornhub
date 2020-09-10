package jdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import utility.Security;

public class InsertDb implements InsertQue {

	public static boolean insertAudit(Connection connection, String user, String action, String description) {
	
//		Date date = new Date();
//		long time = date.getTime();
//		Timestamp ts = new Timestamp(time);
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
	    Date date = new Date(); 
		
		
		if(connection != null) {
			try {
				PreparedStatement prep = 
					connection
					.prepareStatement(INSERT_AUDIT);
				
				prep.setString(1, user);
				prep.setString(2, action);
				prep.setString(3, description);
				prep.setString(4, formatter.format(date));
				
				prep.executeUpdate();
				return true;
			} catch (SQLException sqle) {
				sqle.printStackTrace();
				return false;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}
		return false;
	}
	
	public static boolean insertOrder(Connection connection, String customerName, 
			String shippingAddress, Boolean isDiscounted,String discountKind) {
		
		if(connection != null) {
			try {
				PreparedStatement prep = 
					connection
					.prepareStatement(INSERT_ORDER);
				
				prep.setString(1, customerName);
				prep.setString(2, shippingAddress);
				prep.setBoolean(3, isDiscounted);
				prep.setString(4, discountKind);
			
				
				prep.executeUpdate();
				return true;
			} catch (SQLException sqle) {
				sqle.printStackTrace();
				return false;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}
		return false;
	}
	
	public static boolean insertProduct(Connection connection, String prodId, String prodName, 
			Double prodPrice, Integer stocks, String imagePath) {
		
		if(connection != null) {
			try {
				PreparedStatement prep = 
					connection
					.prepareStatement(INSERT_PRODUCT);
				
				prep.setString(1, prodId);
				prep.setString(2, prodName);
				prep.setDouble(3, prodPrice);
				prep.setInt(4, stocks);
				prep.setString(5, imagePath);
				
				prep.executeUpdate();
				return true;
			} catch (SQLException sqle) {
				sqle.printStackTrace();
				return false;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}
		return false;
	}
	
	public static boolean insertUser(Connection connection, String firstName, String lastName, 
			String email, String password,Boolean isPremium, Integer tier) {
		
		if(connection != null) {
			try {
				PreparedStatement prep = 
					connection
					.prepareStatement(INSERT_USER);
				
				prep.setString(1, firstName);
				prep.setString(2, lastName);
				prep.setString(3, email);
				prep.setString(4, Security.encrypt(password));
				prep.setBoolean(5, isPremium);
				prep.setInt(6, tier);
				
				prep.executeUpdate();
				return true;
			} catch (SQLException sqle) {
				sqle.printStackTrace();
				return false;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}
		return false;
	}
}
