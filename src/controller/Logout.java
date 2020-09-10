package controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbcUtil.DbConnection;
import jdbcUtil.InsertDb;
import utility.CookieHelper;


@WebServlet("/logout")
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Cookie cooks[] = request.getCookies();
		Cookie user = CookieHelper.getCookie(cooks, "userAccount");
		
		Connection connection = DbConnection.getConnection(); 
		InsertDb.insertAudit(connection, user.getValue(), "Authentication", "Successfully logged out");
		user.setMaxAge(0);
		response.addCookie(user);
		request.getSession().invalidate();  
		response.sendRedirect("home");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
