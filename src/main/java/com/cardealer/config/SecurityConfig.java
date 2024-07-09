package com.cardealer.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.core.userdetails.UserDetailsService;
import com.cardealer.services.UserService;

@Configuration
//enables web security support and provides the spring mvc integration
@EnableWebSecurity
public class SecurityConfig {
    
    private UserService userService;

    //Lazy is used to control initialization of beans, created only when requested
    public SecurityConfig(@Lazy UserService userService){
        this.userService = userService;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
        //starts the configuration for authorizing http requests
        .authorizeHttpRequests(authorizeRequests -> authorizeRequests
        //specify the url patterns and their access rules
        .requestMatchers("/", "/signin", "/cars", "/signup", "/cart", "/WEB-INF/jsp/*", "/css/**", "/startup-report", "/availableusers").permitAll()
        .requestMatchers("/transactions").hasAnyRole("SELLER")
        //any other request must be authenticated
        .anyRequest().authenticated()
        )

        //configure form based authentication
        .formLogin(form -> form
        //specify the custom login page url
        .loginPage("/signin")
        //the url to submit the email and password(form action)
        .loginProcessingUrl("/signin")
        //the default url to redirect after a successful login
        .defaultSuccessUrl("/")
        //allows all users to access the login page and submit login credentials
        .permitAll()
        )

        //configure the logout functionality
        .logout(logout -> logout
        //URL to trigger logout
        .logoutUrl("/logout")
        //invalidate/clear the session upon logout
        .invalidateHttpSession(true)
        //delete the session cookie
        .deleteCookies("JSESSIONID")
        .permitAll());
        
        return http.build();
    }

    //Password Encoder Bean
    //hashes the password securely
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    //Authentication Manager Bean
    //retrieve the authentication manager from the authentication configuration. The authentication is responsible for processing authentication requests
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception{
        return authenticationConfiguration.getAuthenticationManager();
    }

    //UserDetailsService bean
    //register our own "UserService class" as the UserDetailsService bean, which is used to load user details from the database. It does that via a method called "loadUserByUsername"
    @Bean
    public UserDetailsService UserDetailsService(){
        return userService;
    }

}