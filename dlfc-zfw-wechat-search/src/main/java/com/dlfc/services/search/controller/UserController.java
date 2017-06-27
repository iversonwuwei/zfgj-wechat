package com.dlfc.services.search.controller;

import com.dlfc.services.search.convertor.UserConvertor;
import com.dlfc.services.search.dto.UserDTO;
import com.dlfc.services.search.service.UsrUserService;
import com.dlfc.zfw.wechat.entities.entity.UsrUser;
import com.housecenter.dlfc.commons.bases.dto.ResultDTO;
import com.housecenter.dlfc.framework.ca.api.PrincipalService;
import com.housecenter.dlfc.framework.common.web.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/ww/users")
public class UserController {

    @Autowired
    private UsrUserService usrUserService;
    @Autowired
    private UserConvertor userConvertor;

    @Autowired
    private PrincipalService principalService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResultDTO<UserDTO> findAll(@RequestHeader String token) {
        AjaxResult user = principalService.principal(token);
        UsrUser yes = usrUserService.findUser(user.getData().toString());
        return userConvertor.toResultDTO(yes);
    }
}
