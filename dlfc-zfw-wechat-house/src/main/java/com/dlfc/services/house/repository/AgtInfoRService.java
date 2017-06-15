package com.dlfc.services.house.repository;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by walden on 17-6-15.
 */
@FeignClient(value = "dlfc-datacenter-agent")
public interface AgtInfoRService {

    @RequestMapping(value = "/wc/datas/agtEmpInfo/findById", method = RequestMethod.GET)
    String findEmpUser(@RequestParam(name = "id") String id);
}
