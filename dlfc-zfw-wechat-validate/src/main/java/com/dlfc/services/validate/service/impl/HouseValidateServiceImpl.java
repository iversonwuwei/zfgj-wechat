package com.dlfc.services.validate.service.impl;

import com.dlfc.services.validate.repository.LesseeRService;
import com.dlfc.services.validate.service.ValidateService;
import com.dlfc.zfw.wechat.entities.entity.HouLeaseInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service(value = "houseValidateServiceImpl")
public class HouseValidateServiceImpl implements ValidateService {

    @Autowired
    private LesseeRService lesseeRService;

    @Override
    public boolean validate(Object o) {
        String id = (String) o;
        HouLeaseInfo houInfo = lesseeRService.getLesseeById(id);
        if (houInfo == null || houInfo.equals("")) {
            return false;
        }
        return true;
    }
}
