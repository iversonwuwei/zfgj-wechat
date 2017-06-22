package com.dlfc.services.house.service;


import com.dlfc.zfw.wechat.entities.entity.SysTrafficLines;
import com.dlfc.zfw.wechat.entities.entity.UsrUser;

import java.util.List;

/**
 * Created by K on 2017/6/7.
 */
public interface SysTrafficLinesService {
    String save(SysTrafficLines sysSurFacis, UsrUser user);

    List<SysTrafficLines> findByLid(String lid);

    void remove(String lid);
}
