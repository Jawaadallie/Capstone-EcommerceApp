package service;

import domain.Shipment;
import java.util.List;

public interface ShipmentService extends IService<Shipment, String> {
    List<Shipment> findAll();
}
