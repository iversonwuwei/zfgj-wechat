package com.dlfc.services.search.repository;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "dlfc-datacenter-lessee")
public interface HouseRService {

    /**
     * 出租信息
     * @param pageSize
     * @param pageNo
     * @return
     */
    @RequestMapping(value = "/wc/datas/lessees/findAll", method = RequestMethod.GET)
    String getlesseedHouse(@RequestParam(defaultValue = "10", name = "pageSize") Integer pageSize,
                           @RequestParam(defaultValue = "1", name = "pageNo") Integer pageNo);

    /**
     * 出租信息查询 根据 出租信息ID
     * @param lesseeId
     * @return
     */
    @RequestMapping(value = "/wc/datas/lessees/findById", method = RequestMethod.GET)
    String getLesseeById(@RequestParam(name = "lesseeId") String lesseeId);

    /**
     * 出租信息查询 根据 用户Id
     * @param uid
     * @return
     */
    @RequestMapping(value = "/wc/datas/lessees/findByUid", method = RequestMethod.GET)
    String getLesseeByUid(@RequestParam(name = "uid") String uid);
}
