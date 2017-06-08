package com.dlfc.zfw.wechat.registry.controller;


import com.dlfc.admin.common.utils.StringUtils;
import com.dlfc.zfw.wechat.registry.convertor.SysMobileCapchaConvertor;
import com.dlfc.zfw.wechat.registry.convertor.UserConvertor;
import com.dlfc.zfw.wechat.registry.convertor.UserRegistryConvertor;
import com.dlfc.zfw.wechat.registry.dto.UserDTO;
import com.dlfc.zfw.wechat.registry.dto.UserVDTO;
import com.dlfc.zfw.wechat.registry.entity.SysMobileCapcha;
import com.dlfc.zfw.wechat.registry.entity.UsrUser;
import com.dlfc.zfw.wechat.registry.service.RegistryService;
import com.dlfc.zfw.wechat.registry.service.VerCodeService;
import com.housecenter.dlfc.commons.bases.dto.ResultDTO;
import com.housecenter.dlfc.commons.bases.error.ResultError;
import com.housecenter.dlfc.framework.ca.api.LoginService;
import com.housecenter.dlfc.framework.ca.api.model.LoginUser;
import com.housecenter.dlfc.framework.common.web.AjaxResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/wc/systems")
public class LoginController {

    private String result;

    @Autowired
    private LoginService loginService;
    @Autowired
    private VerCodeService verCodeService;
    @Autowired
    private RegistryService registryService;
    @Autowired
    private UserConvertor userConvertor;
    @Autowired
    private SysMobileCapchaConvertor sysMobileCapchaConvertor;
    @Autowired
    private UserRegistryConvertor userRegistryConvertor;


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResultDTO<UserDTO> login(@RequestBody LoginUser loginUser) {
        AjaxResult ajaxResult;
        try {
            ajaxResult = loginService.login(loginUser);
        } catch (Exception e) {
            LoginController.log.error(e.getMessage());
            return ResultDTO.failure(new UserDTO());
        }
        return userConvertor.toResultDTO(ajaxResult);
    }

    @RequestMapping(value = "/registry", method = RequestMethod.POST)
    public ResultDTO<Void> registry(@RequestBody UserVDTO userVDTO) {
        SysMobileCapcha sysMobileCapcha = sysMobileCapchaConvertor.toModel(userVDTO);
        result = verCodeService.validate(sysMobileCapcha);
        if (StringUtils.isNotEmpty(result)) {
            return ResultDTO.failure(new ResultError(result, null));
        }
        UsrUser usrUser = userRegistryConvertor.toModel(userVDTO);
        registryService.registry(usrUser);
        return ResultDTO.success();
    }

    @RequestMapping(value = "/forget", method = RequestMethod.POST)
    public ResultDTO<Void> forget(@RequestBody UserDTO userDTO) {
        return ResultDTO.success();
    }

}
