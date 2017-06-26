package com.dlfc.services.contract.repository;

import com.dlfc.zfw.wechat.entities.entity.UsrUser;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by K on 6/20/17.
 */

@FeignClient("dlfc-datacenter-user")
public interface UserRService {

    @RequestMapping(value = "/wc/datas/usrUser/findByUser", method = RequestMethod.GET)
    UsrUser findUsrUserByUser(@RequestParam(name = "user") String user);
}
