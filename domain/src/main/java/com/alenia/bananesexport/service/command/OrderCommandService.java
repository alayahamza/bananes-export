package com.alenia.bananesexport.service.command;

import com.alenia.bananesexport.entity.Order;
import com.alenia.bananesexport.exception.BananaException;
import com.alenia.bananesexport.to.OrderTO;

import java.time.LocalDate;

public interface OrderCommandService {
    Order create(OrderTO orderTO) throws BananaException;

    void checkQuantity(Double quantity) throws BananaException;

    void checkDeliveryDate(LocalDate deliveryDate) throws BananaException;

    Double calculateOrderPrice(Double quantity);

    Order update(OrderTO orderTO, long id) throws BananaException;

    void delete(long id);
}
