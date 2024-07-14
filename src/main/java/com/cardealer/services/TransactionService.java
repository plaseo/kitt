package com.cardealer.services;

import java.security.Principal;
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
import com.cardealer.repositories.UserRepository;

import jakarta.servlet.http.HttpSession;
import com.cardealer.repositories.CarRepository;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private UserRepository userRepository;

    public boolean createTransaction(Cart cart, Principal principal){
        String username = principal.getName();
        User sessionUser = userRepository.findByUsername(username);
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

    public List<Transaction> getAllTransactions() {
        List<Transaction> allTransactions = transactionRepository.findAll();
        return allTransactions;
    }

    
}
