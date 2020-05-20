package com.alenia.bananesexport.repository;

import com.alenia.bananesexport.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class H2DBOrderRepository implements OrderRepository {

    private final SpringDataOrderRepository springDataOrderRepository;

    @Autowired
    public H2DBOrderRepository(SpringDataOrderRepository springDataOrderRepository) {
        this.springDataOrderRepository = springDataOrderRepository;
    }

    @Override
    public Order save(Order order) {
        return springDataOrderRepository.save(order);
    }

    @Override
    public List<Order> findAll() {
        return springDataOrderRepository.findAll();
    }
}
