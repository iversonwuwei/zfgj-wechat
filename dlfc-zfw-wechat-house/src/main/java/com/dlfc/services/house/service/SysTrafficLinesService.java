package com.dlfc.services.house.service;

import com.dlfc.services.house.entity.SysTrafficLines;

import java.util.List;

/**
 * Created by K on 2017/6/7.
 */
public interface SysTrafficLinesService {
    String save(SysTrafficLines sysSurFacis);

    void saveWithLidAndLines(String id, List<String> vehicles);

    void saveWithLidAndOthers(String id, String otherVehicles);

    List<SysTrafficLines> findByLid(String lid);

    void remove(String lid);
}
