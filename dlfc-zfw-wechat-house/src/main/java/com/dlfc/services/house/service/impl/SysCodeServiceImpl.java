package com.dlfc.services.house.service.impl;

import com.dlfc.services.house.repository.MoreRService;
import com.dlfc.services.house.service.SysCodeService;
import com.dlfc.zfw.wechat.entities.entity.SysCode;
import com.housecenter.dlfc.framework.boot.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by walden on 17-6-26.
 */
@Service
public class SysCodeServiceImpl implements SysCodeService {

    @Autowired
    private MoreRService moreRService;


    @Override
    public List<SysCode> findByType(String type, List<String> codes) {
        List<SysCode> sysCodes = moreRService.findByCode(type);
        List<SysCode> sCode = new ArrayList<>();
        for (SysCode sysCode : sysCodes){
            if (codes.contains(sysCode.getCode())){
                sCode.add(sysCode);
            }
        }
        return sCode;
    }
}
