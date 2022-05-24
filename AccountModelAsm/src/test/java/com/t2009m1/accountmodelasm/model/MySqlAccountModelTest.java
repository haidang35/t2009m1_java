package com.t2009m1.accountmodelasm.model;

import com.t2009m1.accountmodelasm.entity.Account;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MySqlAccountModelTest {

    @Test
    void save() {
        MySqlAccountModel mySqlAccountModel = new MySqlAccountModel();
        Account account = new Account("Dang Jinner", "dangjinner", "dangjinner@gmail.com", "123456", 1);
        assertEquals(true, mySqlAccountModel.save(account));
    }
}
