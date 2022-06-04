package com.example.ecommercever1.model.interfaceModel;

import com.example.ecommercever1.entity.Category;
import com.example.ecommercever1.entity.Order;

import java.util.List;

public interface OrderModel {
    boolean create(Order obj);
    boolean update(int id, Order obj);
    boolean delete(int id);
    Order findById(int id);
    List<Order> findAll();
}
