/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kwxy.bookstore.services;

import com.kwxy.bookstore.database.Book;
import com.kwxy.bookstore.database.BookCategory;
import com.kwxy.bookstore.repositories.BookCategoryDAO;
import com.kwxy.bookstore.repositories.BookDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Monika
 */
@Service
public class BookService {
    
    @Autowired
    BookCategoryDAO bookCategoryDAO; 
    
    @Autowired
    BookDAO bookDAO;     
    
    public List<BookCategory> getAllBookCategory(){
        return bookCategoryDAO.findAll();
    }
    
    public List<Book> getBooksByCategoryId(Integer id){
        return bookDAO.findByCategoryId(bookCategoryDAO.findById(id)); 
    }
    
    public List<Book> getAllBooks(){
        return bookDAO.findAll();
    }
    
    public Book getBookById(Integer id){
        return bookDAO.findById(id);
    }
    
    public BookCategory getBookCategoryById(Integer id){
        return bookCategoryDAO.findById(id);
    }
    
    public int getFirstBookCategoryId(){
        return bookCategoryDAO.findAll().get(0).getId();
    }
}
