package com.dlfc.services.house.repository;


import com.dlfc.services.house.entity.UsrUser;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("dlfc-datacenter-user")
public interface UserInfoRService {

    @RequestMapping(value = "/wc/datas/usrUser/findById", method = RequestMethod.GET)
    String findUserById(@RequestParam(name = "id") String id);

    @RequestMapping(value = "/wc/datas/usrUser/findByUser", method = RequestMethod.GET)
    UsrUser findUserByUser(@RequestParam(name = "user") String user);
}
