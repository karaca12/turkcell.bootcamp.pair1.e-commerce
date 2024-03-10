package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.implementation;

import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.Shipment;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.Wishlist;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.repository.ShipmentRepository;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.abstraction.ShipmentService;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.shipment.response.ShipmentStatusOrderReceivedResponse;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.wishlist.WishlistNonUpdatedResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class ShipmentServiceImpl implements ShipmentService {
    private final ShipmentRepository shipmentRepository;

    public ShipmentServiceImpl(ShipmentRepository shipmentRepository) {
        this.shipmentRepository = shipmentRepository;
    }

    @Override
    public List<Shipment> getAll() {
        return shipmentRepository.findAll();
    }

    @Override
    public Optional<Shipment> getById(int id) {
        return shipmentRepository.findById(id);
    }

    @Override
    public void add(Shipment shipment) {
        shipmentRepository.save(shipment);
    }

    @Override
    public void update(Shipment shipment) {

    }

    @Override
    public void deleteById(int id) {
        shipmentRepository.deleteById(id);
    }

    @Override
    public List<ShipmentStatusOrderReceivedResponse> getShipmentsByOrderReceived() {
        List<Shipment> shipments = shipmentRepository.getShipmentsByOrderReceived();
        List<ShipmentStatusOrderReceivedResponse> response = new ArrayList<>();
        for (Shipment shipment :
                shipments) {
            ShipmentStatusOrderReceivedResponse dto = new
                    ShipmentStatusOrderReceivedResponse(shipment.getId(),
                    shipment.getOrderId().getId(),
                    shipment.getOrderId().getCustomerId().getId(),
                    shipment.getShippedDate(),
                    shipment.getEstimatedDeliveryDate(),
                    shipment.getStatus());
            response.add(dto);
        }
        return response;
    }
}
