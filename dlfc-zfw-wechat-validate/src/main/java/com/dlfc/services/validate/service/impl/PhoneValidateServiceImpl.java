package com.dlfc.services.validate.service.impl;

import com.dlfc.services.validate.repository.UserInfoRService;
import com.dlfc.services.validate.service.ValidateService;
import com.dlfc.zfw.wechat.entities.entity.UsrUser;
import com.housecenter.dlfc.framework.boot.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * Created by walden on 17-6-30.
 */
@Service
@Qualifier("phoneValidateServiceImpl")
public class PhoneValidateServiceImpl implements ValidateService<String> {

    @Autowired
    private UserInfoRService userInfoRService;

    @Override
    public boolean validate(String s) {
        UsrUser usrUser = userInfoRService.findUserByUser(s);
        if (usrUser != null) {
            return true;
        }
        return false;
    }
}
