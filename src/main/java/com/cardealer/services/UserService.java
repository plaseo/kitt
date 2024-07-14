package com.cardealer.services;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.jackson2.SimpleGrantedAuthorityMixin;
import org.springframework.stereotype.Service;
import com.cardealer.enums.UserRole;
import com.cardealer.models.Role;
import com.cardealer.models.User;
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

    public User signUp(User user){

        user.setRole(UserRole.BUYER);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User savedUser = userRepository.save(user);
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
    public User editUser(User user, Long id) {
        User foundUser = userRepository.findById(id).orElse(null);
        foundUser.setFirstName(user.getFirstName());
        foundUser.setLastName(user.getLastName());
        foundUser.setDateOfBirth(user.getDateOfBirth());
        foundUser.setAddress(user.getAddress());
        foundUser.setUsername(user.getUsername());
        foundUser.setPassword(user.getPassword());
        foundUser.setPhoneNumber(user.getPhoneNumber());
        // foundUser.setRole(user.getRole());
        foundUser.setIsAdmin(user.getIsAdmin());
        User editedUser = userRepository.save(foundUser);
        return editedUser;
    }
    
    @Override
    public UserDetails loadUserByUsername(String username){
        User user = userRepository.findByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException(username);
        }
        // return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(), null);
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthorities(user.getRoles()));
        // return new MyUserPrincipal(user);
        
    }
    private Set<GrantedAuthority> getAuthorities(Set<Role> roles) {
        return roles.stream()
            .map(role -> new SimpleGrantedAuthority("ROLE_" + role.getName()))
            .collect(Collectors.toSet());
    }

    


    
}