package com.example.ecommercever1.model;

import com.example.ecommercever1.entity.Order;
import com.example.ecommercever1.entity.OrderItem;
import com.example.ecommercever1.entity.Product;
import com.example.ecommercever1.model.interfaceModel.OrderItemModel;
import com.example.ecommercever1.model.interfaceModel.OrderModel;
import com.example.ecommercever1.model.interfaceModel.ProductModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MySqlOrderItemModelTest {
    private OrderItemModel orderItemModel;
    private OrderModel orderModel;
    private ProductModel productModel;

    @BeforeEach
    void setUp() {
        orderItemModel = new MySqlOrderItemModel();
        orderModel = new MySqlOrderModel();
        productModel = new MySqlProductModel();
    }

    @Test
    void create() {
        List<Product> productList = productModel.findAll();
        assertNotEquals(0, productList.size());
        List<Order> orderList = orderModel.findAll();
        assertNotEquals(0, orderList.size());
        assertEquals(true, orderItemModel.create(OrderItem.OrderItemBuilder.anOrderItem()
                .withOrderId(orderList.get(0).getId())
                .withProductId(productList.get(0).getId())
                .withProductName(productList.get(0).getName())
                .withQuantity(2)
                .withThumbnail(productList.get(0).getThumbnail())
                .withPrice(productList.get(0).getPrice())
                .build()));
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    @Test
    void findById() {
    }

    @Test
    void findAll() {
    }
}
