package com.t2009m1.accountmodelasm.model;

import com.t2009m1.accountmodelasm.entity.Account;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MySqlAccountModelTest {
    MySqlAccountModel mySqlAccountModel = new MySqlAccountModel();

    @Test
    void save() {
        Account account = new Account("Dang Jinner", "dangjinner", "dangjinner@gmail.com", "123456", 1);
        assertEquals(true, mySqlAccountModel.save(account));
    }

    @Test
    void update() {
        List<Account> list = mySqlAccountModel.findAll();
        assertNotEquals(0, list.size());
        Account account = list.get(0);
        assertNotEquals(null, account);
        account.setFullName("New full name for this account");
        assertEquals(true, mySqlAccountModel.update(account.getId(), account));
    }

    @Test
    void delete() {
        List<Account> list = mySqlAccountModel.findAll();
        assertNotEquals(0, list.size());
        Account account = list.get(0);
        assertNotEquals(null, account);
        assertEquals(true, mySqlAccountModel.delete(account.getId()));
    }

    @Test
    void findById() {
        List<Account> list = mySqlAccountModel.findAll();
        assertNotEquals(0, list.size());
        Account account = list.get(0);
        assertNotEquals(null, account);
        Account findAccount = mySqlAccountModel.findById(account.getId());
        assertNotEquals(null, findAccount);
        assertEquals(account.getId(), findAccount.getId());
    }

    @Test
    void findAll() {
        List<Account> list = mySqlAccountModel.findAll();
        assertNotEquals(0, list.size());
    }
}
