package com.dlfc.services.collect.service;


import com.dlfc.services.collect.entity.UsrHouCollection;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HouCollectionService {

    List<UsrHouCollection> findCollectedHouses(String uid);

    boolean collected(String uid, String hid);

}
