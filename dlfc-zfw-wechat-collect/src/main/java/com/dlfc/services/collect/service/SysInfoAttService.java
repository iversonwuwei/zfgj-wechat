package com.dlfc.services.collect.service;


import com.dlfc.services.collect.entity.SysInfoAtt;

import java.util.List;

public interface SysInfoAttService {

    List<SysInfoAtt> findByLidAndFileType(String lid);
}
