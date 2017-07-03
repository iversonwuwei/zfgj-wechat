package com.dlfc.services.house.service.impl;


import com.dlfc.services.house.repository.UserRService;
import com.dlfc.services.house.service.HouCollectionService;
import com.dlfc.zfw.wechat.entities.entity.UsrHouCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class HouCollectionServiceImpl implements HouCollectionService {

    @Autowired
    private UserRService userRService;

    /**
     * @param uid 当前登录用户ID
     * @param hid 出租信息ID
     * @return
     */
    @Override
    public List<UsrHouCollection> collected(String uid, String hid) {
        List<UsrHouCollection> collected = userRService.whetherCollected(uid, hid);
        return collected;
    }
}
