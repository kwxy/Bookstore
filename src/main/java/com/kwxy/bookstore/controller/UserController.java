/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kwxy.bookstore.controller;

import com.kwxy.bookstore.database.Client;
import com.kwxy.bookstore.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Monika
 */

@Controller
public class UserController {
    
    @Autowired
    ClientService clientService; 
    
    @RequestMapping(value="/signUpForm")
    public String signUpForm(Client client){
        return "/signUpForm"; 
    }
    
    @RequestMapping(value = "/signUpForm", method = RequestMethod.POST)
    public String signUp(@ModelAttribute("client") Client client){
        clientService.addNewClient(client);
            return "redirect:/";
    }
    
    @RequestMapping("/logInForm")
    public String logIn(){
        return "logInForm";
    }
    
    @RequestMapping(value="/logInForm", method=RequestMethod.POST)
    public String addUser(){
        return "index";
    }
    
    @RequestMapping(value="/logOut")
    public String logOut(){
        return "index";
    }
}
