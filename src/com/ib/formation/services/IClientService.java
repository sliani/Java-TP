package com.ib.formation.services;

import java.util.List;

import com.ib.formation.dao.Client;

public interface IClientService {
	
	public List<Client> getListClients();
	public boolean deleteClient(Client c);
	public boolean updateClient(Client c);
	public boolean addClient(Client c);
}
