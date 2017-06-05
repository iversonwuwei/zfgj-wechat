package com.dlfc.services.unicom.service;

import com.dlfc.services.unicom.entity.SysParam;

import java.util.List;

public interface SysParamService {

    List<SysParam> findByType(String type);
}
