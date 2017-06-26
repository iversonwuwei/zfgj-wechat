package com.dlfc.services.contract.convertor;

import com.dlfc.admin.common.utils.Const;
import com.dlfc.admin.common.utils.DateUtils;
import com.dlfc.admin.common.utils.NumberToCN;
import com.dlfc.admin.common.utils.OrderUtils;
import com.dlfc.services.contract.dto.*;
import com.dlfc.services.contract.enums.ConSourceEnum;
import com.dlfc.services.contract.enums.ConStatusEnum;
import com.dlfc.services.contract.enums.SettlementCycleEnum;
import com.dlfc.services.contract.repository.SystemRService;
import com.dlfc.services.contract.service.*;
import com.dlfc.zfw.wechat.entities.entity.*;
import com.housecenter.dlfc.commons.bases.convertor.AbstractConvertor;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by K on 6/19/17.
 */

@Component
public class ContractConvertor extends AbstractConvertor<ConContract, ContractDTO> {

    private SysPerson sysPersonEntity;

    @Autowired
    private SystemPersonService systemPersonService;
    @Autowired
    private HouseUserService houseUserService;
    @Autowired
    private HouseUserConvertor houseUserConvertor;
    @Autowired
    private HouseUserChildrenService houseUserChildrenService;
    @Autowired
    private HouseUserChildrenConvertor houseUserChildrenConvertor;
    @Autowired
    private DateService dateService;
    @Autowired
    private SystemRService systemRService;
    @Autowired
    private HouseItemService houseItemService;
    @Autowired
    private HouseItemConvertor houseItemConvertor;
    @Autowired
    private OtherCostService otherCostService;
    @Autowired
    private OtherCostConvertor otherCostConvertor;

    @Override
    public ConContract toModel(ContractDTO dto) {
        ConContract model = new ConContract();
        if (null != dto) {
            model.setId(dto.getId());
            // 房主
            model.setLessorName(dto.getOwnerName());
            model.setLessorIdType(dto.getOwnerIdType());
            model.setLessorIdNo(dto.getOwnerIdNo());
            model.setLessorMobile(dto.getOwnerPhone());
            model.setLessorEmail(dto.getOwnerEmail());
            model.setLessorAddress(dto.getOwnerDeliverAddress());
            model.setLessorBackupName(dto.getOwnerBackupName());
            model.setLessorBackupTel(dto.getOwnerBackupPhone());
            // 房客
            model.setLesseeName(dto.getRenterName());
            model.setLesseeIdType(dto.getRenterIdType());
            model.setLesseeIdNo(dto.getRenterIdNo());
            model.setLesseeMobile(dto.getRenterPhone());
            model.setLesseeEmail(dto.getRenterEmail());
            model.setLesseeAddress(dto.getRenterDeliverAddress());
            model.setLesseeBackupName(dto.getRenterBackupName());
            model.setLesseeBackupTel(dto.getRenterBackupPhone());
            model.setLesseeNation(dto.getRenterNation());
            model.setLesseeHouRegProvince(dto.getRenterRegProvince());
            model.setLesseeHouRegCity(dto.getRenterRegCity());
            // 房源
            model.setHouseAddr(dto.getHouseAddress());
            if (null != dto.getHouseArea()) {
                model.setBuildingArea(BigDecimal.valueOf(dto.getHouseArea()));
            }
            model.setPropertyIdNo(dto.getPropertyIdNo());
            model.setPropertyType(dto.getPropertyType());
            model.setHouseStructure(dto.getHouseStructure());
            if (null != dto.getStartDate()) {
                model.setStartTime(dto.getStartDate().getTime());
            }
            if (null != dto.getEndDate()) {
                model.setEndTime(dto.getEndDate().getTime());
            }
            if (null != dto.getRentalMode()) {
                model.setRentalMode(dto.getRentalMode().shortValue());
            }
            if (null != dto.getRentalPurpose()) {
                model.setLeasePurpose(dto.getRentalPurpose().shortValue());
            }
            if (null != dto.getRentalDomain()) {
                model.setLeaseDomain(dto.getRentalDomain());
            } else {
                model.setLeaseDomain("整套");
            }
            if (null != dto.getRentalArea()) {
                model.setLeaseArea(BigDecimal.valueOf(dto.getRentalArea()));
            }
            model.setMonthlyRent(dto.getRent());
            model.setSettlementCycle(dto.getPaymentCycle());
            if (null != dto.getDeposit()) {
                model.setDepositAmt(BigDecimal.valueOf(dto.getDeposit()));
            }
            if (null != dto.getOwnerBears() && dto.getOwnerBears().size() > 0) {
                StringBuffer buffer = new StringBuffer();
                for (String bear : dto.getOwnerBears()) {
                    if (StringUtils.isNotEmpty(bear)) {
                        buffer.append(bear);
                        buffer.append(",");
                    }
                }
                if (buffer.length() > 0) {
                    buffer.deleteCharAt(buffer.length() - 1);
                    model.setOwnerBear(buffer.toString());
                }
            }
            model.setOwnerBearOther(dto.getOwnerBearOthers());
            model.setAdditionalTerms(dto.getOthers());
            // 非页面业务
            model.setStatus((short) ConStatusEnum.WAIT_UPLOAD_ENUM.getValue());
            model.setSource(ConSourceEnum.WECHAT_ENUM.getValue());
            model.setNo(OrderUtils.getBusinessNO(Const.BUSINESS_TYPE_CONTRACT));
            model.setHouseOwnerName(dto.getOwnerName());
            model.setHouseOwnerIdType(dto.getOwnerIdType());
            model.setHouseOwnerIdNo(dto.getOwnerIdNo());
            model.setHouseOwnerMobile(dto.getOwnerPhone());
            sysPersonEntity = findByNameInfos(dto.getOwnerName(), dto.getOwnerIdType(), dto.getOwnerIdNo());
            if (null != sysPersonEntity) {
                model.setHouseOwnerPid(sysPersonEntity.getId());
            }
        }
        return model;
    }

