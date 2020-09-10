package jdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TableMaker implements TableQue {
	
	private static void auditLogTable(Connection connection){
		if(connection != null) {
			try {
				boolean tableExist = false;
				ResultSet rs = connection.getMetaData().getTables(null, null, "auditlog", null);
			    
				while (rs.next()) { 
			    	String tName = rs.getString("TABLE_NAME");
			        if (tName != null && tName.equals("auditlog")) {
			        	tableExist = true;
			            break;
			        }
			    }
				if(!tableExist) {
					PreparedStatement preparedStatement = connection.prepareStatement(AUDITLOG_TABLE); 
					preparedStatement.execute();
				}	
			} catch (SQLException sqle) {
				sqle.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	private static void OrderTable(Connection connection){
		if(connection != null) {
			try {
				boolean tableExist = false;
				ResultSet rs = connection.getMetaData().getTables(null, null, "orders", null);
			    
				while (rs.next()) { 
			    	String tName = rs.getString("TABLE_NAME");
			        if (tName != null && tName.equals("orders")) {
			        	tableExist = true;
			            break;
			        }
			    }
				if(!tableExist) {
					PreparedStatement preparedStatement = connection.prepareStatement(ORDERS_TABLE); 
					preparedStatement.execute();
				}			
			} catch (SQLException sqle) {
				sqle.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	private static void ProductTable(Connection connection){
		if(connection != null) {
			try {
				boolean tableExist = false;
				ResultSet rs = connection.getMetaData().getTables(null, null, "products", null);
			    
				while (rs.next()) { 
			    	String tName = rs.getString("TABLE_NAME");
			        if (tName != null && tName.equals("products")) {
			        	tableExist = true;
			            break;
			        }
			    }
				if(!tableExist) {
					PreparedStatement preparedStatement = connection.prepareStatement(PRODUCTS_TABLE); 
					preparedStatement.execute();
				}			
			} catch (SQLException sqle) {
				sqle.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	private static void UserTable(Connection connection){
		if(connection != null) {
			try {
				boolean tableExist = false;
				ResultSet rs = connection.getMetaData().getTables(null, null, "users", null);
			    
				while (rs.next()) { 
			    	String tName = rs.getString("TABLE_NAME");
			        if (tName != null && tName.equals("users")) {
			        	tableExist = true;
			            break;
			        }
			    }
				if(!tableExist) {
					PreparedStatement preparedStatement = connection.prepareStatement(USERS_TABLE); 
					preparedStatement.execute();
				}			
			} catch (SQLException sqle) {
				sqle.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static boolean process(Connection connection) {
		
		if(connection != null) {
			try {
				auditLogTable(connection);
				OrderTable(connection);
				ProductTable(connection);
				UserTable(connection);
		        return true;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}
		return false;
	}
}
