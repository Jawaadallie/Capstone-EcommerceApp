package service;

import domain.Address;
import java.util.List;

public interface AddressService extends IService<Address, String> {
    List<Address> findAll();
}
