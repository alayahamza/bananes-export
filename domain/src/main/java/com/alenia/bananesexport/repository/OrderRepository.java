package com.alenia.bananesexport.repository;

import com.alenia.bananesexport.entity.Order;

import java.util.List;

public interface OrderRepository {
    Order save(Order order);

    List<Order> findAll();
}
