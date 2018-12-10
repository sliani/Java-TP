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
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IClientService cs = new ClientServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		int idClient = Integer.parseInt(id);
		
		Client c = null;
		for (Client client : cs.getListClients()) {
			if (client.getId() == idClient) {
				c = client;
				break;
			}
		}
		
		request.setAttribute("client", c);
		this.getServletContext().getRequestDispatcher("/editerClient.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		int id = Integer.parseInt(request.getParameter("id"));
		String message = "Error : le client n'a pas ete modifier";
		Client c = new Client();
		
		try {
			
			c.setNom(nom);
			c.setPrenom(prenom);
			c.setId(id);
			if(cs.updateClient(c)) {
				message = "Le client a bien ete modifier...";
			}
		} catch (Exception e) {
			
		}
		
		response.sendRedirect("SearchServlet?message=" + message);
	}

}
