package com.dlfc.zfw.wechat.registry.service.impl;

import com.dlfc.zfw.wechat.registry.entity.SysInfoAtt;
import com.dlfc.zfw.wechat.registry.enums.InfoAttFileTypeEnum;
import com.dlfc.zfw.wechat.registry.repository.SysInfoAttRService;
import com.dlfc.zfw.wechat.registry.service.SysInfoAttService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by K on 6/19/17.
 */

@Service
@Transactional
public class SysInfoAttServiceImpl implements SysInfoAttService {

    private SysInfoAtt entity;

    @Autowired
    private SysInfoAttRService sysInfoAttRService;

    @Override
    public String saveUserAvatar(String path,
                                 String uid) {
        entity = new SysInfoAtt();
        entity.setFileType(InfoAttFileTypeEnum.AVATAR_ENUM.getValue());
        entity.setFilePath(path);
        entity.setLid(uid);
        return save(entity);
    }

    private String save(SysInfoAtt sysInfoAtt) {
        return sysInfoAttRService.saveSysInfoAtt(sysInfoAtt);
    }
}
