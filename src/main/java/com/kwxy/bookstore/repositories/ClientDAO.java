/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kwxy.bookstore.repositories;

import com.kwxy.bookstore.database.Client;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Monika
 */
@Repository
@Transactional
public interface ClientDAO extends CrudRepository<Client, Integer>{

    public Optional<Client> findOneByEmail(String email);
    public Client findById(Integer id);
    public Client findByEmail(String email);

}
