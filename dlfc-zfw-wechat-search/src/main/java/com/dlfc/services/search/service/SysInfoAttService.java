package com.dlfc.services.search.service;

import com.dlfc.zfw.wechat.entities.entity.SysInfoAtt;

public interface SysInfoAttService {

    SysInfoAtt findByLidAndFileType(String lid);
}