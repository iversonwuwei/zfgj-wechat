
/**
 * @name: LeaseInfoSysSource.java
 * @Copyright: (c) 2017 DLFC. All rights reserved.
 * @description:
 * @version: 1.0
 * @date : 2017年5月10日
 * @author: liuyundong
 * @Modification History:<br>
 * Date          Author         Version        Discription
 * 2017年5月10日       liuyundong        1.0             <修改原因描述>
 */
package com.dlfc.services.house.enums;

/**
 * @author liuyundong
 * @version 1.0
 * @name: LeaseInfoSysSource
 * @description: 出租信息系统来源枚举
 */
public enum LeaseInfoSysSourceEnum {

    WEBSITE("网站", "00"),
    ZFGJ("租房管家", "01"),
    APP_WEBSITE("租房网APP", "02"),
    APP_ZFGJ("租房管家APP", "03"),
    WECHAT("微信", "04");

    private String name;

    private String value;

    LeaseInfoSysSourceEnum(String name, String value) {
        this.name = name;
        this.value = value;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
