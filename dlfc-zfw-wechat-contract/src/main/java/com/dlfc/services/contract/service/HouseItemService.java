package com.dlfc.services.contract.service;

import com.dlfc.zfw.wechat.entities.entity.ConHouseItems;
import com.dlfc.zfw.wechat.entities.entity.UsrUser;

import java.util.List;

/**
 * Created by K on 6/26/17.
 */
public interface HouseItemService {
    String save(ConHouseItems conHouseItems, UsrUser user);

    List<ConHouseItems> findByLid(String lid);
}
