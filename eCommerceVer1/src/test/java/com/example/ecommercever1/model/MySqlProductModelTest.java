package com.example.ecommercever1.model;

import com.example.ecommercever1.entity.Category;
import com.example.ecommercever1.entity.Product;
import com.example.ecommercever1.entity.entityEnum.ProductStatus;
import com.example.ecommercever1.model.interfaceModel.CategoryModel;
import com.example.ecommercever1.model.interfaceModel.ProductModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MySqlProductModelTest {
    private ProductModel productModel;
    private CategoryModel categoryModel;
    @BeforeEach
    void setUp() {
        productModel = new MySqlProductModel();
        categoryModel = new MySqlCategoryModel();
    }

    @Test
    void create() {
        List<Category> categoryList = categoryModel.findAll();
        assertNotEquals(0, categoryList.size());
        Category category = categoryList.get(0);
        assertNotEquals(null, category);
        assertEquals(true, productModel.create(Product.ProductBuilder.aProduct()
                        .withName("Product Test")
                        .withPrice(100000)
                        .withDetail("Detail")
                        .withDescription("Description")
                        .withThumbnail("/src/image.png")
                        .withCategoryId(category.getId())
                        .withStatus(ProductStatus.ACTIVE)
                .build()));
    }

    @Test
    void update() {
        List<Product> products = productModel.findAll();
        assertNotEquals(0, products.size());
        Product product = products.get(0);
        assertNotEquals(null, product);
        product.setName("Product Updated");
        assertEquals(true, productModel.update(product.getId(), product));
        Product productUpdated = productModel.findById(product.getId());
        assertEquals(product.getName(), productUpdated.getName());
    }

    @Test
    void delete() {
        List<Product> products = productModel.findAll();
        assertNotEquals(0, products.size());
        Product product = products.get(0);
        assertNotEquals(null, product);
        assertEquals(true, productModel.delete(product.getId()));
    }

    @Test
    void findById() {
        List<Product> products = productModel.findAll();
        assertNotEquals(0, products.size());
        Product product = products.get(0);
        assertNotEquals(null, product);
        assertNotEquals(null, productModel.findById(product.getId()));
    }

    @Test
    void findAll() {
        List<Product> products = productModel.findAll();
        assertNotEquals(0, products.size());
    }
}
