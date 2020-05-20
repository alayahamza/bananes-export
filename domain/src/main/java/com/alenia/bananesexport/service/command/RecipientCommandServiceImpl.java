package com.alenia.bananesexport.service.command;

import com.alenia.bananesexport.constant.BananaConstant;
import com.alenia.bananesexport.entity.Recipient;
import com.alenia.bananesexport.exception.BananaException;
import com.alenia.bananesexport.repository.RecipientRepository;
import com.alenia.bananesexport.service.query.RecipientQueryService;
import com.alenia.bananesexport.to.RecipientTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RecipientCommandServiceImpl implements RecipientCommandService {

    private final RecipientRepository recipientRepository;
    private final RecipientQueryService recipientQueryService;

    @Autowired
    public RecipientCommandServiceImpl(RecipientRepository recipientRepository, RecipientQueryService recipientQueryService) {
        this.recipientRepository = recipientRepository;
        this.recipientQueryService = recipientQueryService;
    }

    @Override
    public Recipient create(RecipientTO recipientTO) throws BananaException {
        checkRecipientExistence(recipientTO);
        Recipient recipient = Recipient.builder()
                .name(recipientTO.getName())
                .address(recipientTO.getAddress())
                .city(recipientTO.getCity())
                .zipCode(recipientTO.getZipCode())
                .country(recipientTO.getCountry())
                .build();
        return recipientRepository.save(recipient);
    }

    @Override
    public Recipient update(RecipientTO recipientTO, long id) throws BananaException {
        checkRecipientExistence(recipientTO);
        Recipient recipientToUpdate = recipientQueryService.findById(id);
        recipientToUpdate.setName(recipientTO.getName());
        recipientToUpdate.setAddress(recipientTO.getAddress());
        recipientToUpdate.setZipCode(recipientTO.getZipCode());
        recipientToUpdate.setCity(recipientTO.getCity());
        recipientToUpdate.setCountry(recipientTO.getCountry());
        return recipientRepository.save(recipientToUpdate);
    }

    private void checkRecipientExistence(RecipientTO recipientTO) throws BananaException {
        Optional<Recipient> recipient = recipientRepository.findByNameAndAddressAndZipCodeAndCityAndCountry(
                recipientTO.getName(),
                recipientTO.getAddress(),
                recipientTO.getZipCode(),
                recipientTO.getCity(),
                recipientTO.getCountry()
        );
        if (recipient.isPresent()) {
            throw new BananaException(BananaConstant.RECIPIENT_EXISTS);
        }
    }
}
