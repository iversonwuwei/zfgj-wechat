package com.dlfc.services.commons.controller;


import com.dlfc.services.commons.convertor.*;
import com.dlfc.services.commons.dto.CodeNameDTO;
import com.dlfc.services.commons.service.DataService;
import com.dlfc.services.commons.service.impl.SysCodeServiceImpl;
import com.dlfc.zfw.wechat.entities.entity.*;
import com.housecenter.dlfc.commons.bases.dto.ListResultDTO;
import com.housecenter.dlfc.commons.exception.CustomRuntimeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(value = "/wc/areas")
public class DistrictController {

    @Autowired
    private DataService<SysAreaAreas> sysAreaAreasService;
    @Autowired
    private DataService<SysTradeAreas> sysTradeAreasService;
    @Autowired
    private DataService<SysAreaProvinces> sysAreaProvincesService;
    @Autowired
    private DataService<SysAreaCities> sysAreaCitiesService;
    @Autowired
    private DataService<SysCode> sysCodeService;
    @Autowired
    private SysAreaAreasConvertor sysAreaAreasConvertor;
    @Autowired
    private SysTradeAreasConvertor sysTradeAreasConvertor;
    @Autowired
    private SysAreaProvincesConvertor sysAreaProvincesConvertor;
    @Autowired
    private SysAreaCitiesConvertor sysAreaCitiesConvertor;
    @Autowired
    private SysCodeConvertor sysCodeConvertor;

    @RequestMapping(value = "/area", method = RequestMethod.GET)
    public ListResultDTO<CodeNameDTO> areas() throws CustomRuntimeException {
        List<SysAreaAreas> sysAreaAreasList = sysAreaAreasService.findBy("210200");
        return sysAreaAreasConvertor.toResultDTO(sysAreaAreasList);
    }

    @RequestMapping(value = "/trade", method = RequestMethod.GET)
    public ListResultDTO<CodeNameDTO> trades(@RequestParam String areaId) throws CustomRuntimeException {
        List<SysTradeAreas> sysTradeAreasList = sysTradeAreasService.findBy(areaId);
        return sysTradeAreasConvertor.toResultDTO(sysTradeAreasList);
    }

    @RequestMapping(value = "/allTrades", method = RequestMethod.GET)
    public ListResultDTO<CodeNameDTO> allTrades() throws CustomRuntimeException {
        List<SysTradeAreas> sysTradeAreasList = sysTradeAreasService.findAll();
        return sysTradeAreasConvertor.toResultDTO(sysTradeAreasList);
    }

    @RequestMapping(value = "/provinces", method = RequestMethod.GET)
    public ListResultDTO<CodeNameDTO> provinces() throws CustomRuntimeException {
        List<SysAreaProvinces> sysAreaProvinceList = sysAreaProvincesService.findAll();
        return sysAreaProvincesConvertor.toResultDTO(sysAreaProvinceList);
    }

    @RequestMapping(value = "/cityByProvince", method = RequestMethod.GET)
    public ListResultDTO<CodeNameDTO> cityByProvince(@RequestParam String provinceId) throws CustomRuntimeException {
        List<SysAreaCities> sysAreaCitiesList = sysAreaCitiesService.findBy(provinceId);
        return sysAreaCitiesConvertor.toResultDTO(sysAreaCitiesList);
    }

    @RequestMapping(value = "/nations", method = RequestMethod.GET)
    public ListResultDTO<CodeNameDTO> nations() throws CustomRuntimeException {
        List<SysCode> sysCodeList = sysCodeService.findBy("nation");
        return sysCodeConvertor.toResultDTO(sysCodeList);
    }
}
