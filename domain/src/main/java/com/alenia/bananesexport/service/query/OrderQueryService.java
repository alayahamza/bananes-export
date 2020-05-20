package com.alenia.bananesexport.service.query;

import com.alenia.bananesexport.entity.Order;
import com.alenia.bananesexport.exception.BananaException;

import java.util.List;

public interface OrderQueryService {
    List<Order> findAll();

    Order findById(long id) throws BananaException;

    List<Order> findAllByRecipient(long id);
}
