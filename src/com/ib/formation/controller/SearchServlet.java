package com.ib.formation.controller;
import java.util.*;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ib.formation.dao.Client;
import com.ib.formation.services.ClientServiceImpl;
import com.ib.formation.services.IClientService;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private IClientService cs = new ClientServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<Client> l = cs.getListClients();
		List<Client> f = new ArrayList<Client>();
		
		String search = request.getParameter("rechercher");
		
		if (search == "" || search == null)
			f = l;
		else {
			search = search.toLowerCase();
			for (Client client : l) {
				if (client.getNom().toLowerCase().contains(search) || client.getPrenom().toLowerCase().contains(search)) {
					f.add(client);
				}
			}
		}
		
		request.setAttribute("listeClient", f);
		request.setAttribute("message", "toto");
		
		this.getServletContext().getRequestDispatcher("/listeClient.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
