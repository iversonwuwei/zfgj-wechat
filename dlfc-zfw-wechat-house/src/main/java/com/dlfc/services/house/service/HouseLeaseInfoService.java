package com.dlfc.services.house.service;

import com.dlfc.services.house.dto.HouLeaseInfoDTO;
import com.dlfc.services.house.entity.HouLeaseInfo;
import com.dlfc.services.house.entity.UsrUser;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HouseLeaseInfoService {

    HouLeaseInfo findByHouseLeaseInfo(String id);

    List<HouLeaseInfo> findByUid(String uid);

    List<HouLeaseInfo> findByParams(HouLeaseInfoDTO dto);

    String save(HouLeaseInfo houLeaseInfo, UsrUser user);
}
