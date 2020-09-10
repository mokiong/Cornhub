package jdbcUtil;

public interface InsertQue {

	
	String INSERT_AUDIT = "insert into auditlog (User,"
			+ "Action, Description, Date) values (?,?,?,?)";
	
	String INSERT_ORDER = "insert into orders (Customer, Address,"
			+ "Price) values (?,?,?)";
	
	String INSERT_PRODUCT = "insert into products (ID, Product_name, Product_price,"
			+ "Stocks, Image_path) values (?,?,?,?,?)";
	
	String INSERT_USER = "insert into users (First_name, Last_name, Email,"
			+ "Password, Premium_user, Premium_tier) values (?,?,?,?,?,?)";
	
	
}
