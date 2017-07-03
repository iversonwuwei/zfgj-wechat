package com.dlfc.zfw.wechat.registry.repository;


import com.dlfc.zfw.wechat.registry.entity.UsrUser;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("dlfc-datacenter-user")
public interface RegistryRService {

    @RequestMapping(value = "/wc/datas/usrUser/save", method = RequestMethod.POST)
    String registry(@RequestBody UsrUser usrUser);

    @RequestMapping(value = "/wc/datas/usrUser/findByUser", method = RequestMethod.GET)
    String findByMobile(@RequestParam(name = "user") String user);
}
