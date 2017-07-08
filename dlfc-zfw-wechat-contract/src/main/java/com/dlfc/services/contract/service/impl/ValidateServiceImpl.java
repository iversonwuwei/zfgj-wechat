package com.dlfc.services.contract.service.impl;

import com.dlfc.services.contract.repository.ValidateRService;
import com.dlfc.services.contract.service.ValidateService;
import com.dlfc.zfw.wechat.entities.dto.UserDTO;
import com.housecenter.dlfc.commons.bases.dto.ResultDTO;
import com.housecenter.dlfc.framework.boot.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by walden on 17-7-8.
 */
@Service
@Transactional
public class ValidateServiceImpl implements ValidateService {
    @Autowired
    private ValidateRService validateRService;

    @Override
    public ResultDTO<UserDTO> validateByToken(String token) {
        ResultDTO<UserDTO> user = validateRService.validateUserBy(token);
        return user;
    }
}
