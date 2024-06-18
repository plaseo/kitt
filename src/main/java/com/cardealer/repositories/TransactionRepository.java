package com.cardealer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cardealer.models.Transaction;

public interface TransactionRepository extends JpaRepository <Transaction, Long>{

}
