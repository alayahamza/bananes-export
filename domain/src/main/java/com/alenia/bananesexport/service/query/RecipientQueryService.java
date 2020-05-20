package com.alenia.bananesexport.service.query;

import com.alenia.bananesexport.entity.Recipient;
import com.alenia.bananesexport.exception.BananaException;

import java.util.List;

public interface RecipientQueryService {
    List<Recipient> findAll();

    Recipient findById(long id) throws BananaException;
}
