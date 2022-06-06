package com.example.ecommercever1.model;

import com.example.ecommercever1.constant.SqlConstant;
import com.example.ecommercever1.entity.entityEnum.OrderStatus;
import com.example.ecommercever1.util.ConnectionHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class MySqlReportModel {
    public int getCountOrder() {
        int count = 0;
        try {
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SqlConstant.ORDER_COUNT_ID);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                count = resultSet.getInt("count");
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    public int getCountOrderByStatus(OrderStatus status) {
        int count = 0;
        try {
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SqlConstant.ORDER_COUNT_ID_BY_STATUS);
            preparedStatement.setInt(1, status.getValue());
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                count = resultSet.getInt("count");
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    public int getCountOrderByCreatedAt(String from, String to) {
        int count = 0;
        try {
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SqlConstant.ORDER_COUNT_ID_BY_CREATED_AT);
            preparedStatement.setString(1, from);
            preparedStatement.setString(2, to);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                count = resultSet.getInt("count");
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    public int getCountOrderByCreatedAtAndStatus(String from, String to, OrderStatus status) {
        int count = 0;
        try {
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SqlConstant.ORDER_COUNT_ID_BY_CREATED_AT_AND_STATUS);
            preparedStatement.setInt(1, status.getValue());
            preparedStatement.setString(2, from);
            preparedStatement.setString(3, to);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                count = resultSet.getInt("count");
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    public double getSumTotalPriceOrder() {
        double sum = 0;
        try {
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SqlConstant.ORDER_SUM_TOTAL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                sum = resultSet.getInt("total");
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return sum;
    }

    public double getSumTotalPriceOrderByCreatedAt(String from, String to) {
        double sum = 0;
        try {
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SqlConstant.ORDER_SUM_TOTAL_BY_CREATED_AT);
            preparedStatement.setString(1, from);
            preparedStatement.setString(2, to);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                sum = resultSet.getInt("total");
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return sum;
    }

    public double getSumTotalPriceOrderByCreatedAtAndStatus(String from, String to, OrderStatus status) {
        double sum = 0;
        try {
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SqlConstant.ORDER_SUM_TOTAL_BY_CREATED_AT_AND_STATUS);
            preparedStatement.setInt(1, status.getValue());
            preparedStatement.setString(2, from);
            preparedStatement.setString(3, to);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                sum = resultSet.getInt("total");
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return sum;
    }

    public double getSumTotalPriceOrderByStatus(OrderStatus orderStatus) {
        double sum = 0;
        try {
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SqlConstant.ORDER_SUM_TOTAL_BY_STATUS);
            preparedStatement.setInt(1, orderStatus.getValue());
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                sum = resultSet.getInt("total");
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return sum;
    }
}
