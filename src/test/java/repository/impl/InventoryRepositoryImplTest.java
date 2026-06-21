/* InventoryRepositoryImplTest.java
   InventoryRepositoryImplTest class
   Author: Plamedie 230082629
   Date: 21 June 2026
*/
package repository.impl;

import domain.Inventory;
import factory.InventoryFactory;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class InventoryRepositoryImplTest {
    private final InventoryRepositoryImpl repo = new InventoryRepositoryImpl();

    @Test
    void testInventoryCRUD() {
        // 1. Create
        Inventory inventory = InventoryFactory.createInventory(
                "INV-505",
                "PROD-001",
                100,
                "Warehouse A",
                "2026-06-21"
        );
        assertNotNull(inventory);
        Inventory created = repo.create(inventory);
        assertEquals(inventory.getInventoryId(), created.getInventoryId());

        // 2. Read
        Inventory read = repo.read(inventory.getInventoryId());
        assertNotNull(read);
        assertEquals("Warehouse A", read.getWarehouseLocation());

        // 3. Update
        Inventory updated = new Inventory.Builder().copy(read)
                .setStockQuantity(120)
                .build();
        Inventory result = repo.update(updated);
        assertNotNull(result);
        assertEquals(120, repo.read(inventory.getInventoryId()).getStockQuantity());

        // 4. Find All
        assertEquals(1, repo.findAll().size());

        // 5. Delete
        boolean deleted = repo.delete(inventory.getInventoryId());
        assertTrue(deleted);
        assertEquals(0, repo.findAll().size());
    }
}
