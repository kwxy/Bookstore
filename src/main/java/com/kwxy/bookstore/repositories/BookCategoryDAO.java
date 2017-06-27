/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kwxy.bookstore.repositories;

import com.kwxy.bookstore.database.BookCategory;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Monika
 */
@Transactional
@Repository
public interface BookCategoryDAO extends CrudRepository<BookCategory, Integer>{
    
    @Override
    public List<BookCategory> findAll(); 
    public BookCategory findById(Integer id); 
}
