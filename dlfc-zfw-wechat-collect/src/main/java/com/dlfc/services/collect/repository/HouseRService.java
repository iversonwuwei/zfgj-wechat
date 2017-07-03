package com.dlfc.services.collect.repository;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "dlfc-datacenter-lessee")
public interface HouseRService {

    /**
     * 出租信息查询 根据 出租信息ID
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/wc/datas/houLeaseInfo/findById", method = RequestMethod.GET)
    String getLesseeById(@RequestParam(name = "id") String id);

}
