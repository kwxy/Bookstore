/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kwxy.bookstore.controller;

import com.kwxy.bookstore.database.Book;
import com.kwxy.bookstore.database.BookCategory;
import com.kwxy.bookstore.services.BookService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Monika
 */
@Controller
public class HomeController {

    @Autowired
    BookService bookService;
    
    public List<BookCategory> getAllCategories() {
        return bookService.getAllBookCategory();
    }

    public List<Book> getBooksByCategoryId(Integer id) {
        return bookService.getBooksByCategoryId(id);
    }
    
    public int getFirstCategoryId(){
        return bookService.getFirstBookCategoryId();
    }
    
    @RequestMapping("/")
    public String mainPage(Model model){
        return "redirect:/" + getFirstCategoryId();
    }

    @RequestMapping(value = "/{currentCategoryId}", method = RequestMethod.GET)
    public String changeCategory(Model model, @PathVariable("currentCategoryId") int currentCategoryId) {
        model.addAttribute("categories", getAllCategories());
        model.addAttribute("books", getBooksByCategoryId(currentCategoryId));
        return "index";
    }    
}
