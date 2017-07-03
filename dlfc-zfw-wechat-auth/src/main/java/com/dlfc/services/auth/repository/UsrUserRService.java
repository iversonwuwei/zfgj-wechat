package com.dlfc.services.auth.repository;

import com.dlfc.zfw.wechat.entities.entity.UsrUser;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by walden on 17-7-3.
 */
@FeignClient(value = "dlfc-datacenter-user")
public interface UsrUserRService {

    @RequestMapping(value = "/wc/datas/usrUser/findByUser",method = RequestMethod.GET)
    UsrUser findByUser(@RequestParam(name = "user") String user);

    @RequestMapping(value = "/wc/datas/usrUser/findById",method = RequestMethod.GET)
    UsrUser findById(@RequestParam(name = "id") String id);
}
