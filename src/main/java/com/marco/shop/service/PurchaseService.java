package com.marco.shop.service;

import com.marco.shop.constant.Category;
import com.marco.shop.vo.ItemVO;
import com.marco.shop.vo.ReceiptVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;

@Service
public class PurchaseService {

    private static final String CALIFORNIA = "CA";
    private static final String NEW_YORK = "NY";
    private static final Double ROUND_UP_INDEX = 0.05;
    private static final String DECIMAL_FORMAT = "##.00";

    @Autowired
    public PurchaseService(){
        //Constructor
    }

    public ReceiptVO printReceipt(List<ItemVO> itemList, String location){

        ReceiptVO receiptVO = new ReceiptVO();
        Double salesTaxRate = CALIFORNIA.equals(location)? 0.0975 : NEW_YORK.equals(location)? 0.08875 : 0;
        Double tax = 0.0;
        Double subtotal = 0.0;

        if(itemList!=null)
            for(ItemVO item:itemList){
                Double itemTotalPrice = item.getPrice() * item.getQuantity();
                if(! isExempt(item.getProductName(),location)){
                    Double roundUp = 1/ROUND_UP_INDEX;
                    tax += Math.ceil((itemTotalPrice*salesTaxRate * (roundUp))) / (roundUp);
                }
                subtotal +=itemTotalPrice;
            }

        DecimalFormat df = new DecimalFormat(DECIMAL_FORMAT);

        receiptVO.setItemList(itemList);
        receiptVO.setSubtotal(Double.valueOf(df.format(subtotal)));
        receiptVO.setTax(Double.valueOf(df.format(tax)));
        receiptVO.setTotal(Double.valueOf(df.format(subtotal + tax)));

        return receiptVO;
    }

    private boolean isExempt(String itemName, String location){
        if(CALIFORNIA.equals(location))
            return Category.FOOD.contains(itemName);
        else if (NEW_YORK.equals(location))
            return Category.FOOD.contains(itemName) || Category.CLOTHING.contains(itemName);
        else
            return false;
    }

}
