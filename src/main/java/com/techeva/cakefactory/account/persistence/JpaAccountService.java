package com.techeva.cakefactory.account.persistence;

import com.techeva.cakefactory.account.Account;
import com.techeva.cakefactory.account.AccountService;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
class JpaAccountService implements AccountService {

    private final AccountRepository accountRepository;
    private final PasswordEncoder passwordEncoder;

    JpaAccountService(AccountRepository accountRepository, PasswordEncoder passwordEncoder) {
        this.accountRepository = accountRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void register(String email, String password) {
        AccountEntity accountEntity = new AccountEntity();
        accountEntity.setEmail(email);
        accountEntity.setPassword(passwordEncoder.encode(password));

        this.accountRepository.save(accountEntity);
    }

    @Override
    public Account find(String email) {
        AccountEntity accountEntity = this.accountRepository.findByEmail(email);
        return new Account(accountEntity.getEmail(), accountEntity.getPassword());
    }

    @Override
    public boolean exists(String email) {
        return this.accountRepository.findByEmail(email) != null;
    }
}
