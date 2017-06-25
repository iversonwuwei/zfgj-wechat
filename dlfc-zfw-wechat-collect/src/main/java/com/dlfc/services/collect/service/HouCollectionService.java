package com.dlfc.services.collect.service;

import com.dlfc.zfw.wechat.entities.entity.UsrHouCollection;
import com.dlfc.zfw.wechat.entities.entity.UsrUser;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HouCollectionService {

    List<UsrHouCollection> findCollectedHouses(String uid);

    boolean cancelCollect(String chid);

    boolean collect(UsrHouCollection usrHouCollection, UsrUser user);
}
