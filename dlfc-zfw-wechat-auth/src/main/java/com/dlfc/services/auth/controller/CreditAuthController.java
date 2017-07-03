package com.dlfc.services.auth.controller;

import com.dlfc.services.auth.dto.CreditAuthDTO;
import com.dlfc.services.auth.service.CreditService;
import com.dlfc.services.auth.service.UsrUserService;
import com.dlfc.zfw.wechat.entities.entity.UsrUser;
import com.housecenter.dlfc.framework.ca.api.PrincipalService;
import com.housecenter.dlfc.framework.common.util.StringUtils;
import com.housecenter.dlfc.framework.common.web.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by walden on 17-6-30.
 */
@RestController
@RequestMapping(value = "/ww/credits")
public class CreditAuthController {

    @Autowired
    private CreditService<CreditAuthDTO> creditService;
    @Autowired
    private UsrUserService usrUserService;
    @Autowired
    private PrincipalService principalService;

    protected UsrUser user;


    @RequestMapping(value = "/card", method = RequestMethod.POST)
    public String creditAuth(@RequestBody CreditAuthDTO creditAuthDTO,
                             @RequestHeader(required = false) String token){
        getUser(token);
        creditAuthDTO.setUId(user.getId());
        String result = creditService.auth(creditAuthDTO);
        return result;
    }

    private void getUser(String token) {
        if (StringUtils.isNotEmpty(token)) {
            AjaxResult ajaxResult = principalService.principal(token);
            user = usrUserService.findByMobile(ajaxResult.getData().toString());
        }
    }
}
