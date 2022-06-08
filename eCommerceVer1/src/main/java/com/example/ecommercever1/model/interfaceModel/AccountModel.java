package com.example.ecommercever1.model.interfaceModel;

import com.example.ecommercever1.entity.Account;
import com.example.ecommercever1.entity.Category;

import java.util.List;

public interface AccountModel {
    boolean create(Account obj);
    boolean update(int id, Account obj);
    boolean delete(int id);
    Account findById(int id);
    Account findByUsername(String username);
    List<Account> findAll();
}
