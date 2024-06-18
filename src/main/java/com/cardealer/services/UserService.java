package com.cardealer.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cardealer.models.User;
import com.cardealer.repositories.UserRepository;

@Service
public class UserService{
    //user service depends on the repository
    //user controller depends on the user service
    //user service is doing the actual work or the raw materials

    @Autowired
    private UserRepository userRepository;

    //going in the method is user information from
    //  the sign up page in the form of a user object
    //going out of the method(after the user information is processed)
    //is a saved user object

    public User signUp(User user){
        User savedUser = userRepository.save(user);
        return savedUser;   
    }




    

} 