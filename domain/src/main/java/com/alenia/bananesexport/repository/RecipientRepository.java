package com.alenia.bananesexport.repository;

import com.alenia.bananesexport.entity.Recipient;

import java.util.Optional;

public interface RecipientRepository {
    Recipient save(Recipient recipient);

    Optional<Recipient> findByNameAndAddressAndZipCodeAndCityAndCountry(String name, String address, Integer zipCode, String city, String country);
}
