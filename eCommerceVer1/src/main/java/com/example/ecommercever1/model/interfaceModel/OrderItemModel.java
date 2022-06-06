package com.example.ecommercever1.model.interfaceModel;

import com.example.ecommercever1.entity.Order;
import com.example.ecommercever1.entity.OrderItem;

import java.util.List;

public interface OrderItemModel {
    boolean create(OrderItem obj);
    boolean update(int id, OrderItem obj);
    boolean delete(int id);
    OrderItem findById(int id);
    List<OrderItem> findAll();
    List<OrderItem> findByOrderId(int orderId);
}
