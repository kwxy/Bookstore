/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kwxy.bookstore.database;

import com.kwxy.bookstore.validators.PostcodePLFormat;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Monika
 */
@Entity
@Table(name = "client")
public class Client implements Serializable{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(max = 30)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(max = 30)
    @Column(name = "surname")
    private String surname;
    @Basic(optional = false)
    @NotNull
    @Size(max = 50)
    @Column(name = "street")
    private String street;
    @Basic(optional = false)
    @NotNull
    @Size(max = 50)
    @Column(name = "city")
    private String city;
    @Basic(optional = false)
    @NotNull
    @Size(min = 6, max = 6, message = "Kod pocztowy ma 6 znaków. ")
    @PostcodePLFormat
    @Column(name = "post_code")
    private String postCode;
    @Basic(optional = false)
    @NotNull
    @Column(name = "email", unique = true)
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 6, message = "Za krótkie haslo")
    @Column(name = "password")
    private String password;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clientId")
    private Collection<Cart> cartCollection;

    public Client(){
    }

    public Client(String name, String surname, String street, String city, String postCode, String email, String password){
        this.name = name;
        this.surname = surname;
        this.street = street;
        this.city = city;
        this.postCode = postCode;
        this.email = email;
        this.password = password;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public Integer getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getSurname(){
        return surname;
    }

    public void setSurname(String surname){
        this.surname = surname;
    }

    public String getStreet(){
        return street;
    }

    public void setStreet(String street){
        this.street = street;
    }

    public String getCity(){
        return city;
    }

    public void setCity(String city){
        this.city = city;
    }

    public String getPostCode(){
        return postCode;
    }

    public void setPostCode(String postCode){
        this.postCode = postCode;
    }

    @XmlTransient
    public Collection<Cart> getCartCollection(){
        return cartCollection;
    }

    public void setCartCollection(Collection<Cart> cartCollection){
        this.cartCollection = cartCollection;
    }

    @Override
    public int hashCode(){
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object){
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Client)){
            return false;
        }
        Client other = (Client) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))){
            return false;
        }
        return true;
    }

    @Override
    public String toString(){
        return "com.kwxy.bookstore.database.Client[ id=" + id + " ]";
    }

}
