package com.ib.formation.dao;

import java.util.Collections;
import java.util.List;


public class ClientDAOInMemory implements IClientDAO {

	private static List<Client> l = Collections.synchronizedList(PopulateClients.generateListClients());
	
	public ClientDAOInMemory() {
	}
	
	/* (non-Javadoc)
	 * @see com.ib.formation.dao.IClientDAO#getListClients()
	 */
	@Override
	public List<Client> getListClients() {
		
		return l;
	}
	
	/* (non-Javadoc)
	 * @see com.ib.formation.dao.IClientDAO#addClient(com.ib.formation.dao.Client)
	 */
	@Override
	public boolean addClient(Client c) {
		l.add(c);
		return true;
	}
	
	/* (non-Javadoc)
	 * @see com.ib.formation.dao.IClientDAO#deleteClient(com.ib.formation.dao.Client)
	 */
	@Override
	public boolean deleteClient(Client c) {
		l.remove(c);
		return true;
	}
	
	/* (non-Javadoc)
	 * @see com.ib.formation.dao.IClientDAO#updateClient(com.ib.formation.dao.Client)
	 */
	@Override
	public boolean updateClient(Client c) {
		for (Client client : l) {
			if (client.getId() == c.getId()) {
				client.setNom(c.getNom());
				client.setPrenom(c.getPrenom());
				return true;
			}
		}
		return false;
		
	}
	
	

}
