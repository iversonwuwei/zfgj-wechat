package com.dlfc.services.house.service;

import com.dlfc.services.house.entity.HouLeaseInfo;
import org.springframework.stereotype.Service;

@Service
public interface HouseLeaseInfoService {

    HouLeaseInfo findByHouseLeaseInfo(String id);
}
