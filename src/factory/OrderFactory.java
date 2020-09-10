package factory;

import model.AuditLog;
import model.DiscountedOrderBean;
import model.Order;
import model.OrderBean;

import model.Product;
import model.User;

public class OrderFactory extends AbstractFactory {

	@Override
	public Order getOrder(String className, String customerName, String shippingAddress, Double price,Boolean isDiscounted, 
			String discountKind) {
		
		Order order = null;
		
		switch (className.toUpperCase()) {
			case "STANDARD":
				order = new OrderBean(customerName,shippingAddress,price,isDiscounted); 
				break;
			case "DISCOUNTED":
				order = new DiscountedOrderBean(customerName,shippingAddress,price,isDiscounted,discountKind); 
				break;
		}
		return order;
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
	public User getUser(String className, String firstName, String lastName, String email, String password,
			Boolean isPremium, String tier) {
		// TODO Auto-generated method stub
		return null;
	}

}
