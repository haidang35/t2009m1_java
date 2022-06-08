package com.example.ecommercever1.model;

import com.example.ecommercever1.entity.Account;
import com.example.ecommercever1.entity.Category;
import com.example.ecommercever1.entity.entityEnum.AccountStatus;
import com.example.ecommercever1.entity.entityEnum.CategoryStatus;
import com.example.ecommercever1.model.interfaceModel.AccountModel;
import com.example.ecommercever1.util.SHA512Hasher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sun.security.provider.SHA;

import static org.junit.jupiter.api.Assertions.*;

class MySqlAccountModelTest {
    private AccountModel accountModel;

    @BeforeEach
    void setUp() {
        accountModel = new MySqlAccountModel();
        String salt = SHA512Hasher.randomString(15);
        String hashedPassword = SHA512Hasher.encode("123456", salt);
        String savedPassword = hashedPassword + "." + salt;
        accountModel.create(Account.AccountBuilder.anAccount()
                        .withFullName("Dang Jinner")
                        .withRoleId(1)
                        .withUsername("dangjinner")
                        .withEmail("dangjinner@gmail.com")
                        .withPhoneNumber("0357888999")
                        .withStatus(AccountStatus.ACTIVE)
                        .withPassword(savedPassword)
                .build());
    }

    @Test
    void create() {
        String salt = SHA512Hasher.randomString(15);
        String hashedPassword = SHA512Hasher.encode("123456", salt);
        String savedPassword = hashedPassword + "." + salt;
        assertEquals(true,accountModel.create(Account.AccountBuilder.anAccount()
                .withFullName("Dang Jinner")
                .withRoleId(1)
                .withUsername("dangjinner")
                .withEmail("dangjinner@gmail.com")
                .withPhoneNumber("0357888999")
                .withStatus(AccountStatus.ACTIVE)
                .withPassword(savedPassword)
                .build()) );
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    @Test
    void findById() {
    }

    @Test
    void findByUsername() {
    }

    @Test
    void findAll() {
    }
}
