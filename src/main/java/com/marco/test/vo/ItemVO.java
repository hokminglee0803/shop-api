package com.marco.test.vo;

import java.io.Serializable;

public class ItemVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String productName;

    private Double price;

    private Integer quantity;

    public ItemVO(){

    }

    public ItemVO(String productName, Double price, Integer quantity) {
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }


}
