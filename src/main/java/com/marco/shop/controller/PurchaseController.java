package com.marco.shop.controller;

import com.marco.shop.service.PurchaseService;
import com.marco.shop.vo.ItemVO;
import com.marco.shop.vo.PurchaseVO;
import com.marco.shop.vo.ReceiptVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.http.HttpServletRequest;
import java.rmi.UnexpectedException;
import java.util.List;

@RestController
@CrossOrigin
@Api(tags = "Purchase")
public class PurchaseController {
    private static final Log log = LogFactory.getLog(PurchaseController.class);

    private static final String ITEMLIST = "itemList";

    @Autowired
    PurchaseService purchaseService;

    @PostMapping(value = "/v1/purchase", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Receipt with Tax and Total", notes = "Post a purchase request then return a receipt with total price", nickname = "purchase")
    public ReceiptVO purchase(
            @ApiParam (value = "PurchaseVO", required = true)
            @RequestBody
            final PurchaseVO purchaseVO)
            throws UnexpectedException {
        try{

            return purchaseService.printReceipt(purchaseVO.getItemList(),purchaseVO.getLocation());

        }catch (final Exception e){
            throw new UnexpectedException(e.getMessage(), e);
        }

    }

}
