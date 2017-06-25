package com.dlfc.services.collect.service;

import com.dlfc.zfw.wechat.entities.entity.SysInfoAtt;

import java.util.List;

public interface SysInfoAttService {

    List<SysInfoAtt> findByLidAndFileType(String lid);
}
