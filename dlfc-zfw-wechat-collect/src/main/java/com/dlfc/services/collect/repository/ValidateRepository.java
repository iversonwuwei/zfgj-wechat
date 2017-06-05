package com.dlfc.services.collect.repository;


import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "dlfc-zfw-validate-services")
public interface ValidateRepository {

    @RequestMapping(value = "/ww/validates/house", method = RequestMethod.GET)
    String validateHouseBy(@RequestParam(name = "hid") String hid);
}
