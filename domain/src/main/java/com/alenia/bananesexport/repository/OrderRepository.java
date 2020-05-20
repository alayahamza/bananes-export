package com.alenia.bananesexport.repository;

import com.alenia.bananesexport.entity.Order;

import java.util.List;
import java.util.Optional;

public interface OrderRepository {
    Order save(Order order);

    List<Order> findAll();

    Optional<Order> findById(long id);

    List<Order> findByRecipientId(long id);

    void delete(long id);
}
