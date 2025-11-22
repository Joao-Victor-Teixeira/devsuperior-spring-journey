package com.joaodev.currency_converter_with_iof.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joaodev.currency_converter_with_iof.entities.CurrencyData;

@Service
public class CurrencyService {

    @Autowired
    TaxService taxService;
    public Double finalValue(CurrencyData currencyData){
        
        double tax = taxService.tax(currencyData.getAmount(),currencyData.getPrice());
        double total = currencyData.getAmount() * currencyData.getPrice();
        
        return total + tax;
    }
}
