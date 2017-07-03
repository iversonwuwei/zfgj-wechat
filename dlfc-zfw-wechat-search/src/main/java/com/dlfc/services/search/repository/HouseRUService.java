package com.dlfc.services.search.repository;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("dlfc-datacenter-user")
public interface HouseRUService {

    /**
     * 收藏房源
     *
     * @param uid
     * @return
     */
    @RequestMapping(value = "/wc/datas/usrHouCollection", method = RequestMethod.GET)
    String findByUid(@RequestParam(name = "uid") String uid);
}
