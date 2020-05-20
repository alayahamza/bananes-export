package com.alenia.bananesexport.service.command;

import com.alenia.bananesexport.constant.BananaConstant;
import com.alenia.bananesexport.entity.Order;
import com.alenia.bananesexport.entity.Recipient;
import com.alenia.bananesexport.exception.BananaException;
import com.alenia.bananesexport.repository.OrderRepository;
import com.alenia.bananesexport.service.query.OrderQueryService;
import com.alenia.bananesexport.service.query.RecipientQueryService;
import com.alenia.bananesexport.to.OrderTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Transactional
@Service
public class OrderCommandServiceImpl implements OrderCommandService {

    private final RecipientQueryService recipientQueryService;
    private final OrderRepository orderRepository;
    private final OrderQueryService orderQueryService;

    @Autowired
    public OrderCommandServiceImpl(RecipientQueryService recipientQueryService, OrderRepository orderRepository, OrderQueryService orderQueryService) {
        this.recipientQueryService = recipientQueryService;
        this.orderRepository = orderRepository;
        this.orderQueryService = orderQueryService;
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
            throw new BananaException(BananaConstant.ORDER_QUANTITY_ERROR);
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

    @Override
    public Order update(OrderTO orderTO, long id) throws BananaException {
        Order orderToUpdate = orderQueryService.findById(id);
        checkQuantity(orderTO.getQuantity());
        checkDeliveryDate(orderTO.getDeliveryDate());
        Recipient recipient = recipientQueryService.findById(orderTO.getRecipient());
        orderToUpdate.setQuantity(orderTO.getQuantity());
        orderToUpdate.setPrice(calculateOrderPrice(orderTO.getQuantity()));
        orderToUpdate.setRecipient(recipient);
        orderToUpdate.setDeliveryDate(orderTO.getDeliveryDate());
        return orderRepository.save(orderToUpdate);
    }

    @Override
    public void delete(long id) {
        orderRepository.delete(id);
    }
}
