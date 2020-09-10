package controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import collection.IteratorInterface;
import collection.Products;
import jdbcUtil.DbConnection;
import jdbcUtil.TableMaker;
import model.Product;
import model.ProductBean;

@WebServlet("/createtables.action")
public class TableCreator extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Connection connection = DbConnection.getConnection();
		
		
		Products produkto = new Products();
		ArrayList<ProductBean> mgaProdukto = Products.getProductList();
		
		if(mgaProdukto.isEmpty()) {
			produkto.addAllProducts();
		}
		
		if(TableMaker.process(connection)) { 
			response.sendRedirect("home");
			System.out.println("Successfully created tables");
		} else {
			response.sendRedirect("error500");
			System.out.println("Error creating tables");
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
