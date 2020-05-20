package com.alenia.bananesexport.configuration;

import com.alenia.bananesexport.repository.RecipientRepository;
import com.alenia.bananesexport.service.command.RecipientCommandService;
import com.alenia.bananesexport.service.command.RecipientCommandServiceImpl;
import com.alenia.bananesexport.service.query.RecipientQueryService;
import com.alenia.bananesexport.service.query.RecipientQueryServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    RecipientQueryService recipientQueryService(RecipientRepository recipientRepository) {
        return new RecipientQueryServiceImpl(recipientRepository);
    }

    @Bean
    RecipientCommandService recipientCommandService(RecipientRepository recipientRepository, RecipientQueryService recipientQueryService) {
        return new RecipientCommandServiceImpl(recipientRepository, recipientQueryService);
    }
}
