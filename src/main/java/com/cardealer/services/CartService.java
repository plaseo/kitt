package com.cardealer.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cardealer.models.Car;
import com.cardealer.models.Cart;
import com.cardealer.models.User;
import com.cardealer.repositories.CarRepository;
import com.cardealer.repositories.CartRepository;
import com.cardealer.repositories.UserRepository;
import jakarta.servlet.http.HttpSession;

@Service
public class CartService {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private UserRepository userRepository;


    public Cart getCart(HttpSession session) {
        User sessionUser = (User) session.getAttribute("user");
        User user = userRepository.findById(sessionUser.getId()).orElse(null);
        //get cart previously set in the user session
        // Cart cart = (Cart) session.getAttribute("cart");
        Cart cart = user.getCart();
        //check if any cart was previously set in the user session
        if (cart == null) {
            //initialize a new cart
            cart = new Cart();
            //set a new cart if no cart has been set
            session.setAttribute("cart", cart);
            //save cart in the db
            cartRepository.save(cart);
            //set the cart for teh current signed in user
            user.setCart(cart);
            //update the uer with that cart
            userRepository.save(user);
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
            cartRepository.save(cart);
        }
    }

    public void removeFromCart(Long id, HttpSession session) {
        //get the cart from the current session
        Cart cart = getCart(session);
        Car carToRemove = null;
        for(Car car: cart.getItemsInCart()) {
            if(car.getId() == id) {
                carToRemove = car;
            }
        }
        cart.getItemsInCart().remove(carToRemove);
        cartRepository.save(cart);
    }

}
