/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kwxy.bookstore.controller;

import com.kwxy.bookstore.database.Client;
import com.kwxy.bookstore.services.CartService;
import com.kwxy.bookstore.services.ClientService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Monika
 */
@Controller
public class UserController{

    @Autowired
    ClientService clientService;

    @Autowired
    CartService cartService;
    
    @RequestMapping(value = "/signUpForm")
    public String signUpForm(Client client){
        return "/signUpForm";
    }

    @RequestMapping(value = "/signUpForm", method = RequestMethod.POST)
    public String signUp(@Valid Client client, BindingResult result, Model model){
        if (clientService.emailIsExist(client.getEmail())){
            result.rejectValue("email", "email.exist", "Podany email już istnieje.");
        }
        if (result.hasErrors()){
            return "/signUpForm";
        }
        clientService.addNewClient(client);
        return "redirect:/";
    }

    @RequestMapping("/logInForm")
    public String logIn(){
        return "logInForm";
    }

    @RequestMapping(value = "/logInForm", method = RequestMethod.POST)
    public String addUser(){
        return "redirect:/";
    }

    @RequestMapping(value = "/clearCart")
    public String clearCart(){
        cartService.clearCart();
        return "redirect:/logout";
    }
}
