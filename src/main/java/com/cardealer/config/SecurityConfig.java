package com.cardealer.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.core.userdetails.UserDetailsService;
import com.cardealer.services.UserService;

@Configuration
//enables web security support and provides the spring mvc integration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
        
        //starts the configuration for authorizing http requests
        .authorizeHttpRequests(authorizeRequests -> authorizeRequests
        //specify the url patterns and their access rules
        .requestMatchers("/", "/logout", "/login", "/cars", "/signup", "/WEB-INF/jsp/*", "/css/**", "error", "/startup-report", "/cardetails/{id}", "/home", "/editprofile").permitAll()
        .requestMatchers("/transactions").hasRole("SELLER")
        //any other request must be authenticated
        .anyRequest().authenticated()
        )

        .formLogin(form -> form
        .loginPage("/login")
        .defaultSuccessUrl("/")
        .permitAll()
        );
        
        
        return http.build();
    }

    //Password Encoder Bean
    //hashes the password securely
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    
   

}