package com.dlfc.services.house.repository;

import com.housecenter.dlfc.commons.bases.dto.ResultDTO;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by walden on 17-6-30.
 */
@FeignClient("dlfc-zfw-position-services")
public interface PositionRService {

    @RequestMapping(value = "/ww/position/latLong", method = RequestMethod.POST)
    String[] getPosition(@RequestParam(name = "city") String city,
                                           @RequestParam(name = "district") String district,
                                           @RequestParam(name = "village") String village);
}
