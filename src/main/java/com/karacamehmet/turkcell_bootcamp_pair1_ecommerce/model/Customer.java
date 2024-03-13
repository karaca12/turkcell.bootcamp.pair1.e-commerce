package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @MapsId
    @OneToOne
    @JoinColumn(name = "id", nullable = false)
    private User users;

    @Column(name = "last_name", nullable = false, length = 50)
    private String lastName;

    @OneToMany(mappedBy = "customerId")
    @JsonIgnore
    private List<Order> orders;

    @OneToOne(mappedBy = "customer")
    @JsonIgnore
    private Cart cart;

    @OneToMany(mappedBy = "customerId")
    @JsonIgnore
    private List<Wishlist> wishlists;


}