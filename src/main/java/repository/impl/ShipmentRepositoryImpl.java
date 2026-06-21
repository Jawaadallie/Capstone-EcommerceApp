/*
 * ShipmentRepositoryImpl.java
 * Author: Tlangelani Chauke
 * Date:22march 2026
 */
package repository.impl;

import domain.Shipment;
import repository.ShipmentRepository;

import java.util.*;

public class ShipmentRepositoryImpl implements ShipmentRepository {

    private static ShipmentRepositoryImpl repository = null;
    private Map<String, Shipment> shipmentDB;

    private ShipmentRepositoryImpl() {
        shipmentDB = new HashMap<>();
    }

    public static ShipmentRepositoryImpl getRepository() {
        if (repository == null) {
            repository = new ShipmentRepositoryImpl();
        }
        return repository;
    }

    @Override
    public Shipment create(Shipment shipment) {
        shipmentDB.put(shipment.getShipmentId(), shipment);
        return shipment;
    }

    @Override
    public Shipment read(String shipmentId) {
        return shipmentDB.get(shipmentId);
    }

    @Override
    public Shipment update(Shipment shipment) {
        if (shipmentDB.containsKey(shipment.getShipmentId())) {
            shipmentDB.put(shipment.getShipmentId(), shipment);
            return shipment;
        }
        return null;
    }

    @Override
    public boolean delete(String shipmentId) {
        Shipment removed = shipmentDB.remove(shipmentId);
        return removed != null;
    }

    @Override
    public List<Shipment> findAll() {
        return List.of();
    }

    //@Override
    //public List<Shipment> getAll() {
       // return new ArrayList<>(shipmentDB.values());
    //}
}
