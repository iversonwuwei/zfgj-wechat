package com.walden.test.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

@RestController
public class DrinkController {

    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "/coffee/{id}", method = RequestMethod.GET)
    public Object test(@PathVariable(name = "id")String id,@RequestParam(name = "helloClient") String helloClient) {
        ServiceInstance instance = client.getLocalServiceInstance();
        String result = "Here is a cup of coffee  /coffee, host:" + instance.getHost() + ", service_id:"
                + instance.getServiceId()+","+helloClient+","+id;
        logger.info(result);
        return result;
    }
}