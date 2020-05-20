package com.alenia.bananesexport.mapper;

import com.alenia.bananesexport.entity.Recipient;
import com.alenia.bananesexport.to.RecipientResponseTO;
import com.alenia.bananesexport.to.RecipientTO;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RecipientMapper {

    RecipientResponseTO toRecipientTO(Recipient recipient);

    @IterableMapping(elementTargetType = RecipientTO.class)
    List<RecipientResponseTO> toRecipientTOList(List<Recipient> recipients);

}
