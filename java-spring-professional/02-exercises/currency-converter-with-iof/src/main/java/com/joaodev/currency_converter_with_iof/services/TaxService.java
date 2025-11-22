package com.joaodev.currency_converter_with_iof.services;

import org.springframework.stereotype.Service;

@Service
public class TaxService {

    public Double tax(double amount , double price){
        if (amount < 1000) {
            return  (amount * price) * 0.06;
        }
        else{
            return (amount * price) * 0.04;
        }
    }
}
