package com.alenia.bananesexport.service.query;

import com.alenia.bananesexport.constant.BananaConstant;
import com.alenia.bananesexport.entity.Recipient;
import com.alenia.bananesexport.exception.BananaException;
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

    @Override
    public Recipient findById(long id) throws BananaException {
        return recipientRepository.findById(id).orElseThrow(() -> new BananaException(BananaConstant.RECIPIENT_NOT_FOUND));
    }
}
