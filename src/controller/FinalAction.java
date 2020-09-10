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
import model.Product;
import utility.CookieHelper;


@WebServlet("/final")
public class FinalAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<Product> arraycart = (ArrayList<Product>)request.getSession().getAttribute("customCart");
		arraycart.clear();
		
		// audit log
		Cookie cooks[] = request.getCookies();
		Cookie cookieId = CookieHelper.getCookie(cooks, "userAccount");
		Connection connection = DbConnection.getConnection(); 
		InsertDb.insertAudit(connection, cookieId.getValue(), "Create", "Successfully processed order");
		
		request.getSession().setAttribute("customCart", arraycart);
		response.sendRedirect("home");
	}

}
