
package com.cardealer.controllers;

import java.security.Principal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.cardealer.models.User;
import com.cardealer.repositories.RoleRepository;
import com.cardealer.services.UserService;
import jakarta.servlet.http.HttpSession;

@Controller
@Scope("session")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private RoleRepository roleRepository;

    @Value("${maps.apiKey}")
    public String mapsApiKey;

    @GetMapping("/")
    public String loadHome(Principal principal, Model model) {
        model.addAttribute("mapsApiKey", mapsApiKey);
        if(principal == null) {
            return "home";
        }else{String username = principal.getName();
            User user = userService.findUserByUsername(username);
            model.addAttribute("user", user); 
            return "home";
        }
    }
    
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "home";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/signup")
    public String signUp() {
        return "signup";
    }

    @PostMapping("/signup")
    public String submitSignUp(@ModelAttribute User user, HttpSession session) {
        User savedUser = userService.signUp(user, session);
        return "redirect:/login ";
    }

    @GetMapping("/userprofile")
    public String userProfile(Principal principal, Model model) {
        String username = principal.getName();
        User user = userService.findUserByUsername(username);
        model.addAttribute("user", user);
        return "userprofile";
    }

    @GetMapping("/editprofile")
    public String editProfile(Principal principal, Model model) {
        String username = principal.getName();
        User user = userService.findUserByUsername(username);
        model.addAttribute("user", user);
        return "editprofile";
    }

    @PostMapping("/editprofile")
    public String updateProfile(Principal principal, @ModelAttribute User user) {
        User editedUser = userService.editProfile(principal, user);
        return "redirect:/userprofile";
    }

    @GetMapping("/availableusers")
    public String availableUsers(Model model) {
        List<User> availableUsers = userService.findAllUsers();
        model.addAttribute("availableUsers", availableUsers); 
        return "availableusers";
    }

    @GetMapping("/userdetails/{id}")
    public String userDetail(@PathVariable Long id, Model model){
        User user = userService.findUserById(id);
        model.addAttribute("user", user);
        return "userdetails";
    }
    @PostMapping("/userdetails/{id}")
    public String editUser(@ModelAttribute User user, @PathVariable Long id) {
        User editedUser = userService.editUser(user, id);
        String fruits = 
        return "redirect:/availableusers";
    }

    @PostMapping("/userdetails/updaterolls")
    public String updateRoles(){
        String fruits = request.getPara
        
    }
    
}
