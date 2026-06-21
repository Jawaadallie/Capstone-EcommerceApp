/* OrderItemRepositoryImpl.java
   OrderItemRepositoryImpl class
   Author: Joshua Jonathan Bird - 230444032
   Date: 21 June 2026
*/
package repository.impl;

import domain.OrderItem;
import repository.OrderItemRepository;
import java.util.*;

public class OrderItemRepositoryImpl implements OrderItemRepository {
    private static OrderItemRepositoryImpl repository = null;
    private final Map<String, OrderItem> orderItemDB = new HashMap<>();

    public OrderItemRepositoryImpl() {
    }

    public static OrderItemRepositoryImpl getRepository() {
        if (repository == null) {
            repository = new OrderItemRepositoryImpl();
        }
        return repository;
    }

    @Override
    public OrderItem create(OrderItem orderItem) {
        orderItemDB.put(orderItem.getOrderItemId(), orderItem);
        return orderItem;
    }

    @Override
    public OrderItem read(String orderItemId) {
        return orderItemDB.get(orderItemId);
    }

    @Override
    public OrderItem update(OrderItem orderItem) {
        if (orderItemDB.containsKey(orderItem.getOrderItemId())) {
            orderItemDB.put(orderItem.getOrderItemId(), orderItem);
            return orderItem;
        }
        return null;
    }

    @Override
    public boolean delete(String orderItemId) {
        return orderItemDB.remove(orderItemId) != null;
    }

    @Override
    public List<OrderItem> findAll() {
        return new ArrayList<>(orderItemDB.values());
    }
}
