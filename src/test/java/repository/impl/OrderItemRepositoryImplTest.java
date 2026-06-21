/* OrderItemRepositoryImplTest.java
   OrderItemRepositoryImplTest class
   Author: Joshua Jonathan Bird - 230444032
   Date: 21 June 2026
*/
package repository.impl;

import domain.OrderItem;
import factory.OrderItemFactory;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class OrderItemRepositoryImplTest {
    private final OrderItemRepositoryImpl repo = new OrderItemRepositoryImpl();

    @Test
    void testOrderItemCRUD() {
        // 1. Create
        OrderItem item = OrderItemFactory.createOrderItem(
                "ITEM-001",
                "ORD-999",
                "PROD-007",
                2,
                150.00
        );
        assertNotNull(item);
        OrderItem created = repo.create(item);
        assertEquals(item.getOrderItemId(), created.getOrderItemId());

        // 2. Read
        OrderItem read = repo.read(item.getOrderItemId());
        assertNotNull(read);
        assertEquals(2, read.getQuantity());

        // 3. Update
        OrderItem updated = new OrderItem.Builder().copy(read)
                .setQuantity(5)
                .build();
        OrderItem result = repo.update(updated);
        assertNotNull(result);
        assertEquals(5, repo.read(item.getOrderItemId()).getQuantity());

        // 4. Find All
        assertEquals(1, repo.findAll().size());

        // 5. Delete
        boolean deleted = repo.delete(item.getOrderItemId());
        assertTrue(deleted);
        assertEquals(0, repo.findAll().size());
    }
}
