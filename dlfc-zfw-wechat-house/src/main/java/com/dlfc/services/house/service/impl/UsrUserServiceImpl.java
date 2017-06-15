package com.dlfc.services.house.service.impl;

import com.dlfc.services.house.entity.UsrUser;
import com.dlfc.services.house.repository.UserInfoRService;
import com.dlfc.services.house.service.UsrUserService;
import com.housecenter.dlfc.commons.bases.convertor.base.IConvertor;
import com.housecenter.dlfc.framework.boot.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by walden on 17-6-15.
 */
@Service
public class UsrUserServiceImpl implements UsrUserService {
    @Autowired
    private UserInfoRService userInfoRService;
    @Autowired
    private IConvertor<UsrUser> convertor;

    @Override
    public UsrUser findById(String uid) {
        String user = null;
        if (uid != null) {
            user = userInfoRService.findUserById(uid);
        }
        UsrUser usrUser = null;
        if (user!= null){
            usrUser = convertor.convert2Object(user, UsrUser.class);
        }
        return usrUser;
    }
}
