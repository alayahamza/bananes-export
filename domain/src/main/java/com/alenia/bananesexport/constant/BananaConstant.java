package com.alenia.bananesexport.constant;

import lombok.experimental.UtilityClass;

@UtilityClass
public class BananaConstant {
    public final String RECIPIENT_EXISTS = "Recipient already exists";
    public final String RECIPIENT_NOT_FOUND = "Recipient not found";
    public final Double ORDER_MAX_QUANTITY = 10000d;
    public final Double ORDER_MIN_QUANTITY = 0d;
    public final Double BOX_SIZE = 25d;
    public final String ORDER_QUANTITY_ERROR = "Quantity should be between " + ORDER_MIN_QUANTITY + " and " + ORDER_MAX_QUANTITY + ", and a multiplier of " + BOX_SIZE;
    public final Integer MIN_DELIVERY_DAYS = 7;
    public final String DELIVERY_DATE_ERROR = "Delivery date should be at least " + MIN_DELIVERY_DAYS + " days from today";
    public final Double UNITY_PRICE = 2.5d;
    public static final String ORDER_NOT_FOUND = "Order not found";
}
