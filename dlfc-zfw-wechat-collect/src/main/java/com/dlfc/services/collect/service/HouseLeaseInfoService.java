package com.dlfc.services.collect.service;

import com.dlfc.services.collect.entity.HouLeaseInfo;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
public interface HouseLeaseInfoService {

    HouLeaseInfo findByHouseLeaseInfo(String id);
}
