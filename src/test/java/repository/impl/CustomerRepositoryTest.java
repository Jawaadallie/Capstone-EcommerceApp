/* 
  Customer____.java
  Author: 222709006 Qhama dyushu
  Date: 22/03/2026
    */
package repository.impl;

import domain.Customer;
import org.junit.jupiter.api.Test;
import repository.CustomerRepository;
import repository.impl.CustomerRepositoryImpl;

import static org.junit.jupiter.api.Assertions.*;

class CustomerRepositoryTest {

    CustomerRepository repo = CustomerRepositoryImpl.getRepository();

    @Test
    void create() {
        Customer customer = new Customer.Builder()
                .setCustomerId("C001")
                .setName("Qhama")
                .build();

        Customer created = repo.create(customer);

        assertNotNull(created);
    }
}
