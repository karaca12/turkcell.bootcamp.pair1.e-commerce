package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "suppliers")
public class Supplier {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @MapsId
    @OneToOne
    @JoinColumn(name = "id", nullable = false)
    private User users;

    @Column(name = "tax_no", nullable = false, length = 15)
    private String taxNo;

    @Column(name = "rating", nullable = false)
    private Float rating;

    @OneToMany(mappedBy = "supplierId")
    @JsonIgnore
    private List<Product> products;

}