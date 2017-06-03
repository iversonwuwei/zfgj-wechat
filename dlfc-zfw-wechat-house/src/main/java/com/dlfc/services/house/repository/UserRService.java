package com.dlfc.services.house.repository;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("dlfc-datacenter-user")
public interface UserRService {

    @RequestMapping(value = "/wc/datas/usrHouCollection/whetherCollected", method = RequestMethod.GET)
    boolean whetherCollected(@RequestParam(name = "uid") String uid,
                             @RequestParam(name = "hid") String hid);
}
