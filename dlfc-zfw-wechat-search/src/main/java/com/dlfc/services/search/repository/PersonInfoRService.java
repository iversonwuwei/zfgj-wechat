package com.dlfc.services.search.repository;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("dlfc-datacenter-system")
public interface PersonInfoRService {

    @RequestMapping(value = "/wc/datas/sysPerson/findById", method = RequestMethod.GET)
    String findPersonById(@RequestParam(name = "id") String id);
}
