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

    public Cart createCart(Client client) {
        cart = new Cart(new BigDecimal(0), client);
        return cart;
    }

    public void addProduct(Book book, Client client) {
        if (cart == null) {
            createCart(client);
        }
        book.setQuantity(book.getQuantity() - 1);
        cartPosition = new CartPosition(1, cart, book);
        if (cartPositions.contains(cartPosition)) {
            increaseBookQuantityInCart(cartPositions.indexOf(cartPosition));
        } else {
            cartPositions.add(cartPosition);
            addCartPrice(book.getPrice());
        }
    }

    public List<CartPosition> getCartPositions() {
        return cartPositions;
    }

    public void saveCart() {
        cart.setCartPositionCollection(cartPositions);
        cartDAO.save(cart);
    }

    public void confirmOrder() {
        //change books quantity in database will be added later.. 
        saveCart();
        clearCart();
    }

    public void deleteCartPosition(int cartPositionId) {
        CartPosition cartPositionToRemove = cartPositions.get(cartPositionId);
        substractCartPrice(cartPositionToRemove.getBookId().getPrice(), cartPositionToRemove.getQuantity());
        cartPositions.remove(cartPositionId);
    }

    public BigDecimal getCartPrice() {
        return cart.getCartPrice();
    }

    public void addCartPrice(BigDecimal price) {
        cart.setCartPrice(cart.getCartPrice().add(price));
    }

    public void substractCartPrice(BigDecimal price, int quantity) {
        // cartPrice - ( bookPrice * quantity ) 
        cart.setCartPrice(cart.getCartPrice().subtract(price.multiply(new BigDecimal(quantity))));
    }

    public void decreaseBookQuantityInCart(int cartPosition) {
        CartPosition currentCart = cartPositions.get(cartPosition);
        currentCart.setQuantity(currentCart.getQuantity() - 1);
        int quantity = currentCart.getQuantity();
        substractCartPrice(currentCart.getBookId().getPrice(), 1);
        if (quantity == 0) {
            deleteCartPosition(cartPosition);
        }
    }

    public void increaseBookQuantityInCart(int cartPosition) {
        CartPosition currentCart = cartPositions.get(cartPosition);
        currentCart.setQuantity(currentCart.getQuantity() + 1);
        addCartPrice(currentCart.getBookId().getPrice());
    }
    
//    public BigDecimal getCurrentCartPrice(){
//    }
    
    public void clearCart(){
        cartPositions.clear();
        cart=null;
    }
}
