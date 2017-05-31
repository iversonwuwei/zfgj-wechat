package com.dlfc.services.commons.repository;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "dlfc-datacenter-system")
public interface AreaDataService {

    @RequestMapping(value = "/wc/datas/sysAreaAreas/findByCityId", method = RequestMethod.GET)
    String getDistricts(@RequestParam(name = "cityId") String cityId);

    @RequestMapping(value = "", method = RequestMethod.GET)
    String getTradeAreas(@RequestParam(name = "areaId") String areaId);

    @RequestMapping(value = "", method = RequestMethod.GET)
    String getSysCode(@RequestParam(name = "type") String type);
}
