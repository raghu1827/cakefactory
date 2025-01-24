package com.techeva.cakefactory.basket;

import java.math.BigDecimal;

import com.techeva.cakefactory.catalog.Item;

import lombok.Data;

@Data
public class BasketItem {

    final private Item item;
    final private int qty;

    BigDecimal getTotal() {
        return this.item.getPrice().multiply(BigDecimal.valueOf(qty));
    };


}