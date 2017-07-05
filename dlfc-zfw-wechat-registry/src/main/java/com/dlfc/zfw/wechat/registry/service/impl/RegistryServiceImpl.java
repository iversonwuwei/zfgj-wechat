package com.dlfc.zfw.wechat.registry.service.impl;

import com.dlfc.zfw.wechat.registry.entity.UsrUser;
import com.dlfc.zfw.wechat.registry.repository.RegistryRService;
import com.dlfc.zfw.wechat.registry.service.RegistryService;
import com.housecenter.dlfc.commons.bases.convertor.base.IConvertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by K on 2017/6/8.
 */

@Service
@Transactional
public class RegistryServiceImpl implements RegistryService<UsrUser> {

    private String result;

    @Autowired
    private RegistryRService registryRService;
    @Autowired
    private IConvertor convertor;

    @Override
    public void registry(UsrUser usrUser) {
        registryRService.registry(usrUser);
    }
}
