package com.dlfc.services.house.service;

import com.dlfc.services.house.entity.SysSurFacis;

import java.util.List;

/**
 * Created by K on 2017/6/3.
 */
public interface SysSurFaciService {
    List<SysSurFacis> findByFacilityIds(List<String> facilityIds);
}
