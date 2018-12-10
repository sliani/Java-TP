package com.ib.formation.dao;

import java.util.List;

public interface IClientDAO {

	List<Client> getListClients();

	boolean addClient(Client c);

	boolean deleteClient(Client c);

	boolean updateClient(Client c);

}