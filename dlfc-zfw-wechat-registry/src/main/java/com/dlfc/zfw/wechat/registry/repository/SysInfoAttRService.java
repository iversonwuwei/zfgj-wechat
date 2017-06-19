package com.dlfc.zfw.wechat.registry.repository;

import com.dlfc.zfw.wechat.registry.entity.SysInfoAtt;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by K on 6/19/17.
 */

@FeignClient("data-center-system")
public interface SysInfoAttRService {

    @RequestMapping(value = "/wc/datas/sysInfoAtt", method = RequestMethod.POST)
    String saveSysInfoAtt(@RequestBody SysInfoAtt sysInfoAtt);
}
