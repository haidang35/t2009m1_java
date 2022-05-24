package com.t2009m1.accountmodelasm.model;

import com.t2009m1.accountmodelasm.entity.Account;
import com.t2009m1.accountmodelasm.util.ConnectionHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class MySqlAccountModel implements AccountModel{
    private static final String INSERT_ACCOUNT = "INSERT INTO accounts (fullName, username, email, password, status ) VALUES (?, ?, ?, ?, ?);";
    private static final String UPDATE_ACCOUNT = "UPDATE accounts SET fullName = ?, username = ?, email = ?, password = ?, status = ? WHERE id = ?;";
    private static final String DELETE_ACCOUNT = "DELETE FROM accounts WHERE id = ?";
    private static final String FIND_BY_ID = "SELECT * FROM accounts WHERE id = ?";
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
    public boolean update() {
        return false;
    }

    @Override
    public boolean delete() {
        return false;
    }

    @Override
    public Account findById(int id) {
        return null;
    }

    @Override
    public List<Account> findAll() {
        return null;
    }
}
