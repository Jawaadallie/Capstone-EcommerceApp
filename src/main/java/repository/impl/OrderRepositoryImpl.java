/* 
  Order____.java
  Author: Joshua Jonathan Bird - 230444032
  Date: 22/03/2026
    */
package repository.impl;

import domain.Order;
import repository.OrderRepository;
import java.util.*;

public class OrderRepositoryImpl implements OrderRepository {
    private final Map<String, Order> orderDB = new HashMap<>();

    @Override
    public Order create(Order order) {
        orderDB.put(order.getOrderId(), order);
        return order;
    }

    @Override
    public Order read(String id) {
        return orderDB.get(id);
    }

    @Override
    public Order update(Order order) {
        orderDB.put(order.getOrderId(), order);
        return order;
    }

    @Override
    public boolean delete(String id) {
        return orderDB.remove(id) != null;
    }

    @Override
    public List<Order> findAll() {
        return new ArrayList<>(orderDB.values());
    }

}
