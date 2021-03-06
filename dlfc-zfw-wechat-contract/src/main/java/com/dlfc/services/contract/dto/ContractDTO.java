package com.dlfc.services.contract.dto;

import com.dlfc.services.contract.enums.RentalPurposeEnum;
import com.housecenter.dlfc.commons.bases.dto.AbstractDTO;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by K on 6/19/17.
 */

@Getter
@Setter
public class ContractDTO extends AbstractDTO {

    /**
     * 房主姓名
     */
    private String ownerName;

    /**
     * 房主证件类型
     */
    private Integer ownerIdType;

    /**
     * 房主证件号码
     */
    private String ownerIdNo;

    /**
     * 房主电话号码
     */
    private String ownerPhone;

    /**
     * 房主邮箱
     */
    private String ownerEmail;

    /**
     * 房主送达地址
     */
    private String ownerDeliverAddress;

    /**
     * 房主备用联系人姓名
     */
    private String ownerBackupName;

    /**
     * 房主备用联系人电话
     */
    private String ownerBackupPhone;

    /**
     * 承租人姓名
     */
    private String renterName;

    /**
     * 承租人证件类型
     */
    private Integer renterIdType;

    /**
     * 承租人证件号码
     */
    private String renterIdNo;

    /**
     * 承租人电话号码
     */
    private String renterPhone;

    /**
     * 承租人邮箱
     */
    private String renterEmail;

    /**
     * 承租人送达地址
     */
    private String renterDeliverAddress;

    /**
     * 承租人备用联系人姓名
     */
    private String renterBackupName;

    /**
     * 承租人备用联系人电话
     */
    private String renterBackupPhone;

    /**
     * 承租人民族
     */
    private String renterNation;

    /**
     * 承租人户籍（省）
     */
    private String renterRegProvince;

    /**
     * 承租人户籍（市）
     */
    private String renterRegCity;

    /**
     * 实际使用人
     */
    private List<HouseUserDTO> userList;

    /**
     * 实际使用人
     */
    private List<HouseUserChildrenDTO> childrenList;

    /**
     * 详细地址
     */
    private String houseAddress;

    /**
     * 房源面积
     */
    private BigDecimal houseArea;

    /**
     * 产权证件编号
     */
    private String propertyIdNo;

    /**
     * 产权证件类型
     */
    private String propertyType;

    /**
     * 房屋结构
     */
    private String houseStructure;

    /**
     * 房屋结构名
     */
    private String houseStructureName;

    /**
     * 合同起始时间
     */
    private Date startDate;

    /**
     * 合同终止时间
     */
    private Date endDate;

    /**
     * 合同期限（年）
     */
    private Integer years;

    /**
     * 合同期限（月）
     */
    private Integer months;

    /**
     * 出租方式
     */
    private String rentalMode;

    /**
     * 租赁用途
     */
    private Integer rentalPurpose = RentalPurposeEnum.CIVIL_USE_ENUM.getValue();

    /**
     * 出租区域
     */
    private String rentalDomain;

    /**
     * 出租面积
     */
    private BigDecimal rentalArea;

    /**
     * 租金
     */
    private Integer rent;

    /**
     * 租金周期
     */
    private String paymentCycle;

    /**
     * 租金周期名
     */
    private String paymentCycleName;

    /**
     * 押金
     */
    private BigDecimal deposit;

    /**
     * 房主承担费用
     */
    private List<String> ownerBears;

    /**
     * 其它房主承担费用
     */
    private String ownerBearOthers;

    /**
     * 其他约定
     */
    private String others;

    /**
     * 房屋交割清单
     */
    private List<HouseItemDTO> houseItemsList;

    /**
     * 其它相关费用
     */
    private List<OtherCostDTO> otherCostList;

    // 非页面输入项
    /**
     * 编号
     */
    private String no;

    /**
     * 月租汉字
     */
    private String rentCN;

    /**
     * 支付方式说明
     */
    private List<String> paymentExplanation;

    /**
     * 房客承担
     */
    private List<String> renterBears;

    /**
     * 押金汉字
     */
    private String depositCN;

    /**
     * 房主证件类型名
     */
    private String ownerIdTypeName;

    /**
     * 承租人证件类型名
     */
    private String renterIdTypeName;

    /**
     * 承租人民族名
     */
    private String renterNationName;

    /**
     * 承租人户籍（省）名
     */
    private String renterRegProvinceName;

    /**
     * 承租人户籍（市）名
     */
    private String renterRegCityName;

    /**
     * 产权证件类型名
     */
    private String propertyTypeName;

    /**
     * 出租方式名
     */
    private String rentalModeName;

    /**
     * 房主签名地址
     */
    private String ownerSignPath;

    /**
     * 房客签名地址
     */
    private String renterSignPath;
}
