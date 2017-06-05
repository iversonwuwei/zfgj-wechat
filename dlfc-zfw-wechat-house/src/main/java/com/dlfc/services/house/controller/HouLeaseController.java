package com.dlfc.services.house.controller;

import com.dlfc.services.house.convertor.ConditionConvertor;
import com.dlfc.services.house.convertor.HouseInfoConvertor;
import com.dlfc.services.house.dto.HouLeaseInfoDTO;
import com.dlfc.services.house.dto.HouseConditionDTO;
import com.dlfc.services.house.dto.HouseDTO;
import com.dlfc.services.house.entity.HouLeaseInfo;
import com.dlfc.services.house.entity.SysSurFacis;
import com.dlfc.services.house.entity.UsrUser;
import com.dlfc.services.house.service.HouseLeaseInfoService;
import com.dlfc.services.house.service.SysSurFaciService;
import com.housecenter.dlfc.commons.bases.dto.ListResultDTO;
import com.housecenter.dlfc.commons.bases.dto.ResultDTO;
import com.housecenter.dlfc.commons.bases.error.ResultError;
import com.housecenter.dlfc.commons.exception.CustomRuntimeException;
import com.housecenter.dlfc.framework.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    private HouseInfoConvertor houseInfoConvertor;
    @Autowired
    private ConditionConvertor conditionConvertor;

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
            throw new CustomRuntimeException("", "");
        }
        return houseInfoConvertor.toResultDTO(houLeaseInfoList);
    }

    /**
     * 我的房源
     *
     * @param uid
     * @return
     * @throws CustomRuntimeException
     */
    @RequestMapping(value = "/my", method = RequestMethod.GET)
    public ListResultDTO<HouseDTO> myHouses(@RequestParam(required = false) String uid) throws CustomRuntimeException {
        houLeaseInfoList = houseLeaseInfoService.findByUid(uid);
        if (null == houLeaseInfoList || houLeaseInfoList.size() == 0) {
            throw new CustomRuntimeException("", "");
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
            throw new CustomRuntimeException("", "");
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
    public ResultDTO<String> details(@RequestBody HouseDTO dto) throws CustomRuntimeException {
        UsrUser user = new UsrUser();
        HouLeaseInfo houLeaseInfo = houseInfoConvertor.toModel(dto);
        String id = houseLeaseInfoService.save(houLeaseInfo, user);
        if (StringUtils.isEmpty(id)) {
            ResultError resultError = new ResultError("", "");
            return ResultDTO.failure(id, resultError);
        }
        SysSurFacis sysSurFacis=new SysSurFacis();
        sysSurFaciService.save(sysSurFacis);
        return ResultDTO.success(id);
    }
}
