package com.alenia.bananesexport.service.query;

import com.alenia.bananesexport.entity.Recipient;

import java.util.List;
import java.util.Optional;

public interface RecipientQueryService {
    List<Recipient> findAll();

    Optional<Recipient> findById(long id);
}
