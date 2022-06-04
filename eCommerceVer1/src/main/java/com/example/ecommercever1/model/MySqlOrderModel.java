package com.example.ecommercever1.model;

import com.example.ecommercever1.constant.SqlConstant;
import com.example.ecommercever1.entity.Category;
import com.example.ecommercever1.entity.Order;
import com.example.ecommercever1.entity.Product;
import com.example.ecommercever1.entity.entityEnum.CategoryStatus;
import com.example.ecommercever1.entity.entityEnum.OrderStatus;
import com.example.ecommercever1.model.interfaceModel.OrderModel;
import com.example.ecommercever1.util.ConnectionHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MySqlOrderModel implements OrderModel {
    @Override
    public boolean create(Order order) {
        try{
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SqlConstant.ORDER_INSERT);
            preparedStatement.setString(1, order.getFirstName());
            preparedStatement.setString(2, order.getLastName());
            preparedStatement.setString(3, order.getCompanyName());
            preparedStatement.setString(4, order.getCountry());
            preparedStatement.setString(5, order.getAddress());
            preparedStatement.setString(6, order.getEmail());
            preparedStatement.setString(7, order.getPhoneNumber());
            preparedStatement.setString(8, order.getNote());
            preparedStatement.setDouble(9, order.getTotal());
            preparedStatement.setDouble(10, order.getShippingFee());
            preparedStatement.setString(11, order.getCreatedAt().toString());
            preparedStatement.setString(12, order.getUpdatedAt().toString());
            preparedStatement.setInt(13, order.getCreatedBy());
            preparedStatement.setInt(14, order.getUpdatedBy());
            preparedStatement.setInt(15, order.getStatus().getValue());
            return preparedStatement.executeUpdate() > 0;
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(int id, Order order) {
        try{
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SqlConstant.ORDER_UPDATE);
            preparedStatement.setString(1, order.getFirstName());
            preparedStatement.setString(2, order.getLastName());
            preparedStatement.setString(3, order.getCompanyName());
            preparedStatement.setString(4, order.getCountry());
            preparedStatement.setString(5, order.getAddress());
            preparedStatement.setString(6, order.getEmail());
            preparedStatement.setString(7, order.getPhoneNumber());
            preparedStatement.setString(8, order.getNote());
            preparedStatement.setDouble(9, order.getTotal());
            preparedStatement.setDouble(10, order.getShippingFee());
            preparedStatement.setString(11, order.getCreatedAt().toString());
            preparedStatement.setString(12, order.getUpdatedAt().toString());
            if(order.getDeletedAt() != null) {
                preparedStatement.setString(13, order.getDeletedAt().toString());
            }else {
                preparedStatement.setString(13,null);
            }
            preparedStatement.setInt(14, order.getCreatedBy());
            preparedStatement.setInt(15, order.getUpdatedBy());
            preparedStatement.setInt(16, order.getDeletedBy());
            preparedStatement.setInt(17, order.getStatus().getValue());
            preparedStatement.setInt(18, id);
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
            PreparedStatement preparedStatement = connection.prepareStatement(SqlConstant.ORDER_DELETE);
            preparedStatement.setInt(1, id);
            return preparedStatement.executeUpdate() > 0;
        }catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }

    @Override
    public Order findById(int id) {
        try{
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SqlConstant.ORDER_FIND_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()) {
                return resultSetToCategory(rs);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Order> findAll() {
        List<Order> orders = new ArrayList<>();
        try{
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SqlConstant.ORDER_FIND_ALL);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()) {
                Order product = resultSetToCategory(rs);
                if(product != null) {
                    orders.add(product);
                }
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }

    public Order resultSetToCategory(ResultSet rs)
    {
        try{
            int id = Integer.parseInt(rs.getString(SqlConstant.ORDER_FIELD_ID));
            String firstName = rs.getString(SqlConstant.ORDER_FIELD_FIRST_NAME);
            String lastName = rs.getString(SqlConstant.ORDER_FIELD_LAST_NAME);
            String companyName = rs.getString(SqlConstant.ORDER_FIELD_COMPANY_NAME);
            String country = rs.getString(SqlConstant.ORDER_FIELD_COUNTRY);
            String address = rs.getString(SqlConstant.ORDER_FIELD_ADDRESS);
            String email = rs.getString(SqlConstant.ORDER_FIELD_EMAIL);
            String phoneNumber = rs.getString(SqlConstant.ORDER_FIELD_PHONE_NUMBER);
            String note = rs.getString(SqlConstant.ORDER_FIELD_NOTE);
            double total = rs.getDouble(SqlConstant.ORDER_FIELD_TOTAL);
            double shippingFee = rs.getDouble(SqlConstant.ORDER_FIELD_SHIPPING_FEE);
            LocalDateTime createdAt = rs.getTimestamp(SqlConstant.FIELD_CREATED_AT).toLocalDateTime();
            LocalDateTime updatedAt = rs.getTimestamp(SqlConstant.FIELD_UPDATED_AT).toLocalDateTime();
            LocalDateTime deletedAt = null;
            if(rs.getTimestamp(SqlConstant.FIELD_DELETED_AT) != null) {
                deletedAt = rs.getTimestamp(SqlConstant.FIELD_DELETED_AT).toLocalDateTime();
            }
            int createdBy = rs.getInt(SqlConstant.FIELD_CREATED_BY);
            int updatedBy = rs.getInt(SqlConstant.FIELD_UPDATED_BY);
            int deletedBy = rs.getInt(SqlConstant.FIELD_DELETED_BY);
            OrderStatus status = OrderStatus.of(rs.getInt(SqlConstant.ORDER_FIELD_STATUS));
            return Order.OrderBuilder.anOrder()
                    .withId(id)
                    .withFirstName(firstName)
                    .withLastName(lastName)
                    .withCompanyName(companyName)
                    .withCountry(country)
                    .withAddress(address)
                    .withEmail(email)
                    .withPhoneNumber(phoneNumber)
                    .withNote(note)
                    .withTotal(total)
                    .withShippingFee(shippingFee)
                    .withCreatedAt(createdAt)
                    .withUpdatedAt(updatedAt)
                    .withDeletedAt(deletedAt)
                    .withCreatedBy(createdBy)
                    .withUpdatedBy(updatedBy)
                    .withDeletedBy(deletedBy)
                    .withStatus(status)
                    .build();

        }catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
}
