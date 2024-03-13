package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "email", nullable = false, length = 50)
    private String email;

    @Column(name = "password_hash", nullable = false, length = 50)
    private String passwordHash;

    @Column(name = "phone_number", nullable = false, length = 15)
    private String phoneNumber;

    @OneToOne(mappedBy = "users", optional = true)
    @JsonIgnore
    private Customer customer;

    @OneToOne(mappedBy = "users", optional = true)
    @JsonIgnore
    private Supplier supplier;

    @OneToMany(mappedBy = "userId")
    @JsonIgnore
    private List<Address> addressId;
}