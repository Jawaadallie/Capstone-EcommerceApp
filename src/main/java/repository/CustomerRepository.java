/* 
  Customer____.java
  Author: 222709006 Qhama dyushu
  Date: 22/03/2026
    */
package repository;

import domain.Customer;
import java.util.List;

public interface CustomerRepository {

    Customer create(Customer customer);

    Customer read(String customerId);

    Customer update(Customer customer);

    boolean delete(String customerId);

    List<Customer> getAll();
}
