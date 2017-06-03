package com.dlfc.services.commons.repository;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("dlfc-datacenter-system")
public interface RepositoryService {

    @RequestMapping(value = "/wc/datas/sysCode/findByType", method = RequestMethod.GET)
    String findSysCodeByType(@RequestParam(name = "type") String type);

    @RequestMapping(value = "/wc/datas/sysAreaAreas/findByCityId", method = RequestMethod.GET)
    String findSysAreaAreasByCityId(@RequestParam(name = "cityId") String cityId);

    @RequestMapping(value = "/wc/datas/sysTradeAreas/findByParentId", method = RequestMethod.GET)
    String findSysTradeAreasByParentId(@RequestParam(name = "parentId") String parentId);

    @RequestMapping(value = "/wc/datas/sysHouEquipmentsContrast/findAll", method = RequestMethod.GET)
    String findSysHouEquipmentsContrastAll();
}
