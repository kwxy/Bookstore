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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Monika
 */
@Entity
@Table(name = "cart_position")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CartPosition.findAll", query = "SELECT c FROM CartPosition c")
    , @NamedQuery(name = "CartPosition.findById", query = "SELECT c FROM CartPosition c WHERE c.id = :id")
    , @NamedQuery(name = "CartPosition.findByQuantity", query = "SELECT c FROM CartPosition c WHERE c.quantity = :quantity")})
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

    public CartPosition(Integer id) {
        this.id = id;
    }

    public CartPosition(Integer id, int quantity) {
        this.id = id;
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
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CartPosition)) {
            return false;
        }
        CartPosition other = (CartPosition) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kwxy.bookstore.database.CartPosition[ id=" + id + " ]";
    }
    
}
