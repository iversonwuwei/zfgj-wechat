package com.dlfc.services.contract.controller.base;

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

    @Autowired
    private UserRService userRService;
    @Autowired
    private PrincipalService principalService;

    public void getUser(String token) throws CustomRuntimeException {
        if (StringUtils.isNotEmpty(token)) {
            try {
                AjaxResult ajaxResult = principalService.principal(token);
                user = userRService.findUsrUserByUser(ajaxResult.getData().toString());
            } catch (Exception e) {
                log.error("token失效");
                //throw new CustomRuntimeException("", "");
                ResultError resultError;
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
