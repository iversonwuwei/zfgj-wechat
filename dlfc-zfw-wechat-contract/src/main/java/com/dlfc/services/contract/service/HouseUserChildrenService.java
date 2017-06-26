package com.dlfc.services.contract.service;

import com.dlfc.zfw.wechat.entities.entity.ConHouseUserChildren;
import com.dlfc.zfw.wechat.entities.entity.UsrUser;

import java.util.List;

/**
 * Created by K on 6/20/17.
 */
public interface HouseUserChildrenService {
    void save(ConHouseUserChildren conHouseUserChildren, UsrUser user);

    List<ConHouseUserChildren> findByLid(String lid);
}
