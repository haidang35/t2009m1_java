package com.t2009m1.accountmodelasm.model;

import com.t2009m1.accountmodelasm.entity.Account;
import com.t2009m1.accountmodelasm.util.ConnectionHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySqlAccountModel implements AccountModel{
    private static final String INSERT_ACCOUNT = "INSERT INTO accounts (fullName, username, email, password, status ) VALUES (?, ?, ?, ?, ?);";
    private static final String UPDATE_ACCOUNT = "UPDATE accounts SET fullName = ?, username = ?, email = ?, password = ?, status = ? WHERE id = ?;";
    private static final String DELETE_ACCOUNT = "DELETE FROM accounts WHERE id = ?;";
    private static final String FIND_BY_ID = "SELECT * FROM accounts WHERE id = ?;";
    private static final String FIND_BY_ALL = "SELECT * FROM accounts;";

    @Override
    public boolean save(Account account) {
        try{
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ACCOUNT);
            preparedStatement.setString(1, account.getFullName());
            preparedStatement.setString(2, account.getUsername());
            preparedStatement.setString(3, account.getEmail());
            preparedStatement.setString(4, account.getPassword());
            preparedStatement.setInt(5, account.getStatus());
            preparedStatement.executeUpdate();
            return true;
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(int id, Account account) {
        try{
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ACCOUNT);
            preparedStatement.setString(1, account.getFullName());
            preparedStatement.setString(2, account.getUsername());
            preparedStatement.setString(3, account.getEmail());
            preparedStatement.setString(4, account.getPassword());
            preparedStatement.setInt(5, account.getStatus());
            preparedStatement.setInt(6, id);
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
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_ACCOUNT);
            preparedStatement.setInt(1, id);
            return preparedStatement.executeUpdate() > 0;
        }catch (SQLException  e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Account findById(int id) {
        try{
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String fullName = rs.getString("fullName");
                String username = rs.getString("username");
                String email = rs.getString("email");
                String password = rs.getString("password");
                int status = Integer.parseInt(rs.getString("status")) ;
                Account account = new Account(id, fullName, username, email, password, status);
                return account;
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Account> findAll() {
        List<Account> list = new ArrayList<>();
        try{
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ALL);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()) {
                int id = rs.getInt("id");
                String fullName = rs.getString("fullName");
                String username = rs.getString("username");
                String email = rs.getString("email");
                String password = rs.getString("password");
                int status = Integer.parseInt(rs.getString("status")) ;
                Account account = new Account(id, fullName, username, email, password, status);
                list.add(account);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
