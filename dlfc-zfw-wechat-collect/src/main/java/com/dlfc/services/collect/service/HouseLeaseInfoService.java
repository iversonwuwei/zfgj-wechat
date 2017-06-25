package com.dlfc.services.collect.service;

import com.dlfc.zfw.wechat.entities.entity.HouLeaseInfo;
import org.springframework.stereotype.Service;

@Service
public interface HouseLeaseInfoService {

    HouLeaseInfo findByHouseLeaseInfo(String id);
}
