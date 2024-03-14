package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.implementation;

import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.core.exception.types.BusinessException;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.Order;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.Shipment;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.repository.ShipmentRepository;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.abstraction.OrderService;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.abstraction.ShipmentService;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.shipment.requests.AddShipmentRequest;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.shipment.requests.UpdateShipmentRequest;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.shipment.response.ShipmentListResponse;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.shipment.response.ShipmentStatusOrderReceivedResponse;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.mapper.ShipmentMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class ShipmentServiceImpl implements ShipmentService {
    private final ShipmentRepository shipmentRepository;
    private final OrderService orderService;

    public ShipmentServiceImpl(ShipmentRepository shipmentRepository, OrderService orderService) {
        this.shipmentRepository = shipmentRepository;
        this.orderService = orderService;
    }

    @Override
    public List<ShipmentListResponse> getAll() {
        List<Shipment> shipments= shipmentRepository.findAll();


        return ShipmentMapper.INSTANCE.shipmentGetAllResponseListFromShipmentList(shipments);
    }

    @Override
    public ShipmentListResponse getById(int id) {
        Shipment shipment=shipmentRepository.findById(id).orElseThrow(()->new BusinessException("There is no shipment with id:"+id));


        return ShipmentMapper.INSTANCE.shipmentGetAllResponseFromShipment(shipment);
    }

    @Override
    public void add(AddShipmentRequest addShipmentRequest) {
        if (!isDeliveryDateValid(addShipmentRequest.getShippedDate(),addShipmentRequest.getEstimatedDeliveryDate())){
            throw new BusinessException("Estimated delivery date can not be earlier than shipped date.");
        }
        Shipment shipment=ShipmentMapper.INSTANCE.shipmentFromAddRequest(addShipmentRequest);
        shipmentRepository.save(shipment);
    }

    @Override
    public void update(UpdateShipmentRequest updateShipmentRequest) {
        if(shipmentRepository.findById(updateShipmentRequest.getId()).isEmpty()){
            throw new BusinessException("Shipment not found with id:"+updateShipmentRequest.getId());
        }
        Shipment shipment=ShipmentMapper.INSTANCE.shipmentFromUpdateRequest(updateShipmentRequest);
        shipmentRepository.save(shipment);
    }

    @Override
    public void deleteById(int id) {
        shipmentRepository.deleteById(id);
    }

    @Override
    public List<ShipmentStatusOrderReceivedResponse> getShipmentsByOrderReceived() {


        List<Shipment> shipments = shipmentRepository.getShipmentsByOrderReceived();

        return ShipmentMapper.INSTANCE.GetAllOrderRecievedFromShipment(shipments);
    }

    public boolean isDeliveryDateValid(LocalDate shippedDate,LocalDate estimatedDate){
        if(shippedDate.isAfter(estimatedDate)){
            return false;
        }
        return true;
    }
}
