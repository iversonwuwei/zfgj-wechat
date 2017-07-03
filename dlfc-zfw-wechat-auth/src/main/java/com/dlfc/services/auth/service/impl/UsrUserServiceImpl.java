package com.dlfc.services.auth.service.impl;

import com.dlfc.services.auth.repository.UsrUserRService;
import com.dlfc.services.auth.service.UsrUserService;
import com.dlfc.zfw.wechat.entities.entity.UsrUser;
import com.housecenter.dlfc.framework.boot.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by walden on 17-7-3.
 */
@Service
public class UsrUserServiceImpl implements UsrUserService {
    @Autowired
    private UsrUserRService usrUserRService;

    @Override
    public UsrUser findById(String uid) {
        UsrUser usrUser = usrUserRService.findById(uid);
        return usrUser;
    }

    @Override
    public UsrUser findByMobile(String mobile) {
        UsrUser usrUser = usrUserRService.findByUser(mobile);
        return usrUser;
    }
}
