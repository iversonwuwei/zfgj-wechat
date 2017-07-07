package com.dlfc.services.feedback.repository;

import com.dlfc.zfw.wechat.entities.entity.SysPerson;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by walden on 17-7-6.
 */
@FeignClient("dlfc-datacenter-system")
public interface UsrPersonRService {

    @RequestMapping(value = "/wc/datas/sysPerson/findById", method = RequestMethod.GET)
    SysPerson findById(@RequestParam(name = "id") String id);
}
