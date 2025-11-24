package com.joaodev.streaming_subscription.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joaodev.streaming_subscription.entities.Subscription;

@Service
public class SubscriptionService {

    @Autowired
    DiscountService discountService;

    public Double total(Subscription subscription){
        double discount = discountService.discountCalculation(subscription.getMonthlyPrice(), subscription.getMonths());
        double gross = subscription.getMonthlyPrice() * subscription.getMonths();
        double net = gross - discount;
        return net;
    }
}
