package com.dlfc.services.unicom.repository;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("dlfc-datacenter-system")
public interface UnicomRepository {

    @RequestMapping(value = "/wc/datas/sysCode/findByType", method = RequestMethod.GET)
    String findByType(@RequestParam(name = "type") String type);

    @RequestMapping(value = "/wc/datas/sysParam/findByScope", method = RequestMethod.GET)
    String findByScope(@RequestParam(name = "scope") String scope);
}
