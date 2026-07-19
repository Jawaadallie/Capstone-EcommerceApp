package service;

import domain.Inventory;
import java.util.List;

public interface InventoryService extends IService<Inventory, String> {
    List<Inventory> findAll();
}
