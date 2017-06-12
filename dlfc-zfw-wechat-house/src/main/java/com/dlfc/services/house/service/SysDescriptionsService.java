package com.dlfc.services.house.service;

import com.dlfc.services.house.entity.SysDescriptions;
import com.dlfc.services.house.entity.SysTrafficLines;

import java.util.List;

/**
 * Created by K on 2017/6/7.
 */
public interface SysDescriptionsService {
    void save(SysDescriptions sysDescriptions);

    List<SysDescriptions> findByLid(String lid);
}
