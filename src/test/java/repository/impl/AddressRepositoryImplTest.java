/* AddressRepositoryImplTest.java
   AddressRepositoryImplTest class
   Author: 222709006 Qhama dyushu
   Date: 21 June 2026
*/
package repository.impl;

import domain.Address;
import factory.AddressFactory;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AddressRepositoryImplTest {
    private final AddressRepositoryImpl repo = new AddressRepositoryImpl();

    @Test
    void testAddressCRUD() {
        // 1. Create
        Address address = AddressFactory.createAddress(
                "ADDR-101",
                "CUST-202",
                "123 Main St",
                "Cape Town",
                "Western Cape",
                "8001",
                "South Africa",
                "Shipping"
        );
        assertNotNull(address);
        Address created = repo.create(address);
        assertEquals(address.getAddressId(), created.getAddressId());

        // 2. Read
        Address read = repo.read(address.getAddressId());
        assertNotNull(read);
        assertEquals("123 Main St", read.getStreetAddress());

        // 3. Update
        Address updated = new Address.Builder().copy(read)
                .setCity("Stellenbosch")
                .build();
        Address result = repo.update(updated);
        assertNotNull(result);
        assertEquals("Stellenbosch", repo.read(address.getAddressId()).getCity());

        // 4. Find All
        assertEquals(1, repo.findAll().size());

        // 5. Delete
        boolean deleted = repo.delete(address.getAddressId());
        assertTrue(deleted);
        assertEquals(0, repo.findAll().size());
    }
}
