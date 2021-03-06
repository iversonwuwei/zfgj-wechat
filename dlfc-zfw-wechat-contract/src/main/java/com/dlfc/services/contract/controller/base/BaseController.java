package com.dlfc.services.contract.controller.base;

import com.dlfc.admin.common.exception.ApplicationException;
import com.dlfc.services.contract.repository.UserRService;
import com.dlfc.zfw.wechat.entities.entity.UsrUser;
import com.housecenter.dlfc.commons.bases.error.ResultError;
import com.housecenter.dlfc.commons.exception.CustomRuntimeException;
import com.housecenter.dlfc.framework.ca.api.PrincipalService;
import com.housecenter.dlfc.framework.common.util.StringUtils;
import com.housecenter.dlfc.framework.common.web.AjaxResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by K on 6/26/17.
 */

@Controller
@Slf4j
public class BaseController {

    protected UsrUser user;
    protected ResultError resultError;

    @Autowired
    private UserRService userRService;
    @Autowired
    private PrincipalService principalService;

    public void getUser(String token) throws CustomRuntimeException {
        if (StringUtils.isNotEmpty(token)) {
            try {
                user = null;
                AjaxResult ajaxResult = principalService.principal(token);
                user = userRService.findUsrUserByUser(ajaxResult.getData().toString());
                if (null == user) {
                    throw new ApplicationException("500");
                }
            } catch (Exception e) {
                log.error("token失效");
                //throw new CustomRuntimeException("", "");
                if (e.getMessage().contains("500") || e.getMessage().contains("404")) {
                    resultError = new ResultError();
                    resultError.setErrcode("250");
                    resultError.setErrmsg("token expired please re-login!");
                } else {
                    resultError = new ResultError();
                    resultError.setErrmsg(e.getMessage());
                }
            }
        }
    }
}
