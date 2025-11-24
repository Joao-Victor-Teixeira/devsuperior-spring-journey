package com.joaodev.order_processing_logistics.services;

import org.springframework.stereotype.Service;

import com.joaodev.order_processing_logistics.entities.Product;
import com.joaodev.order_processing_logistics.entities.enums.ShippingRates;

@Service
public class ShippingService {

    public Double shipping(ShippingRates region, Product product){
        if (product.getPrice() > 200.0) {
            return 0.0;
        }else{
            switch (region) {
            case SUL:
                return 25.00;
            case SUDESTE:
                return 15.00;
            case NORDESTE:
                return 30.00;    
            default:
                return 40.00;
        }
        }
        
    }
}
