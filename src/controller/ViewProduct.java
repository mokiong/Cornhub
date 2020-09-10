package controller;

import java.io.IOException;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import collection.IteratorInterface;
import collection.Products;
import model.ProductBean;


@WebServlet("/ViewProduct.action")
public class ViewProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String productId = request.getParameter("prodId");

		IteratorInterface iterator = new Products(); 
		Iterator<ProductBean> prodIterator = iterator.createIterator();
		
		ProductBean prod = null;
		
		System.out.println(productId);
		while(prodIterator.hasNext()){
			int counter = 0;
			ProductBean product = (ProductBean) prodIterator.next();
	    	if(product.getProdId().equals(productId)){
	    		prod = product;
	    		request.setAttribute("angProdukto", prod); 
	    		request.getRequestDispatcher("view-product").forward(request, response);

	    		break;
	    	}
	    }

	    

	}

}
