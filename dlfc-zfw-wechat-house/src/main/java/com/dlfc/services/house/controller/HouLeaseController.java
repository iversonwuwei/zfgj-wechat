package com.dlfc.services.house.controller;

import com.dlfc.services.house.convertor.*;
import com.dlfc.services.house.dto.*;
import com.dlfc.services.house.repository.PositionRService;
import com.dlfc.services.house.repository.UserInfoRService;
import com.dlfc.services.house.repository.ValidateRService;
import com.dlfc.services.house.service.*;
import com.dlfc.zfw.wechat.entities.entity.*;
import com.housecenter.dlfc.commons.bases.convertor.base.IConvertor;
import com.housecenter.dlfc.commons.bases.dto.ListResultDTO;
import com.housecenter.dlfc.commons.bases.dto.ResultDTO;
import com.housecenter.dlfc.commons.bases.error.ResultError;
import com.housecenter.dlfc.commons.exception.CustomRuntimeException;
import com.housecenter.dlfc.framework.ca.api.PrincipalService;
import com.housecenter.dlfc.framework.common.util.StringUtils;
import com.housecenter.dlfc.framework.common.web.AjaxResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/ww/houseinfos")
public class HouLeaseController {

    private String result;
    private UsrUser user;
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
    private IConvertor convertor;
    @Autowired
    private PrincipalService principalService;
    @Autowired
    private UserInfoRService userInfoRService;
    @Autowired
    private SysInfoAttService sysInfoAttService;
    @Autowired
    private SysHouEquipsConvertor sysHouEquipsConvertor;
    @Autowired
    private SysTranfficLinesConvertor tranfficLinesConvertor;
    @Autowired
    private SysSurFaciesConvertor sysSurFaciesConvertor;
    @Autowired
    private SysInfoAttConvertor sysInfoAttConvertor;
    @Autowired
    private ValidateRService validateRService;
    @Autowired
    private PositionService positionService;

    /**
     * 查找房源
     *
     * @param conditionDTO
     * @return
     * @throws CustomRuntimeException
     */

    @RequestMapping(method = RequestMethod.POST)
    public ListResultDTO<HouseDTO> houses(@RequestBody HouseConditionDTO conditionDTO,
                                          @RequestHeader(required = false) String token) throws CustomRuntimeException {
        HouLeaseInfoDTO dto = null;
        try {
            dto = conditionConvertor.toModel(conditionDTO);
            houLeaseInfoList = houseLeaseInfoService.findByParams(dto);
            if (null == houLeaseInfoList || houLeaseInfoList.size() == 0) {
                return houseInfoConvertor.toResultDTO(new ArrayList<HouLeaseInfo>());
            }
            getUser(token);
            return houseInfoConvertor.toResultDTO(houLeaseInfoList, user.getId());
        }catch (Exception e){
            return houseInfoConvertor.toResultDTO(houLeaseInfoList);
        }
    }

    /**
     * 出租信息编辑后更新
     *
     * @param houseDTO
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResultDTO<Void> update(@RequestBody HouseDTO houseDTO,
                                  @RequestHeader String token) {
        getUser(token);
        SysTrafficLines sysTrafficLines;
        SysDescriptions sysDescriptions;
        SysInfoAtt sysInfoAtt;
        HouLeaseInfo houLeaseInfo = houseInfoConvertor.toModel(houseDTO);
        if (houLeaseInfo != null) {
            if (houseLeaseInfoService.update(houLeaseInfo)) {
                if (StringUtils.isEmpty(houseDTO.getId())) {
                    ResultError resultError = new ResultError("", "");
                    return ResultDTO.failure(resultError);
                }
                if (this.isNull(houseDTO.getHouImg())) {
                    sysInfoAttService.remove(houseDTO.getId());
                    for (ImgDTO imgDTO : houseDTO.getHouImg()) {
                        sysInfoAtt = sysInfoAttConvertor.toModel(imgDTO);
                        sysInfoAtt.setLid(houseDTO.getId());
                        sysInfoAttService.save(sysInfoAtt, user);
                    }
                }
                if (isNull(houseDTO.getVehicles())) {
                    sysTrafficLinesService.remove(houseDTO.getId());
                    for (SysTranfficLinesDTO sysTranfficLinesDTO : houseDTO.getVehicles()) {
                        sysTranfficLinesDTO.setLid(houseDTO.getId());
                        sysTrafficLines = tranfficLinesConvertor.toModel(sysTranfficLinesDTO);
                        sysTrafficLinesService.save(sysTrafficLines, user);
                    }
                }
                if (isNull(houseDTO.getDescriptionDTOS())) {
                    sysDescriptionsService.remove(houseDTO.getId());
                    for (SysDescriptionDTO sysDescriptionDTO : houseDTO.getDescriptionDTOS()) {
                        sysDescriptionDTO.setLid(houseDTO.getId());
                        sysDescriptions = sysDescriptionConvertor.toModel(sysDescriptionDTO);
                        sysDescriptionsService.save(sysDescriptions, user);
                    }
                }
                return ResultDTO.success();
            }
        }
        return ResultDTO.failure();
    }

    /**
     * 房源上架
     *
     * @param lid
     * @return
     */
    @RequestMapping(value = "/publish", method = RequestMethod.PUT)
    public ResultDTO<Void> publish(@RequestParam String lid) {
        boolean result = houseLeaseInfoService.publish(lid);
        if (result) {
            return ResultDTO.success();
        }
        return ResultDTO.failure();
    }

