package com.dlfc.services.validate.convertor;

import com.dlfc.zfw.wechat.entities.dto.UserDTO;
import com.dlfc.zfw.wechat.entities.entity.UsrUser;
import com.housecenter.dlfc.commons.bases.convertor.AbstractConvertor;
import org.springframework.stereotype.Component;

/**
 * Created by walden on 17-6-21.
 */
@Component
public class UserValidateConvertor extends AbstractConvertor<UsrUser, UserDTO> {
    @Override
    public UsrUser toModel(UserDTO dto) {
        return null;
    }

    @Override
    public UserDTO toDTO(UsrUser model, Object... objects) {
        UserDTO dto = new UserDTO();
        if (null != model) {
            dto.setId(model.getId());
            dto.setUsername(model.getUsername());
            dto.setAgtCert(model.getAgtCert());
            dto.setEmail(model.getEmail());
            dto.setPhone(model.getMobile());
            dto.setPid(model.getPerId());
        }
        return dto;
    }
}
