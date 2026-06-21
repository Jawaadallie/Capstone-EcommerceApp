/* PaymentRepositoryImplTest.java
   This is the test class for PaymentRepositoryImpl.
   Author: Mogamad Jawaad Allie - 230472125
   Date: 25 March 2026
*/
package repository.impl;

import domain.Payment;
import factory.PaymentFactory;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PaymentRepositoryImplTest {
    // Initializing the repository for testing
    private final PaymentRepositoryImpl repo = new PaymentRepositoryImpl();

    @Test
    void testPaymentCRUD() {
        // 1. Create a Payment
        Payment myPayment = PaymentFactory.createPayment("ORD-999", 1200.50, "2026-03-25", "EFT");
        assertNotNull(myPayment);
        
        Payment created = repo.create(myPayment);
        assertEquals(myPayment.getPaymentId(), created.getPaymentId());
        System.out.println("Created: " + created);

        // 2. Read the Payment
        Payment readPayment = repo.read(myPayment.getPaymentId());
        assertNotNull(readPayment);
        assertEquals("ORD-999", readPayment.getOrderId());
        System.out.println("Read: " + readPayment);

        // 3. Update the Payment (using the builder copy method)
        Payment updatedPayment = new Payment.Builder().copy(readPayment)
                .setPaymentAmount(1300.75)
                .build();
        
        Payment result = repo.update(updatedPayment);
        assertNotNull(result);
        assertEquals(1300.75, repo.read(myPayment.getPaymentId()).getPaymentAmount());
        System.out.println("Updated: " + result);

        // 4. Find All
        assertEquals(1, repo.findAll().size());

        // 5. Delete the Payment
        boolean isDeleted = repo.delete(myPayment.getPaymentId());
        assertTrue(isDeleted);
        assertEquals(0, repo.findAll().size());
        System.out.println("Deleted successfully");
    }
}
