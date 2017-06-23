package com.dlfc.services.contract.service;

import com.dlfc.zfw.wechat.entities.entity.ConHouseUser;
import com.dlfc.zfw.wechat.entities.entity.UsrUser;

/**
 * Created by K on 6/19/17.
 */
public interface HouseUserService {
    void save(ConHouseUser conHouseUser, UsrUser user);
}
