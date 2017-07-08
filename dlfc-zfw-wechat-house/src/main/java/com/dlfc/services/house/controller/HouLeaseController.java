package com.dlfc.services.house.controller;

import com.dlfc.services.house.convertor.*;
import com.dlfc.services.house.dto.*;
import com.dlfc.services.house.repository.UserInfoRService;
import com.dlfc.services.house.repository.ValidateRService;
import com.dlfc.services.house.service.*;
import com.dlfc.zfw.wechat.entities.dto.UserDTO;
import com.dlfc.zfw.wechat.entities.entity.*;
import com.housecenter.dlfc.commons.bases.convertor.base.IConvertor;
import com.housecenter.dlfc.commons.bases.dto.ListResultDTO;
import com.housecenter.dlfc.commons.bases.dto.ResultDTO;
import com.housecenter.dlfc.commons.bases.error.ResultError;
import com.housecenter.dlfc.commons.exception.CustomRuntimeException;
import com.housecenter.dlfc.framework.ca.api.PrincipalService;
import com.housecenter.dlfc.framework.common.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
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
        ResultDTO<UserDTO> result = validateRService.validateUserBy(token);
        HouLeaseInfoDTO dto = conditionConvertor.toModel(conditionDTO);
        houLeaseInfoList = houseLeaseInfoService.findByParams(dto);
        if (null == houLeaseInfoList || houLeaseInfoList.size() == 0) {
            houLeaseInfoList = new ArrayList<>();
        }
        if (null != result && result.isFailure()) {
            return houseInfoConvertor.toResultDTO(houLeaseInfoList);
        }
        return houseInfoConvertor.toResultDTO(houLeaseInfoList, result.getData().getId());
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
        ResultDTO<UserDTO> result = validateRService.validateUserBy(token);
        if (null != result || result.isFailure()) {
            return ResultDTO.failure(result.getErrors());
        }
        UsrUser user = userInfoRService.findUserById(result.getData().getId());
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
                /*if (isNull(houseDTO.getDescriptionDTOS())) {
                    sysDescriptionsService.remove(houseDTO.getId());
                    for (SysDescriptionDTO sysDescriptionDTO : houseDTO.getDescriptionDTOS()) {
                        sysDescriptionDTO.setLid(houseDTO.getId());
                        sysDescriptions = sysDescriptionConvertor.toModel(sysDescriptionDTO);
                        sysDescriptionsService.save(sysDescriptions, user);
                    }
                }*/
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
        ResultDTO<UserDTO> result = null;
        List<HouLeaseInfo> houLeaseInfos = houseLeaseInfoService.findAll(pageNo, pageSize);
        if (token != null) {
            result = validateRService.validateUserBy(token);
            if (null == result || result.isFailure()) {
                return houseInfoConvertor.toResultDTO(houLeaseInfos);
            } else {
                return houseInfoConvertor.toResultDTO(houLeaseInfos, result.getData().getId());
            }
        }
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
        ResultDTO<UserDTO> result = validateRService.validateUserBy(token);
        if (null != result && result.isFailure()) {
            return ListResultDTO.failure(new ArrayList<HouseDTO>(), result.getErrors());
        }
        houLeaseInfoList = houseLeaseInfoService.findByUid(result.getData().getId());
        if (null == houLeaseInfoList || houLeaseInfoList.size() == 0) {
            houLeaseInfoList = new ArrayList<>();
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
        HouLeaseInfo houLeaseInfo = houseLeaseInfoService.findByHouseLeaseInfo(lid);
        if (token != null) {
            ResultDTO<UserDTO> result = validateRService.validateUserBy(token);
            if (null != result && result.isFailure()) {
                return houseInfoConvertor.toResultDTO(houLeaseInfo);
            }else {
                return houseInfoConvertor.toResultDTO(houLeaseInfo, result.getData().getId());
            }
        }
        return houseInfoConvertor.toResultDTO(houLeaseInfo);
    }

    /**
     * 删除房源
     */
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public ResultDTO<Void> delete(@RequestParam String lid, @RequestHeader String token) {
        ResultDTO<UserDTO> result = validateRService.validateUserBy(token);
        if (null != result && result.isFailure()) {
            return ResultDTO.failure(result.getErrors());
        }
        boolean success = houseLeaseInfoService.delete(lid);
        if (success) {
            return ResultDTO.success();
        }
        return ResultDTO.failure(new ResultError("删除房源失败", null));
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
        ResultDTO<UserDTO> result = validateRService.validateUserBy(token);
        if (null != result && result.isFailure()) {
            return ResultDTO.failure(null, result.getErrors());
        }
        SysTrafficLines sysTrafficLines;
        SysDescriptions sysDescriptions;
        SysInfoAtt sysInfoAtt;
        dto.setUid(result.getData().getId());
        UsrUser user = userInfoRService.findUserById(result.getData().getId());
        HouLeaseInfo houLeaseInfo = houseInfoConvertor.toModel(dto);
        String id = houseLeaseInfoService.save(houLeaseInfo, user);
        if (StringUtils.isEmpty(id)) {
            ResultError resultError = new ResultError("", "");
            return ResultDTO.failure(id, resultError);
        }
        if (this.isNull(dto.getHouImg()) && dto.getHouImg().size() > 0) {
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
        /*if (isNull(dto.getDescriptionDTOS())) {
            for (SysDescriptionDTO sysDescriptionDTO : dto.getDescriptionDTOS()) {
                sysDescriptionDTO.setLid(id);
                sysDescriptions = sysDescriptionConvertor.toModel(sysDescriptionDTO);
                sysDescriptionsService.save(sysDescriptions, user);
            }
        }*/

        return ResultDTO.success(id);
    }

    private boolean isNull(Object obj) {
        if (obj == null) {
            return false;
        }
        return true;
    }
}
