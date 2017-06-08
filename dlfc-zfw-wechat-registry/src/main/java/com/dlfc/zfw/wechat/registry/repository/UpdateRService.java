package com.dlfc.zfw.wechat.registry.repository;

import com.dlfc.zfw.wechat.registry.entity.UsrUser;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("dlfc-datacenter-user")
public interface UpdateRService {

    @RequestMapping(value = "/wc/datas/usrUser/updateById", method = RequestMethod.POST)
    String updateById(@RequestBody UsrUser usrUser);

}
