package com.ib.formation.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);
		Boolean isConnected = (Boolean) session.getAttribute("connected");
		if (isConnected != null && isConnected.booleanValue()) {
			response.sendRedirect("SearchServlet");
		}
		else {
			this.getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
		}
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		String message = "Auth : not ok...";
		
		try {
			if (login.equals ("admin") && password.equals("admin")) {
				message = "Auth: ok...";
				HttpSession session = request.getSession(true);
				session.setAttribute("connected", true);
				session.setAttribute("login", login);
				response.sendRedirect("SearchServlet?message=" + message);
			} else {
				doGet(request, response);
			}
		} catch (Exception e) {
			
		}
		
	}

}
