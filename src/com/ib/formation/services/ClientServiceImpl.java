package com.ib.formation.services;

import java.util.List;

import com.ib.formation.dao.Client;
import com.ib.formation.dao.ClientDAOInMemory;
import com.ib.formation.dao.IClientDAO;

public class ClientServiceImpl implements IClientService{

	private IClientDAO dao = new ClientDAOInMemory();
	private List<Client> l;
	@Override
	public List<Client> getListClients() {
		return dao.getListClients();
	}

	@Override
	public boolean deleteClient(Client c) {
		return dao.deleteClient(c);
	}

	@Override
	public boolean updateClient(Client c) {
		return dao.updateClient(c);
	}

	@Override
	public boolean addClient(Client c) {
		return dao.addClient(c);
	}

}
