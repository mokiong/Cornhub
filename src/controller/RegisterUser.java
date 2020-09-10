package controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import factory.UserFactory;
import jdbcUtil.DbConnection;
import jdbcUtil.InsertDb;
import model.User;


@WebServlet("/RegisterUser")
public class RegisterUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		Boolean isPremium = Boolean.parseBoolean(request.getParameter("isPremium"));
		Integer tier = Integer.parseInt(request.getParameter("tier"));

		
		Connection connection = DbConnection.getConnection(); 
		 
		
		if(InsertDb.insertUser(connection, firstName, lastName, email, password, isPremium, tier)) {
			System.out.println("Successfully registered user");
			InsertDb.insertAudit(connection, email, "Create", "Successfully registered");
			response.sendRedirect("login");
		} else {
			response.sendRedirect("error500");
		}
	
	}

}
