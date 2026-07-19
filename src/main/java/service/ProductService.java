package service;

import domain.Product;
import java.util.List;

public interface ProductService extends IService<Product, String> {
    List<Product> findAll();
    Product findByProductName(String productName);
}
