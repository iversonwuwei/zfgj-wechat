package com.dlfc.services.validate.convertor;

import com.dlfc.services.validate.dto.ValidateResultDTO;
import com.dlfc.zfw.wechat.entities.entity.UsrUser;
import com.housecenter.dlfc.commons.bases.convertor.AbstractConvertor;
import org.springframework.stereotype.Component;

/**
 * Created by walden on 17-6-21.
 */
@Component
public class UserValidateConvertor extends AbstractConvertor<UsrUser, ValidateResultDTO> {
    @Override
    public UsrUser toModel(ValidateResultDTO validateResultDTO) {
        return null;
    }

    @Override
    public ValidateResultDTO toDTO(UsrUser user, Object... objects) {
        ValidateResultDTO validateResultDTO = new ValidateResultDTO();
        validateResultDTO.setUsername(user.getUsername());
        validateResultDTO.setAgtCert(user.getAgtCert());
        validateResultDTO.setEmail(user.getEmail());
        validateResultDTO.setPhone(user.getMobile());
        validateResultDTO.setPid(user.getPerId());
        validateResultDTO.setId(user.getId());

        return validateResultDTO;
    }
}
