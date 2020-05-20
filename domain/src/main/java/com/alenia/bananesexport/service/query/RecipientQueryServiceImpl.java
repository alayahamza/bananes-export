package com.alenia.bananesexport.service.query;

import com.alenia.bananesexport.entity.Recipient;
import com.alenia.bananesexport.repository.RecipientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
