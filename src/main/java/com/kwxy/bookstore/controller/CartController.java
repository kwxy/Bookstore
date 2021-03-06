/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kwxy.bookstore.controller;

import com.kwxy.bookstore.database.Book;
import com.kwxy.bookstore.database.Client;
import com.kwxy.bookstore.services.BookService;
import com.kwxy.bookstore.services.CartService;
import com.kwxy.bookstore.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Monika
 */
@PreAuthorize("hasAuthority('USER')")
@Controller
public class CartController{

    @Autowired
    ClientService clientService;

    @Autowired
    BookService bookService;

    @Autowired
    CartService cartService;

    @RequestMapping(value = "/addProduct/{currentBookId}")
    public String addProduct(@PathVariable("currentBookId") int bookId){
        Book currentBook = bookService.getBookById(bookId);
        Client currentClient = clientService.getCurrentClient();
        cartService.addProduct(currentBook, currentClient);
        return "redirect:/" + currentBook.getCategoryId().getId();
    }

    @RequestMapping(value = "/cart")
    public String showCart(Model model){
        if ((cartService.getCartPositions().size()) == 0){
            //empty cart.. 
            return "redirect:/";
        }
        model.addAttribute("cartPositions", cartService.getCartPositions());
        model.addAttribute("cartPrice", cartService.getCartPrice());
        return "/cart";
    }

    @RequestMapping("cart/deleteCartPosition/{currentCartPositionId}")
    public String deleteCartPosition(@PathVariable("currentCartPositionId") int cartPositionId){
        cartService.deleteCartPosition(cartPositionId);
        return "redirect:/cart";
    }

    @RequestMapping("cart/confirmOrder")
    public String confirm(){
        cartService.confirmOrder();
        return "redirect:/";
    }

    @RequestMapping("cartPosition/subtractBook/{currentCartPositionId}")
    public String decreaseBookQuantityInCart(@PathVariable("currentCartPositionId") int currentCartPositionId){
        cartService.decreaseBookQuantityInCart(currentCartPositionId);
        return "redirect:/cart";
    }

    @RequestMapping("cartPosition/addBook/{currentCartPositionId}")
    public String increaseBookQuantityInCart(@PathVariable("currentCartPositionId") int currentCartPositionId){
        cartService.increaseBookQuantityInCart(currentCartPositionId);
        return "redirect:/cart";
    }
}
