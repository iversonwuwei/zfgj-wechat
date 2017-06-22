package com.dlfc.services.house.service;


import com.dlfc.zfw.wechat.entities.entity.SysInfoAtt;
import com.dlfc.zfw.wechat.entities.entity.UsrUser;

import java.util.List;

public interface SysInfoAttService {

    List<SysInfoAtt> findByLidAndFileType(String lid);

    String save(SysInfoAtt sysInfoAtt, UsrUser user);

    void remove(String lid);
}
