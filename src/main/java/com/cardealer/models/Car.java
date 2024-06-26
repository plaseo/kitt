package com.cardealer.models;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import com.cardealer.enums.BodyStyle;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
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
    
    @Column(name = "dateAdded")
    private LocalDate dateAdded;

    @Column(name = "dateSold")
    private LocalDate dateSold;
    
    @Column(name = "description", length=5000)
    private String description;
    
    @Column(name = "engineType")
    private String engineType;

    @Enumerated(EnumType.STRING)
    @Column(name = "bodyStyle")
    private BodyStyle bodyStyle;
    
    @Column(name = "price")
    private double price;
    
    @Column(name = "isAvailable")
    private boolean isAvailable;
    
    @Column(name = "isNew")
    private boolean isNew;
    
    //possible constraints : nullable, unique, primary key, length
    @Column(name = "vin", unique=true, nullable = false)
    private String vin;
    
    @Column(name = "photoUrl")
    public String photoUrl;

    @OneToMany
    @JoinColumn(name = "car_id", referencedColumnName = "id")
    public List<Photo> photos;

    @Column(name = "discountapplied")
    private Boolean discountApplied;

    public Car(String manufacturerName, String model, int year, String color, String transmission, double mileage,
            String description, String engineType, BodyStyle bodyStyle, double price,
            boolean isAvailable, boolean isNew, String vin) {
        this.manufacturerName = manufacturerName;
        this.model = model;
        this.year = year;
        this.color = color;
        this.transmission = transmission;
        this.mileage = mileage;
    
        this.description = description;
        this.engineType = engineType;
        this.bodyStyle = bodyStyle;
        this.price = price;
        this.isAvailable = isAvailable;
        this.isNew = isNew;
        this.vin = vin;
    }

    //empty constructor
    public Car(){

    }
    //possible constraints : nullable, unique, primary key, length
    
}
