package com.alenia.bananesexport.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class H2DBOrderRepository implements OrderRepository {

    private final SpringDataOrderRepository springDataOrderRepository;

    @Autowired
    public H2DBOrderRepository(SpringDataOrderRepository springDataOrderRepository) {
        this.springDataOrderRepository = springDataOrderRepository;
    }
}
