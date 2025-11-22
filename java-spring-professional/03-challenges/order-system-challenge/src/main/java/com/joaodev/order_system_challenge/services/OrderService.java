package com.joaodev.order_system_challenge.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joaodev.order_system_challenge.entities.Order;

@Service
public class OrderService {

    @Autowired
    ShippingService shippingService;

    public Double total(Order order){
       Double tot = order.getBasic() * (order.getDiscount() / 100.0);
       return (order.getBasic() - tot) + shippingService.shipment(order);
    }
}
