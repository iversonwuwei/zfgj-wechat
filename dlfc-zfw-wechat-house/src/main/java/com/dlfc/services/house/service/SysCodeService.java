package com.dlfc.services.house.service;

import com.dlfc.zfw.wechat.entities.entity.SysCode;

import java.util.List;

/**
 * Created by walden on 17-6-26.
 */
public interface SysCodeService {

    List<SysCode> findByType(String type, List<String> codes);
}
