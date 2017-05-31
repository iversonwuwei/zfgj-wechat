package com.dlfc.services.commons.repository;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("dlfc-datacenter-system")
public interface RepositoryService {

    @RequestMapping(value = "/wc/datas/sysAreaAreas/findAll", method = RequestMethod.GET)
    String getDistricts(@RequestParam(name = "pageSize") Integer pageSize, @RequestParam(name = "pageNo") Integer pageNo);

    /*@RequestMapping(value = "", method = RequestMethod.GET)
    String getTradeAreas(@RequestParam(name = "areaId") String areaId);

    @RequestMapping(value = "", method = RequestMethod.GET)
    String getSysCode(@RequestParam(name = "type") String type);*/
}
