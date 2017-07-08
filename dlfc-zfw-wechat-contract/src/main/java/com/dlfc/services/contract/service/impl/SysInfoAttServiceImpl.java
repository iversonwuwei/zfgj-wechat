package com.dlfc.services.contract.service.impl;

import com.dlfc.services.contract.repository.SystemRService;
import com.dlfc.services.contract.service.SysInfoAttService;
import com.dlfc.zfw.wechat.entities.entity.SysInfoAtt;
import com.dlfc.zfw.wechat.entities.entity.UsrUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by K on 6/26/17.
 */

@Service
@Transactional
public class SysInfoAttServiceImpl implements SysInfoAttService {

    private SysInfoAtt entity;

    @Autowired
    private SystemRService systemRService;

    @Override
    public String saveSign(String lid,
                           String path,
                           int type,
                           UsrUser user) {
        if (null != user) {
            systemRService.removeSysInfoAttByLid(lid);
            entity = new SysInfoAtt();
            entity.setLid(lid);
            entity.setFilePath(path);
            entity.setFileType(type);
            entity.preInsert(user);
            return systemRService.saveSysInfoAtt(entity);
        }
        return null;
    }
}
