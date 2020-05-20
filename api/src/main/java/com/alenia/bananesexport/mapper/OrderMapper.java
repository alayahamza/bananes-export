package com.alenia.bananesexport.mapper;

import com.alenia.bananesexport.entity.Order;
import com.alenia.bananesexport.to.OrderResponseTO;
import com.alenia.bananesexport.to.OrderTO;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    OrderResponseTO toOrderTO(Order order);

    @IterableMapping(elementTargetType = OrderTO.class)
    List<OrderResponseTO> toOrderTOList(List<Order> orders);
}
