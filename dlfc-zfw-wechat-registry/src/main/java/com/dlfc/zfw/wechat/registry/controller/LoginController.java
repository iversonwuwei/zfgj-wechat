package com.dlfc.zfw.wechat.registry.controller;


import com.dlfc.zfw.wechat.registry.dto.UserDTO;
import com.housecenter.dlfc.commons.bases.dto.ResultDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.attribute.UserDefinedFileAttributeView;

@RestController
@RequestMapping(value = "/wc/systems")
public class LoginController {

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResultDTO<Void> login(@RequestParam UserDTO userDTO){
        return ResultDTO.success();
    }

    @RequestMapping(value = "/registry", method = RequestMethod.POST)
    public ResultDTO<Void> registry(@RequestParam UserDTO userDTO){
        return ResultDTO.success();
    }

    @RequestMapping(value = "/forget", method = RequestMethod.POST)
    public ResultDTO<Void> forget(@RequestParam UserDTO userDTO){
        return ResultDTO.success();
    }

}
