package com.dlfc.services.contract.repository;

import com.dlfc.zfw.wechat.entities.entity.*;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by K on 6/26/17.
 */

@FeignClient("dlfc-datacenter-system")
public interface SystemRService {

    @RequestMapping(value = "/wc/datas/sysPerson/findByNameInfos", method = RequestMethod.POST)
    SysPerson findSysPersonByNameInfos(@RequestBody SysPerson sysPerson);

    @RequestMapping(value = "/wc/datas/sysCode/findByType", method = RequestMethod.GET)
    List<SysCode> findSysCodeByType(@RequestParam(name = "type") String type);

    @RequestMapping(value = "/wc/datas/sysInfoAtt/save", method = RequestMethod.POST)
    String saveSysInfoAtt(@RequestBody SysInfoAtt sysInfoAtt);

    @RequestMapping(value = "/wc/datas/sysInfoAtt/removeByLid", method = RequestMethod.DELETE)
    void removeSysInfoAttByLid(@RequestParam(name = "lid") String lid);

    @RequestMapping(value = "/wc/datas/sysPerson/findById", method = RequestMethod.GET)
    SysPerson findById(@RequestParam(name = "id") String id);

    @RequestMapping(value = "/wc/datas/sysCode/findByTypeAndCode", method = RequestMethod.GET)
    List<SysCode> findSysCodeByTypeAndCode(@RequestParam(name = "type") String type,
                                           @RequestParam(name = "code") String code);

    @RequestMapping(value = "/wc/datas/sysAreaCities/findByCode", method = RequestMethod.GET)
    List<SysAreaCities> findSysAreaCitiesByCode(@RequestParam(name = "code") String code);

    @RequestMapping(value = "/wc/datas/sysAreaProvinces/findByCode", method = RequestMethod.GET)
    List<SysAreaProvinces> findSysAreaProvincesByCode(@RequestParam(name = "code") String code);

    @RequestMapping(value = "/wc/datas/sysInfoAtt/findAllByLidAndFileType", method = RequestMethod.GET)
    List<SysInfoAtt> findSysInfoAttByLidAndFileType(@RequestParam(name = "lid") String lid,
                                                    @RequestParam(name = "fileType") Integer fileType);
}
