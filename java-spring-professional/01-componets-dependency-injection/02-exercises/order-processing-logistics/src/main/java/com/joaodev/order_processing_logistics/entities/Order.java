package com.joaodev.order_processing_logistics.entities;

import com.joaodev.order_processing_logistics.entities.enums.ShippingRates;

public class Order {
    
    private Integer code;
    private Product product;
    private Double discountPercent;
    private ShippingRates region;


    public Order(){
    }


    public Order(Integer code, Product product, Double discountPercent, ShippingRates region) {
        this.code = code;
        this.product = product;
        this.discountPercent = discountPercent;
        this.region = region;
    }


    public Integer getCode() {
        return code;
    }


    public void setCode(Integer code) {
        this.code = code;
    }


    public Product getProduct() {
        return product;
    }


    public void setProduct(Product product) {
        this.product = product;
    }


    public Double getDiscountPercent() {
        return discountPercent;
    }


    public void setDiscountPercent(Double discountPercent) {
        this.discountPercent = discountPercent;
    }


    public ShippingRates getRegion() {
        return region;
    }


    public void setRegion(ShippingRates region) {
        this.region = region;
    }


    @Override
    public String toString() {
        return "Order [code=" + code + ", product=" + product + ", discountPercent=" + discountPercent + ", region="
                + region + "]";
    }

    
}
