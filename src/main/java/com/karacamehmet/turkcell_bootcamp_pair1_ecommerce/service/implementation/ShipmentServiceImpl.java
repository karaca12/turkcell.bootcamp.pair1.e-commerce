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

        List<ShipmentListResponse> shipmentListResponses=new ArrayList<>();
        for(Shipment i:shipments){

            ShipmentListResponse shipmentListResponse=new ShipmentListResponse(i.getId(),i.getOrderId().getId(),i.getShippedDate(),i.getEstimatedDeliveryDate(),i.getStatus());
            shipmentListResponses.add(shipmentListResponse);
        }
        return shipmentListResponses;
    }

    @Override
    public ShipmentListResponse getById(int id) {
        Shipment shipment=shipmentRepository.findById(id).orElseThrow(()->new BusinessException("There is no shipment with id:"+id));
        ShipmentListResponse shipmentListResponse=new ShipmentListResponse();
        shipmentListResponse.setShipmentId(shipment.getId());
        shipmentListResponse.setOrderId(shipment.getOrderId().getId());
        shipmentListResponse.setShippedDate(shipment.getShippedDate());
        shipmentListResponse.setStatus(shipment.getStatus());
        shipmentListResponse.setEstimatedDeliveryDate(shipment.getEstimatedDeliveryDate());

        return shipmentListResponse;
    }

    @Override
    public void add(AddShipmentRequest addShipmentRequest) {
        if (isdeliveryDateValid(addShipmentRequest.getShippedDate(),addShipmentRequest.getEstimatedDeliveryDate())){
            throw new BusinessException("Estimated delivery date can not be earlier than shipped date.");
        }
        Shipment shipment=new Shipment();
        Order order=orderService.getById(addShipmentRequest.getOrderId()).orElseThrow(()->new BusinessException("Order could not founnt with id:"+addShipmentRequest.getOrderId()));
        shipment.setId(addShipmentRequest.getId());
        shipment.setOrderId(order);
        shipment.setStatus(addShipmentRequest.getStatus());
        shipment.setEstimatedDeliveryDate(addShipmentRequest.getEstimatedDeliveryDate());
        shipment.setShippedDate(addShipmentRequest.getShippedDate());
        shipmentRepository.save(shipment);
    }

    @Override
    public void update(UpdateShipmentRequest updateShipmentRequest) {
        Shipment shipment=shipmentRepository.findById(updateShipmentRequest.getId()).orElseThrow(()->new BusinessException("Shipment not found with id:"+updateShipmentRequest.getId()));
        Order order=orderService.getById(updateShipmentRequest.getOrderId()).orElseThrow(()-> new BusinessException("Order coulld not found with id"+updateShipmentRequest.getOrderId()));
        shipment.setStatus(updateShipmentRequest.getStatus());
        shipment.setShippedDate(updateShipmentRequest.getShippedDate());
        shipment.setEstimatedDeliveryDate(updateShipmentRequest.getEstimatedDeliveryDate());
        shipment.setOrderId(order);
        shipmentRepository.save(shipment);
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
    public boolean isdeliveryDateValid(LocalDate shippedDate,LocalDate estimatedDate){
        if(shippedDate.compareTo(estimatedDate)>0){
            return true;
        }
        return false;
    }
}
