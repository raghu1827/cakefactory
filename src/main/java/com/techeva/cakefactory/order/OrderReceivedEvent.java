package com.techeva.cakefactory.order;

import lombok.Data;

import java.util.Collection;

import com.techeva.cakefactory.basket.BasketItem;

@Data
public class OrderReceivedEvent {

    private final String deliveryAddress;
    private final Collection<BasketItem> items;

}
