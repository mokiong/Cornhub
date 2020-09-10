package factory;

import model.AuditLog;
import model.Order;
import model.PremiumUser;
import model.Product;
import model.User;
import model.UserBean;

public class UserFactory extends AbstractFactory {

	@Override
	public User getUser(String className, String firstName, String lastName, 
			String email, String password,Boolean isPremium, String tier) {
		
		User user = null;
		
		switch (className.toUpperCase()) {
			case "STANDARD":
				user = new UserBean(firstName, lastName, email, password,isPremium); //object polymorphism (data type casting widening)  
				break;
			case "PREMIUM":
				user = new PremiumUser(firstName, lastName, email, password,isPremium, tier); //object polymorphism (data type casting widening)
				break;
		
		}
	
		return user;
	}
	
	
	@Override
	public AuditLog getAuditLog(String className, String user, String action, String description, String date) {
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
	public Order getOrder(String className, String customerName, String shippingAddress, Double price,Boolean isDiscounted,
			String discountKind) {
		// TODO Auto-generated method stub
		return null;
	}


}
