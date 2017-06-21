package com.dlfc.services.contract.service.impl;

import com.dlfc.services.contract.repository.UserRService;
import com.dlfc.services.contract.service.UserService;
import com.housecenter.dlfc.commons.bases.convertor.base.IConvertor;
import entity.UsrUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by K on 6/20/17.
 */

@Service
public class UserServiceImpl implements UserService {

    private String result;

    @Autowired
    private UserRService userRService;
    @Autowired
    private IConvertor convertor;

    @Override
    public UsrUser findUser(String id) {
        result = userRService.findUsrUserByUser(id);
        return (UsrUser) convertor.convert2Object(result, UsrUser.class);
    }
}
