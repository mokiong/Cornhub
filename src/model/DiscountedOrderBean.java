package model;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class DiscountedOrderBean implements Order {

	private static final Double VAT = 0.12;
	
	private String customerName;
	private String shippingAddress;
	private Boolean isDiscounted;
	private String discountKind;
	
	
	// computed
	private int shippingFee;
	private double cartPrice;
	private double withVAT;
	private double withNormalDiscount;
	private double withPremiumDiscount;
	
	
	public int getShippingFee() {
		return shippingFee;
	}




	public void setShippingFee(int shippingFee) {
		this.shippingFee = shippingFee;
	}

	
	
	public DiscountedOrderBean() {
		
	}
	
	

	
	public DiscountedOrderBean(String customerName, String shippingAddress, Double cartPrice, Boolean isDiscounted, String discountKind) {
		super();
		this.customerName = customerName;
		this.shippingAddress = shippingAddress;
		this.isDiscounted = isDiscounted;
		this.discountKind = discountKind;
		this.cartPrice = cartPrice;
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



	public String getDiscountKind() {
		return discountKind;
	}

	public void setDiscountKind(String discountKind) {
		this.discountKind = discountKind;
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

	public double getWithNormalDiscount() {
		return withNormalDiscount;
	}

	public void setWithNormalDiscount(double withDiscount) {
		this.withNormalDiscount = withDiscount;
	}

	
	public double getWithPremiumDiscount() {
		return withPremiumDiscount;
	}

	public void setWithPremiumDiscount(double withPremiumDiscount) {
		this.withPremiumDiscount = withPremiumDiscount;
	}
	
	public void computeCartPrice() {
		if(cartPrice < 3000) {
			shippingFee = 200;
		} else {
			shippingFee = 0;
		}
	}
	
	public void computeDiscount() {
		int discount = 0;
		if(isDiscounted) {
			 discount = (int) cartPrice / 1000;
			 withNormalDiscount = discount * 50;
		} else {
			withNormalDiscount = 0.0;
		}
	}
	
	public void computeFinalPrice() {
		withVAT = (((cartPrice) * VAT) + cartPrice - withNormalDiscount) + shippingFee;
		withVAT = round(withVAT,2);
	}
	
	@Override
	public void process() {
		computeCartPrice();
		computeDiscount();
		computeFinalPrice();
	}

	public static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    BigDecimal bd = BigDecimal.valueOf(value);
	    bd = bd.setScale(places, RoundingMode.HALF_UP);
	    return bd.doubleValue();
	}

}
