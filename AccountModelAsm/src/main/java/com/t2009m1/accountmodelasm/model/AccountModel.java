package com.t2009m1.accountmodelasm.model;

import com.t2009m1.accountmodelasm.entity.Account;

import java.util.List;

public interface AccountModel {
    boolean save(Account account);
    boolean update();
    boolean delete();
    Account findById(int id);
    List<Account> findAll();
}
