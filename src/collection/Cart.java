package collection;

import java.util.ArrayList;
import java.util.Iterator;

import model.Order;
import model.Product;
import model.ProductBean;

public class Cart implements IteratorInterface, Order {

	
	private static ArrayList<Product> cart = new ArrayList<Product>();
	
	public Cart() {
		
	}
	
	public void addTocart(ArrayList<Product> customerCart ,Product product) {
		customerCart.add(product);
	}
	
	
	@Override
	public Iterator createIterator() {
		return cart.iterator();
	}
	
	public Iterator createIterator(ArrayList<Product> cart) {
		return cart.iterator();
	}

	@Override
	public void process() {
		
	}


}
