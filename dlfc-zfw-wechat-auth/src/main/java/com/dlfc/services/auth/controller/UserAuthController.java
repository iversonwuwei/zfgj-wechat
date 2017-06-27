package com.dlfc.services.auth.controller;

import com.dlfc.services.auth.entity.SysParam;
import com.dlfc.services.auth.service.AuthParamService;
import com.dlfc.services.auth.service.impl.ContractAuthFacet;
import com.dlfc.services.auth.utils.MapUtils;
import com.housecenter.dlfc.commons.bases.dto.ResultDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/ww/users")
public class UserAuthController {


    @Autowired
    private AuthParamService authParamService;

    public static final String AUTH = "auth";

    @RequestMapping(value = "/auth", method = RequestMethod.GET)
    public ResultDTO<Void> userAuth(@RequestParam String username, @RequestParam String idNo){
        List<SysParam> sysParamList = authParamService.findSysParam(AUTH);
        Map<String, String> paramMaps = MapUtils.getAuthParam(sysParamList);
        if(ContractAuthFacet.authID(username, idNo, paramMaps)){
            return ResultDTO.success();
        }
        return ResultDTO.failure();
    }
}
