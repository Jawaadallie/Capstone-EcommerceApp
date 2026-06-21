package repository.impl;

import domain.Product;
import repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ProductRepositoryImpl implements ProductRepository {

    private final Map<String, Product> storage = new ConcurrentHashMap<>();

    @Override
    public Product create(Product product) {
        if (storage.containsKey(product.getProductId())) {
            return null;
        }
        storage.put(product.getProductId(), product);
        return product;
    }

    @Override
    public Product read(String productId) {
        return storage.get(productId);
    }

    @Override
    public Product update(Product product) {
        if (!storage.containsKey(product.getProductId())) {
            return null;
        }
        storage.put(product.getProductId(), product);
        return product;
    }

    @Override
    public boolean delete(String productId) {
        return storage.remove(productId) != null;
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(storage.values());
    }

    @Override
    public Product findByProductName(String productName) {
        return storage.values().stream()
                .filter(p -> p.getProductName().equalsIgnoreCase(productName))
                .findFirst()
                .orElse(null);
    }
}
