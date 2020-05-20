package com.alenia.bananesexport.repository;

import com.alenia.bananesexport.entity.Recipient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class H2DBRecipientRepository implements RecipientRepository {

    private final SpringDataRecipientRepository springDataRecipientRepository;

    @Autowired
    public H2DBRecipientRepository(SpringDataRecipientRepository springDataRecipientRepository) {
        this.springDataRecipientRepository = springDataRecipientRepository;
    }

    @Override
    public Recipient save(Recipient recipient) {
        return springDataRecipientRepository.save(recipient);
    }


    @Override
    public Optional<Recipient> findByNameAndAddressAndZipCodeAndCityAndCountry(String name, String address, Integer zipCode, String city, String country) {
        return springDataRecipientRepository.findByNameAndAddressAndZipCodeAndCityAndCountry(name, address, zipCode, city, country);
    }

    @Override
    public List<Recipient> findAll() {
        return springDataRecipientRepository.findAll();
    }

    @Override
    public Optional<Recipient> findById(long id) {
        return springDataRecipientRepository.findById(id);
    }

    @Override
    public void delete(long id) {
        springDataRecipientRepository.deleteById(id);
    }
}
