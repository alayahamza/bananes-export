package com.alenia.bananesexport.service.query;

import com.alenia.bananesexport.entity.Recipient;

import java.util.List;

public interface RecipientQueryService {
    List<Recipient> findAll();
}
