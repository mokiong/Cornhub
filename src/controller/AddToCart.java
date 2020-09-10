package controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import collection.Cart;
import collection.IteratorInterface;
import collection.Products;
import factory.ProductFactory;
import jdbcUtil.DbConnection;
import jdbcUtil.InsertDb;
import model.Product;
import model.ProductBean;
import utility.CookieHelper;


@WebServlet("/cart.action")
public class AddToCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String productId = request.getParameter("prodId");
		String prodName = request.getParameter("prodName");
		Double prodPrice = Double.parseDouble(request.getParameter("prodPrice"));
		String imagePath = request.getParameter("imagePath");
		Integer quantity = Integer.parseInt(request.getParameter("quantity"));
		Integer stocks = Integer.parseInt(request.getParameter("stocks"));
		
		if(quantity > stocks) {
			quantity = stocks;
		}
		
		if(quantity != 0) {
			Product cartProduct = new ProductFactory().getProduct("standard", productId, 
					prodName, prodPrice, quantity, imagePath);
			
			IteratorInterface iterator = new Products(); 
			Iterator<ProductBean> prodIterator = iterator.createIterator();
			
			Products prod = new Products();
			ArrayList<ProductBean> productList = prod.getProductList();

			int counter = 0;
			while(prodIterator.hasNext()){
				
				ProductBean product = (ProductBean) prodIterator.next();
				
		    	if(product.getProdId().equals(productId)){
		    		product.setStocks(product.getStocks() - quantity);
		    		productList.set(counter, product);
		    		break;
		    	}
		    	counter++;
		    	System.out.println(counter);
		    }

			
			ArrayList<Product> arraycart = (ArrayList<Product>)request.getSession().getAttribute("customCart");
			arraycart.add(cartProduct);
			
			// audit log
			Cookie cooks[] = request.getCookies();
			Cookie cookieId = CookieHelper.getCookie(cooks, "userAccount");
			Connection connection = DbConnection.getConnection(); 
			InsertDb.insertAudit(connection, cookieId.getValue(), "Create", "Successfully added item to cart");
			
			request.getSession().setAttribute("customCart", arraycart);

			
		}
		
		response.sendRedirect("my-cart");	
	}
}
