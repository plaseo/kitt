package com.cardealer.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cardealer.models.Transaction;

public interface TransactionRepository extends JpaRepository <Transaction, Long> {

    @Query(value = "select * from transaction order by date asc", nativeQuery = true)
    public List<Transaction> findAllOrderByDateAsc();
    
}