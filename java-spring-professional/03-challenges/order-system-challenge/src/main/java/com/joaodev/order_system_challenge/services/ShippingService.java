package com.joaodev.order_system_challenge.services;

import org.springframework.stereotype.Service;

import com.joaodev.order_system_challenge.entities.Order;

@Service
public class ShippingService {

    public Double shipment(Order order){
        if (order.getBasic() < 100.0) {
            return 20.0;
        }
        if (order.getBasic() < 200.0) {
            return 12.0;
        }
        else{
            return 0.0;
        }
    }
}
