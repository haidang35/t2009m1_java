package com.example.ecommercever1.model;

import com.example.ecommercever1.constant.SqlConstant;
import com.example.ecommercever1.entity.Order;
import com.example.ecommercever1.entity.OrderItem;
import com.example.ecommercever1.entity.entityEnum.OrderStatus;
import com.example.ecommercever1.model.interfaceModel.OrderItemModel;
import com.example.ecommercever1.util.ConnectionHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MySqlOrderItemModel implements OrderItemModel {
    @Override
    public boolean create(OrderItem orderItem) {
        try{
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SqlConstant.ORDER_ITEM_INSERT);
            preparedStatement.setInt(1, orderItem.getOrderId());
            preparedStatement.setString(2, orderItem.getProductName());
            preparedStatement.setDouble(3, orderItem.getPrice());
            preparedStatement.setString(4, orderItem.getThumbnail());
            preparedStatement.setInt(5, orderItem.getQuantity());
            preparedStatement.setInt(6, orderItem.getProductId());
            return preparedStatement.executeUpdate() > 0;
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(int id, OrderItem orderItem) {
        try{
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SqlConstant.ORDER_ITEM_UPDATE);
            preparedStatement.setInt(1, orderItem.getOrderId());
            preparedStatement.setString(2, orderItem.getProductName());
            preparedStatement.setDouble(3, orderItem.getPrice());
            preparedStatement.setString(4, orderItem.getThumbnail());
            preparedStatement.setInt(5, orderItem.getQuantity());
            preparedStatement.setInt(6, orderItem.getProductId());
            preparedStatement.setInt(7, id);
            return preparedStatement.executeUpdate() > 0;
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        try{
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SqlConstant.ORDER_ITEM_DELETE);
            preparedStatement.setInt(1, id);
            return preparedStatement.executeUpdate() > 0;
        }catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }

    @Override
    public OrderItem findById(int id) {
        try{
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SqlConstant.ORDER_ITEM_FIND_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()) {
                return resultSetToOrderItem(rs);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<OrderItem> findAll() {
        List<OrderItem> orderItems = new ArrayList<>();
        try{
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SqlConstant.ORDER_ITEM_FIND_ALL);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()) {
                OrderItem orderItem = resultSetToOrderItem(rs);
                if(orderItem != null) {
                    orderItems.add(orderItem);
                }
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return orderItems;
    }

    @Override
    public List<OrderItem> findByOrderId(int orderId) {
        List<OrderItem> orderItems = new ArrayList<>();
        try{
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SqlConstant.ORDER_ITEM_FIND_BY_ORDER_ID);
            preparedStatement.setInt(1, orderId);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()) {
                OrderItem orderItem = resultSetToOrderItem(rs);
                if(orderItem != null) {
                    orderItems.add(orderItem);
                }
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return orderItems;
    }

    public OrderItem resultSetToOrderItem(ResultSet rs)
    {
        try{
            int id = Integer.parseInt(rs.getString(SqlConstant.ORDER_ITEM_FIELD_ID));
            int orderId = Integer.parseInt(rs.getString(SqlConstant.ORDER_ITEM_FIELD_ORDER_ID));
            int productId = Integer.parseInt(rs.getString(SqlConstant.ORDER_ITEM_FIELD_PRODUCT_ID));
            String productName = rs.getString(SqlConstant.ORDER_ITEM_FIELD_PRODUCT_NAME);
            String thumbnail = rs.getString(SqlConstant.ORDER_ITEM_FIELD_THUMBNAIL);
            int quantity = rs.getInt(SqlConstant.ORDER_ITEM_FIELD_QUANTITY);
            double price = rs.getDouble(SqlConstant.ORDER_ITEM_FIELD_PRICE);
            return OrderItem.OrderItemBuilder.anOrderItem()
                    .withId(id)
                    .withOrderId(orderId)
                    .withProductId(productId)
                    .withProductName(productName)
                    .withThumbnail(thumbnail)
                    .withQuantity(quantity)
                    .withPrice(price)
                    .build();

        }catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
}
