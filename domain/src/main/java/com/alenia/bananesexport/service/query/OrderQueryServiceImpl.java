package com.alenia.bananesexport.service.query;

import com.alenia.bananesexport.constant.BananaConstant;
import com.alenia.bananesexport.entity.Order;
import com.alenia.bananesexport.exception.BananaException;
import com.alenia.bananesexport.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderQueryServiceImpl implements OrderQueryService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderQueryServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Order findById(long id) throws BananaException {
        return orderRepository.findById(id).orElseThrow(() -> new BananaException(BananaConstant.ORDER_NOT_FOUND));
    }

    @Override
    public List<Order> findAllByRecipient(long id) {
        return orderRepository.findByRecipientId(id);
    }
}
