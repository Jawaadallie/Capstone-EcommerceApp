package service;

import domain.Customer;
import java.util.List;

public interface CustomerService extends IService<Customer, String> {
    List<Customer> getAll();
}
