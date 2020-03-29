package com.marco.test.controller;

import com.marco.test.service.CheckDigitService;
import com.marco.test.vo.PurchaseVO;
import com.marco.test.vo.ReceiptVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.rmi.UnexpectedException;

@RestController
@CrossOrigin
@Api(tags = "CheckDigit")
public class CheckDigitController {
    private static final Log log = LogFactory.getLog(CheckDigitController.class);

    @Autowired
    CheckDigitService checkDigitService;

    @GetMapping (value = "/v1/checkDigit")
    @ApiOperation(value = "Check Digit", notes = "Check Digit", nickname = "check digit")
    @ResponseBody
    public String CheckDigit(
            @ApiParam (value = "Digit", required = true)
            @RequestParam
            final String digit)
            throws UnexpectedException {
        try{
            return checkDigitService.checkDigit(digit);
        }catch (final Exception e){
            throw new UnexpectedException(e.getMessage());
        }

    }

}
