package com.dlfc.zfw.wechat.registry.service.impl;

import com.dlfc.zfw.wechat.registry.dto.UserVDTO;
import com.dlfc.zfw.wechat.registry.entity.UsrUser;
import com.dlfc.zfw.wechat.registry.repository.RegistryRService;
import com.dlfc.zfw.wechat.registry.service.UsrUserService;
import com.housecenter.dlfc.commons.bases.convertor.base.IConvertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UsrUserServiceImpl implements UsrUserService<UserVDTO> {
    @Autowired
    private RegistryRService registryRService;
    @Autowired
    private IConvertor<UsrUser> convertor;

    @Override
    public UsrUser findUser(UserVDTO userVDTO) {
        UsrUser user = registryRService.findByMobile(userVDTO.getMobile());
        if (user != null) {
            return user;
        }
        return null;
    }
}
