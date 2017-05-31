package com.dlfc.services.search.controller;

import com.alibaba.fastjson.JSONObject;
import com.dlfc.services.search.repository.UserInfoRService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/ww/users")
public class UserController {

    @Autowired
    private UserInfoRService userInfoRService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public JSONObject findAll(){
        JSONObject yes = userInfoRService.findUserById("3c007a5512804d5183d737b4c9e5b26a");
        return yes;
    }
}
