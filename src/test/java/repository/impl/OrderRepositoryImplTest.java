/* 
  Order____.java
  Author: Joshua Jonathan Bird - 230444032
  Date: 22/03/2026
    */

package repository.impl;

import domain.Order;
import factory.OrderFactory;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class OrderRepositoryImplTest {
    private final OrderRepositoryImpl repo = new OrderRepositoryImpl();

    @Test
    void testCreateReadUpdateDelete() {
        Order order = OrderFactory.createOrder("O001", "C123", "2026-03-19", 1500.00);

        // Create
        repo.create(order);
        assertEquals(1, repo.findAll().size());

        // Read
        Order found = repo.read("O001");
        assertNotNull(found);

        // Update
        Order updated = new Order.Builder()
                .setOrderId("O001")
                .setCustomerId("C123")
                .setOrderDate("2026-03-20")
                .setTotalAmount(2000.00)
                .build();
        repo.update(updated);
        assertEquals(2000.00, repo.read("O001").getTotalAmount());

        // Delete
        assertTrue(repo.delete("O001"));
        assertEquals(0, repo.findAll().size());
    }
}
