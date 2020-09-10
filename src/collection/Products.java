package collection;

import java.util.ArrayList;
import java.util.Iterator;
import model.ProductBean;
import prototype.PrototypeInterface;

public class Products implements IteratorInterface, PrototypeInterface {

	private static ArrayList<ProductBean> products = new ArrayList<ProductBean>();;
	
	public Products() {
		
	}
	
	public void addAllProducts() {
		addProduct("0785135367","Big Black Corn", 6969.00, 69, "images/bbc.jpg");
		addProduct("7746524767","Corn Bits", 999.00, 3, "images/cornbits.jpg");
		addProduct("1908525367","Glass Gem", 15000.00, 5, "images/rareCorn.jpg");
		addProduct("1910903717","Japanese Blurred", 1.00, 15, "images/japanese.jpg");
		addProduct("4189967661","Buttered corn", 200.00, 15, "images/butteredcorn.jpg");
		addProduct("0317970154","Popcorn", 20.00, 20, "images/popcorn.jpg");
		addProduct("9565454368","Corn costume", 20.00, 10000, "images/corngirl.jpg");
		addProduct("1665654998","High Qua Corn", 20.00, 10000, "images/highquaCorn.jpg");
	}
	
	// Add a SongInfo object to the end of the ArrayList
	public void addProduct(String prodId, String prodName, Double prodPrice,  Integer stocks,
			String imagePath){
		
		ProductBean prodInfo = new ProductBean(prodId, prodName, prodPrice, stocks, imagePath);
		products.add(prodInfo);
	}
	
	@Override
	public PrototypeInterface clone() {
        return new Products();
    }

    
	@Override
	public Iterator createIterator() {
		return products.iterator();
	}
	
	
	public static ArrayList<ProductBean> getProductList(){
		return products;
	}
	
}
