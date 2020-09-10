package controller;

import java.io.IOException;
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
import collection.Products;
import factory.OrderFactory;
import model.Order;
import model.Product;
import model.ProductBean;
import utility.CookieHelper;

@WebServlet("/checkout")
public class CheckOut extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String name = request.getParameter("name");
		String address = request.getParameter("address");
		ArrayList<ProductBean> arraycart = (ArrayList<ProductBean>)request.getSession().getAttribute("customCart");
		Order cartProduct;
		
		double cartPrice = 0;
		
		for(ProductBean prod : arraycart) {
			cartPrice = cartPrice + prod.getProdPrice() * prod.getStocks();	
		}
		
		String orderType;
		if(cartPrice < 1000 && cartPrice > 0) {
			cartProduct = new OrderFactory().getOrder("STANDARD", name, 
					address,cartPrice, false, null);
			orderType = "STANDARD";
		} else { 
			cartProduct = new OrderFactory().getOrder("DISCOUNTED", name, 
					address,cartPrice, true, null);
			orderType = "DISCOUNTED";
		}
		
		cartProduct.process();
		request.setAttribute("order", cartProduct);
		request.setAttribute("orderType", orderType);
		request.getRequestDispatcher("cart-receipt").forward(request, response);
	}

}
