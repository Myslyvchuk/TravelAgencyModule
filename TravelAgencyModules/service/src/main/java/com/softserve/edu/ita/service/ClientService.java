package com.softserve.edu.ita.service;


import com.softserve.edu.ita.dao.implementation.DaoFactory;
import com.softserve.edu.ita.entity.Client;

import java.util.List;

public class ClientService {
	public void addClient(Client client) {
		DaoFactory.getInstance().getClientDao().addElement(client);
	}
	public void updateClient(Client client) {
		DaoFactory.getInstance().getClientDao().updateElement(client);
	}
	public Client getClientById(Long clientId) {
        return DaoFactory.getInstance().getClientDao().getElementById(clientId);
    }

    public List<Client> getAllClient() {
        return DaoFactory.getInstance().getClientDao().getAllElement();
    }

    public void deleteClient(Client client) {
        DaoFactory.getInstance().getClientDao().deleteElement(client);
    }
	

}

