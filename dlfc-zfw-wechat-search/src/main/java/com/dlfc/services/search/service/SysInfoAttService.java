package com.dlfc.services.search.service;


import com.dlfc.services.search.entity.SysInfoAtt;
import com.dlfc.services.search.enums.InfoAttFileTypeEnum;

public interface SysInfoAttService {

    SysInfoAtt findByLidAndFileType(String lid);
}
