/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kwxy.bookstore.services;

import com.kwxy.bookstore.database.Book;
import com.kwxy.bookstore.database.Cart;
import com.kwxy.bookstore.database.CartPosition;
import com.kwxy.bookstore.database.Client;
import com.kwxy.bookstore.repositories.CartDAO;
import com.kwxy.bookstore.repositories.CartPositionDAO;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Monika
 */
@Service
public class CartService {
    
    @Autowired
    CartDAO cartDAO; 
    
    @Autowired
    CartPositionDAO cartPositionDAO;
    
    private Cart cart; 
    private CartPosition cartPosition; 
    private List<CartPosition> cartPositions = new ArrayList();
    
    public Cart createCart(Client client){
        cart = new Cart(new BigDecimal(0), client); 
        return cart; 
    }
    
    public void addProduct(Book book, Client client){
        if (cart==null) createCart(client);
        book.setQuantity(book.getQuantity()-1);
        cartPosition = new CartPosition(1, cart, book); 
        cartPositions.add(cartPosition);
        cart.setCartPrice(cart.getCartPrice().add(book.getPrice()));
    }
    
    public List<CartPosition> getCartPositions(){
        return cartPositions;
    }
    
    public void saveCart(){
        cart.setCartPositionCollection(cartPositions);
        cartDAO.save(cart);
    }
    
    public void confirmOrder(){
        //change books quantity in database will be added later.. 
        saveCart(); 
    }
    
    public void deleteCartPosition(int cartPositionId){
        CartPosition cartPositionToRemove = cartPositions.get(cartPositionId);
        // cartPrice - ( bookPrice * quantity ) 
        cart.setCartPrice(cart.getCartPrice().subtract((cartPositionToRemove.getBookId().getPrice()).multiply(new BigDecimal(cartPositionToRemove.getQuantity()))));
        cartPositions.remove(cartPositionId);
    }
    
    public BigDecimal getCartPrice(){
        return cart.getCartPrice();
    }
}
