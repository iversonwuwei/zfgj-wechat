package com.dlfc.services.search.controller;

import com.dlfc.services.search.convertor.UserConvertor;
import com.dlfc.services.search.dto.UserDTO;
import com.dlfc.services.search.entity.UserEntity;
import com.dlfc.services.search.service.SysPersonService;
import com.dlfc.services.search.service.UsrUserService;
import com.housecenter.dlfc.commons.bases.dto.ResultDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/ww/users")
public class UserController {

    @Autowired
    private UsrUserService usrUserService;
    @Autowired
    private SysPersonService sysPersonService;
    @Autowired
    private UserConvertor userConvertor;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResultDTO<UserDTO> findAll(@RequestParam String uid) {
        UserEntity yes = usrUserService.findUser(uid);
        return userConvertor.toResultDTO(yes);
    }
}
