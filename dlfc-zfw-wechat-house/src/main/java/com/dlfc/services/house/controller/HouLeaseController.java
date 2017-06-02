package com.dlfc.services.house.controller;

import com.dlfc.services.house.convertor.HouseInfoConvertor;
import com.dlfc.services.house.dto.HouseDTO;
import com.dlfc.services.house.entity.HouLeaseInfo;
import com.dlfc.services.house.service.HouseLeaseInfoService;
import com.housecenter.dlfc.commons.bases.dto.ListResultDTO;
import com.housecenter.dlfc.commons.bases.dto.ResultDTO;
import com.housecenter.dlfc.commons.exception.CustomRuntimeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/ww/houseinfos")
public class HouLeaseController {

    @Autowired
    private HouseLeaseInfoService houseLeaseInfoService;

    @Autowired
    private HouseInfoConvertor houseInfoConvertor;

    @RequestMapping(method = RequestMethod.GET)
    public ListResultDTO<HouseDTO> houses(@RequestParam(required = false) String uid){
        return null;
    }

    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public ResultDTO<HouseDTO> details(@RequestParam String lid) throws CustomRuntimeException {
        HouLeaseInfo houLeaseInfo = houseLeaseInfoService.findByHouseLeaseInfo(lid);
        if (houLeaseInfo == null){
            throw new CustomRuntimeException("","");
        }
        return houseInfoConvertor.toResultDTO(houLeaseInfo);
    }
}
