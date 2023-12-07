package com.example.fashionshop.service.impl;

import com.example.fashionshop.model.Account;
import com.example.fashionshop.repository.IAccountRepository;
import com.example.fashionshop.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountServiceImpl implements IAccountService {
    @Autowired
    private IAccountRepository accountRepository;
    @Override
    public Optional<Account> findByUsername(String username) {
        return accountRepository.findByUsername(username);
    }

    @Override
    public Boolean existsByUsername(String username) {
        return accountRepository.existsByUsername(username);
    }

    @Override
    public Account save(Account account) {
        return accountRepository.save(account);
    }
}
