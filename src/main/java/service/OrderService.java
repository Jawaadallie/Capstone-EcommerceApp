package service;

import domain.Order;
import java.util.List;

public interface OrderService extends IService<Order, String> {
    List<Order> findAll();
}
