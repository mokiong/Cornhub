package factory;

import model.AuditLog;
import model.AuditLogBean;
import model.Order;
import model.Product;
import model.User;

public class AuditLogFactory extends AbstractFactory {

	@Override
	public AuditLog getAuditLog(String className, String user, String action, String description, String date) {
		
		AuditLog log = null;
		
		switch (className.toUpperCase()) {
			case "STANDARD":
				log = new AuditLogBean(user,action,description,date); 
				break;
		}
		
		return log;
	}

	@Override
	public Order getOrder(String className, String customerName, String shippingAddress, Double price,Boolean isDiscounted,
			String discountKind) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product getProduct(String className, String prodId, String prodName, Double prodPrice, Integer stocks,
			String imagePath) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUser(String className, String firstName, String lastName, String email, String password,
			Boolean isPremium, String tier) {
		// TODO Auto-generated method stub
		return null;
	}

}
