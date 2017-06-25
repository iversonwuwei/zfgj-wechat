package com.dlfc.services.collect.controller.base;

import com.dlfc.services.collect.repository.UserInfoRService;
import com.dlfc.zfw.wechat.entities.entity.UsrUser;
import com.housecenter.dlfc.commons.bases.convertor.base.IConvertor;
import com.housecenter.dlfc.framework.ca.api.PrincipalService;
import com.housecenter.dlfc.framework.common.util.StringUtils;
import com.housecenter.dlfc.framework.common.web.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by K on 6/26/17.
 */

@Controller
public class BaseController {

    protected UsrUser user;

    @Autowired
    private UserInfoRService userInfoRService;
    @Autowired
    private PrincipalService principalService;

    public void getUser(String token) {
        if (StringUtils.isNotEmpty(token)) {
            AjaxResult ajaxResult = principalService.principal(token);
            user = userInfoRService.findUserByUser(ajaxResult.getData().toString());
        }
    }
}
