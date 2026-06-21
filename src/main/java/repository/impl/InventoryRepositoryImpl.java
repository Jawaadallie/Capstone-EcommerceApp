/* InventoryRepositoryImpl.java
   InventoryRepositoryImpl class
   Author: Plamedie 230082629
   Date: 21 June 2026
*/
package repository.impl;

import domain.Inventory;
import repository.InventoryRepository;
import java.util.*;

public class InventoryRepositoryImpl implements InventoryRepository {
    private static InventoryRepositoryImpl repository = null;
    private final Map<String, Inventory> inventoryDB = new HashMap<>();

    public InventoryRepositoryImpl() {
    }

    public static InventoryRepositoryImpl getRepository() {
        if (repository == null) {
            repository = new InventoryRepositoryImpl();
        }
        return repository;
    }

    @Override
    public Inventory create(Inventory inventory) {
        inventoryDB.put(inventory.getInventoryId(), inventory);
        return inventory;
    }

    @Override
    public Inventory read(String inventoryId) {
        return inventoryDB.get(inventoryId);
    }

    @Override
    public Inventory update(Inventory inventory) {
        if (inventoryDB.containsKey(inventory.getInventoryId())) {
            inventoryDB.put(inventory.getInventoryId(), inventory);
            return inventory;
        }
        return null;
    }

    @Override
    public boolean delete(String inventoryId) {
        return inventoryDB.remove(inventoryId) != null;
    }

    @Override
    public List<Inventory> findAll() {
        return new ArrayList<>(inventoryDB.values());
    }
}
