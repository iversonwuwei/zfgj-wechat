package com.dlfc.services.house.service.impl;


import com.dlfc.services.house.repository.UserRService;
import com.dlfc.services.house.service.HouCollectionService;
import com.housecenter.dlfc.commons.bases.convertor.base.IConvertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class HouCollectionServiceImpl implements HouCollectionService {

    @Autowired
    private UserRService userRService;
    @Autowired
    private IConvertor convertor;

    /**
     *
     * @param uid 当前登录用户ID
     * @param hid 出租信息ID
     * @return
     */
    @Override
    public boolean collected(String uid, String hid) {
        boolean collected = userRService.whetherCollected(uid, hid);
        return collected;
    }
}
