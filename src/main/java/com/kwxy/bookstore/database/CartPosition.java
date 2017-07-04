/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kwxy.bookstore.database;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Monika
 */
@Entity
@Table(name = "cart_position")
public class CartPosition implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "quantity")
    private int quantity;
    @JoinColumn(name = "cart_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Cart cartId;
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Book bookId;

    public CartPosition() {
    }

    public CartPosition(int quantity, Cart cartId, Book bookId) {
        this.cartId = cartId; 
        this.bookId = bookId;
        this.quantity = quantity;
    }

    public Integer getId() {
        return id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Cart getCartId() {
        return cartId;
    }

    public Book getBookId() {
        return bookId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bookId != null ? bookId.hashCode() : 0); //change it later... 
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof CartPosition)) {
            return false;
        }
        CartPosition other = (CartPosition) object;
        if ((this.bookId == null && other.bookId != null) || (this.bookId != null && !this.bookId.equals(other.bookId))) { //change it later..
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kwxy.bookstore.database.CartPosition[ id=" + id + " ]";
    }
    
}
