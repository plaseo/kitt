package com.cardealer.models;

import java.time.LocalDate;
import java.util.List;
import com.cardealer.enums.UserRole;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "user")
@Data

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "dateOfBirth")
    private LocalDate dateOfBirth;

    @Column(name = "address")
    private String address;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "phoneNumber")
    private String phoneNumber;

    // @Column(name = "role")
    // private UserRole role;

    //@Enumerated specifies how the enum should be persisted in the database
    //@EnumType.String = store the enum as a string, corresponding to the name of enum constant
    //@EnumType.ORDINAL = 
    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private UserRole role;
    
    @Column(name = "isAdmin")
    private boolean isAdmin;

    @OneToMany
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private List<Car> cars;

    public User(String firstName, String lastName, LocalDate dateOfBirth, String address, String email, String password,
            String phoneNumber, UserRole role, boolean isAdmin) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.role = role;
        this.isAdmin = isAdmin;
    }

    

    


    
}
