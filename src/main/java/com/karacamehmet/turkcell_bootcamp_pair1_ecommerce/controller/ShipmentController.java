package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.controller;

import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.Shipment;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.abstraction.ShipmentService;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.shipment.response.ShipmentStatusOrderReceivedResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/shipments")
public class ShipmentController {
    private final ShipmentService shipmentService;

    public ShipmentController(ShipmentService shipmentService) {
        this.shipmentService = shipmentService;
    }

    @GetMapping()
    List<Shipment> getAll() {
        return shipmentService.getAll();
    }

    @GetMapping("/{id}")
    Optional<Shipment> getById(@PathVariable int id) {
        return shipmentService.getById(id);
    }

    @PostMapping
    void add(@RequestBody Shipment shipment) {
        shipmentService.add(shipment);
    }

    @DeleteMapping("/{id}")
    void deleteById(@PathVariable int id) {
        shipmentService.deleteById(id);
    }

    @GetMapping("/getShipmentsByOrderReceived")
    List<ShipmentStatusOrderReceivedResponse> getShipmentsByOrderReceived() {
        return shipmentService.getShipmentsByOrderReceived();
    }
}
