/*
 * ProductRepository.java
 * Product Repository Interface
 * Author: Plamedie 230082629
 * Date: 24 March 2026
 */
package repository;

import domain.Product;

public interface ProductRepository extends IRepository<Product, String> {
    // Additional product-specific methods if needed
    Product findByProductName(String productName);
}
