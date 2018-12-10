package com.ib.formation.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClientDAOInDB implements IClientDAO {

	@Override
	public List<Client> getListClients() {
		Connection conn = JDBCUtils.getConnection();
		List<Client> l = new ArrayList<Client>();
		try {
			Statement stmt = conn.createStatement();
			String sql;
			sql = "SELECT * FROM shop.client;";
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				// Retrieve by column name
				int id = rs.getInt("id");
				String nom = rs.getString("nom");
				String prenom = rs.getString("prenom");

				Client cl = new Client();
				cl.setId(id);
				cl.setNom(nom);
				cl.setPrenom(prenom);
				l.add(cl);
			}
		} catch (Exception e) {

		}
		return l;

	}

	@Override
	public boolean addClient(Client c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteClient(Client c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateClient(Client c) {
		// TODO Auto-generated method stub
		return false;
	}

}
