/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kwxy.bookstore.services;

import com.kwxy.bookstore.database.Client;
import com.kwxy.bookstore.repositories.ClientDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author Monika
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final ClientDAO clientDAO;

    @Autowired
    public UserDetailsServiceImpl(ClientDAO clientDAO) {
        this.clientDAO = clientDAO;
    }

    @Override
    public CurrentClient loadUserByUsername(String email) throws UsernameNotFoundException {
        Client client = clientDAO.findOneByEmail(email).orElseThrow(() -> new UsernameNotFoundException(String.format("User with email=%s was not found", email)));
//        Client client = clientDAO.findByEmail(email);
//        if(client==null)  new UsernameNotFoundException(String.format("User with email=%s was not found", email));
        return new CurrentClient(client);
    }
    
    public Client getCurrentUser()
    {
        CurrentClient userDetailsServiceImpl = (CurrentClient) SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();
        Client currentClient = userDetailsServiceImpl.getClient();
        return currentClient;
    }
}
