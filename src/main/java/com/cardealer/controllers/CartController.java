package com.cardealer.controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.cardealer.models.Cart;
import com.cardealer.services.CartService;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping
    public String viewCart(Principal principal, Model model) {
        //get cart previously set in the user session or set a new cart
        //  if no cart has been set
        // String username = principal.getName();
        Cart cart = cartService.getCart(principal);
        //the data we want to pass to the cart webpage is whatever items are currently in the cart
        model.addAttribute("cartItems", cart.getItemsInCart());
        return "cart";
    }

    @GetMapping("/add/{id}")
        //use the car id from the car details page to retrieve the car object from 
        //  the db that we want to add to our items in the cart list
    public String addToCart(@PathVariable Long id, Principal principal) {
        cartService.addToCart(id, principal);
        return "redirect:/cart";
    }

    @GetMapping ("/remove/{id}")
    public String removeFromCart(@PathVariable Long id, Principal principal) {
        cartService.removeFromCart(id, principal);
        return "redirect:/cart";
    }
    
    
}
