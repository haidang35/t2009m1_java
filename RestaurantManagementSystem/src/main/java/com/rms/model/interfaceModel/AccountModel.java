package com.rms.model.interfaceModel;

import com.rms.entity.Account;

import java.util.List;

public interface AccountModel {
    boolean create(Account obj);
    boolean update(int id, Account obj);
    boolean delete(int id);
    Account findById(int id);
    Account findByUsername(String username);
    List<Account> findAll();
}
