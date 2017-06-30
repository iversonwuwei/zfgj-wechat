package com.dlfc.services.position.controller;

import com.dlfc.services.position.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by walden on 17-6-30.
 */
@RestController
@RequestMapping(value = "/ww/position")
public class LatLongController {

    @Autowired
    private PositionService positionService;

    @RequestMapping(value = "/latLong", method = RequestMethod.POST)
    public String[] position(@RequestParam String city,
                                               @RequestParam String district,
                                               @RequestParam String village){
        String location = positionService.getPosition(city, district, village);
        String[] latAndLong = splite(location,",");
        return latAndLong;
    }

    private String[] splite(String str, String fix){
        String[] strs = StringUtils.delimitedListToStringArray(str, fix);
        return strs;
    }
}
