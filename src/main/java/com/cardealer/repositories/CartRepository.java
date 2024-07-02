package com.cardealer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cardealer.models.Cart;

public interface CartRepository extends JpaRepository<Cart, Long>{
    
}
