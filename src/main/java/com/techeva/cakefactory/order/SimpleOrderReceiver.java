package com.techeva.cakefactory.order;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.techeva.cakefactory.basket.BasketItem;

@Component
public class SimpleOrderReceiver {

    @EventListener
    public void onNewOrder(OrderReceivedEvent event) {
        System.out.println("New order received:");
        System.out.println("Delivery address " + event.getDeliveryAddress());
        for (BasketItem basketItem : event.getItems()) {
            System.out.println(basketItem.getItem().getTitle() + " - " + basketItem.getQty());
        }
    }
}
