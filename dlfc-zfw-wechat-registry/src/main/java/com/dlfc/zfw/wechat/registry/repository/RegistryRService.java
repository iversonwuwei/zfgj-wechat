package com.dlfc.zfw.wechat.registry.repository;


import com.dlfc.zfw.wechat.registry.dto.UserVDTO;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@EnableFeignClients("dlfc-datacenter-user")
public interface RegistryRService {

    @RequestMapping(value = "/wc/datas/usrUser", method = RequestMethod.POST)
    String registry(@RequestBody UserVDTO userVDTO);
}
