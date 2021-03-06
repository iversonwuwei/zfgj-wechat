package com.dlfc.services.unicom.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
public class SysParam {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_param.ID
     *
     * @mbggenerated Mon May 29 16:00:38 CST 2017
     */
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_param.PINDEX
     *
     * @mbggenerated Mon May 29 16:00:38 CST 2017
     */
    private Integer pindex;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_param.SCOPE
     *
     * @mbggenerated Mon May 29 16:00:38 CST 2017
     */
    private String scope;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_param.SKEY
     *
     * @mbggenerated Mon May 29 16:00:38 CST 2017
     */
    private String skey;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_param.SVALUE
     *
     * @mbggenerated Mon May 29 16:00:38 CST 2017
     */
    private String svalue;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_param.DCRP
     *
     * @mbggenerated Mon May 29 16:00:38 CST 2017
     */
    private String dcrp;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_param.CREATE_USER
     *
     * @mbggenerated Mon May 29 16:00:38 CST 2017
     */
    private String createUser;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_param.CREATE_USER_IDENTITY
     *
     * @mbggenerated Mon May 29 16:00:38 CST 2017
     */
    private Short createUserIdentity;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_param.CREATE_TIME
     *
     * @mbggenerated Mon May 29 16:00:38 CST 2017
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_param.MODIFY_USER
     *
     * @mbggenerated Mon May 29 16:00:38 CST 2017
     */
    private String modifyUser;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_param.MODIFY_USER_IDENTITY
     *
     * @mbggenerated Mon May 29 16:00:38 CST 2017
     */
    private Short modifyUserIdentity;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_param.MODIFY_TIME
     *
     * @mbggenerated Mon May 29 16:00:38 CST 2017
     */
    private Date modifyTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_param.DELETE_FLG
     *
     * @mbggenerated Mon May 29 16:00:38 CST 2017
     */
    private Short deleteFlg;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_param.VERSION
     *
     * @mbggenerated Mon May 29 16:00:38 CST 2017
     */
    private Integer version;

}