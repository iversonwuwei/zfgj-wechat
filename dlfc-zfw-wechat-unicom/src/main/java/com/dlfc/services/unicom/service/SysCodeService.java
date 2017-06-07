package com.dlfc.services.unicom.service;

import com.dlfc.services.unicom.entity.SysCode;

import java.util.List;

public interface SysCodeService {

    List<SysCode> findByType(String type);
}
