/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kwxy.bookstore.services;

import com.kwxy.bookstore.database.Client;
import java.util.Collection;
import java.util.HashSet;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

/**
 *
 * @author Monika
 */
    public class CurrentClient extends org.springframework.security.core.userdetails.User {

    private Client client;

    public CurrentClient(Client client) {
        super(client.getEmail(), client.getPassword(), AuthorityUtils.createAuthorityList("USER"));
        this.client = client;
    }

    public Client getClient() {
        return client;
    }

    public int getId() {
        return client.getId();
    }
    
    @Override
    public String getPassword() {
        return client.getPassword();
    }

    @Override
    public String getUsername() {
        return client.getName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
