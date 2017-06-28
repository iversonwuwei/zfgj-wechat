package com.dlfc.services.house.service;


import com.dlfc.zfw.wechat.entities.entity.UsrHouCollection;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HouCollectionService {

    List<UsrHouCollection> collected(String uid, String hid);

}
