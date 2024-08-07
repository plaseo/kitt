package com.cardealer.services;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.cardealer.models.Role;
import com.cardealer.models.User;
import com.cardealer.repositories.RoleRepository;
import com.cardealer.repositories.UserRepository;
import jakarta.servlet.http.HttpSession;
import java.security.Principal;

@Service
public class UserService implements UserDetailsService{
    //user service depends on the repository
    //user controller depends on the user service
    //user service is doing the actual work or the raw materials

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleRepository roleRepository;

    public User signUp(User user, HttpSession session){
        Role role = roleRepository.findRole("SELLER");
        user.addRole(role);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User savedUser = userRepository.save(user);
        session.setAttribute("signupsuccess", "Sign Up Successful!");
        return savedUser;
    }

    public User findUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.get();
    }

    public User findUserByUsername(String username) {
        User user = userRepository.findByUsername(username);
        return user;
    }

    public User editProfile(Principal principal, User user) {
        String username = principal.getName();
        User sessionUser = userRepository.findByUsername(username);
        //go to the database and find the user that needs to be edited
        // User usertoedit = userRepository.findById(sessionUser.getId()).orElse(null);
        //modify user data from editprofile page
        sessionUser.setFirstName(user.getFirstName());
        sessionUser.setLastName(user.getLastName());
        sessionUser.setDateOfBirth(user.getDateOfBirth());
        sessionUser.setAddress(user.getAddress());
        sessionUser.setUsername(user.getUsername());
        sessionUser.setPhoneNumber(user.getPhoneNumber());
        //store the modified object in the user table
        //when you modify and object before calling the save method in the repository
        //  it will run an update SQL query 
        User editedUser = userRepository.save(sessionUser);
        return editedUser;

    }
    public List<User> findAllUsers() {
        List<User> findAllUsers = userRepository.findAll();
        return findAllUsers;
    }

    // public List<Role> findAllRoles() {
    //     List<Role> findAllRoles = roleRepository.findAll();
    //     return findAllRoles;
    // }


    public User editUser(User user, Long id) {
        User foundUser = userRepository.findById(id).orElse(null);
        foundUser.setFirstName(user.getFirstName());
        foundUser.setLastName(user.getLastName());
        foundUser.setDateOfBirth(user.getDateOfBirth());
        foundUser.setAddress(user.getAddress());
        foundUser.setUsername(user.getUsername());
        foundUser.setPassword(user.getPassword());
        foundUser.setPhoneNumber(user.getPhoneNumber());
        // makeAdmin(foundUser);
        User editedUser = userRepository.save(foundUser);
        return editedUser;
    }

    public User makeAdmin(User user){
        Role role = roleRepository.findRole("ADMIN");
        user.addRole(role);
        return user;
    }

    public User makeSeller(User user){
        Role role = roleRepository.findRole("SELLER");
        user.addRole(role);
        return user;
    }

    public User makeBuyer(User user){
        Role role = roleRepository.findRole("BUYER");
        user.addRole(role);
        return user;
    }
    
    @Override
    public UserDetails loadUserByUsername(String username){
        User user = userRepository.findByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException(username);
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthorities(user.getRoles()));
    }
    private Set<GrantedAuthority> getAuthorities(Set<Role> roles) {
        return roles.stream()
            .map(role -> new SimpleGrantedAuthority("ROLE_" + role.getName()))
            .collect(Collectors.toSet());
    }

    

   

    


    
}