    @Override
    public ContractDTO toDTO(ConContract model, Object... objects) {
        ContractDTO dto = new ContractDTO();
        if (null != model) {
            dto.setId(model.getId());
            dto.setNo(model.getNo());
            // 房主
            dto.setOwnerName(model.getLessorName());
            dto.setOwnerIdType(model.getLessorIdType());
            dto.setOwnerIdNo(model.getLessorIdNo());
            dto.setOwnerDeliverAddress(model.getLessorAddress());
            dto.setOwnerPhone(model.getLessorMobile());
            dto.setOwnerEmail(model.getLessorEmail());
            dto.setOwnerBackupName(model.getLessorBackupName());
            dto.setOwnerBackupPhone(model.getLessorBackupTel());
            // 房客
            dto.setRenterName(model.getLesseeName());
            dto.setRenterIdType(model.getLesseeIdType());
            dto.setRenterIdNo(model.getLesseeIdNo());
            dto.setRenterDeliverAddress(model.getLesseeAddress());
            dto.setRenterPhone(model.getLesseeMobile());
            dto.setRenterEmail(model.getLesseeEmail());
            dto.setRenterBackupName(model.getLesseeBackupName());
            dto.setRenterBackupPhone(model.getLesseeBackupTel());
            dto.setRenterNation(model.getLesseeNation());
            dto.setRenterRegProvince(model.getLesseeHouRegProvince());
            dto.setRenterRegCity(model.getLesseeHouRegCity());
            // 实际使用人
            dto.setUserList(findHouseUsers(model.getId()));
            // 随住子女
            dto.setChildrenList(findHouseUserChildren(model.getId()));
            // 房源
            dto.setHouseAddress(model.getHouseAddr());
            dto.setHouseStructure(model.getHouseStructure());
            dto.setPropertyType(model.getPropertyType());
            dto.setPropertyIdNo(model.getPropertyIdNo());
            if (null != model.getBuildingArea()) {
                dto.setHouseArea(model.getBuildingArea().doubleValue());
            }
            if (null != model.getLeaseArea()) {
                dto.setRentalArea(model.getLeaseArea().doubleValue());
            }
            if (null != model.getLeasePurpose()) {
                dto.setRentalPurpose(model.getLeasePurpose().intValue());
            }
            dto.setYears(model.getLeaseTermYear());
            dto.setMonths(model.getLeaseTermMonth());
            dto.setStartDate(new Date(model.getStartTime()));
            dto.setEndDate(new Date(model.getStartTime()));
            dto.setRent(model.getMonthlyRent());
            dto.setRentCN(NumberToCN.number2CNMontrayUnit(new BigDecimal(model.getMonthlyRent())));
            dto.setPaymentCycle(model.getSettlementCycle());
            dto.setPaymentExplanation(getExplanation(model));
            ownerRenterBears(model, dto);
            if (null != model.getDepositAmt()) {
                dto.setDeposit(model.getDepositAmt().doubleValue());
                dto.setDepositCN(NumberToCN.number2CNMontrayUnit(model.getDepositAmt()));
            }
            dto.setOthers(model.getAdditionalTerms());
            dto.setHouseItemsList(findHouseItems(model.getId()));
            dto.setOtherCostList(findOtherCosts(model.getId()));
        }
        return dto;
    }

