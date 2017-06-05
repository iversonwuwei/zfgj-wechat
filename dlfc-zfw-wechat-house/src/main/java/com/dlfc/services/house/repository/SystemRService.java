package com.dlfc.services.house.repository;

import com.dlfc.services.house.entity.SysSurFacis;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("dlfc-datacenter-system")
public interface SystemRService {

    @RequestMapping(value = "/wc/datas/sysInfoAtt/findAllByLidAndFileType", method = RequestMethod.GET)
    String findSysInfoAttByLidAndFileType(@RequestParam(name = "lid") String lid,
                                          @RequestParam(name = "fileType") Integer fileType);

    @RequestMapping(value = "/wc/datas/sysSurFacis/findByFacilityIds", method = RequestMethod.POST)
    String findSysSurFacisByFacilityIds(@RequestBody List<String> facilityIds);

    @RequestMapping(value = "/wc/datas/sysSurFacis/save", method = RequestMethod.POST)
    String saveSysSurFacis(SysSurFacis sysSurFacis);
}
