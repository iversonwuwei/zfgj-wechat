package com.dlfc.services.contract.service;

import com.dlfc.zfw.wechat.entities.entity.ConHouseUser;
import com.dlfc.zfw.wechat.entities.entity.UsrUser;

import java.util.List;

/**
 * Created by K on 6/19/17.
 */
public interface HouseUserService {
    void save(ConHouseUser conHouseUser, UsrUser user);

    List<ConHouseUser> findByLid(String lid);
}
