/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kwxy.bookstore.repositories;

import com.kwxy.bookstore.database.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Monika
 */
@Repository
@Transactional
public interface ClientDAO extends CrudRepository<Client, Integer> {
    
    public Client findById(Integer id);
    
}
