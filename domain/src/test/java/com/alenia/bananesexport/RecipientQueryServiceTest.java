package com.alenia.bananesexport;

import com.alenia.bananesexport.entity.Recipient;
import com.alenia.bananesexport.exception.BananaException;
import com.alenia.bananesexport.repository.RecipientRepository;
import com.alenia.bananesexport.service.query.RecipientQueryService;
import com.alenia.bananesexport.service.query.RecipientQueryServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@Import(RecipientQueryServiceImpl.class)
public class RecipientQueryServiceTest {

    @Autowired
    private RecipientQueryService recipientQueryService;

    @MockBean
    private RecipientRepository recipientRepository;

    private Recipient recipient1;
    private Recipient recipient2;
    private List<Recipient> recipients;

    @Before
    public void setUp() {
        recipient1 = Recipient.builder()
                .id(1)
                .name("name")
                .build();
        recipient2 = Recipient.builder()
                .id(2)
                .name("name")
                .build();
        recipients = new ArrayList<>();
        recipients.add(recipient1);
        recipients.add(recipient2);
    }


    @Test
    public void should_return_all_recipients() {
        Mockito.when(recipientRepository.findAll()).thenReturn(recipients);
        List<Recipient> allRecipients = recipientQueryService.findAll();
        assertEquals(2, allRecipients.size());
    }

    @Test
    public void should_return_recipient_with_id() throws BananaException {
        Mockito.when(recipientRepository.findById(1)).thenReturn(Optional.ofNullable(recipient1));
        Recipient recipientFound = recipientQueryService.findById(1);
        assertEquals(1, recipientFound.getId());
    }

}
