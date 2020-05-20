package com.alenia.bananesexport;

import com.alenia.bananesexport.entity.Order;
import com.alenia.bananesexport.entity.Recipient;
import com.alenia.bananesexport.exception.BananaException;
import com.alenia.bananesexport.repository.OrderRepository;
import com.alenia.bananesexport.repository.RecipientRepository;
import com.alenia.bananesexport.service.command.OrderCommandService;
import com.alenia.bananesexport.service.command.OrderCommandServiceImpl;
import com.alenia.bananesexport.service.query.OrderQueryServiceImpl;
import com.alenia.bananesexport.service.query.RecipientQueryServiceImpl;
import com.alenia.bananesexport.to.OrderTO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@Import({OrderCommandServiceImpl.class, RecipientQueryServiceImpl.class, OrderQueryServiceImpl.class})
public class OrderCommandServiceTest {

    @Autowired
    private OrderCommandService orderCommandService;

    @MockBean
    private OrderRepository orderRepository;

    @MockBean
    private RecipientRepository recipientRepository;

    private OrderTO orderTO;
    private Order order;
    private Recipient recipient;

    @Before
    public void setUp() {
        orderTO = new OrderTO();
        orderTO.setRecipient(1);
        orderTO.setQuantity(50d);
        orderTO.setDeliveryDate(LocalDate.now().plusDays(10));
        recipient = Recipient.builder()
                .id(1)
                .name("name")
                .build();

        order = Order.builder()
                .id(1)
                .price(3250d)
                .quantity(50d)
                .deliveryDate(LocalDate.now().plusDays(10))
                .recipient(recipient)
                .build();

    }

    @Test(expected = BananaException.class)
    public void should_throw_exception_when_wrong_quantity() throws BananaException {
        orderCommandService.checkQuantity(233d);
    }

    @Test(expected = BananaException.class)
    public void should_throw_exception_when_wrong_delivery_date() throws BananaException {
        orderCommandService.checkDeliveryDate(LocalDate.now().plusDays(2));
    }

    @Test
    public void should_calculate_order_price() {
        Double orderPrice = orderCommandService.calculateOrderPrice(2d);
        assertEquals(Double.valueOf(125), orderPrice);
    }

    @Test
    public void should_create_order() throws BananaException {
        Mockito.when(recipientRepository.findById(1)).thenReturn(Optional.ofNullable(recipient));
        Mockito.when(orderRepository.save(Mockito.any(Order.class))).thenReturn(order);
        Order orderCreated = orderCommandService.create(orderTO);
        assertNotNull(orderCreated);
        assertEquals(orderTO.getRecipient(), orderCreated.getRecipient().getId());
        assertEquals(orderTO.getQuantity(), orderCreated.getQuantity());
    }

    @Test
    public void should_update_order() throws BananaException {
        Mockito.when(orderRepository.findById(1)).thenReturn(Optional.ofNullable(order));
        Mockito.when(orderRepository.save(Mockito.any(Order.class))).thenReturn(order);
        Mockito.when(recipientRepository.findById(orderTO.getRecipient())).thenReturn(Optional.ofNullable(recipient));
        orderTO.setQuantity(100d);
        Order updatedOrder = orderCommandService.update(orderTO, 1);
        assertEquals(orderTO.getQuantity(), updatedOrder.getQuantity());
    }
}
