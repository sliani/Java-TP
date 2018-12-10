package com.ib.formation.dao;

import java.util.ArrayList;
import java.util.List;

public class PopulateClients {
	
	public static List<Client> generateListClients(){
		
		Client c1 = new Client();
		c1.setNom("Jean");
		c1.setPrenom("Prenom");
		Client c2 = new Client();
		c2.setNom("Patrick");
		c2.setPrenom("Prenom");
		Client c3 = new Client();
		c3.setNom("Gaston");
		c3.setPrenom("Prenom");
		Client c4 = new Client();
		c4.setNom("Emile");
		c4.setPrenom("Prenom");
		Client c5 = new Client();
		c5.setNom("Mohamade");
		c5.setPrenom("Prenom");
		
		List<Client> l = new ArrayList<Client>();
		l.add(c1);
		l.add(c2);
		l.add(c3);
		l.add(c4);
		l.add(c5);
		
		return l;
		
	}
}
