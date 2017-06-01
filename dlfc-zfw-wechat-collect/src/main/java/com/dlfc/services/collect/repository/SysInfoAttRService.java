package com.dlfc.services.collect.repository;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("dlfc-datacenter-system")
public interface SysInfoAttRService {

    @RequestMapping(value = "/wc/datas/sysInfoAtt/findAllByLidAndFileType", method = RequestMethod.GET)
    String findByLidAndFileType(@RequestParam(name = "lid") String lid,
                                @RequestParam(name = "fileType") Integer fileType);
}
