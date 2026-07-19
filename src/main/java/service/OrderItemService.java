package service;

import domain.OrderItem;
import java.util.List;

public interface OrderItemService extends IService<OrderItem, String> {
    List<OrderItem> findAll();
}
