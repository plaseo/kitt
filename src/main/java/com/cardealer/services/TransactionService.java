package com.cardealer.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cardealer.models.Car;
import com.cardealer.models.Cart;
import com.cardealer.models.Transaction;
import com.cardealer.models.User;
import com.cardealer.repositories.TransactionRepository;
import jakarta.servlet.http.HttpSession;
import com.cardealer.repositories.CarRepository;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private CarRepository carRepository;

    public boolean createTransaction(Cart cart, HttpSession session){
        User sessionUser = (User) session.getAttribute("user");
        for(Car car: cart.getItemsInCart()){
            car.setIsAvailable(false);
        }
        Transaction transaction = new Transaction();
        transaction.setDate(LocalDate.now());
        transaction.setUser(sessionUser);    
        transaction.setTotalAmount(calculateTotal(cart));
        transactionRepository.save(transaction);
        List<Car> updatedCars = new ArrayList<>();
        for(Car car: cart.getItemsInCart()){
            car.setIsAvailable(false);
            car.setTransaction(transaction);
            carRepository.save(car);
            updatedCars.add(car);
        }
        //save the transaction to the db
        transaction.setItems(updatedCars);
        transactionRepository.save(transaction);
        return true;
    }
    public double calculateTotal(Cart cart){
        double total = 0;
        for(Car car: cart.getItemsInCart()){
            total = total + car.getPrice();
        }
        return total;
    }
    
}
