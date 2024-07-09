package com.cardealer.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.cardealer.enums.UserRole;
import com.cardealer.models.User;
import com.cardealer.repositories.UserRepository;
import jakarta.servlet.http.HttpSession;

@Service
public class UserService implements UserDetailsService{
    //user service depends on the repository
    //user controller depends on the user service
    //user service is doing the actual work or the raw materials

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    //going in the method is user information from
    //  the sign up page in the form of a user object
    //going out of the method(after the user information is processed)
    //is a saved user object

    public User signUp(User user){

        user.setRole(UserRole.BUYER);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User savedUser = userRepository.save(user);
        return savedUser;
    }

    public User signIn(String email, String password) throws Exception{
        //data we're working with: email, password
        //check if the user exist in the database based on the email given
        User foundUser = userRepository.findByEmail(email);
        //if a user is returned from the database
        if(foundUser != null){
            //if the found user's password matches the user's password
            if(passwordEncoder.matches(password, foundUser.getPassword())){
                //output the authenticated user
                return foundUser;
            }
            else{
                //wrong password was entered. throw exception
                throw new Exception("Invalid credentials. Try password again");
            }
        }
        throw new Exception("No account exists with the given email");
    }
    public User findUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.get();
    }

    public User editProfile(User user, HttpSession session) {
        // HttpSession session;
        User sessionUser = (User) session.getAttribute("user");
        //go to the database and find the user that needs to be edited
        User usertoedit = userRepository.findById(sessionUser.getId()).orElse(null);
        //modify user data from editprofile page
        usertoedit.setFirstName(user.getFirstName());
        usertoedit.setLastName(user.getLastName());
        usertoedit.setDateOfBirth(user.getDateOfBirth());
        usertoedit.setAddress(user.getAddress());
        usertoedit.setEmail(user.getEmail());
        usertoedit.setPhoneNumber(user.getPhoneNumber());
        //store the modified object in the user table
        //when you modify and object before calling the save method in the repository
        //  it will run an update SQL query 
        User editedUser = userRepository.save(usertoedit);
        return editedUser;

    }
    public List<User> findAllUsers() {
        List<User> findAllUsers = userRepository.findAll();
        return findAllUsers;
    }
    public User editUser(User user, Long id) {
        User foundUser = userRepository.findById(id).orElse(null);
        foundUser.setFirstName(user.getFirstName());
        foundUser.setLastName(user.getLastName());
        foundUser.setDateOfBirth(user.getDateOfBirth());
        foundUser.setAddress(user.getAddress());
        foundUser.setEmail(user.getEmail());
        foundUser.setPassword(user.getPassword());
        foundUser.setPhoneNumber(user.getPhoneNumber());
        foundUser.setRole(user.getRole());
        foundUser.setIsAdmin(user.getIsAdmin());
        User editedUser = userRepository.save(foundUser);
        return editedUser;
    }

    @Override
    public UserDetails loadUserByUsername(String email){
        User user = userRepository.findByEmail(email);
        if(user == null){
            throw new UsernameNotFoundException("User Not Found");
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(), AuthorityUtils.createAuthorityList("ROLE_" + user.getRole()));
        
    }
}