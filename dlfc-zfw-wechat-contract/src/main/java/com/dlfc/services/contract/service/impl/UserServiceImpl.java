package com.dlfc.services.contract.service.impl;

import com.dlfc.services.contract.repository.UserRService;
import com.dlfc.services.contract.service.UserService;
import com.dlfc.zfw.wechat.entities.entity.UsrUser;
import com.housecenter.dlfc.commons.bases.convertor.base.IConvertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by K on 6/20/17.
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRService userRService;

    @Override
    public UsrUser findUser(String id) {
        return userRService.findUsrUserByUser(id);
    }
}