    private SysPerson findByNameInfos(String ownerName,
                                      Integer ownerIdType,
                                      String ownerIdNo) {
        sysPersonEntity = new SysPerson();
        sysPersonEntity.setName(ownerName);
        sysPersonEntity.setIdType(ownerIdType);
        sysPersonEntity.setIdNo(ownerIdNo);
        return systemPersonService.findByNameInfos(sysPersonEntity);
    }

    private List<HouseUserDTO> findHouseUsers(String id) {
        List<ConHouseUser> conHouseUserList = houseUserService.findByLid(id);
        if (null != conHouseUserList && conHouseUserList.size() > 0) {
            return houseUserConvertor.toListDTO(conHouseUserList);
        }
        return null;
    }

    private List<HouseUserChildrenDTO> findHouseUserChildren(String id) {
        List<ConHouseUserChildren> conHouseUserChildrenList = houseUserChildrenService.findByLid(id);
        if (null != conHouseUserChildrenList && conHouseUserChildrenList.size() > 0) {
            return houseUserChildrenConvertor.toListDTO(conHouseUserChildrenList);
        }
        return null;
    }

    private List<String> getExplanation(ConContract model) {
        if (null != model.getMonthlyRent()
                && null != model.getSettlementCycle()
                && null != model.getStartTime()
                && null != model.getEndTime()) {
            Date startDate = new Date(model.getStartTime());
            Date endDate = new Date(model.getEndTime());
            Date start = startDate;
            Date end;
            String explanation;
            String startString;
            String endString;
            List<String> result = new ArrayList<>();
            int cycle = getPaymentCycle(model.getSettlementCycle());
            for (; start.before(endDate); start = DateUtils.addDays(end, 1)) {
                startString = DateUtils.dateToStr(start, DateUtils.CHINA_DATE_YMD);
                end = dateService.getEndDate(start, 0, cycle);
                endString = DateUtils.dateToStr(end, DateUtils.CHINA_DATE_YMD);
                explanation = startString;
                explanation += "支付";
                explanation += startString;
                explanation += "至";
                explanation += endString;
                explanation += "的租金，共计";
                explanation += model.getMonthlyRent();
                explanation += "元；";
                result.add(explanation);
            }
            return result;
        }
        return null;
    }

    private int getPaymentCycle(Integer settlementCycle) {
        if (SettlementCycleEnum.YEAR_ENUM.getValue() == settlementCycle) {
            return 12;
        } else if (SettlementCycleEnum.HALF_YEAR_ENUM.getValue() == settlementCycle) {
            return 6;
        } else if (SettlementCycleEnum.QUARTER_ENUM.getValue() == settlementCycle) {
            return 3;
        }
        return 1;
    }

    private void ownerRenterBears(ConContract model,
                                  ContractDTO dto) {
        List<String> ownerBears = new ArrayList<>();
        List<String> renterBears = new ArrayList<>();
        List<SysCode> bears = systemRService.findSysCodeByType("lessor_bear");
        if (null != bears && bears.size() > 0) {
            String[] array;
            if (StringUtils.isNotEmpty(model.getOwnerBear())) {
                array = model.getOwnerBear().split(",");
                if (null != array && array.length > 0) {
                    ownerBears = Arrays.asList(array);
                }
            }
            for (SysCode sysCode : bears) {
                if (!ownerBears.contains(sysCode.getCode())) {
                    renterBears.add(sysCode.getCode());
                }
            }
        }
        dto.setOwnerBears(ownerBears);
        dto.setRenterBears(renterBears);
    }

    private List<HouseItemDTO> findHouseItems(String id) {
        List<ConHouseItems> houseItemsList = houseItemService.findByLid(id);
        if (null != houseItemsList && houseItemsList.size() > 0) {
            return houseItemConvertor.toListDTO(houseItemsList);
        }
        return null;
    }

    private List<OtherCostDTO> findOtherCosts(String id) {
        List<ConOtherCosts> otherCostsList = otherCostService.findByLid(id);
        if (null != otherCostsList && otherCostsList.size() > 0) {
            return otherCostConvertor.toListDTO(otherCostsList);
        }
        return null;
    }
}
