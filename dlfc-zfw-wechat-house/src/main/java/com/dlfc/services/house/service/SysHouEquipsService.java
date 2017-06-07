package com.dlfc.services.house.service;

import com.dlfc.services.house.entity.SysHouEquips;

import java.util.List;

/**
 * Created by K on 2017/6/7.
 */
public interface SysHouEquipsService {
    String save(SysHouEquips sysSurFacis);

    void saveWithLidAndCode(String id, List<String> equips);
}
