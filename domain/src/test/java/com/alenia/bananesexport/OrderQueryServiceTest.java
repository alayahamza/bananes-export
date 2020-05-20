package com.alenia.bananesexport;

import com.alenia.bananesexport.entity.Order;
import com.alenia.bananesexport.repository.OrderRepository;
import com.alenia.bananesexport.service.query.OrderQueryService;
import com.alenia.bananesexport.service.query.OrderQueryServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@Import({OrderQueryServiceImpl.class})
public class OrderQueryServiceTest {

    @Autowired
    private OrderQueryService orderQueryService;

    @MockBean
    private OrderRepository orderRepository;

    private Order order;
    private List<Order> orders;

    @Before
    public void setUp() {
        order = new Order();
        orders = new ArrayList<>();
        orders.add(order);
    }

    @Test
    public void should_return_all_orders() {
        Mockito.when(orderRepository.findAll()).thenReturn(orders);
        List<Order> orderList = orderQueryService.findAll();
        assertEquals(1, orderList.size());
    }
}
