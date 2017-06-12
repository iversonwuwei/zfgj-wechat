package com.dlfc.services.house.service;

import com.dlfc.services.house.entity.SysSurFacis;
import com.dlfc.services.house.entity.SysTrafficLines;

import java.util.List;

/**
 * Created by K on 2017/6/3.
 */
public interface SysSurFaciService {

    String save(SysSurFacis sysSurFacis);

    List<SysSurFacis> findByLid(String lid);
}
