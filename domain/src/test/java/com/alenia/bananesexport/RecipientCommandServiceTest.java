package com.alenia.bananesexport;

import com.alenia.bananesexport.entity.Recipient;
import com.alenia.bananesexport.exception.BananaException;
import com.alenia.bananesexport.repository.RecipientRepository;
import com.alenia.bananesexport.service.command.RecipientCommandService;
import com.alenia.bananesexport.service.command.RecipientCommandServiceImpl;
import com.alenia.bananesexport.service.query.RecipientQueryServiceImpl;
import com.alenia.bananesexport.to.RecipientTO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@Import({RecipientCommandServiceImpl.class, RecipientQueryServiceImpl.class})
public class RecipientCommandServiceTest {

    @Autowired
    private RecipientCommandService recipientCommandService;

    @MockBean
    private RecipientRepository recipientRepository;

    private Recipient recipient;
    private RecipientTO recipientTO;

    @Before
    public void setUp() {
        recipient = Recipient.builder()
                .name("name")
                .build();
        recipientTO = new RecipientTO();
        recipientTO.setName("name");
    }

    @Test
    public void should_create_recipient_when_create() throws BananaException {
        Mockito.when(recipientRepository.save(Mockito.any())).thenReturn(recipient);
        Recipient recipientCreated = recipientCommandService.create(recipientTO);
        assertNotNull(recipientCreated);
        assertEquals(recipient.getName(), recipientCreated.getName());
    }

    @Test(expected = BananaException.class)
    public void should_throw_exception_when_recipient_already_exists() throws BananaException {
        Mockito.when(recipientRepository.findByNameAndAddressAndZipCodeAndCityAndCountry(Mockito.any(), Mockito.any(), Mockito.any(), Mockito.any(), Mockito.any()))
                .thenReturn(java.util.Optional.ofNullable(recipient));
        recipientCommandService.create(recipientTO);
    }

    @Test
    public void should_update_recipient_name() throws BananaException {
        Mockito.when(recipientRepository.findById(1)).thenReturn(java.util.Optional.ofNullable(recipient));
        Mockito.when(recipientRepository.save(Mockito.any())).thenReturn(recipient);
        recipientTO.setName("new name");
        Recipient updatedRecipient = recipientCommandService.update(recipientTO, 1);
        assertEquals(updatedRecipient.getName(), recipientTO.getName());
    }
}
