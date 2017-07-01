package com.dlfc.services.auth.controller;

import com.dlfc.services.auth.dto.CreditAuthDTO;
import com.dlfc.services.auth.service.CreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by walden on 17-6-30.
 */
@RestController
@RequestMapping(value = "/ww/credits")
public class CreditAuthController {

    @Autowired
    private CreditService creditService;

    @RequestMapping(value = "/card", method = RequestMethod.POST)
    public String creditAuth(@RequestBody CreditAuthDTO creditAuthDTO){
        return null;
    }
}
