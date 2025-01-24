package com.techeva.cakefactory.address;

public interface AddressService {
    Address findOrEmpty(String email);
    void update(String email, String addressLine1, String addressLine2, String postcode);
}
