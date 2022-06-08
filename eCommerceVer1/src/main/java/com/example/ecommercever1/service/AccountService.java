package com.example.ecommercever1.service;

import com.example.ecommercever1.entity.Account;
import com.example.ecommercever1.entity.entityEnum.AccountStatus;
import com.example.ecommercever1.model.MySqlAccountModel;
import com.example.ecommercever1.model.interfaceModel.AccountModel;
import com.example.ecommercever1.util.SHA512Hasher;

public class AccountService {
    private AccountModel accountModel;

    public AccountService() {
        accountModel = new MySqlAccountModel();
    }

    public Account register(Account account) {
        String salt = SHA512Hasher.randomString(15);
        String hashedPassword = SHA512Hasher.encode(account.getPassword(), salt);
        String savedPassword = hashedPassword + "." + salt;
        if(accountModel.create(Account.AccountBuilder.anAccount()
                .withFullName(account.getFullName())
                .withRoleId(account.getRoleId())
                .withUsername(account.getUsername())
                .withEmail(account.getEmail())
                .withPhoneNumber(account.getPhoneNumber())
                .withStatus(AccountStatus.ACTIVE)
                .withPassword(savedPassword)
                .build())) {
            return account;
        }
        return null;
    }

    public Account login(String username, String password) {
        Account account = accountModel.findByUsername(username);
        if(account != null && SHA512Hasher.checkPassword(account.getPassword(), password)) {
            return account;
        }
        return null;
    }
}
