package com.dlfc.services.auth.repository;


import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient("dlfc-datacenter-system")
public interface UserAuthRService {

    @RequestMapping(value = "/wc/datas/sysParam/findByScope", method = RequestMethod.GET)
    String findByScope(@RequestParam(name = "scope") String scope);
}
