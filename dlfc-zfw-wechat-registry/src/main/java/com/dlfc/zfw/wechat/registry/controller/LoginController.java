package com.dlfc.zfw.wechat.registry.controller;


import com.dlfc.zfw.wechat.registry.convertor.UserConvertor;
import com.dlfc.zfw.wechat.registry.dto.UserDTO;
import com.housecenter.dlfc.commons.bases.dto.ResultDTO;
import com.housecenter.dlfc.framework.ca.api.LoginService;
import com.housecenter.dlfc.framework.ca.api.PrincipalService;
import com.housecenter.dlfc.framework.ca.api.model.LoginUser;
import com.housecenter.dlfc.framework.common.web.AjaxResult;
import com.housecenter.dlfc.framework.common.web.AjaxResultBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Slf4j
@RestController
@RequestMapping(value = "/wc/systems")
public class LoginController {

    @Autowired
    private LoginService loginService;
    @Autowired
    private PrincipalService principalService;
    @Autowired
    private UserConvertor userConvertor;


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResultDTO<UserDTO> login(@RequestBody LoginUser loginUser){
        AjaxResult ajaxResult = null;
        try {
            ajaxResult = loginService.login(loginUser);
        }catch (Exception e){
            LoginController.log.error(e.getMessage());
            return ResultDTO.failure(new UserDTO());
        }
        return userConvertor.toResultDTO(ajaxResult);
    }

    @RequestMapping(value = "/registry", method = RequestMethod.POST)
    public ResultDTO<Void> registry(@RequestBody UserDTO userDTO){
        return ResultDTO.success();
    }

    @RequestMapping(value = "/forget", method = RequestMethod.POST)
    public ResultDTO<Void> forget(@RequestBody UserDTO userDTO){
        return ResultDTO.success();
    }

}
