package com.dlfc.services.search.convertor;

import com.dlfc.services.search.dto.UserDTO;
import com.dlfc.services.search.entity.Person;
import com.dlfc.services.search.entity.SysInfoAtt;
import com.dlfc.services.search.entity.UserEntity;
import com.dlfc.services.search.service.SysInfoAttService;
import com.dlfc.services.search.service.SysPersonService;
import com.housecenter.dlfc.commons.bases.convertor.AbstractConvertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class UserConvertor extends AbstractConvertor<UserEntity, UserDTO> {

    @Autowired
    private SysInfoAttService sysInfoAttService;
    @Autowired
    private SysPersonService sysPersonService;

    private SysInfoAtt sysInfoAtt;

    @Override
    public UserEntity toModel(UserDTO userDTO) {
        return null;
    }

    @Override
    public UserDTO toDTO(UserEntity userEntity, Object... strings) {
        UserDTO userDTO = new UserDTO();
        Person person = null;
        userDTO.setId(userEntity.getId());
        userDTO.setUid(userEntity.getPerId());
        userDTO.setPhoneNumber(userEntity.getMobile());
        userDTO.setCertified(userEntity.getAgtCert());
        sysInfoAtt = sysInfoAttService.findByLidAndFileType(userEntity.getId());
        if (sysInfoAtt != null){
            userDTO.setImgUrl(sysInfoAtt.getFilePath());
        }else {
            userDTO.setImgUrl("/logo/underLogo.png");
        }
        if (userEntity.getPerId() != null) {
            person = sysPersonService.findById(userEntity.getPerId());
            userDTO.setRealName(person.getName());
        }
        return userDTO;
    }
}
