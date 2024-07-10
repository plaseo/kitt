package com.cardealer.controllers;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.cardealer.models.User;
import com.cardealer.services.UserService;
import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String loadHome() {
        return "home";
    }

    @GetMapping("/signin")
    public String signIn() {
        return "signin";
    }

    @GetMapping("/signup")
    public String signUp() {
        return "signup";
    }

    @PostMapping("/signup")
    public String submitSignUp(@ModelAttribute User user) {
        User savedUser = userService.signUp(user);
        return "signin";
    }

    // session is used to save user information temporarily on the server
    // httpsession is used to store temporary data/ session-specific data
    @PostMapping("/signinsubmit")
    public String submitSignIn(@RequestParam("email") String email, @RequestParam("password") String Password, Model model, HttpSession session){
        try {
            User authenticatedUser = userService.signIn(email, Password);

            session.setAttribute("user", authenticatedUser);
            session.setAttribute("userRole", authenticatedUser.getRole());

            // the parameters of addAttribute include: "attributeName"
            // used to access the object on the webpage, and then
            // you have actual object you want to pass to the webpage
            model.addAttribute("user", authenticatedUser);
            return "home";
        } catch (Exception e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "signin";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        // clear any data that is set in the session
        session.invalidate();
        return "signin";    
    }

    @GetMapping("/userprofile")
    public String userProfile(HttpSession session, Model model) {
        // get the object of the signed in user from the session
        User sessionUser = (User) session.getAttribute("user");
        // persist our object from the database
        User user = userService.findUserById(sessionUser.getId());
        if (user == null) {
            return "signin";
        } else {
            model.addAttribute("user", user);
            return "userprofile";
        }
        // have to go to db to get use1r object of signed in user
    }

    @GetMapping("/editprofile/{id}")
    // retrieve the user object we want to edit from the database
    // we want to pass that user object to the edit profile so we can edit
    public String editProfile(@PathVariable Long id, Model model) {
        User user = userService.findUserById(id);
        model.addAttribute("user", user);
        return "editprofile";
    }

    @PostMapping("/editprofile")
    public String updateProfile(@ModelAttribute User user, HttpSession session) {
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
        return "redirect:/availableusers";
    }

}
