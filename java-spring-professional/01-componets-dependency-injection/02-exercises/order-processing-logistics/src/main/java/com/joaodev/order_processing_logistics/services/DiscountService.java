package com.joaodev.order_processing_logistics.services;

import org.springframework.stereotype.Service;

import com.joaodev.order_processing_logistics.entities.Order;

@Service
public class DiscountService {


    public Double discountPercentage(Order order){
        return order.getProduct().getPrice() * (order.getDiscountPercent() / 100.0);
    }
}
