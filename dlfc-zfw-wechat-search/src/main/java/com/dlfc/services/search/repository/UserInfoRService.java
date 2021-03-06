package com.dlfc.services.search.repository;


import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("dlfc-datacenter-user")
public interface UserInfoRService {

    @RequestMapping(value = "/wc/datas/usrUser/findById", method = RequestMethod.GET)
    String findUserById(@RequestParam(name = "id") String id);

    @RequestMapping(value = "/wc/datas/usrUser/findByUser", method = RequestMethod.GET)
    String findUserByUser(@RequestParam(name = "user") String user);
}
