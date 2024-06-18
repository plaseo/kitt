package com.cardealer.models;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "transaction")
@Data

public class Transaction {


    //we need a table to hold our transactions
    //
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @OneToMany
    @JoinColumn(name = "transaction_id", referencedColumnName = "id")
    private List<Car> items;

    @ManyToOne
    @JoinColumn(name = "user_ud", referencedColumnName = "id")
    private User user;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "tax")
    private double tax;

    @Column(name = "totalAmount")
    private BigDecimal totalAmount;

    

}


