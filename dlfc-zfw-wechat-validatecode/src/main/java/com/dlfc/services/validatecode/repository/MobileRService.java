package com.dlfc.services.validatecode.repository;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by K on 2017/6/7.
 */

@FeignClient("dlfc-datacenter-system")
public interface MobileRService {

    @RequestMapping(value = "/findByMobileAndDomain", method = RequestMethod.GET)
    String findSysMobileCapchaByMobileAndDomain(@RequestParam(name = "mobile") String phone,
                                                @RequestParam(name = "domain") String domain);
}
