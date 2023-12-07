package com.example.fashionshop.service;

import com.example.fashionshop.model.Account;

import java.util.Optional;

public interface IAccountService {
    Optional<Account> findByUsername(String username);
    Boolean existsByUsername(String username);
    Account save(Account account);
}
