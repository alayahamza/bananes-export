package com.alenia.bananesexport.mapper;

import com.alenia.bananesexport.entity.Order;
import com.alenia.bananesexport.to.OrderResponseTO;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    @Mapping(source = "recipient.id", target = "recipient")
    OrderResponseTO toOrderTO(Order order);

    @IterableMapping(elementTargetType = OrderResponseTO.class)
    List<OrderResponseTO> toOrderTOList(List<Order> orders);

}
