package com.dlfc.services.search.service.impl;


import com.dlfc.services.search.repository.UserInfoRService;
import com.dlfc.services.search.service.UsrUserService;
import com.dlfc.zfw.wechat.entities.entity.UsrUser;
import com.housecenter.dlfc.commons.bases.convertor.base.IConvertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsrUserServiceImpl implements UsrUserService {

    @Autowired
    private UserInfoRService userInfoRService;
    @Autowired
    private IConvertor convertor;

    @Override
    public UsrUser findUser(String user) {
        String userInfo = userInfoRService.findUserByUser(user);
        return (UsrUser) convertor.convert2Object(userInfo, UsrUser.class);
    }
}
