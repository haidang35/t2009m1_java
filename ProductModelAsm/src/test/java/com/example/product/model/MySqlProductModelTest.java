package com.example.product.model;

import com.example.product.entity.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MySqlProductModelTest {

    private ProductModel productModel;

    @BeforeEach
    void setUp() {
        productModel = new MySqlProductModel();
        Product product = new Product("Product 1", "Demo description", "Detail", 100000, "src/images/product1.png", "demo@gmail.com", "0357888999" );
        productModel.save(product);
    }

    @Test
    void save() {
        Product product = new Product("Product 1", "Demo description", "Detail", 100000, "src/images/product1.png", "demo@gmail.com", "0357888999" );
        assertEquals(true, productModel.save(product));
    }

    @Test
    void update() {
        List<Product>  products = productModel.findAll();
        assertNotEquals(0, products.size());
        Product product = products.get(0);
        assertNotEquals(null, product);
        product.setName("Product Updated Name");
        productModel.update(product.getId(), product);
        Product productUpdated = productModel.findById(product.getId());
        assertEquals("Product Updated Name", productUpdated.getName());
    }


    @Test
    void delete() {
        List<Product>  products = productModel.findAll();
        assertNotEquals(0, products.size());
        Product product = products.get(0);
        assertEquals(true, productModel.delete(product.getId()));
    }

    @Test
    void findById() {
        List<Product>  products = productModel.findAll();
        assertNotEquals(0, products.size());
        Product product = products.get(0);
        Product productFind = productModel.findById(product.getId());
        assertEquals(product.getId(), productFind.getId());
    }

    @Test
    void findAll() {
        List<Product> products = productModel.findAll();
        assertNotEquals(0, products.size());
    }
}
