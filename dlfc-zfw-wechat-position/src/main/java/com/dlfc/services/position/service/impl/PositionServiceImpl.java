package com.dlfc.services.position.service.impl;

import com.dlfc.services.position.service.PositionService;
import com.dlfc.services.position.utils.GetAddressLatAndLonUtils;
import com.housecenter.dlfc.framework.boot.stereotype.Service;

/**
 * Created by walden on 17-6-30.
 */
@Service
public class PositionServiceImpl implements PositionService {

    @Override
    public String getPosition(String city, String district, String village) {
        String location = GetAddressLatAndLonUtils.getAddressLatAndLon(city + district + village);
        return location;
    }
}
