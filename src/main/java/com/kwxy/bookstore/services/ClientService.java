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
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Monika
 */
@Transactional
@Service
public class ClientService {

    @Autowired
    ClientDAO clientDAO; 
    
    public void addNewClient(Client client){
        clientDAO.save(client);
    }
    
    public Client getCurrentClient(){
        return clientDAO.findById(12); //it will be change later... 
    }
}
