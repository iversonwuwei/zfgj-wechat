package com.dlfc.services.search.convertor;

import com.dlfc.services.search.dto.UserDTO;
import com.dlfc.services.search.service.SysInfoAttService;
import com.dlfc.services.search.service.SysPersonService;
import com.dlfc.zfw.wechat.entities.entity.SysInfoAtt;
import com.dlfc.zfw.wechat.entities.entity.SysPerson;
import com.dlfc.zfw.wechat.entities.entity.UsrUser;
import com.housecenter.dlfc.commons.bases.convertor.AbstractConvertor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class UserConvertor extends AbstractConvertor<UsrUser, UserDTO> {

    @Autowired
    private SysInfoAttService sysInfoAttService;
    @Autowired
    private SysPersonService sysPersonService;

    private SysInfoAtt sysInfoAtt;

    @Override
    public UsrUser toModel(UserDTO userDTO) {
        return null;
    }

    @Override
    public UserDTO toDTO(UsrUser model, Object... strings) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(model.getId());
        userDTO.setUid(model.getPerId());
        userDTO.setPhoneNumber(model.getMobile());
        userDTO.setCertified(model.getAgtCert());
        sysInfoAtt = sysInfoAttService.findByLidAndFileType(model.getId());
        if (sysInfoAtt != null) {
            userDTO.setImgUrl(sysInfoAtt.getFilePath());
        } else {
            userDTO.setImgUrl("/logo/underLogo.png");
        }
        if (StringUtils.isNotEmpty(model.getPerId())) {
            SysPerson person = sysPersonService.findById(model.getPerId());
            if (null != person && 1 != person.getDeleteFlg()) {
                userDTO.setRealName(person.getName());
                userDTO.setIdNoType(person.getIdType());
                userDTO.setIdNo(person.getIdNo());
            }
        }
        userDTO.setEmail(model.getEmail());
        return userDTO;
    }
}
