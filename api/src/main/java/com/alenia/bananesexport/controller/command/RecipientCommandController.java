package com.alenia.bananesexport.controller.command;

import com.alenia.bananesexport.exception.BananaException;
import com.alenia.bananesexport.mapper.RecipientMapper;
import com.alenia.bananesexport.service.command.RecipientCommandService;
import com.alenia.bananesexport.to.RecipientResponseTO;
import com.alenia.bananesexport.to.RecipientTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/recipients")
public class RecipientCommandController {

    private final RecipientCommandService recipientCommandService;
    private final RecipientMapper recipientMapper;

    @Autowired
    public RecipientCommandController(RecipientCommandService recipientCommandService, RecipientMapper recipientMapper) {
        this.recipientCommandService = recipientCommandService;
        this.recipientMapper = recipientMapper;
    }

    @PutMapping
    public ResponseEntity<RecipientResponseTO> put(@Validated @RequestBody RecipientTO recipient) throws BananaException {
        return ResponseEntity.ok().body(recipientMapper.toRecipientTO(recipientCommandService.create(recipient)));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<RecipientResponseTO> patch(@Validated @RequestBody RecipientTO recipient, @PathVariable("id") long id) throws BananaException {
        return ResponseEntity.ok().body(recipientMapper.toRecipientTO(recipientCommandService.update(recipient, id)));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") long id) throws BananaException {
        recipientCommandService.delete(id);
    }
}
