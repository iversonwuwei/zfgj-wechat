package com.dlfc.services.house.repository;

import com.dlfc.services.house.entity.SysDescriptions;
import com.dlfc.services.house.entity.SysHouEquips;
import com.dlfc.services.house.entity.SysSurFacis;
import com.dlfc.services.house.entity.SysTrafficLines;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("dlfc-datacenter-system")
public interface SystemRService {

    @RequestMapping(value = "/wc/datas/sysInfoAtt/findAllByLidAndFileType", method = RequestMethod.GET)
    String findSysInfoAttByLidAndFileType(@RequestParam(name = "lid") String lid,
                                          @RequestParam(name = "fileType") Integer fileType);

    @RequestMapping(value = "/wc/datas/sysSurFacis/save", method = RequestMethod.POST)
    String saveSysSurFacis(@RequestBody SysSurFacis sysSurFacis);

    @RequestMapping(value = "/wc/datas/sysSurFacis/findByLid", method = RequestMethod.GET)
    String findSysSurFacisByLid(@RequestParam(name = "lid") String lid);

    @RequestMapping(value = "/wc/datas/sysSurFacisContrast/findByCode", method = RequestMethod.GET)
    String findSysSurFacisContrastByCode(@RequestParam(name = "code") String code);

    @RequestMapping(value = "/wc/datas/sysHouEquips/save", method = RequestMethod.POST)
    String saveSysHouEquips(@RequestBody SysHouEquips sysSurFacis);

    @RequestMapping(value = "/wc/datas/sysHouEquipsContrast/findByCode", method = RequestMethod.GET)
    String findSysHouEquipsContrastByCode(@RequestParam(name = "code") String code);

    @RequestMapping(value = "/wc/datas/saveSysTrafficLines/save", method = RequestMethod.POST)
    String saveSysTrafficLines(SysTrafficLines sysSurFacis);

    @RequestMapping(value = "/wc/datas/sysDescriptions/save", method = RequestMethod.POST)
    void saveSysDescriptions(SysDescriptions sysDescriptions);
}
