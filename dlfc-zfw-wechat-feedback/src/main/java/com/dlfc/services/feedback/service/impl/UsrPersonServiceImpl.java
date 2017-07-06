package com.dlfc.services.feedback.service.impl;

import com.dlfc.services.feedback.repository.UsrPersonRService;
import com.dlfc.services.feedback.service.UsrPersonService;
import com.dlfc.zfw.wechat.entities.entity.SysPerson;
import com.housecenter.dlfc.framework.boot.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by walden on 17-7-6.
 */
@Service
public class UsrPersonServiceImpl implements UsrPersonService {
    @Autowired
    private UsrPersonRService usrPersonRService;

    @Override
    public SysPerson findById(String id) {
        SysPerson usrUser = usrPersonRService.findById(id);
        return usrUser;
    }
}
