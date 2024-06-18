package com.cardealer.models;

import java.time.LocalDate;

import com.cardealer.enums.BodyStyle;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "car")
//@Data automatically generates boilerplate code eg getters/setters
// or the no argument constructor, toString method, etc
@Data
public class Car {
    @Id
    //IDENTITY: relies on the database's auto-increment to generate primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "manufacturerName")
    private String manufacturerName;

    @Column(name = "model")
    private String model;
    
    @Column(name = "year")
    private int year;
    
    @Column(name = "color")
    private String color;
    
    @Column(name = "transmission")
    private String transmission;
    
    @Column(name = "mileage")
    private double mileage;
    
    @Column(name = "dateOfPurchase")
    private LocalDate dateOfPurchase;
    
    @Column(name = "photoUrl")
    private String photoUrl;
    
    @Column(name = "description", length=5000)
    private String description;
    
    @Column(name = "engineType")
    private String engineType;
    
    @Column(name = "bodyStyle")
    private BodyStyle bodyStyle;
    
    @Column(name = "price")
    private double price;
    
    @Column(name = "isAvailable")
    private boolean isAvailable;
    
    @Column(name = "isNew")
    private boolean isNew;
    
    @Column(name = "vin", unique=true, nullable = false)
    private String vin;
    //possible constraints : nullable, unique, primary key, length
    
}
