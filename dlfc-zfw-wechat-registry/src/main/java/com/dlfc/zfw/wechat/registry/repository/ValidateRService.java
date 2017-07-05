package com.dlfc.zfw.wechat.registry.repository;

import com.dlfc.zfw.wechat.entities.entity.SysMobileCapcha;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by K on 2017/6/8.
 */

@FeignClient("dlfc-datacenter-system")
public interface ValidateRService {

    @RequestMapping(value = "/wc/datas/sysMobileCapcha/findByParams", method = RequestMethod.POST)
    List<SysMobileCapcha> validate(@RequestBody SysMobileCapcha sysMobileCapcha);
}
