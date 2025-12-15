package com.devsuperior.dsmeta.dto;

public class SaleSumDTO {

    private String sellerName;
    private Double total;

    public SaleSumDTO(){
    }

    public SaleSumDTO(String sellerName, Double total) {
        this.sellerName = sellerName;
        this.total = total;
    }

    public String getSellerName() {
        return sellerName;
    }

    public Double getTotal() {
        return total;
    }

    
}
