package com.dlfc.services.contract.service;

import entity.ConHouseUser;
import entity.UsrUser;

/**
 * Created by K on 6/19/17.
 */
public interface HouseUserService {
    void save(ConHouseUser conHouseUser, UsrUser user);
}
