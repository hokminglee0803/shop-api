package com.marco.test.vo;

import java.io.Serializable;
import java.util.List;

public class PurchaseVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private List<ItemVO> itemList;

    private String location;

    public List<ItemVO> getItemList() {
        return itemList;
    }

    public void setItemList(List<ItemVO> itemList) {
        this.itemList = itemList;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

}
