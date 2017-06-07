package com.dlfc.zfw.wechat.registry.convertor;

import com.dlfc.zfw.wechat.registry.dto.UserDTO;
import com.housecenter.dlfc.commons.bases.convertor.AbstractConvertor;
import com.housecenter.dlfc.commons.bases.dto.AbstractDTO;
import com.housecenter.dlfc.framework.ca.api.model.LoginUser;
import com.housecenter.dlfc.framework.common.web.AjaxResult;
import org.springframework.stereotype.Component;


@Component
public class UserConvertor extends AbstractConvertor<AjaxResult, UserDTO>{


    @Override
    public AjaxResult toModel(UserDTO userDTO) {
        return null;
    }

    @Override
    public UserDTO toDTO(AjaxResult ajaxResult, Object... objects) {
        UserDTO userDTO = new UserDTO();
        userDTO.setToken(ajaxResult.getToken().toString());
        return userDTO;
    }
}
