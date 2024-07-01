package com.cardealer.models;

import jakarta.persistence.Table;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
@Table(name = "cart")
@Data
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //many to many: multiple instances of one class are related to multiple
    //  instances of another class
    //a car can be in  multiple carts, and a cart can have multiple cars
    //a many to many joins two tables into one by taking the primary keys
    //  from each table and using them as foreign keys to make a new table

    @ManyToMany
    @JoinTable(
        //the table that's created by joining
        name = "carsincart",
        //primary key of the first referenced table
        joinColumns = @JoinColumn(name = "cart_id", referencedColumnName = "id"),
        //primary key of the other table, ie the collection you've declared to represent
        inverseJoinColumns = @JoinColumn(name = "car_id", referencedColumnName = "id")
    )
    private List<Car> itemsInCart = new ArrayList<>();
    //unidirectional relationship means that only one entity knows about the relationship
    // i.e. you can only navigate one side of the relationship
    //bidirectional means that both entities know about the relationship
    //  i.e you can navigate the relationship on both sides

}
