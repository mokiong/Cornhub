package model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class OrderBean implements Order{
	
	private static final Double VAT = 0.12;
	
	private String customerName;
	private String shippingAddress;
	private Boolean isDiscounted;
	// computed
	private double cartPrice;
	private double withVAT;
	private int shippingFee;
	private double withNormalDiscount;
	
	public int getShippingFee() {
		return shippingFee;
	}


	public void setShippingFee(int shippingFee) {
		this.shippingFee = shippingFee;
	}


	public OrderBean() {
		
	}


	public OrderBean(String customerName, String shippingAddress, Double cartPrice,Boolean isDiscounted) {
		super();
		this.customerName = customerName;
		this.shippingAddress = shippingAddress;
		this.isDiscounted = isDiscounted;
		this.cartPrice = cartPrice;
	}


	public double getWithNormalDiscount() {
		return withNormalDiscount;
	}


	public void setWithNormalDiscount(double withNormalDiscount) {
		this.withNormalDiscount = withNormalDiscount;
	}


	public Boolean getIsDiscounted() {
		return isDiscounted;
	}


	public void setIsDiscounted(Boolean isDiscounted) {
		this.isDiscounted = isDiscounted;
	}


	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	
	public double getCartPrice() {
		return cartPrice;
	}

	public void setCartPrice(double cartPrice) {
		this.cartPrice = cartPrice;
	}

	public double getWithVAT() {
		return withVAT;
	}

	public void setWithVAT(double withVAT) {
		this.withVAT = withVAT;
	}
	
	public void computeCartPrice() {
		if(cartPrice < 3000) {
			shippingFee = 200;
		} else {
			shippingFee = 0;
		}
	}
	
	public void computeFinalPrice() {
		withVAT = cartPrice * VAT + cartPrice + shippingFee;
		withVAT = round(withVAT,2);
	}
	
	@Override
	public void process() {
		computeCartPrice();
		computeFinalPrice();
	}
	
	public static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    BigDecimal bd = BigDecimal.valueOf(value);
	    bd = bd.setScale(places, RoundingMode.HALF_UP);
	    return bd.doubleValue();
	}
	
}
