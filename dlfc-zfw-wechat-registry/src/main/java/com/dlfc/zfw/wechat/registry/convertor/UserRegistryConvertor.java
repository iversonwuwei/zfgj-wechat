package com.dlfc.zfw.wechat.registry.convertor;

import com.dlfc.zfw.wechat.registry.dto.UserVDTO;
import com.dlfc.zfw.wechat.registry.entity.UsrUser;
import com.dlfc.zfw.wechat.registry.enums.PasswordLevelEnum;
import com.dlfc.zfw.wechat.registry.service.EncryptService;
import com.housecenter.dlfc.commons.bases.convertor.AbstractConvertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by K on 2017/6/8.
 */
@Service
public class UserRegistryConvertor extends AbstractConvertor<UsrUser, UserVDTO> {

    @Autowired
    private EncryptService encryptService;

    @Override
    public UsrUser toModel(UserVDTO dto) {
        UsrUser model = new UsrUser();
        if (null != dto) {
            model.setMobile(dto.getMobile());
            model.setPassword(encryptService.generatePassword(dto.getPassword()));
            model.setUsername(encryptService.generateUsername(dto.getMobile()));
            model.setPasswordLevel(Short.valueOf(PasswordLevelEnum.LEVEL_LOW.getValue()));
        }
        return model;
    }

    @Override
    public UserVDTO toDTO(UsrUser usrUser, Object... objects) {
        return null;
    }
}
