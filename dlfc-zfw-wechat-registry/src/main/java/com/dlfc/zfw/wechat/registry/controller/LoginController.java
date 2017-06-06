package com.dlfc.zfw.wechat.registry.controller;


import com.dlfc.zfw.wechat.registry.dto.UserDTO;
import com.housecenter.dlfc.commons.bases.dto.ResultDTO;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/wc/systems")
public class LoginController {

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResultDTO<Void> login(@RequestBody UserDTO userDTO){
        return ResultDTO.success();
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
