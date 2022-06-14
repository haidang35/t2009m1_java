package com.wcd.model;

import com.wcd.constant.SqlConstant;
import com.wcd.entity.Phone;
import com.wcd.util.ConnectionHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MySqlPhoneModel implements PhoneModel{


    @Override
    public boolean create(Phone phone) {
        try{
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SqlConstant.PHONE_INSERT);
            preparedStatement.setString(1, phone.getName());
            preparedStatement.setString(2, phone.getBrand());
            preparedStatement.setDouble(3, phone.getPrice());
            preparedStatement.setString(4, phone.getDescription());
            preparedStatement.setString(5, phone.getCreatedAt().toString());
            preparedStatement.setString(6, phone.getUpdatedAt().toString());
            preparedStatement.setInt(7, phone.getCreatedBy());
            preparedStatement.setInt(8, phone.getUpdatedBy());
            return preparedStatement.executeUpdate() > 0;
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(int id, Phone obj) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public Phone findById(int id) {
        return null;
    }

    @Override
    public List<Phone> findAll() {
        List<Phone> categories = new ArrayList<>();
        try{
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SqlConstant.PHONE_FIND_ALL);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()) {
                Phone phone = resultSetToPhone(rs);
                if(phone != null) {
                    categories.add(phone);
                }
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return categories;
    }

    public Phone resultSetToPhone(ResultSet rs)
    {
        try{
            int id = Integer.parseInt(rs.getString(SqlConstant.PHONE_FIELD_ID));
            String name = rs.getString(SqlConstant.PHONE_FIELD_NAME);
            String brand = rs.getString(SqlConstant.PHONE_FIELD_BRAND);
            String description = rs.getString(SqlConstant.PHONE_FIELD_DESCRIPTION);
            double price = rs.getDouble(SqlConstant.PHONE_FIELD_PRICE);
            LocalDateTime createdAt = rs.getTimestamp(SqlConstant.FIELD_CREATED_AT).toLocalDateTime();
            LocalDateTime updatedAt = rs.getTimestamp(SqlConstant.FIELD_UPDATED_AT).toLocalDateTime();
            LocalDateTime deletedAt = null;
            if(rs.getTimestamp(SqlConstant.FIELD_DELETED_AT) != null) {
                deletedAt = rs.getTimestamp(SqlConstant.FIELD_DELETED_AT).toLocalDateTime();
            }
            int createdBy = rs.getInt(SqlConstant.FIELD_CREATED_BY);
            int updatedBy = rs.getInt(SqlConstant.FIELD_UPDATED_BY);
            int deletedBy = rs.getInt(SqlConstant.FIELD_DELETED_BY);
            return Phone.PhoneBuilder.aPhone()
                    .withId(id)
                    .withName(name)
                    .withPrice(price)
                    .withBrand(brand)
                    .withDescription(description)
                    .withCreatedAt(createdAt)
                    .withUpdatedAt(updatedAt)
                    .withDeletedAt(deletedAt)
                    .withCreatedBy(createdBy)
                    .withUpdatedBy(updatedBy)
                    .withDeletedBy(deletedBy)
                    .build();
        }catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
}
