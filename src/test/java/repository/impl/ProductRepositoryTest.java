/*
 * ProductRepositoryTest.java
 * TDD Test for Product Repository
 * Author: Plamedie 230082629
 * Date: 24 March 2026
 */
package repository.impl;

import domain.Product;
import factory.ProductFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.ProductRepository;
import repository.impl.ProductRepositoryImpl;

import static org.junit.jupiter.api.Assertions.*;

public class ProductRepositoryTest {

    private ProductRepository repository;

    @BeforeEach
    public void setUp() {
        repository = new ProductRepositoryImpl();
    }

    @Test
    public void testCreateProductSuccess() {
        Product product = ProductFactory.buildProduct(
                "P001", "Laptop", "Gaming Laptop", 999.99
        );

        Product created = repository.create(product);

        assertNotNull(created);
        assertEquals("P001", created.getProductId());
        assertEquals(repository.read("P001"), created);
    }

    @Test
    public void testCreateDuplicateProduct() {
        Product product1 = ProductFactory.buildProduct(
                "P001", "Laptop", "Gaming Laptop", 999.99
        );
        Product product2 = ProductFactory.buildProduct(
                "P001", "Laptop", "Gaming Laptop", 999.99
        );

        repository.create(product1);
        Product created2 = repository.create(product2);

        assertNull(created2); // Should return null for duplicate
    }

    @Test
    public void testReadProduct() {
        Product product = ProductFactory.buildProduct(
                "P001", "Laptop", "Gaming Laptop", 999.99
        );
        repository.create(product);

        Product found = repository.read("P001");

        assertNotNull(found);
        assertEquals("P001", found.getProductId());
    }

    @Test
    public void testUpdateProduct() {
        Product product = ProductFactory.buildProduct(
                "P001", "Laptop", "Gaming Laptop", 999.99
        );
        repository.create(product);

        Product updatedProduct = ProductFactory.buildProduct(
                "P001", "Laptop", "Updated Gaming Laptop", 1099.99
        );
        Product result = repository.update(updatedProduct);

        assertNotNull(result);
        assertEquals("Updated Gaming Laptop", result.getDescription());
        assertEquals(1099.99, result.getCurrentPrice());
    }

    @Test
    public void testDeleteProduct() {
        Product product = ProductFactory.buildProduct(
                "P001", "Laptop", "Gaming Laptop", 999.99
        );
        repository.create(product);

        boolean deleted = repository.delete("P001");

        assertTrue(deleted);
        assertNull(repository.read("P001"));
    }

    @Test
    public void testFindByProductName() {
        Product product1 = ProductFactory.buildProduct(
                "P001", "Laptop", "Gaming Laptop", 999.99
        );
        Product product2 = ProductFactory.buildProduct(
                "P002", "Mouse", "Gaming Mouse", 49.99
        );

        repository.create(product1);
        repository.create(product2);

        Product found = repository.findByProductName("Laptop");

        assertNotNull(found);
        assertEquals("Laptop", found.getProductName());
    }
}
