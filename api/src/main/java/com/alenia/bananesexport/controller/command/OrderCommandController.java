package com.alenia.bananesexport.controller.command;

import com.alenia.bananesexport.exception.BananaException;
import com.alenia.bananesexport.mapper.OrderMapper;
import com.alenia.bananesexport.service.command.OrderCommandService;
import com.alenia.bananesexport.to.OrderResponseTO;
import com.alenia.bananesexport.to.OrderTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/orders")
public class OrderCommandController {

    private final OrderCommandService orderCommandService;
    private final OrderMapper orderMapper;

    @Autowired
    public OrderCommandController(OrderCommandService orderCommandService, OrderMapper orderMapper) {
        this.orderCommandService = orderCommandService;
        this.orderMapper = orderMapper;
    }

    @PutMapping
    public ResponseEntity<OrderResponseTO> put(@Validated @RequestBody OrderTO orderTO) throws BananaException {
        return ResponseEntity.ok().body(orderMapper.toOrderTO(orderCommandService.create(orderTO)));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<OrderResponseTO> patch(@Validated @RequestBody OrderTO orderTO, @PathVariable("id") long id) throws BananaException {
        return ResponseEntity.ok().body(orderMapper.toOrderTO(orderCommandService.update(orderTO, id)));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") long id) throws BananaException {
        orderCommandService.delete(id);
    }
}
