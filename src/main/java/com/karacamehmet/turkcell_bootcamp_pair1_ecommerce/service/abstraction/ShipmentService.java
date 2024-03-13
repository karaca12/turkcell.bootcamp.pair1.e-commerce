package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.abstraction;

import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.Shipment;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.shipment.requests.AddShipmentRequest;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.shipment.requests.UpdateShipmentRequest;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.shipment.response.ShipmentListResponse;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.shipment.response.ShipmentStatusOrderReceivedResponse;

import java.util.List;
import java.util.Optional;

public interface ShipmentService {
    List<ShipmentListResponse> getAll();

    ShipmentListResponse getById(int id);

    void add(AddShipmentRequest addShipmentRequest);

    void update(UpdateShipmentRequest updateShipmentRequest);

    void deleteById(int id);
    List<ShipmentStatusOrderReceivedResponse> getShipmentsByOrderReceived();
}
