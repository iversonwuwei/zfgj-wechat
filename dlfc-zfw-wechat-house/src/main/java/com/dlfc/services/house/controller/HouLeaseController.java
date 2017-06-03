package com.dlfc.services.house.controller;

import com.dlfc.services.house.convertor.ConditionConvertor;
import com.dlfc.services.house.convertor.HouseInfoConvertor;
import com.dlfc.services.house.dto.HouLeaseInfoDTO;
import com.dlfc.services.house.dto.HouseConditionDTO;
import com.dlfc.services.house.dto.HouseDTO;
import com.dlfc.services.house.entity.HouLeaseInfo;
import com.dlfc.services.house.service.HouseLeaseInfoService;
import com.housecenter.dlfc.commons.bases.dto.ListResultDTO;
import com.housecenter.dlfc.commons.bases.dto.ResultDTO;
import com.housecenter.dlfc.commons.exception.CustomRuntimeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/ww/houseinfos")
public class HouLeaseController {

    private List<HouLeaseInfo> houLeaseInfoList;
    ;

    @Autowired
    private HouseLeaseInfoService houseLeaseInfoService;

    @Autowired
    private HouseInfoConvertor houseInfoConvertor;

    @Autowired
    private ConditionConvertor conditionConvertor;

    @RequestMapping(method = RequestMethod.POST)
    public ListResultDTO<HouseDTO> houses(@RequestBody HouseConditionDTO conditionDTO) throws CustomRuntimeException {
        HouLeaseInfoDTO dto = conditionConvertor.toModel(conditionDTO);
        houLeaseInfoList = houseLeaseInfoService.findByParams(dto);
        if (null == houLeaseInfoList || houLeaseInfoList.size() == 0) {
            throw new CustomRuntimeException("", "");
        }
        return houseInfoConvertor.toResultDTO(houLeaseInfoList);
    }

    @RequestMapping(value = "/my", method = RequestMethod.GET)
    public ListResultDTO<HouseDTO> myHouses(@RequestParam(required = false) String uid) throws CustomRuntimeException {
        houLeaseInfoList = houseLeaseInfoService.findByUid(uid);
        if (null == houLeaseInfoList || houLeaseInfoList.size() == 0) {
            throw new CustomRuntimeException("", "");
        }
        return houseInfoConvertor.toResultDTO(houLeaseInfoList);
    }

    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public ResultDTO<HouseDTO> details(@RequestParam String lid) throws CustomRuntimeException {
        HouLeaseInfo houLeaseInfo = houseLeaseInfoService.findByHouseLeaseInfo(lid);
        if (houLeaseInfo == null) {
            throw new CustomRuntimeException("", "");
        }
        return houseInfoConvertor.toResultDTO(houLeaseInfo);
    }
}
