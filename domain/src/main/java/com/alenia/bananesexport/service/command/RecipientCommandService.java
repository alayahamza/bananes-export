package com.alenia.bananesexport.service.command;

import com.alenia.bananesexport.entity.Recipient;
import com.alenia.bananesexport.exception.BananaException;
import com.alenia.bananesexport.to.RecipientTO;

public interface RecipientCommandService {
    Recipient create(RecipientTO recipient) throws BananaException;

    Recipient update(RecipientTO recipientTO, long id) throws BananaException;
}
