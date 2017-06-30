package com.dlfc.services.validate.controller;

import com.housecenter.dlfc.commons.bases.dto.ResultDTO;
import com.housecenter.dlfc.commons.bases.error.ResultError;
import com.housecenter.dlfc.framework.ca.api.PrincipalService;
import com.housecenter.dlfc.framework.common.web.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by walden on 17-6-30.
 */
@RestController
@RequestMapping(value = "/ww/validates")
public class TokenValidateController {

    @Autowired
    private PrincipalService principalService;

    @RequestMapping(value = "/token", method = RequestMethod.GET)
    public ResultDTO tokenValidate(@RequestParam String token){
        ResultError resultError;
        AjaxResult user = null;
        try {
            user = principalService.principal(token);
        }catch (Exception e){
            if (e.getMessage().contains("认证失效")){
                resultError = new ResultError();
                resultError.setErrmsg("认证失效，请重新登录！");
                resultError.setErrcode("100");
                return ResultDTO.failure(resultError);
            }
        }
        return ResultDTO.success(user);
    }
}
