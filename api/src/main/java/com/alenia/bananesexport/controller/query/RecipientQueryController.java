package com.alenia.bananesexport.controller.query;

import com.alenia.bananesexport.mapper.RecipientMapper;
import com.alenia.bananesexport.service.query.RecipientQueryService;
import com.alenia.bananesexport.to.RecipientResponseTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/recipients")
public class RecipientQueryController {

    private final RecipientQueryService recipientQueryService;
    private final RecipientMapper recipientMapper;

    @Autowired
    public RecipientQueryController(RecipientQueryService recipientQueryService, RecipientMapper recipientMapper) {
        this.recipientQueryService = recipientQueryService;
        this.recipientMapper = recipientMapper;
    }

    @GetMapping
    public ResponseEntity<List<RecipientResponseTO>> findAll() {
        return ResponseEntity.ok()
                .body(recipientMapper.toRecipientTOList(recipientQueryService.findAll()));
    }
}
