package com.dlfc.services.auth.controller;

import com.dlfc.services.auth.service.AuthParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by walden on 17-7-7.
 */
@RequestMapping(value = "/log")
public class LogTestController {

    @Autowired
    private AuthParamService authParamService;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public void test(){
        authParamService.findSysParam("test");
    }
}
