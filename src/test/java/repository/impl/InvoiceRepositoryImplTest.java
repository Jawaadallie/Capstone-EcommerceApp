/* InvoiceRepositoryImplTest.java
   InvoiceRepositoryImplTest class
   Author: Mogamad Jawaad Allie - 230472125
   Date: 21 June 2026
*/
package repository.impl;

import domain.Invoice;
import factory.InvoiceFactory;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class InvoiceRepositoryImplTest {
    private final InvoiceRepositoryImpl repo = new InvoiceRepositoryImpl();

    @Test
    void testInvoiceCRUD() {
        // 1. Create
        Invoice invoice = InvoiceFactory.createInvoice(
                "INV-1001",
                "ORD-555",
                "2026-06-21",
                1150.00,
                150.00,
                "Paid"
        );
        assertNotNull(invoice);
        Invoice created = repo.create(invoice);
        assertEquals(invoice.getInvoiceId(), created.getInvoiceId());

        // 2. Read
        Invoice read = repo.read(invoice.getInvoiceId());
        assertNotNull(read);
        assertEquals("ORD-555", read.getOrderId());

        // 3. Update
        Invoice updated = new Invoice.Builder().copy(read)
                .setInvoiceStatus("Refunded")
                .build();
        Invoice result = repo.update(updated);
        assertNotNull(result);
        assertEquals("Refunded", repo.read(invoice.getInvoiceId()).getInvoiceStatus());

        // 4. Find All
        assertEquals(1, repo.findAll().size());

        // 5. Delete
        boolean deleted = repo.delete(invoice.getInvoiceId());
        assertTrue(deleted);
        assertEquals(0, repo.findAll().size());
    }
}
