package com.dlfc.services.contract.dto;

import com.housecenter.dlfc.commons.bases.dto.AbstractDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Created by wangna on 2017/6/26.
 */
@Getter
@Setter
public class ContractListDTO extends AbstractDTO {
    /**
     * 合同编号
     */
    private String contractNo;

    /**
     * 承租方
     */
    private String initiator;

    /**
     * 出租方
     */
    private String invitedPerson;

    /**
     * 合同状态
     */
    private String status;

    /**
     * 发起时间
     */
    private Date date;
    private String dateStr;

    /**
     * 是否可删除
     */
    private Boolean isDelete;
    /**
     * 是否可编辑
     */
    private Boolean isEdit;
}
