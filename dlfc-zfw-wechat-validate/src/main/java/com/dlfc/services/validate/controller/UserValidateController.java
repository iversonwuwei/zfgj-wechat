package com.dlfc.services.validate.controller;

import com.dlfc.services.validate.convertor.UserValidateConvertor;
import com.dlfc.services.validate.repository.UserInfoRService;
import com.dlfc.zfw.wechat.entities.dto.UserDTO;
import com.dlfc.zfw.wechat.entities.entity.UsrUser;
import com.housecenter.dlfc.commons.bases.dto.ResultDTO;
import com.housecenter.dlfc.commons.bases.error.ResultError;
import com.housecenter.dlfc.framework.ca.api.PrincipalService;
import com.housecenter.dlfc.framework.common.web.AjaxResult;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by walden on 17-6-21.
 */
@RestController
@Slf4j
@RequestMapping(value = "/ww/validate")
public class UserValidateController {

    @Autowired
    private PrincipalService principalService;
    @Autowired
    private UserInfoRService userInfoRService;
    @Autowired
    private UserValidateConvertor userValidateConvertor;

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ResultDTO<UserDTO> userValidation(@RequestParam String token) {
        if (StringUtils.isNotEmpty(token)) {
            AjaxResult result = principalService.principal(token);
            if (null != result && null != result.getData()) {
                UsrUser usrUser = userInfoRService.findUserByUser(result.getData().toString());
                if (null != usrUser) {
                    return userValidateConvertor.toResultDTO(usrUser);
                } else {
                    log.error("查询登陆信息为" + result.getData().toString() + "的返回结果为空");
                }
            } else {
                log.error("principal方法返回为空或者返回数据为空");
            }
        } else {
            log.error("token为空");
        }
        return ResultDTO.failure(new UserDTO(), new ResultError("登陆信息异常，请重新登陆", null));
    }
}
