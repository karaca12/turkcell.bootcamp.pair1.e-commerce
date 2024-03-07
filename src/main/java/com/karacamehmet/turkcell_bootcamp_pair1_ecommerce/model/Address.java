package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "addresses")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "district_id", nullable = false)
    private District districtId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User userId;

    @Column(name = "details", nullable = false, length = 250)
    private String details;

}