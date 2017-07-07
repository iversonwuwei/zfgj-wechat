package com.dlfc.services.house.repository;

import com.dlfc.zfw.wechat.entities.dto.UserDTO;
import com.housecenter.dlfc.commons.bases.dto.ResultDTO;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by walden on 17-6-21.
 */
@FeignClient(value = "dlfc-zfw-validate-services")
public interface ValidateRService {

    @RequestMapping(value = "/ww/validates/house", method = RequestMethod.GET)
    String validateHouseBy(@RequestParam(name = "hid") String hid);

    @RequestMapping(value = "/ww/validate/user", method = RequestMethod.GET)
    ResultDTO<UserDTO> validateUserBy(@RequestParam(name = "token") String token);
}
