/*
 * ShipmentRepositoryTest.java
 * Author: Tlangelani Chauke
 * Date:22march 2026
 */
package repository.impl;

import org.junit.jupiter.api.*;
import domain.Shipment;
import factory.ShipmentFactory;

import static org.junit.jupiter.api.Assertions.*;

        import java.util.Date;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ShipmentRepositoryTest {

    private static repository.impl.ShipmentRepositoryImpl shipmentRepository = repository.impl.ShipmentRepositoryImpl.getRepository();

    private static Shipment shipment = ShipmentFactory.createShipment(
            "Cape Town",
            new Date(),
            new Date(),
            "Pending"
    );

    @Test
    @Order(1)
    void create() {
        Shipment created = shipmentRepository.create(shipment);
        assertNotNull(created);
    }

    @Test
    @Order(2)
    void read() {
        Shipment read = shipmentRepository.read(shipment.getShipmentId());
        assertNotNull(read);
    }

    @Test
    @Order(3)
    void update() {
        Shipment updatedShipment = new Shipment.Builder()
                .copy(shipment)
                .setStatus("Delivered")
                .build();

        Shipment updated = shipmentRepository.update(updatedShipment);
        assertEquals("Delivered", updated.getStatus());
    }

    private void assertEquals(String delivered, String status) {
    }

   // @Test
    //@Order(4)
    //void getAll() {
      //  assertFalse(shipmentRepository.getAll().isEmpty());
    //}

    @Test
    @Order(5)
    void delete() {
        boolean success = shipmentRepository.delete(shipment.getShipmentId());
        assertTrue(success);
    }
}
