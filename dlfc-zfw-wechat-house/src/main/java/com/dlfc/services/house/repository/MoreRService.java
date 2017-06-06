package com.dlfc.services.house.repository;

import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@EnableFeignClients(value = "dlfc-datacenter-system")
public interface MoreRService {

    @RequestMapping(value = "/wc/datas/sysDescriptions/findById", method = RequestMethod.GET)
    String findDescriptionById(@RequestParam(name = "id") String id);

    @RequestMapping(value = "/wc/datas/sysDescriptions/findByLid", method = RequestMethod.GET)
    String findByDescriptionLid(@RequestParam(name = "lid") String lid);

    @RequestMapping(value = "/wc/datas/sysHouEquips/findById", method = RequestMethod.GET)
    String findsysHouEquipsById(@RequestParam(name = "id") String id);

    @RequestMapping(value = "/wc/datas/sysHouEquips/findById", method = RequestMethod.GET)
    String findsysHouEquipsByLid(@RequestParam(name = "lid") String lid);

    @RequestMapping(value = "/wc/datas/sysTrafficLines/findById", method = RequestMethod.GET)
    String findById(@RequestParam(name = "id") String id);

    @RequestMapping(value = "/wc/datas/sysTrafficLines/findById", method = RequestMethod.GET)
    String findByLid(@RequestParam(name = "lid") String lid);
}
