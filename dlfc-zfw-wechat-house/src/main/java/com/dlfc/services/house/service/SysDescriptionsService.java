package com.dlfc.services.house.service;

import com.dlfc.zfw.wechat.entities.entity.SysDescriptions;
import com.dlfc.zfw.wechat.entities.entity.UsrUser;

import java.util.List;

/**
 * Created by K on 2017/6/7.
 */
public interface SysDescriptionsService {
    String save(SysDescriptions sysDescriptions, UsrUser user);

    List<SysDescriptions> findByLid(String lid);

    void remove(String lid);
}
