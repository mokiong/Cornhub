package jdbcUtil;

public interface TableQue {

	String AUDITLOG_TABLE = "CREATE TABLE auditlog "
			+ "(ID INTEGER not NULL AUTO_INCREMENT PRIMARY KEY,User VARCHAR(255), Action VARCHAR(255), "
            + "Description VARCHAR(255), Date VARCHAR(255))";
	
	String ORDERS_TABLE = "CREATE TABLE orders "
			+ "(ID INTEGER not NULL AUTO_INCREMENT PRIMARY KEY,Customer VARCHAR(255), Address VARCHAR(255), "
            + "Price DOUBLE)";
	
	String PRODUCTS_TABLE = "CREATE TABLE products "
			+ "(ID VARCHAR(255) not NULL PRIMARY KEY,Product_name VARCHAR(255), Product_price DOUBLE, "
            + "Stocks INT, Image_path VARCHAR(255))";
	
	String USERS_TABLE = "CREATE TABLE users "
			+ "(ID INTEGER not NULL AUTO_INCREMENT PRIMARY KEY,First_name VARCHAR(255), Last_name VARCHAR(255), "
            + "Email VARCHAR(255), Password VARCHAR(255), Premium_user BOOLEAN, Premium_tier INT)";
}
