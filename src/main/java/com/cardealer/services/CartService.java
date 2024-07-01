package com.cardealer.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cardealer.models.Car;
import com.cardealer.models.Cart;
import com.cardealer.repositories.CarRepository;
import jakarta.servlet.http.HttpSession;

@Service
public class CartService {

    @Autowired
    private CarRepository carRepository;

    public Cart getCart(HttpSession session) {
        //get cart previously set in the user session
        Cart cart = (Cart) session.getAttribute("cart");
        //check if any cart was previously set in the user session
        if (cart == null) {
            //initialize a new cart
            cart = new Cart();
            //set a new cart if no cart has been set
            session.setAttribute("cart", cart);
        }
        return cart;
    }

    //add to cart
    public void addToCart(Long id, HttpSession session) {
        //get the cart associated w/user we want to add a car to
        Cart cart = getCart(session);
        //use the car id from teh car details page to retrieve the car object
        Car carToAdd = carRepository.findById(id).orElse(null);
        //if a car comes back from the database 
        if(carToAdd != null) {
            ///add our items in the cart list
            cart.getItemsInCart().add(carToAdd);
        }
    }

}
