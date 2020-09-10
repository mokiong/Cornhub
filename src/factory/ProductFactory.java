package factory;

import model.AuditLog;
import model.Order;
import model.Product;
import model.ProductBean;
import model.User;

public class ProductFactory extends AbstractFactory {


	@Override
	public Product getProduct(String className, String prodId, String prodName, Double prodPrice, Integer stocks,
			String imagePath) {
		
		Product product = null;
		
		switch (className.toUpperCase()) {
			case "STANDARD":
				product = new ProductBean(prodId,prodName,prodPrice,stocks,imagePath); 
				break;
		}
		
		return product;
	}
	
	
	@Override
	public AuditLog getAuditLog(String className, String user, String action, String description, String date) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Order getOrder(String className, String customerName, String shippingAddress,Double price, Boolean isDiscounted,
			String discountKind) {
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
