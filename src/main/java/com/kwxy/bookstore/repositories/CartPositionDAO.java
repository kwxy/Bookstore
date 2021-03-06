/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kwxy.bookstore.repositories;

import com.kwxy.bookstore.database.CartPosition;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Monika
 */

@Repository
@Transactional
public interface CartPositionDAO extends CrudRepository<CartPosition, Integer> {
    
    @Override
    public List<CartPosition> findAll(); 
}
