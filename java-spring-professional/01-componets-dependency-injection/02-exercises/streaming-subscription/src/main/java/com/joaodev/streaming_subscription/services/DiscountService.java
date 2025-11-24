package com.joaodev.streaming_subscription.services;

import org.springframework.stereotype.Service;

@Service
public class DiscountService {


    public double discountCalculation(double amount, int months){
        if (months < 12) {
            return 0.0;
        }
        else{
            return (amount * months) * 0.1;
        }
    }
}
