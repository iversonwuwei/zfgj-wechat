package com.dlfc.services.validate.repository;

import com.dlfc.zfw.wechat.entities.entity.HouLeaseInfo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "dlfc-datacenter-lessee")
public interface LesseeRService {

    @RequestMapping(value = "/wc/datas/houLeaseInfo/findById", method = RequestMethod.GET)
    HouLeaseInfo getLesseeById(@RequestParam(name = "id") String id);
}
