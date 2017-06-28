package com.dlfc.services.commons.repository;

import com.dlfc.zfw.wechat.entities.entity.SysAreaCities;
import com.dlfc.zfw.wechat.entities.entity.SysAreaProvinces;
import com.dlfc.zfw.wechat.entities.entity.SysCode;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("dlfc-datacenter-system")
public interface RepositoryService {

    @RequestMapping(value = "/wc/datas/sysCode/findByType", method = RequestMethod.GET)
    String findSysCodeByType(@RequestParam(name = "type") String type);

    @RequestMapping(value = "/wc/datas/sysAreaAreas/findByCityId", method = RequestMethod.GET)
    String findSysAreaAreasByCityId(@RequestParam(name = "cityId") String cityId);

    @RequestMapping(value = "/wc/datas/sysTradeAreas/findByParentId", method = RequestMethod.GET)
    String findSysTradeAreasByParentId(@RequestParam(name = "parentId") String parentId);

    @RequestMapping(value = "/wc/datas/sysHouEquipsContrast/findAll", method = RequestMethod.GET)
    String findSysHouEquipsContrastAll();

    @RequestMapping(value = "/wc/datas/sysSurFacisContrast/findAll", method = RequestMethod.GET)
    String findSysSurFacisContrastAll();

    @RequestMapping(value = "/wc/datas/sysTradeAreas/findAll", method = RequestMethod.GET)
    String findSysTradeAreasAll();

    @RequestMapping(value = "/wc/datas/sysCode/findByType", method = RequestMethod.GET)
    List<SysCode> findByCode(@RequestParam(name = "type") String type);

    @RequestMapping(value = "/wc/datas/sysAreaProvinces/findAll", method = RequestMethod.GET)
    List<SysAreaProvinces> findSysAreaProvincesAll();

    @RequestMapping(value = "/wc/datas/sysAreaCities/findByLid", method = RequestMethod.GET)
    List<SysAreaCities> findCitiesByProvince(@RequestParam(name = "lid") String lid);

    @RequestMapping(value = "/wc/datas/sysAreaCities/findAll", method = RequestMethod.GET)
    List<SysAreaCities> findCitiesAll();
}
