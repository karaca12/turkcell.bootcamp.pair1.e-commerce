package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "shipments")
public class Shipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    @JsonIgnore
    private Order orderId;

    @Column(name = "shipped_date", nullable = false)
    private LocalDate shippedDate;

    @Column(name = "estimated_delivery_date", nullable = false)
    private LocalDate estimatedDeliveryDate;

    @Column(name = "status", nullable = false, length = 50)
    private String status;

}