    /**
     * 房源下架
     *
     * @param lid
     * @return
     */
    @RequestMapping(value = "/shutdown", method = RequestMethod.PUT)
    public ResultDTO<Void> shutdown(@RequestParam String lid) {
        boolean result = houseLeaseInfoService.shutdown(lid);
        if (result) {
            return ResultDTO.success();
        }
        return ResultDTO.failure();
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
                                                 @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize,
                                                 @RequestHeader(required = false) String token)
            throws CustomRuntimeException {
        List<HouLeaseInfo> houLeaseInfos = houseLeaseInfoService.findAll(pageNo, pageSize);
        try {
            getUser(token);
        } catch (Exception e) {
            return houseInfoConvertor.toResultDTO(houLeaseInfos);
        }
        user = (UsrUser) convertor.convert2Object(result, UsrUser.class);
        return houseInfoConvertor.toResultDTO(houLeaseInfos, user.getId());
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
        try {
            ResultDTO<UserDTO> user = validateRService.validateUserBy(token);
            houLeaseInfoList = houseLeaseInfoService.findByUid(user.getData().getId());
            if (null == houLeaseInfoList || houLeaseInfoList.size() == 0) {
                return houseInfoConvertor.toResultDTO(new ArrayList<HouLeaseInfo>());
            }
        } catch (Exception e) {
            ResultError resultError;
            if (e.getMessage().contains("500") || e.getMessage().contains("404")) {
                resultError = new ResultError();
                resultError.setErrcode("250");
                resultError.setErrmsg("token expired please re-login!");
                return ListResultDTO.failure(new ArrayList<HouseDTO>(), resultError);
            } else {
                resultError = new ResultError();
                resultError.setErrmsg(e.getMessage());
                return ListResultDTO.failure(new ArrayList<HouseDTO>(), resultError);
            }
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
    public ResultDTO<HouseDTO> details(@RequestParam String lid,
                                       @RequestHeader(required = false) String token) throws CustomRuntimeException {
        HouLeaseInfo houLeaseInfo = null;
        try {
            houLeaseInfo = houseLeaseInfoService.findByHouseLeaseInfo(lid);
            getUser(token);
            if (houLeaseInfo == null) {
                return null;
            }
            return houseInfoConvertor.toResultDTO(houLeaseInfo, user.getId());
        }catch (Exception e){
            return houseInfoConvertor.toResultDTO(houLeaseInfo);
        }
    }

    /**
     * 删除房源
     */
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public ResultDTO<Void> delete(@RequestParam String lid) {
        boolean success = houseLeaseInfoService.delete(lid);
        if (success) {
            return ResultDTO.success();
        }
        return ResultDTO.failure();
    }

    /**
     * 发布房源
     *
     * @param dto
     * @return
     * @throws CustomRuntimeException
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResultDTO<String> details(@RequestBody HouseDTO dto,
                                     @RequestHeader String token) throws CustomRuntimeException {
        getUser(token);
        SysTrafficLines sysTrafficLines;
        SysDescriptions sysDescriptions;
        SysInfoAtt sysInfoAtt;
        dto.setUid(user.getId());
        HouLeaseInfo houLeaseInfo = houseInfoConvertor.toModel(dto);
        String id = houseLeaseInfoService.save(houLeaseInfo, user);
        if (StringUtils.isEmpty(id)) {
            ResultError resultError = new ResultError("", "");
            return ResultDTO.failure(id, resultError);
        }
        if (this.isNull(dto.getHouImg())) {
            for (ImgDTO imgDTO : dto.getHouImg()) {
                sysInfoAtt = sysInfoAttConvertor.toModel(imgDTO);
                sysInfoAtt.setLid(id);
                sysInfoAttService.save(sysInfoAtt, user);
            }
        }

        if (isNull(dto.getVehicles())) {
            for (SysTranfficLinesDTO sysTranfficLinesDTO : dto.getVehicles()) {
                sysTranfficLinesDTO.setLid(id);
                sysTrafficLines = tranfficLinesConvertor.toModel(sysTranfficLinesDTO);
                sysTrafficLinesService.save(sysTrafficLines, user);
            }
        }
        if (isNull(dto.getDescriptionDTOS())) {
            for (SysDescriptionDTO sysDescriptionDTO : dto.getDescriptionDTOS()) {
                sysDescriptionDTO.setLid(id);
                sysDescriptions = sysDescriptionConvertor.toModel(sysDescriptionDTO);
                sysDescriptionsService.save(sysDescriptions, user);
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

    private void getUser(String token) {
        if (StringUtils.isNotEmpty(token)) {
            AjaxResult ajaxResult = principalService.principal(token);
            result = userInfoRService.findUserByUser(ajaxResult.getData().toString());
            if (StringUtils.isNotEmpty(result)) {
                user = (UsrUser) convertor.convert2Object(result, UsrUser.class);
            }
        }
    }
}
