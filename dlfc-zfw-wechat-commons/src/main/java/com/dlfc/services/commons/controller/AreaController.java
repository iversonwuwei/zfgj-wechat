package com.dlfc.services.commons.controller;

import com.dlfc.services.commons.dto.DistrictDTO;
import com.housecenter.dlfc.commons.bases.dto.ResultDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/wc/areas")
public class AreaController {

    @RequestMapping(value = "/district", method = RequestMethod.GET)
    public ResultDTO<DistrictDTO> districts(@RequestParam(required = false) String dCode){

        return null;
    }
}
