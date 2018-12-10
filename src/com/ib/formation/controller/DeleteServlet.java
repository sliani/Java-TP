package com.ib.formation.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ib.formation.dao.Client;
import com.ib.formation.services.ClientServiceImpl;
import com.ib.formation.services.IClientService;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IClientService cs = new ClientServiceImpl(); 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String message = "Error : le client n'a pas ete supprimer";
		try {
			int idClient = Integer.parseInt(id);
			Client client = new Client();
			client.setId(idClient);
			if(cs.deleteClient(client)) {
				message = "Le client a bien ete supprimer...";
			}
		} catch(Exception e) {
			
		}
		response.sendRedirect("SearchServlet?message=" + message);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
