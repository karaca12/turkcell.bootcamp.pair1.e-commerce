package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.abstraction;

import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.Shipment;

import java.util.List;
import java.util.Optional;

public interface ShipmentService {
    List<Shipment> getAll();

    Optional<Shipment> getById(int id);

    void add(Shipment shipment);

    void update(Shipment shipment);

    void deleteById(int id);
}
