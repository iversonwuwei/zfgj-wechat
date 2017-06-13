package com.dlfc.services.house.service;


import com.dlfc.services.house.entity.SysInfoAtt;

import java.util.List;

public interface SysInfoAttService {

    List<SysInfoAtt> findByLidAndFileType(String lid);

    String save(SysInfoAtt sysInfoAtt);

    void remove(String lid);
}
