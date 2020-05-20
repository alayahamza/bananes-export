package com.alenia.bananesexport.service.query;

import com.alenia.bananesexport.entity.Order;

import java.util.List;

public interface OrderQueryService {
    List<Order> findAll();
}
