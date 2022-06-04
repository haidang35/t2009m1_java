package com.example.ecommercever1.model;

import com.example.ecommercever1.entity.Category;
import com.example.ecommercever1.entity.Order;
import com.example.ecommercever1.entity.entityEnum.CategoryStatus;
import com.example.ecommercever1.entity.entityEnum.OrderStatus;
import com.example.ecommercever1.model.interfaceModel.OrderModel;
import com.sun.org.apache.xpath.internal.operations.Or;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MySqlOrderModelTest {
    private OrderModel orderModel;

    @BeforeEach
    void setUp() {
        orderModel = new MySqlOrderModel();
        orderModel.create( Order.OrderBuilder.anOrder()
                .withFirstName("Jinner")
                .withLastName("Dang")
                .withCountry("Vietnam")
                .withAddress("Hanoi")
                .withEmail("dangjinneryq@gmaiil.com")
                .withPhoneNumber("0357888999")
                .withNote("Note")
                .withTotal(5000)
                .withShippingFee(0)
                .withStatus(OrderStatus.PENDING)
                .build());
    }

    @Test
    void create() {
       assertEquals(true, orderModel.create( Order.OrderBuilder.anOrder()
               .withFirstName("Jinner")
               .withLastName("Dang")
               .withCountry("Vietnam")
               .withAddress("Hanoi")
               .withEmail("dangjinneryq@gmaiil.com")
               .withPhoneNumber("0357888999")
               .withNote("Note")
               .withTotal(5000)
               .withStatus(OrderStatus.PENDING)
               .withShippingFee(0)
               .build()) );
    }

    @Test
    void update() {
        List<Order> orderList = orderModel.findAll();
        assertNotEquals(0, orderList.size());
        Order order = orderList.get(0);
        assertNotEquals(null, order);
        order.setStatus(OrderStatus.SUCCESSFUL);
        orderModel.update(order.getId(), order);
        Order orderUpdated = orderModel.findById(order.getId());
        assertEquals(order.getStatus().getValue(), orderUpdated.getStatus().getValue());
    }

    @Test
    void delete() {
        List<Order> orderList = orderModel.findAll();
        assertNotEquals(0, orderList.size());
        Order order = orderList.get(0);
        assertNotEquals(null, order);
        assertEquals(true, orderModel.delete(order.getId()));
    }

    @Test
    void findById() {
        List<Order> orderList = orderModel.findAll();
        assertNotEquals(0, orderList.size());
        Order order = orderList.get(0);
        assertNotEquals(null, order);
        assertNotEquals(null, orderModel.findById(order.getId()));
    }

    @Test
    void findAll() {
        List<Order> orderList = orderModel.findAll();
        assertNotEquals(0, orderList.size());
    }
}
