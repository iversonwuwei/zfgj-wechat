package com.dlfc.services.house.service.impl;

import com.dlfc.services.house.repository.PositionRService;
import com.dlfc.services.house.service.PositionService;
import com.housecenter.dlfc.framework.boot.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by walden on 17-6-30.
 */
@Service
public class PositionServiceImpl implements PositionService {

    @Autowired
    private PositionRService positionRService;

    @Override
    public String[] getPosition(String city, String district, String village) {
        String[] position = positionRService.getPosition(city, district, village);
        return position;
    }
}
