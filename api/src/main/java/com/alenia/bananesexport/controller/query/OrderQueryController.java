package com.alenia.bananesexport.controller.query;

import com.alenia.bananesexport.mapper.OrderMapper;
import com.alenia.bananesexport.service.query.OrderQueryService;
import com.alenia.bananesexport.to.OrderResponseTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/orders")
public class OrderQueryController {

    private final OrderQueryService orderQueryService;
    private final OrderMapper orderMapper;

    @Autowired
    public OrderQueryController(OrderQueryService orderQueryService, OrderMapper orderMapper) {
        this.orderQueryService = orderQueryService;
        this.orderMapper = orderMapper;
    }

    @GetMapping
    public ResponseEntity<List<OrderResponseTO>> findAll() {
        return ResponseEntity.ok()
                .body(orderMapper.toOrderTOList(orderQueryService.findAll()));
    }
}
