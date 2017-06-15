package com.dlfc.services.house.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.math.BigDecimal;
import java.util.Date;


@Getter
@Setter
public class HouLeaseInfo {

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hou_lease_info.ID
     *
     * @mbggenerated Wed May 31 16:50:59 CST 2017
     */
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hou_lease_info.PINDEX
     *
     * @mbggenerated Wed May 31 16:50:59 CST 2017
     */
    private Integer pindex;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hou_lease_info.UID
     *
     * @mbggenerated Wed May 31 16:50:59 CST 2017
     */
    private String uid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hou_lease_info.EID
     *
     * @mbggenerated Wed May 31 16:50:59 CST 2017
     */
    private String eid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hou_lease_info.LNO
     *
     * @mbggenerated Wed May 31 16:50:59 CST 2017
     */
    private String lno;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hou_lease_info.SYS_SOURCE
     *
     * @mbggenerated Wed May 31 16:50:59 CST 2017
     */
    private String sysSource;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hou_lease_info.PREFERENTIAL
     *
     * @mbggenerated Wed May 31 16:50:59 CST 2017
     */
    private String preferential;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hou_lease_info.ONLINE_PAYMENT
     *
     * @mbggenerated Wed May 31 16:50:59 CST 2017
     */
    private String onlinePayment;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hou_lease_info.AUDIT_STATUS
     *
     * @mbggenerated Wed May 31 16:50:59 CST 2017
     */
    private Integer auditStatus;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hou_lease_info.LOCK_USERID
     *
     * @mbggenerated Wed May 31 16:50:59 CST 2017
     */
    private String lockUserid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hou_lease_info.LOCK_TIME
     *
     * @mbggenerated Wed May 31 16:50:59 CST 2017
     */
    @Temporal(TemporalType.TIMESTAMP)
    private String lockTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hou_lease_info.RELEASE_TIME
     *
     * @mbggenerated Wed May 31 16:50:59 CST 2017
     */
    @Temporal(TemporalType.TIMESTAMP)
    private String releaseTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hou_lease_info.SOURCE_TYPE
     *
     * @mbggenerated Wed May 31 16:50:59 CST 2017
     */
    private Integer sourceType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hou_lease_info.REJECT_TYPE
     *
     * @mbggenerated Wed May 31 16:50:59 CST 2017
     */
    private Integer rejectType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hou_lease_info.REJECT_REASON
     *
     * @mbggenerated Wed May 31 16:50:59 CST 2017
     */
    private String rejectReason;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hou_lease_info.RELEASE_STATUS
     *
     * @mbggenerated Wed May 31 16:50:59 CST 2017
     */
    private Integer releaseStatus;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hou_lease_info.SHELF_TYPE
     *
     * @mbggenerated Wed May 31 16:50:59 CST 2017
     */
    private Integer shelfType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hou_lease_info.SHELF_REASON
     *
     * @mbggenerated Wed May 31 16:50:59 CST 2017
     */
    private String shelfReason;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hou_lease_info.HID
     *
     * @mbggenerated Wed May 31 16:50:59 CST 2017
     */
    private String hid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hou_lease_info.HOUSE_TYPE
     *
     * @mbggenerated Wed May 31 16:50:59 CST 2017
     */
    private Integer houseType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hou_lease_info.STATIONID
     *
     * @mbggenerated Wed May 31 16:50:59 CST 2017
     */
    private String stationid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hou_lease_info.CHECKIN_TIME
     *
     * @mbggenerated Wed May 31 16:50:59 CST 2017
     */
    @Temporal(TemporalType.TIMESTAMP)
    private String checkinTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hou_lease_info.RENT_TYPE
     *
     * @mbggenerated Wed May 31 16:50:59 CST 2017
     */
    private String rentType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hou_lease_info.LEASE_MODE
     *
     * @mbggenerated Wed May 31 16:50:59 CST 2017
     */
    private Integer leaseMode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hou_lease_info.RENT
     *
     * @mbggenerated Wed May 31 16:50:59 CST 2017
     */
    private BigDecimal rent;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hou_lease_info.VILLAGE_NAME
     *
     * @mbggenerated Wed May 31 16:50:59 CST 2017
     */
    private String villageName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hou_lease_info.DISTRICT
     *
     * @mbggenerated Wed May 31 16:50:59 CST 2017
     */
    private String district;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hou_lease_info.DISTRICT_NAME
     *
     * @mbggenerated Wed May 31 16:50:59 CST 2017
     */
    private String districtName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hou_lease_info.NO
     *
     * @mbggenerated Wed May 31 16:50:59 CST 2017
     */
    private String no;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hou_lease_info.FLOOR
     *
     * @mbggenerated Wed May 31 16:50:59 CST 2017
     */
    private String floor;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hou_lease_info.BUILD_TIME
     *
     * @mbggenerated Wed May 31 16:50:59 CST 2017
     */
    private String buildTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hou_lease_info.APARTMENT_LAYOUT
     *
     * @mbggenerated Wed May 31 16:50:59 CST 2017
     */
    private String apartmentLayout;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hou_lease_info.ORIENTATION
     *
     * @mbggenerated Wed May 31 16:50:59 CST 2017
     */
    private String orientation;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hou_lease_info.DECOR
     *
     * @mbggenerated Wed May 31 16:50:59 CST 2017
     */
    private String decor;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hou_lease_info.DECOR_TIME
     *
     * @mbggenerated Wed May 31 16:50:59 CST 2017
     */
    private String decorTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hou_lease_info.FACILITIES
     *
     * @mbggenerated Wed May 31 16:50:59 CST 2017
     */
    private String facilities;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hou_lease_info.ELECTRIC
     *
     * @mbggenerated Wed May 31 16:50:59 CST 2017
     */
    private String electric;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hou_lease_info.FEATURE
     *
     * @mbggenerated Wed May 31 16:50:59 CST 2017
     */
    private String feature;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hou_lease_info.ENVIRONMENT
     *
     * @mbggenerated Wed May 31 16:50:59 CST 2017
     */
    private String environment;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hou_lease_info.REQUIREMENT
     *
     * @mbggenerated Wed May 31 16:50:59 CST 2017
     */
    private String requirement;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hou_lease_info.DESCRIPTION
     *
     * @mbggenerated Wed May 31 16:50:59 CST 2017
     */
    private String description;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hou_lease_info.DCRP_TXT
     *
     * @mbggenerated Wed May 31 16:50:59 CST 2017
     */
    private String dcrpTxt;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hou_lease_info.TITLE
     *
     * @mbggenerated Wed May 31 16:50:59 CST 2017
     */
    private String title;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hou_lease_info.TEL
     *
     * @mbggenerated Wed May 31 16:50:59 CST 2017
     */
    private String tel;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hou_lease_info.CONTACT
     *
     * @mbggenerated Wed May 31 16:50:59 CST 2017
     */
    private String contact;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hou_lease_info.OWNER_COST_ITEMS
     *
     * @mbggenerated Wed May 31 16:50:59 CST 2017
     */
    private String ownerCostItems;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hou_lease_info.OWNER_COST
     *
     * @mbggenerated Wed May 31 16:50:59 CST 2017
     */
    private String ownerCost;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hou_lease_info.FRESH_TIME
     *
     * @mbggenerated Wed May 31 16:50:59 CST 2017
     */
    @Temporal(TemporalType.TIMESTAMP)
    private Date freshTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hou_lease_info.TO_SPECIAL
     *
     * @mbggenerated Wed May 31 16:50:59 CST 2017
     */
    private Integer toSpecial;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hou_lease_info.LONGITUDE
     *
     * @mbggenerated Wed May 31 16:50:59 CST 2017
     */
    private String longitude;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hou_lease_info.LATITUDE
     *
     * @mbggenerated Wed May 31 16:50:59 CST 2017
     */
    private String latitude;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hou_lease_info.RENTAL_AREA
     *
     * @mbggenerated Wed May 31 16:50:59 CST 2017
     */
    private BigDecimal rentalArea;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hou_lease_info.ROOM
     *
     * @mbggenerated Wed May 31 16:50:59 CST 2017
     */
    private String room;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hou_lease_info.CREATE_USER
     *
     * @mbggenerated Wed May 31 16:50:59 CST 2017
     */
    private String createUser;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hou_lease_info.CREATE_USER_IDENTITY
     *
     * @mbggenerated Wed May 31 16:50:59 CST 2017
     */
    private Short createUserIdentity;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hou_lease_info.CREATE_TIME
     *
     * @mbggenerated Wed May 31 16:50:59 CST 2017
     */
    @Temporal(TemporalType.TIMESTAMP)
    private String createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hou_lease_info.MODIFY_USER_IDENTITY
     *
     * @mbggenerated Wed May 31 16:50:59 CST 2017
     */
    private Short modifyUserIdentity;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hou_lease_info.MODIFY_TIME
     *
     * @mbggenerated Wed May 31 16:50:59 CST 2017
     */
    @Temporal(TemporalType.TIMESTAMP)
    private String modifyTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hou_lease_info.MODIFY_USER
     *
     * @mbggenerated Wed May 31 16:50:59 CST 2017
     */
    private String modifyUser;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hou_lease_info.DELETE_FLG
     *
     * @mbggenerated Wed May 31 16:50:59 CST 2017
     */
    private Short deleteFlg;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hou_lease_info.VERSION
     *
     * @mbggenerated Wed May 31 16:50:59 CST 2017
     */
    private Integer version;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hou_lease_info.STAGES
     *
     * @mbggenerated Wed May 31 16:50:59 CST 2017
     */
    private String stages;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hou_lease_info.SURROUDING_FACILITIES
     *
     * @mbggenerated Wed May 31 16:50:59 CST 2017
     */
    private String surroudingFacilities;
}
