package com.cardealer.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.cardealer.models.User;

@Controller
public class UserController {
    @GetMapping("/home")
    public String loadHome(){
        return "home";
    }

    @GetMapping("/signin")
    public String signIn(){
        return "signin";
    }

    @GetMapping("/signin")
    public String signUp(){
        return "signup";
    }

    @PostMapping("/signup")
        public String submitSignUp(@ModelAttribute User user){
            User savedUser = userService.signUp(user);
        }
    }


    


    

