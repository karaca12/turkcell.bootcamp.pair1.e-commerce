package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.mapper;

import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.model.Shipment;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.shipment.requests.AddShipmentRequest;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.shipment.requests.UpdateShipmentRequest;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.shipment.response.ShipmentListResponse;
import com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.service.dto.shipment.response.ShipmentStatusOrderReceivedResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ShipmentMapper {
    ShipmentMapper INSTANCE = Mappers.getMapper(ShipmentMapper.class);

    @Mapping(source = "orderId", target = "orderId.id")
    Shipment shipmentFromAddRequest(AddShipmentRequest addShipmentRequest);

    @Mapping(source = "orderId.id", target = "orderId")
    ShipmentListResponse shipmentGetAllResponseFromShipment(Shipment shipment);


    List<ShipmentListResponse> shipmentGetAllResponseListFromShipmentList(List<Shipment> shipments);

    @Mapping(source = "orderId", target = "orderId.id")
    Shipment shipmentFromUpdateRequest(UpdateShipmentRequest updateShipmentRequest);

    @Mapping(source="orderId.id",target = "orderId")
    @Mapping(source="orderId.customerId.id",target = "customerId")
    ShipmentStatusOrderReceivedResponse shipmentGetAllOrderRecievedResponse(Shipment shipment);
    List<ShipmentStatusOrderReceivedResponse> GetAllOrderRecievedFromShipment(List<Shipment> shipments);
}
