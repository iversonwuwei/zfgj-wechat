package com.dlfc.zfw.wechat.registry.convertor;

import com.dlfc.zfw.wechat.registry.dto.UserVDTO;
import com.dlfc.zfw.wechat.registry.entity.SysMobileCapcha;
import com.housecenter.dlfc.commons.bases.convertor.AbstractConvertor;
import org.springframework.stereotype.Component;

/**
 * Created by K on 2017/6/5.
 */

@Component
public class SysMobileCapchaConvertor extends AbstractConvertor<SysMobileCapcha, UserVDTO> {
    @Override
    public SysMobileCapcha toModel(UserVDTO dto) {
        SysMobileCapcha model = new SysMobileCapcha();
        if (null != dto) {
            model.setMobile(dto.getMobile());
            model.setDeviceId(dto.getDeviceId());
            model.setVerCode(dto.getVerCode());
        }
        return model;
    }

    @Override
    public UserVDTO toDTO(SysMobileCapcha sysMobileCapcha, Object... objects) {
        return null;
    }
}
