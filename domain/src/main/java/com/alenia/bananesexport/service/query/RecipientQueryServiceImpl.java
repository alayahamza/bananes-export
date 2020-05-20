package com.alenia.bananesexport.service.query;

import com.alenia.bananesexport.entity.Recipient;
import com.alenia.bananesexport.repository.RecipientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecipientQueryServiceImpl implements RecipientQueryService {

    private final RecipientRepository recipientRepository;

    @Autowired
    public RecipientQueryServiceImpl(RecipientRepository recipientRepository) {
        this.recipientRepository = recipientRepository;
    }

    @Override
    public List<Recipient> findAll() {
        return recipientRepository.findAll();
    }

    @Override
    public Optional<Recipient> findById(long id) {
        return recipientRepository.findById(1);
    }
}
