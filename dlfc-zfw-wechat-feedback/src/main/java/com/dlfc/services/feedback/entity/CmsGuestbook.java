package com.dlfc.services.feedback.entity;



import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
public class CmsGuestbook {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cms_guestbook.id
     *
     * @mbggenerated Tue Jun 06 15:28:38 CST 2017
     */
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cms_guestbook.type
     *
     * @mbggenerated Tue Jun 06 15:28:38 CST 2017
     */
    private String type;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cms_guestbook.content
     *
     * @mbggenerated Tue Jun 06 15:28:38 CST 2017
     */
    private String content;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cms_guestbook.name
     *
     * @mbggenerated Tue Jun 06 15:28:38 CST 2017
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cms_guestbook.email
     *
     * @mbggenerated Tue Jun 06 15:28:38 CST 2017
     */
    private String email;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cms_guestbook.phone
     *
     * @mbggenerated Tue Jun 06 15:28:38 CST 2017
     */
    private String phone;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cms_guestbook.workunit
     *
     * @mbggenerated Tue Jun 06 15:28:38 CST 2017
     */
    private String workunit;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cms_guestbook.ip
     *
     * @mbggenerated Tue Jun 06 15:28:38 CST 2017
     */
    private String ip;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cms_guestbook.create_date
     *
     * @mbggenerated Tue Jun 06 15:28:38 CST 2017
     */
    private Date createDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cms_guestbook.re_user_id
     *
     * @mbggenerated Tue Jun 06 15:28:38 CST 2017
     */
    private String reUserId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cms_guestbook.re_date
     *
     * @mbggenerated Tue Jun 06 15:28:38 CST 2017
     */
    private Date reDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cms_guestbook.re_content
     *
     * @mbggenerated Tue Jun 06 15:28:38 CST 2017
     */
    private String reContent;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cms_guestbook.del_flag
     *
     * @mbggenerated Tue Jun 06 15:28:38 CST 2017
     */
    private String delFlag;

}