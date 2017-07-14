/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kwxy.bookstore.services;

import com.kwxy.bookstore.database.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kwxy.bookstore.repositories.ClientDAO;

/**
 *
 * @author Monika
 */
@Service
public class ClientService{

    @Autowired
    public void setClientDAO(ClientDAO clientDAO){
        this.clientDAO = clientDAO;
    }

    ClientDAO clientDAO;

    @Autowired
    UserDetailsServiceImpl currentClient;

    public void addNewClient(Client client){
        clientDAO.save(client);
    }

    public Client getCurrentClient(){
        return currentClient.getCurrentUser();
    }

    public boolean emailIsExist(String email){
        return clientDAO.findOneByEmail(email).isPresent();
    }
}
