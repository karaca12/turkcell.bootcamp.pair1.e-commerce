package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.repository;

import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.Shipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShipmentRepository extends JpaRepository<Shipment, Integer> {
    @Query(value = "select * from shipments where status = 'order received'",nativeQuery = true)
    List<Shipment> getShipmentsByOrderReceived();
}