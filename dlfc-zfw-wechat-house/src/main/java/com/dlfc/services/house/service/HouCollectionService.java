package com.dlfc.services.house.service;


import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HouCollectionService {

    boolean collected(String uid, String hid);

}
