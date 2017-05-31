package com.dlfc.services.search.service.impl;


import com.dlfc.services.search.entity.UserEntity;
import com.dlfc.services.search.repository.UserInfoRService;
import com.dlfc.services.search.service.UsrUserService;
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
    public UserEntity findUser(String userid) {
        String userInfo = userInfoRService.findUserById(userid);
        return (UserEntity) convertor.convert2Object(userInfo, UserEntity.class);
    }
}
