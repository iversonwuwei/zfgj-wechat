package com.dlfc.services.house.controller;

import com.dlfc.services.house.convertor.*;
import com.dlfc.services.house.dto.*;
import com.dlfc.services.house.entity.*;
import com.dlfc.services.house.repository.UserInfoRService;
import com.dlfc.services.house.service.*;
import com.housecenter.dlfc.commons.bases.convertor.base.IConvertor;
import com.housecenter.dlfc.commons.bases.dto.ListResultDTO;
import com.housecenter.dlfc.commons.bases.dto.ResultDTO;
import com.housecenter.dlfc.commons.bases.error.ResultError;
import com.housecenter.dlfc.commons.exception.CustomRuntimeException;
import com.housecenter.dlfc.framework.ca.api.PrincipalService;
import com.housecenter.dlfc.framework.common.util.StringUtils;
import com.housecenter.dlfc.framework.common.web.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/ww/houseinfos")
public class HouLeaseController {

    private List<HouLeaseInfo> houLeaseInfoList;

    @Autowired
    private HouseLeaseInfoService houseLeaseInfoService;
    @Autowired
    private SysSurFaciService sysSurFaciService;
    @Autowired
    private SysHouEquipsService sysHouEquipsService;
    @Autowired
    private SysTrafficLinesService sysTrafficLinesService;
    @Autowired
    private SysDescriptionsService sysDescriptionsService;
    @Autowired
    private HouseInfoConvertor houseInfoConvertor;
    @Autowired
    private ConditionConvertor conditionConvertor;
    @Autowired
    private SysDescriptionConvertor sysDescriptionConvertor;

    @Autowired
    private IConvertor<UserDTO> convertor;
    @Autowired
    private PrincipalService principalService;

    @Autowired
    private UserInfoRService userInfoRService;

    @Autowired
    private SysHouEquipsConvertor sysHouEquipsConvertor;
    @Autowired
    private SysTranfficLinesConvertor tranfficLinesConvertor;
    @Autowired
    private SysSurFaciesConvertor sysSurFaciesConvertor;

    /**
     * 查找房源
     *
     * @param conditionDTO
     * @return
     * @throws CustomRuntimeException
     */
    @RequestMapping(method = RequestMethod.POST)
    public ListResultDTO<HouseDTO> houses(@RequestBody HouseConditionDTO conditionDTO) throws CustomRuntimeException {
        HouLeaseInfoDTO dto = conditionConvertor.toModel(conditionDTO);
        houLeaseInfoList = houseLeaseInfoService.findByParams(dto);
        if (null == houLeaseInfoList || houLeaseInfoList.size() == 0) {
            return houseInfoConvertor.toResultDTO(new ArrayList<HouLeaseInfo>());
        }
        return houseInfoConvertor.toResultDTO(houLeaseInfoList);
    }

    /**
     * 搜索默认的出租信息-默认为第一页 10条
     *
     * @param pageNo
     * @param pageSize
     * @return
     * @throws CustomRuntimeException
     */
    @RequestMapping(value = "/default", method = RequestMethod.GET)
    public ListResultDTO<HouseDTO> findAllHouses(@RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                                 @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize) throws CustomRuntimeException {
        List<HouLeaseInfo> houLeaseInfos = houseLeaseInfoService.findAll(pageNo, pageSize);
        return houseInfoConvertor.toResultDTO(houLeaseInfos);
    }

    /**
     * 我的房源
     *
     * @param token
     * @return
     * @throws CustomRuntimeException
     */
    @RequestMapping(value = "/my", method = RequestMethod.GET)
    public ListResultDTO<HouseDTO> myHouses(@RequestHeader String token) throws CustomRuntimeException {
        AjaxResult user = principalService.principal(token);
        UserDTO userDTO = convertor.convert2Object(userInfoRService.findUserByUser(user.getData().toString()), UserDTO.class);
        houLeaseInfoList = houseLeaseInfoService.findByUid(userDTO.getId());
        if (null == houLeaseInfoList || houLeaseInfoList.size() == 0) {
            houseInfoConvertor.toResultDTO(new ArrayList<HouLeaseInfo>());
        }
        return houseInfoConvertor.toResultDTO(houLeaseInfoList);
    }

    /**
     * 房源详情
     *
     * @param lid
     * @return
     * @throws CustomRuntimeException
     */
    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public ResultDTO<HouseDTO> details(@RequestParam String lid) throws CustomRuntimeException {
        HouLeaseInfo houLeaseInfo = houseLeaseInfoService.findByHouseLeaseInfo(lid);
        if (houLeaseInfo == null) {
            return null;
        }
        return houseInfoConvertor.toResultDTO(houLeaseInfo);
    }

    /**
     * 发布房源
     *
     * @param dto
     * @return
     * @throws CustomRuntimeException
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResultDTO<String> details(@RequestBody HouseDTO dto, @RequestHeader String token) throws CustomRuntimeException {
        AjaxResult user = principalService.principal(token);
        SysSurFacis surFacis = null;
        SysHouEquips sysHouEquips = null;
        SysTrafficLines sysTrafficLines = null;
        SysDescriptions sysDescriptions = null;
        UserDTO userDTO = convertor.convert2Object(userInfoRService.findUserByUser(user.getData().toString()), UserDTO.class);
        dto.setUid(userDTO.getId());
        HouLeaseInfo houLeaseInfo = houseInfoConvertor.toModel(dto);
        String id = houseLeaseInfoService.save(houLeaseInfo);
        if (StringUtils.isEmpty(id)) {
            ResultError resultError = new ResultError("", "");
            return ResultDTO.failure(id, resultError);
        }
        if (this.isNull(dto.getAround())) {
            for (SysSurFaciesDTO sysSurFaciesDTO : dto.getAround()){
                sysSurFaciesDTO.setLid(id);
                surFacis = sysSurFaciesConvertor.toModel(sysSurFaciesDTO);
                sysSurFaciService.save(surFacis);
            }
        }
        if (isNull(dto.getEquips())) {
            for (SysHouEquipsDTO sysHouEquipsDTO : dto.getEquips()){
                sysHouEquipsDTO.setLid(id);
                sysHouEquips = sysHouEquipsConvertor.toModel(sysHouEquipsDTO);
                sysHouEquipsService.save(sysHouEquips);
            }
        }
        if (isNull(dto.getVehicles())) {
            for (SysTranfficLinesDTO sysTranfficLinesDTO : dto.getVehicles()){
                sysTranfficLinesDTO.setLid(id);
                sysTrafficLines = tranfficLinesConvertor.toModel(sysTranfficLinesDTO);
                sysTrafficLinesService.save(sysTrafficLines);
            }
        }
        if (isNull(dto.getDescriptionDTOS())) {
            for (SysDescriptionDTO sysDescriptionDTO : dto.getDescriptionDTOS()){
                sysDescriptionDTO.setLid(id);
                sysDescriptions = sysDescriptionConvertor.toModel(sysDescriptionDTO);
                sysDescriptionsService.save(sysDescriptions);
            }
        }

        return ResultDTO.success(id);
    }

    private boolean isNull(Object obj) {
        if (obj == null) {
            return false;
        }
        return true;
    }
}
