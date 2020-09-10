package controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import jdbcUtil.DbConnection;
import jdbcUtil.InsertDb;
import jdbcUtil.SelectDb;
import model.Product;


@WebServlet("/login.action")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		
		Connection connection = DbConnection.getConnection();
		
		String user = SelectDb.searchUser(connection, userName, password);
		if(user == null) {
			response.sendRedirect("error-login");
		} else {
			Cookie userAccount = new Cookie("userAccount", user);
			userAccount.setMaxAge(-1);
			response.addCookie(userAccount);
			InsertDb.insertAudit(connection, userName, "Authentication", "Succesfully logged in");
			
			ArrayList<Product> arraycart = new ArrayList<Product>();
			request.getSession().setAttribute("customCart", arraycart);
			response.sendRedirect("home");
		}
	}

}
