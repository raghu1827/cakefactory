package com.techeva.cakefactory.auth;

import org.springframework.stereotype.Component;

import com.techeva.cakefactory.account.AccountService;
import com.techeva.cakefactory.address.AddressService;

import javax.transaction.Transactional;

@Component
class DefaultSignupService implements SignupService {

    private final AccountService accountService;
    private final AddressService addressService;

    public DefaultSignupService(AccountService accountService, AddressService addressService) {
        this.accountService = accountService;
        this.addressService = addressService;
    }

    @Override
    public boolean accountExists(String email) {
        return false;
    }

    @Override
    @Transactional
    public void register(String email, String password, String addressLine1, String addressLine2, String postcode) {
        this.accountService.register(email, password);
        this.addressService.update(email, addressLine1, addressLine2, postcode);
    }
}
