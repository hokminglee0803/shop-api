package com.marco.test.controller;

import com.marco.test.vo.ItemVO;
import com.marco.test.vo.PurchaseVO;
import com.marco.test.vo.ReceiptVO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PurchaseControllerTest {


    @LocalServerPort
    private int port;

    private URL base;

    @Autowired
    private TestRestTemplate template;

    @BeforeEach
    public void setUp() throws Exception {
        this.base = new URL("http://localhost:" + port + "/v1/purchase");
    }

    @Test
    public void Purchase_NoItem_ReturnReceiptWithZeroTotal() throws Exception{
        PurchaseVO request = new PurchaseVO();

        ResponseEntity<ReceiptVO> response = template.postForEntity(base.toString(), request,
                ReceiptVO.class);

        assertTrue(response.getStatusCode().is2xxSuccessful());

        ReceiptVO receipt = response.getBody();
        assertEquals(0.0, receipt.getSubtotal(),"SubTotal");
        assertEquals(0.0, receipt.getTax(),"Tax");
        assertEquals(0.0, receipt.getTotal(),"Total");
    }

    @Test
    public void Purchase_1Book1PotatoChipsInCA_ReturnReceipt() throws Exception{
        PurchaseVO request = new PurchaseVO();

        List<ItemVO> itemList = new ArrayList<>();

        ItemVO item1 = new ItemVO("potato chips", 3.99, 1);
        itemList.add(item1);

        ItemVO item2 = new ItemVO("book", 17.99, 1);
        itemList.add(item2);

        request.setItemList(itemList);
        request.setLocation("CA");

        ResponseEntity<ReceiptVO> response = template.postForEntity(base.toString(), request,
                ReceiptVO.class);

        assertTrue(response.getStatusCode().is2xxSuccessful());

        ReceiptVO receipt = response.getBody();
        assertEquals(21.98, receipt.getSubtotal(),"SubTotal");
        assertEquals(1.8, receipt.getTax(),"Tax");
        assertEquals(23.78, receipt.getTotal(),"Total");
    }

    @Test
    public void Purchase_1Book3PencilsInNY_ReturnReceipt() throws Exception{
        PurchaseVO request = new PurchaseVO();

        List<ItemVO> itemList = new ArrayList<>();

        ItemVO item1 = new ItemVO("pencils", 2.99 , 3);
        itemList.add(item1);

        ItemVO item2 = new ItemVO("book", 17.99, 1);
        itemList.add(item2);

        request.setItemList(itemList);
        request.setLocation("NY");

        ResponseEntity<ReceiptVO> response = template.postForEntity(base.toString(), request,
                ReceiptVO.class);

        assertTrue(response.getStatusCode().is2xxSuccessful());

        ReceiptVO receipt = response.getBody();
        assertEquals(26.96, receipt.getSubtotal(),"SubTotal");
        assertEquals(2.40, receipt.getTax(),"Tax");
        assertEquals(29.36, receipt.getTotal(),"Total");
    }

    @Test
    public void Purchase_1Shirt1PencilsInNY_ReturnReceipt() throws Exception{
        PurchaseVO request = new PurchaseVO();

        List<ItemVO> itemList = new ArrayList<>();

        ItemVO item1 = new ItemVO("pencils", 2.99, 2);
        itemList.add(item1);

        ItemVO item2 = new ItemVO("shirt",29.99,1);
        itemList.add(item2);

        request.setItemList(itemList);
        request.setLocation("NY");

        ResponseEntity<ReceiptVO> response = template.postForEntity(base.toString(), request,
                ReceiptVO.class);

        assertTrue(response.getStatusCode().is2xxSuccessful());

        ReceiptVO receipt = response.getBody();
        assertEquals(35.97, receipt.getSubtotal(),"SubTotal");
        assertEquals(0.55, receipt.getTax(),"Tax");
        assertEquals(36.52, receipt.getTotal(),"Total");
    }

}