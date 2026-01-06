package com.joaodev.order_processing_logistics.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joaodev.order_processing_logistics.entities.Order;

@Service
public class OrderService {

    @Autowired
    ShippingService shippingService;

    @Autowired
    DiscountService discountService;

    public Double total(Order order){

        return (order.getProduct().getPrice() - discountService.discountPercentage(order)) + shippingService.shipping(order.getRegion(), order.getProduct());
    }
}
