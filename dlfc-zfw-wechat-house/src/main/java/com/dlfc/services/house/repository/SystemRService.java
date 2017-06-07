package com.dlfc.services.house.repository;

import com.dlfc.services.house.entity.SysSurFacis;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("dlfc-datacenter-system")
public interface SystemRService {

    @RequestMapping(value = "/wc/datas/sysInfoAtt/findAllByLidAndFileType", method = RequestMethod.GET)
    String findSysInfoAttByLidAndFileType(@RequestParam(name = "lid") String lid,
                                          @RequestParam(name = "fileType") Integer fileType);

    @RequestMapping(value = "/wc/datas/sysSurFacis/save", method = RequestMethod.POST)
    String saveSysSurFacis(SysSurFacis sysSurFacis);

    @RequestMapping(value = "/wc/datas/sysSurFacis/findByLid", method = RequestMethod.GET)
    String findSysSurFacisByLid(@RequestParam(name = "lid") String lid);

    @RequestMapping(value = "/wc/datas/sysSurFacisContrast/findByCode", method = RequestMethod.POST)
    String findSysSurFacisContrastByCode(String str);
}
