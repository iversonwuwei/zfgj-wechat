package com.dlfc.services.contract.service;

import com.dlfc.zfw.wechat.entities.dto.UserDTO;
import com.dlfc.zfw.wechat.entities.entity.UsrUser;
import com.housecenter.dlfc.commons.bases.dto.ResultDTO;

import java.nio.file.attribute.UserDefinedFileAttributeView;

/**
 * Created by walden on 17-7-8.
 */
public interface ValidateService {

    ResultDTO<UserDTO> validateByToken(String token);
}
