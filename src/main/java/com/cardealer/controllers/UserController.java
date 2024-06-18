package com.cardealer.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.cardealer.models.User;
import com.cardealer.services.UserService;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String loadHome(){
        return "home";
    }

    @GetMapping("/signin")
    public String signIn(){
        return "signin";
    }

    @GetMapping("/signup")
    public String signUp(){
        return "signup";
    }

    @PostMapping("/signup")
        public String submitSignUp(@ModelAttribute User user){
            User savedUser = userService.signUp(user);
            return "signin";
        }
    }


    


    

