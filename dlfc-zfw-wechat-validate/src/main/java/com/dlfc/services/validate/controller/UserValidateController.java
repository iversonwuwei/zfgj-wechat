package com.dlfc.services.validate.controller;

import com.dlfc.services.validate.convertor.UserValidateConvertor;
import com.dlfc.services.validate.dto.ValidateResultDTO;
import com.dlfc.services.validate.repository.UserInfoRService;
import com.dlfc.zfw.wechat.entities.entity.UsrUser;
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
 * Created by walden on 17-6-21.
 */
@RestController
@RequestMapping(value = "/ww/validate")
public class UserValidateController {

    @Autowired
    private PrincipalService principalService;
    @Autowired
    private UserInfoRService userInfoRService;
    @Autowired
    private UserValidateConvertor userValidateConvertor;

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ResultDTO userValidation(@RequestParam String token) {
        AjaxResult user = null;
        UsrUser userEntity = null;
        try {
            if (!token.equals("") && token != null) {
                user = principalService.principal(token);
                //userEntity = convertor.convert2Object(userInfoRService.findUserByUser(user.getData().toString()), User.class);
                userEntity = userInfoRService.findUserByUser(user.getData().toString());
            }
        }catch (Exception e){
            ResultError resultError;
            if (e.getMessage().contains("认证失效")) {
                resultError = new ResultError();
                resultError.setErrcode("250");
                resultError.setErrmsg("认证失效！");
            }else {
                resultError = new ResultError();
                resultError.setErrcode("280");
                resultError.setErrmsg("请重新登录！");
            }
            return ResultDTO.failure(resultError);
        }
        return userValidateConvertor.toResultDTO(userEntity);
    }
}
