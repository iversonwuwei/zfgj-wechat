package com.dlfc.zfw.wechat.registry.service.impl;

import com.dlfc.zfw.wechat.registry.dto.UserDTO;
import com.dlfc.zfw.wechat.registry.dto.UserVDTO;
import com.dlfc.zfw.wechat.registry.entity.UsrUser;
import com.dlfc.zfw.wechat.registry.repository.RegistryRService;
import com.dlfc.zfw.wechat.registry.repository.UpdateRService;
import com.dlfc.zfw.wechat.registry.service.EncryptService;
import com.dlfc.zfw.wechat.registry.service.PasswordChangeService;
import com.dlfc.zfw.wechat.registry.service.UsrUserService;
import com.housecenter.dlfc.commons.bases.convertor.base.IConvertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.security.util.Password;

@Service
public class PasswordChangeServiceImpl implements PasswordChangeService<UserVDTO> {
    @Autowired
    private UsrUserService<UserVDTO> usrUserService;
    @Autowired
    private UpdateRService updateRService;
    @Autowired
    private EncryptService encryptService;

    @Override
    public String change(UserVDTO o) {
        UsrUser usrUser = usrUserService.findUser(o);
        if (usrUser != null){
            usrUser.setPassword(encryptService.generatePassword(o.getPassword()));
            return updateRService.updateById(usrUser);
        }
        return null;
    }
}
