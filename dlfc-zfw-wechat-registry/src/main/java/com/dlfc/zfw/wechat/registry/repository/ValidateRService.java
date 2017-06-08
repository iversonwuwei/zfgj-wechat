package com.dlfc.zfw.wechat.registry.repository;

import com.dlfc.zfw.wechat.registry.entity.SysMobileCapcha;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by K on 2017/6/8.
 */

@FeignClient("dlfc-datacenter-system")
public interface ValidateRService {

    @RequestMapping(value = "/wc/datas/sysMobileCapcha/findByParams", method = RequestMethod.POST)
    String validate(@RequestBody SysMobileCapcha sysMobileCapcha);
}
