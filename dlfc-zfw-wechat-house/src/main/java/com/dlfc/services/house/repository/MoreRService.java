package com.dlfc.services.house.repository;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("dlfc-datacenter-system")
public interface MoreRService {

    @RequestMapping(value = "/wc/datas/sysDescriptions/findByLid", method = RequestMethod.GET)
    String findByDescriptionLid(@RequestParam(name = "lid") String lid);

    @RequestMapping(value = "/wc/datas/sysHouEquipments/findByLid", method = RequestMethod.GET)
    String findsysHouEquipsByLid(@RequestParam(name = "lid") String lid);

    @RequestMapping(value = "/wc/datas/sysTrafficLines/findByLid", method = RequestMethod.GET)
    String findsysTrafficLinesById(@RequestParam(name = "lid") String lid);

    @RequestMapping(value = "/wc/datas/sysSurroundingFacilities/findByLid", method = RequestMethod.GET)
    String findsysSurroundingFacilitiesByLid(@RequestParam(name = "lid") String lid);

    @RequestMapping(value = "/wc/datas/sysHouEquipments/removeByLid", method = RequestMethod.DELETE)
    void houEquipRemove(@RequestParam(name = "lid") String lid);

    @RequestMapping(value = "/wc/datas/sysDescriptions/removeByLid", method = RequestMethod.DELETE)
    void descRemove(@RequestParam(name = "lid") String lid);

    @RequestMapping(value = "/wc/datas/sysTrafficLines/removeByLid", method = RequestMethod.DELETE)
    void trafficRemove(@RequestParam(name = "lid") String lid);

    @RequestMapping(value = "/wc/datas/sysSurroundingFacilities/removeByLid", method = RequestMethod.DELETE)
    void surFacRemove(@RequestParam(name = "lid") String lid);

    @RequestMapping(value = "/wc/datas/sysInfoAtt/removeByLid", method = RequestMethod.DELETE)
    void SysInfoAttRemove(@RequestParam(name = "lid") String lid);
}
