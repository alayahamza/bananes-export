package com.alenia.bananesexport.service.command;

import com.alenia.bananesexport.constant.BananaConstant;
import com.alenia.bananesexport.entity.Order;
import com.alenia.bananesexport.entity.Recipient;
import com.alenia.bananesexport.exception.BananaException;
import com.alenia.bananesexport.repository.OrderRepository;
import com.alenia.bananesexport.service.query.RecipientQueryService;
import com.alenia.bananesexport.to.OrderTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class OrderCommandServiceImpl implements OrderCommandService {

    private final RecipientQueryService recipientQueryService;
    private final OrderRepository orderRepository;

    @Autowired
    public OrderCommandServiceImpl(RecipientQueryService recipientQueryService, OrderRepository orderRepository) {
        this.recipientQueryService = recipientQueryService;
        this.orderRepository = orderRepository;
    }


    @Override
    public Order create(OrderTO orderTO) throws BananaException {
        checkQuantity(orderTO.getQuantity());
        checkDeliveryDate(orderTO.getDeliveryDate());
        Recipient recipient = recipientQueryService.findById(orderTO.getRecipient());
        Order order = Order.builder()
                .recipient(recipient)
                .deliveryDate(orderTO.getDeliveryDate())
                .quantity(orderTO.getQuantity())
                .price(calculateOrderPrice(orderTO.getQuantity()))
                .build();
        return orderRepository.save(order);
    }

    @Override
    public void checkQuantity(Double quantity) throws BananaException {
        boolean quantityRules = quantity < BananaConstant.ORDER_MIN_QUANTITY ||
                quantity > BananaConstant.ORDER_MAX_QUANTITY ||
                quantity % BananaConstant.BOX_SIZE != 0;

        if (quantityRules) {
            throw new BananaException(BananaConstant.WRONG_ORDER_QUANTITY);
        }
    }

    @Override
    public void checkDeliveryDate(LocalDate deliveryDate) throws BananaException {
        LocalDate minDeliveryDate = LocalDate.now().plusDays(BananaConstant.MIN_DELIVERY_DAYS);
        if (deliveryDate.isBefore(minDeliveryDate)) {
            throw new BananaException(BananaConstant.DELIVERY_DATE_ERROR);
        }
    }

    @Override
    public Double calculateOrderPrice(Double quantity) {
        return quantity * BananaConstant.BOX_SIZE * BananaConstant.UNITY_PRICE;
    }
}
