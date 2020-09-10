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

import collection.Cart;
import collection.IteratorInterface;
import factory.ProductFactory;
import jdbcUtil.DbConnection;
import jdbcUtil.InsertDb;
import model.Product;
import model.ProductBean;
import utility.CookieHelper;


@WebServlet("/remove.action")
public class RemoveItem extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String productId = request.getParameter("prodId");

		
		
		ArrayList<Product> arraycart = (ArrayList<Product>)request.getSession().getAttribute("customCart");
				
		Cart iterator = new Cart();
		Iterator<Product> prodIterator = iterator.createIterator(arraycart);
		
		while(prodIterator.hasNext()){
			int counter = 0;
			ProductBean product = (ProductBean) prodIterator.next();
	    	if(product.getProdId().equals(productId)){
	    		arraycart.remove(counter);
	    		break;
	    	}

	    }
		request.getSession().setAttribute("customCart", arraycart);
		// audit log
		Cookie cooks[] = request.getCookies();
		Cookie cookieId = CookieHelper.getCookie(cooks, "userAccount");
		Connection connection = DbConnection.getConnection(); 
		InsertDb.insertAudit(connection, cookieId.getValue(), "Delete", "Successfully removed product from cart");
				
		
		
		response.sendRedirect("my-cart");
	}

}
