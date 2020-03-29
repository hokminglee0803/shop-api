package com.marco.test.vo;

import java.io.Serializable;
import java.util.List;

public class ReceiptVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private List<ItemVO> itemList;

    private Double subtotal;

    private Double tax;

    private Double total;

    public List<ItemVO> getItemList() {
        return itemList;
    }

    public void setItemList(List<ItemVO> itemList) {
        this.itemList = itemList;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public Double getTax() {
        return tax;
    }

    public void setTax(Double tax) {
        this.tax = tax;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

}
