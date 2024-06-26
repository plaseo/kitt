package com.cardealer.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.cardealer.models.User;
import com.cardealer.services.UserService;

import jakarta.servlet.http.HttpSession;

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

    //session is used to save user information temporarily on the server
    //httpsession is used to store temporary data/ session-specific data    
    @PostMapping("/signin")
    public String submitSignIn(@ModelAttribute User user, Model model, HttpSession session){
        try {
        User authenticatedUser = userService.signIn(user);

        session.setAttribute("user", authenticatedUser);
        session.setAttribute("userRole", authenticatedUser.getRole());


        //the parameters of addAttribute include: "attributeName" 
        //  used to access the object on the webpage, and then
        //      you have actual object you want to pass to the webpage
        model.addAttribute("user", authenticatedUser);
        return "home";
        }
        catch(Exception e){
            model.addAttribute("errorMessage", e.getMessage());
            return "signin";
        }



    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        //clear any data that is set in the session
        session.invalidate();
        return "signin";


    }
    

}


    


    

