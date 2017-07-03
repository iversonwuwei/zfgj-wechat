package com.dlfc.services.collect.service.impl;

import com.dlfc.services.collect.repository.HouCollectionRService;
import com.dlfc.services.collect.service.HouCollectionService;
import com.dlfc.zfw.wechat.entities.entity.UsrHouCollection;
import com.dlfc.zfw.wechat.entities.entity.UsrUser;
import com.housecenter.dlfc.commons.bases.convertor.base.IConvertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class HouCollectionServiceImpl implements HouCollectionService {

    @Autowired
    private HouCollectionRService houCollectionRService;
    @Autowired
    private IConvertor convertor;

    @Override
    public List<UsrHouCollection> findCollectedHouses(String uid) {

        String houses = houCollectionRService.findCollectedHouses(uid);
        List<UsrHouCollection> houLeaseInfos = convertor.convert2Objects(houses, UsrHouCollection.class);
        return houLeaseInfos;
    }

    @Override
    public boolean cancelCollect(String chid) {

        String cancel = houCollectionRService.cancelCollect(chid);
        if (cancel != null) {
            return true;
        }
        return false;
    }

    @Override
    public String collect(UsrHouCollection usrHouCollection,
                          UsrUser user) {
        String collect = "";
        if (usrHouCollection != null) {
            usrHouCollection.preInsert(user);
            collect = houCollectionRService.collect(usrHouCollection);
        }

        if (!collect.equals("") && collect != null) {
            return collect;
        }

        return null;
    }
}
