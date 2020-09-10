package prototype;

import java.util.HashMap;
import java.util.Map;

import collection.Products;

public class Factory {

	private static final Map<String, Products> prototypes = new HashMap<>();
		
		static {
	        prototypes.put("produkto", new Products());     
	    }
		
	public static PrototypeInterface getPrototype(String type) {
			 try {
				 return prototypes.get(type).clone();
		     } catch (NullPointerException ex) {
		    	 System.out.println("Prototype with name: " 
		            	+ type + ", doesn't exist");
		         return null;
		     }
		 }
	
	
}
