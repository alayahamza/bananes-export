package com.alenia.bananesexport.repository;

import com.alenia.bananesexport.entity.Recipient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SpringDataRecipientRepository extends JpaRepository<Recipient, Long> {
    Optional<Recipient> findByNameAndAddressAndZipCodeAndCityAndCountry(String name, String address, Integer zipCode, String city, String country);

}
