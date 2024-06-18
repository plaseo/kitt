package com.cardealer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cardealer.models.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository <Transaction, Long>{

}
