package com.dlfc.services.house.service;

import com.dlfc.zfw.wechat.entities.entity.SysHouEquips;
import com.dlfc.zfw.wechat.entities.entity.UsrUser;

import java.util.List;

/**
 * Created by K on 2017/6/7.
 */
public interface SysHouEquipsService {
    String save(SysHouEquips sysSurFacis, UsrUser user);

    List<SysHouEquips> findByLid(String lid);

    void remove(String lid);
}
