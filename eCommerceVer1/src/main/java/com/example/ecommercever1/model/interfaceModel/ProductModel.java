package com.example.ecommercever1.model.interfaceModel;

import com.example.ecommercever1.entity.Category;
import com.example.ecommercever1.entity.Product;

import java.util.List;

public interface ProductModel {
    boolean create(Product obj);
    boolean update(int id, Product obj);
    boolean delete(int id);
    Product findById(int id);
    Product findBySlug(String slug);
    List<Product> findByCategory(int categoryId);
    List<Product> findAll();
}
