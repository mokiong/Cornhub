package factory;

import model.AuditLog;
import model.Order;
import model.Product;
import model.User;

public abstract class AbstractFactory {
	
	public abstract AuditLog getAuditLog
		(String className, String user, String action, String description, String date);
	public abstract Order getOrder
		(String className, String customerName, String shippingAddress, Double price,Boolean isDiscounted,String discountKind);
	public abstract Product getProduct
		(String className, String prodId, String prodName, 
		Double prodPrice, Integer stocks, String imagePath);
	public abstract User getUser
		(String className, String firstName, String lastName, 
		String email, String password,Boolean isPremium, String tier);
}
