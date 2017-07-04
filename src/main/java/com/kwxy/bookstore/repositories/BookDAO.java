/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kwxy.bookstore.repositories;

import com.kwxy.bookstore.database.Book;
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
public interface BookDAO extends CrudRepository<Book, Integer> {

    @Override
    public List<Book> findAll();
    public Book findById(Integer id);
    public List<Book> findByCategoryId(BookCategory categoryId);
}
